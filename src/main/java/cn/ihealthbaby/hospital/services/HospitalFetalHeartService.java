package cn.ihealthbaby.hospital.services;

import cn.ihealthbaby.data.db.dao.readonly.DepartmentReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalFetalheartReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.HospitalFetalheartDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.DeviceForm;
import cn.ihealthbaby.hospital.form.HospitalFetalheartQueryForm;
import cn.ihealthbaby.hospital.helps.SqlUtils;
import cn.ihealthbaby.hospital.model.HospitalFetalHeartInfo;
import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParam;
import com.isnowfox.core.dao.QueryParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiang on 2015/7/31.
 */
@Service
public class HospitalFetalHeartService {
    private static final int MAX = 100000;
    @Autowired
    private HospitalFetalheartReadOnlyDao hospitalFetalheartReadOnlyDao;
    @Autowired
    private HospitalReadOnlyDao hospitalReadOnlyDao;
    @Autowired
    private DepartmentReadOnlyDao departmentReadOnlyDao;
    @Autowired
    private ApiManager apiManager;
    public PageResult<HospitalFetalHeartInfo> queryForList(HospitalFetalheartQueryForm form,long hospitalId,int useType){
        String sql="SELECT %s FROM (\n" +
                "SELECT\n" +
                "`hospital_fetalheart`.*\n" +
                "FROM\n" +
                "hospital_fetalheart\n" +
                "LEFT JOIN hospital ON hospital_fetalheart.hospital_id = hospital.id\n" +
                "LEFT JOIN department ON hospital_fetalheart.department_id = department.id\n" +
                "WHERE hospital.id="+hospitalId+"\n";
                sql += "AND hospital_fetalheart.use_type = "+useType+"\n";
        if(StringUtils.isNotBlank(form.getSerialnum())){
            sql += "AND hospital_fetalheart.serialnum = '"+ SqlUtils.Sqlfilter(form.getSerialnum())+"'\n";
        }
        if(form.getStatus()!=-1){
            sql += "AND hospital_fetalheart.status = "+form.getStatus()+"\n";
        }
        if(StringUtils.isNotBlank(form.getHospitalName())){
            sql += "AND hospital.name like '%%"+SqlUtils.Sqlfilter(form.getHospitalName())+"%%'\n";
        }
        if(StringUtils.isNotBlank(form.getDepartmentName())){
            sql += "AND department.department like '%%"+SqlUtils.Sqlfilter(form.getDepartmentName())+"%%'\n";
        }
        sql+=	"ORDER BY\n" +
                "hospital_fetalheart.create_time DESC\n";
        sql+=") tt";
        PageResult<HospitalFetalheartDO> result= hospitalFetalheartReadOnlyDao.fastQueryPage(sql, (new HospitalFetalheartDO()).getTableInfo().getRowMapper(), form.getPage(), form.getPageSize());
        List<HospitalFetalHeartInfo> devlist =new ArrayList<HospitalFetalHeartInfo>();
        for (HospitalFetalheartDO hospitalFetalheartDO : result.getValue()){
            HospitalFetalHeartInfo hospitalFetalHeartInfo = new HospitalFetalHeartInfo();
            BeanUtils.copyProperties(hospitalFetalheartDO, hospitalFetalHeartInfo);
            HospitalDO hospitalDO = hospitalReadOnlyDao.get(hospitalFetalheartDO.getHospitalId());
            hospitalFetalHeartInfo.setDepartmentDO(departmentReadOnlyDao.get(hospitalFetalheartDO.getDepartmentId()));
            hospitalFetalHeartInfo.setHospitalDO(hospitalDO);
            devlist.add(hospitalFetalHeartInfo);
        }
        return  PageResult.createPage(result.getCount(),result.getPage(),result.getPageSize(),devlist);
    }
    public HospitalFetalHeartInfo queryById(long id){
        HospitalFetalHeartInfo hospitalFetalHeartInfo =new HospitalFetalHeartInfo();
        HospitalFetalheartDO hospitalFetalheartDO = hospitalFetalheartReadOnlyDao.get(id);
        BeanUtils.copyProperties(hospitalFetalheartDO,hospitalFetalHeartInfo);
        HospitalDO hospitalDO = hospitalReadOnlyDao.get(hospitalFetalheartDO.getHospitalId());
        hospitalFetalHeartInfo.setHospitalDO(hospitalDO);
        hospitalFetalHeartInfo.setDepartmentDO(departmentReadOnlyDao.get(hospitalFetalheartDO.getDepartmentId()));
        return hospitalFetalHeartInfo;
    }

