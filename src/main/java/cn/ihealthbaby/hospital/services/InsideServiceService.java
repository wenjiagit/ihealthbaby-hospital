package cn.ihealthbaby.hospital.services;

import java.util.ArrayList;
import java.util.List;

import cn.ihealthbaby.hospital.helps.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ihealthbaby.data.db.dao.readonly.DepartmentReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.ServiceInsideReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.ServiceInsideDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.ServiceInsideForm;
import cn.ihealthbaby.hospital.form.InsideServiceQueryForm;
import cn.ihealthbaby.hospital.model.InsideServiceModel;

import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.QueryParams;

/**
 * Created by qiang on 2015/8/20.
 */
@Service
public class InsideServiceService {

	private static final int PAGE_MAX = 500;
	private static final int MAX = 10000;
	@Autowired
	private ApiManager apiManager;
	@Autowired
	private ServiceInsideReadOnlyDao serviceInsideReadOnlyDao;
	@Autowired
	private HospitalReadOnlyDao hospitalReadOnlyDao;
	@Autowired
	private DepartmentReadOnlyDao departmentReadOnlyDao;
	@Autowired
	private SysUserReadOnlyDao sysUserReadOnlyDao;

	public Result addInsideService(ServiceInsideForm form) {
		return apiManager.adminServiceApi.addServiceInside(form);
	}

	public PageResult<InsideServiceModel> getInsideServiceList(
			InsideServiceQueryForm form, UserAccount account) {
		long hid = account.getSysUserDO().getHospitalId();
		String sql="SELECT %s FROM (\n" +
				"SELECT service_inside.*\n" +
				"FROM\n" +
				"service_inside\n" +
				"LEFT  JOIN `user` ON service_inside.user_id = `user`.id\n"+
				"WHERE\n" +
				"1=1 \n";
		if(hid!=1){
			sql+="and `service_inside`.`hospital_id` = "+hid+"\n";
		}
		if(StringUtils.isNotBlank(form.getName())){
			sql+="and `user`.`name` like '%%"+ SqlUtils.Sqlfilter(form.getName())+"%%'\n";
		}
		if(StringUtils.isNotBlank(form.getMobile())){
			sql+="and `user`.`mobile` = '"+ SqlUtils.Sqlfilter(form.getMobile())+"'\n";
		}
		if(StringUtils.isNotBlank(form.getServiceNumber())) {
			if (form.getServiceNumber().matches("\\d*")) {
				sql += "and `service_inside`.`service_number` = '" + SqlUtils.Sqlfilter(form.getServiceNumber()) + "'\n";
			}
		}
		if(form.getStatus()!=-1){
			sql+="and `service_inside`.`status` = "+ form.getStatus()+"\n";
		}
		sql+=	"ORDER BY\n" +
				"service_inside.createtime DESC\n";
		sql+=") tt";
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
		PageResult<ServiceInsideDO> page = serviceInsideReadOnlyDao.fastQueryPage(
				sql, (new ServiceInsideDO()).getTableInfo().getRowMapper(), form.getPage(), pageSize);
		List<InsideServiceModel> list = new ArrayList<>();
		for (ServiceInsideDO serviceInsideDO : page.getValue()) {
			InsideServiceModel model = new InsideServiceModel();
			BeanUtils.copyProperties(serviceInsideDO, model);
			model.setHospitalDO(hospitalReadOnlyDao.get(serviceInsideDO
					.getHospitalId()));
			model.setDepartmentDO(departmentReadOnlyDao.get(serviceInsideDO
					.getDepartmentId()));
			model.setSysUserDO(sysUserReadOnlyDao.get(serviceInsideDO
					.getDoctorId()));
			list.add(model);
		}
		return PageResult.createPage(page.getCount(), page.getPage(),
				page.getPageSize(), list);
	}

	public PageResult<InsideServiceModel> getInsideServiceListToDeal(
			InsideServiceQueryForm form, UserAccount account) {
		QueryParams params = QueryParams.create();
		long hid = account.getSysUserDO().getHospitalId();
		if (hid != 0) {
			params.add(ServiceInsideDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, hid);
		}
		params.add(ServiceInsideDO.ThisTableInfo.STATUS_DB_NAME, 0);
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
		PageResult<ServiceInsideDO> page = serviceInsideReadOnlyDao.findPage(
				params, form.getPage(), pageSize);
		List<InsideServiceModel> list = new ArrayList<>();
		for (ServiceInsideDO serviceInsideDO : page.getValue()) {
			InsideServiceModel model = new InsideServiceModel();
			BeanUtils.copyProperties(serviceInsideDO, model);
			model.setHospitalDO(hospitalReadOnlyDao.get(serviceInsideDO
					.getHospitalId()));
			model.setDepartmentDO(departmentReadOnlyDao.get(serviceInsideDO
					.getDepartmentId()));
			model.setSysUserDO(sysUserReadOnlyDao.get(serviceInsideDO
					.getDoctorId()));
			list.add(model);
		}
		return PageResult.createPage(page.getCount(), page.getPage(),
				page.getPageSize(), list);
	}
}