    /**
     * 获取登录人所在医院
     * @param account
     * @return
     */
    public HospitalDO getHospitalbyAccount(UserAccount account){
        HospitalDO hospitalDO = hospitalReadOnlyDao.get(account.getSysUserDO().getHospitalId());
        return hospitalDO;
    }

    public Result addDeviceToHospital(DeviceForm form) {
        form.setSerialnum(form.getSerialnum().toUpperCase());
        if(form.getUseType()==1){
            form.setDepartmentId(0);
        }
        if(form.getDeviceId()!=null) {
            if (form.getDeviceId().equals("")) {
                form.setDeviceId(null);
            }
        }
       Result<Integer> result= apiManager.adminDeviceApi.addDeviceToHospital(form);
        if(result.getData()!=null) {
            if (result.getData() == 1) {
                Map<String, Object> map = new HashMap<>();
                map.put("serialnum", "设备编号已存在!");
                result.setMsgMap(map);
                result.setStatus(1);
            }
        }
        return result;
    }

    public Result updateDeviceToHospital(long id, DeviceForm form) {
        form.setSerialnum(form.getSerialnum().toUpperCase());
        if(form.getUseType()==1){
            form.setDepartmentId(0);
            form.setDeviceId(null);
        }
        if(form.getDeviceId()==""){
            form.setDeviceId(null);
        }
        return  apiManager.adminDeviceApi.updateDeviceToHospital(id,form);

    }
    public List<DepartmentDO> belongDepartment(long hospitalId) {
        QueryParams params = QueryParams.create();
        params.add(DepartmentDO.ThisTableInfo.HOSPITALID_DB_NAME, hospitalId);
        List<DepartmentDO> list = departmentReadOnlyDao.find(MAX, params,
                Order.asc(DepartmentDO.ThisTableInfo.DEPARTMENT_DB_NAME));
        return list;
    }


    public Result delHospitalFetalheart(long id) {
        return  apiManager.adminDeviceApi.delHospitalFetalheart(id);
    }


    public PageResult<HospitalFetalHeartInfo> queryForAdminList(HospitalFetalheartQueryForm form){
        String sql="SELECT %s FROM (\n" +
                "SELECT\n" +
                "`hospital_fetalheart`.*\n" +
                "FROM\n" +
                "hospital_fetalheart\n" +
                "LEFT JOIN hospital ON hospital_fetalheart.hospital_id = hospital.id\n" +
                "LEFT JOIN department ON hospital_fetalheart.department_id = department.id\n" +
                "WHERE 1=1\n";

        if(StringUtils.isNotBlank(form.getSerialnum())){
            sql += "AND hospital_fetalheart.serialnum = '"+ SqlUtils.Sqlfilter(form.getSerialnum())+"'\n";
        }
        if(form.getUseType()!=-1){
            sql += "AND hospital_fetalheart.use_type = "+form.getUseType()+"\n";
        }
        if(form.getStatus()!=-1){
            sql += "AND hospital_fetalheart.status = "+form.getStatus()+"\n";
        }
        if(StringUtils.isNotBlank(form.getHospitalName())){
            sql += "AND hospital.name like '%%"+SqlUtils.Sqlfilter(form.getHospitalName())+"%%'\n";
        }
        if(StringUtils.isNotBlank(form.getDepartmentName())){
            sql += "AND department.department like '%%"+SqlUtils.Sqlfilter(form.getDepartmentName())+"%%'\n";
        }
        sql+=	"ORDER BY\n" +
                "hospital_fetalheart.create_time DESC\n";
        sql+=") tt";
        PageResult<HospitalFetalheartDO> result= hospitalFetalheartReadOnlyDao.fastQueryPage(sql, (new HospitalFetalheartDO()).getTableInfo().getRowMapper(), form.getPage(), form.getPageSize());
        List<HospitalFetalHeartInfo> devlist =new ArrayList<>();
        for (HospitalFetalheartDO hospitalFetalheartDO : result.getValue()){
            HospitalFetalHeartInfo hospitalFetalHeartInfo = new HospitalFetalHeartInfo();
            BeanUtils.copyProperties(hospitalFetalheartDO, hospitalFetalHeartInfo);
            HospitalDO hospitalDO = hospitalReadOnlyDao.get(hospitalFetalheartDO.getHospitalId());
            hospitalFetalHeartInfo.setDepartmentDO(departmentReadOnlyDao.get(hospitalFetalheartDO.getDepartmentId()));
            hospitalFetalHeartInfo.setHospitalDO(hospitalDO);
            devlist.add(hospitalFetalHeartInfo);
        }
        return  PageResult.createPage(result.getCount(), result.getPage(), result.getPageSize(), devlist);
    }

}
