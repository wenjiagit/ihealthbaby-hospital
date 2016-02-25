package cn.ihealthbaby.hospital.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ihealthbaby.hospital.form.DoctorQueryForm;
import cn.ihealthbaby.hospital.helps.SqlUtils;
import com.isnowfox.util.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.ihealthbaby.data.db.dao.readonly.AdviceReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.DepartmentReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.UserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.AdviceDO;
import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.DoctorForm;
import cn.ihealthbaby.hospital.db.dao.cache.SysUserRoleCacheDao;
import cn.ihealthbaby.hospital.db.entity.SysUserRoleDO;
import cn.ihealthbaby.hospital.model.AdviceModel;
import cn.ihealthbaby.hospital.model.DoctorModel;

import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParams;

@Service
public class DoctorService {
	private static final int MAX = 10000;

	@Value("${qiniu.base.path}")
	private String qiNiuBasePath;
	@Autowired
	private SysUserReadOnlyDao sysUserReadOnlyDao;
	@Autowired
	private DepartmentReadOnlyDao departmentReadOnlyDao;
	@Autowired
	private HospitalReadOnlyDao hospitalReadOnlyDao;
	@Autowired
	private SysUserRoleCacheDao sysUserRoleCacheDao;
	@Autowired
	private UserReadOnlyDao userReadOnlyDao;
	@Autowired
	private AdviceReadOnlyDao adviceReadOnlyDao;
	@Autowired
	private ApiManager adminApiManager;

	public static final int PAGE_MAX = 200;
	public PageResult<DoctorModel> query(DoctorQueryForm doctorQueryForm) {
		int pageSize = Math.min(doctorQueryForm.getPageSize(), PAGE_MAX);
		int page = doctorQueryForm.getPage();
		String sql="SELECT %s FROM (\n" +
				"SELECT sys_user.*\n" +
				"FROM\n" +
				"sys_user\n" +
				"Left JOIN hospital ON sys_user.hospital_id = hospital.id\n" +
				"Left JOIN department ON sys_user.department_id = department.id\n" +
				"WHERE\n" +
				"sys_user.type = 1\n";
        if(StringUtils.isNotBlank(doctorQueryForm.getName())){
			sql += "AND sys_user.name like '%%"+ SqlUtils.Sqlfilter(doctorQueryForm.getName())+"%%'\n";
		}
		if(StringUtils.isNotBlank(doctorQueryForm.getMobile())){
			sql += "AND sys_user.mobile = '"+SqlUtils.Sqlfilter(doctorQueryForm.getMobile())+"'\n";
		}
		if(StringUtils.isNotBlank(doctorQueryForm.getHospitalName())){
			sql += "AND hospital.name like '%%"+SqlUtils.Sqlfilter(doctorQueryForm.getHospitalName())+"%%'\n";
		}
		if(StringUtils.isNotBlank(doctorQueryForm.getDepartmentName())){
			sql += "AND department.department like '%%"+SqlUtils.Sqlfilter(doctorQueryForm.getDepartmentName())+"%%'\n";
		}
		sql+=	"ORDER BY\n" +
				"sys_user.create_time DESC\n";
		sql+=") tt";
		PageResult<SysUserDO> doctorPage = sysUserReadOnlyDao.fastQueryPage(sql, (new SysUserDO()).getTableInfo().getRowMapper(),page, pageSize);
		List<DoctorModel> list = new ArrayList<>();
		for (SysUserDO sysUserDO : doctorPage.getValue()) {
			DoctorModel model = new DoctorModel();
			BeanUtils.copyProperties(sysUserDO, model);
			model.setHospitalDO(hospitalReadOnlyDao.get(sysUserDO
					.getHospitalId()));
			model.setDepartmentDO(departmentReadOnlyDao.get(sysUserDO
					.getDepartmentId()));
			if (sysUserDO.getHeadPic() != null) {
				model.setHeadPic(qiNiuBasePath + sysUserDO.getHeadPic());
			}
			list.add(model);
		}
		return PageResult.createPage(doctorPage.getCount(),
				doctorPage.getPage(), doctorPage.getPageSize(), list);
	}
	public PageResult<DoctorModel> queryWithHospital(long hospitalId,DoctorQueryForm doctorQueryForm) {
		int pageSize = Math.min(doctorQueryForm.getPageSize(), PAGE_MAX);
		int page = doctorQueryForm.getPage();
		String sql="SELECT %s FROM (\n" +
				"SELECT sys_user.*\n" +
				"FROM\n" +
				"sys_user\n" +
				"Left JOIN hospital ON sys_user.hospital_id = hospital.id\n" +
				"Left JOIN department ON sys_user.department_id = department.id\n" +
				"WHERE\n" +
				"sys_user.type = 1\n" +
				"AND sys_user.hospital_id = "+hospitalId+"\n";
		if(StringUtils.isNotBlank(doctorQueryForm.getName())){
			sql += "AND sys_user.name like '%%"+SqlUtils.Sqlfilter(doctorQueryForm.getName())+"%%'\n";
		}
		if(StringUtils.isNotBlank(doctorQueryForm.getMobile())){
			sql += "AND sys_user.mobile = '"+SqlUtils.Sqlfilter(doctorQueryForm.getMobile())+"'\n";
		}
		if(StringUtils.isNotBlank(doctorQueryForm.getHospitalName())){
			sql += "AND hospital.name like '%%"+SqlUtils.Sqlfilter(doctorQueryForm.getHospitalName())+"%%'\n";
		}
		if(StringUtils.isNotBlank(doctorQueryForm.getDepartmentName())){
			sql += "AND department.department like '%%"+SqlUtils.Sqlfilter(doctorQueryForm.getDepartmentName())+"%%'\n";
		}
		sql+=	"ORDER BY\n" +
				"sys_user.create_time DESC\n";
		sql+=") tt";
		PageResult<SysUserDO> doctorPage = sysUserReadOnlyDao.fastQueryPage(sql, (new SysUserDO()).getTableInfo().getRowMapper(), page, pageSize);
		List<DoctorModel> list = new ArrayList<>();
		for (SysUserDO sysUserDO : doctorPage.getValue()) {
			DoctorModel model = new DoctorModel();
			BeanUtils.copyProperties(sysUserDO, model);
			model.setHospitalDO(hospitalReadOnlyDao.get(sysUserDO
					.getHospitalId()));
			model.setDepartmentDO(departmentReadOnlyDao.get(sysUserDO
					.getDepartmentId()));
			if (sysUserDO.getHeadPic() != null) {
				model.setHeadPic(qiNiuBasePath + sysUserDO.getHeadPic());
			}
			list.add(model);
		}
		return PageResult.createPage(doctorPage.getCount(),
				doctorPage.getPage(), doctorPage.getPageSize(), list);
	}
	public PageResult<DoctorModel> queryWithDepartment(long hospitalId,
			long departmentId, DoctorQueryForm doctorQueryForm) {
		int pageSize = Math.min(doctorQueryForm.getPageSize(), PAGE_MAX);
		int page = doctorQueryForm.getPage();
		String sql="SELECT %s FROM (\n" +
				"SELECT sys_user.*\n" +
				"FROM\n" +
				"sys_user\n" +
				"Left JOIN hospital ON sys_user.hospital_id = hospital.id\n" +
				"Left JOIN department ON sys_user.department_id = department.id\n" +
				"WHERE\n" +
				"sys_user.type = 1\n"+
				"AND sys_user.hospital_id = "+hospitalId+"\n" +
				"AND sys_user.department_id = "+departmentId+"\n";
		if(StringUtils.isNotBlank(doctorQueryForm.getName())){
			sql += "AND sys_user.name like '%%"+SqlUtils.Sqlfilter(doctorQueryForm.getName())+"%%'\n";
		}
		if(StringUtils.isNotBlank(doctorQueryForm.getMobile())){
			sql += "AND sys_user.mobile = '"+SqlUtils.Sqlfilter(doctorQueryForm.getMobile())+"'\n";
		}
		if(StringUtils.isNotBlank(doctorQueryForm.getHospitalName())){
			sql += "AND hospital.name like '%%"+SqlUtils.Sqlfilter(doctorQueryForm.getHospitalName())+"%%'\n";
		}
		if(StringUtils.isNotBlank(doctorQueryForm.getDepartmentName())){
			sql += "AND department.department like '%%"+SqlUtils.Sqlfilter(doctorQueryForm.getDepartmentName())+"%%'\n";
		}
		sql+=	"ORDER BY\n" +
				"sys_user.create_time DESC\n";
		sql+=") tt";
		PageResult<SysUserDO> doctorPage = sysUserReadOnlyDao.fastQueryPage(sql, (new SysUserDO()).getTableInfo().getRowMapper(), page, pageSize);
		List<DoctorModel> list = new ArrayList<>();
		for (SysUserDO sysUserDO : doctorPage.getValue()) {
			DoctorModel model = new DoctorModel();
			BeanUtils.copyProperties(sysUserDO, model);
			model.setHospitalDO(hospitalReadOnlyDao.get(sysUserDO
					.getHospitalId()));
			model.setDepartmentDO(departmentReadOnlyDao.get(sysUserDO
					.getDepartmentId()));
			if (sysUserDO.getHeadPic() != null) {
				model.setHeadPic(qiNiuBasePath + sysUserDO.getHeadPic());
			}
			list.add(model);
		}
		return PageResult.createPage(doctorPage.getCount(),
				doctorPage.getPage(), doctorPage.getPageSize(), list);
	}

	public DoctorForm get(long id) {
		DoctorForm form = new DoctorForm();
		SysUserDO userDO = sysUserReadOnlyDao.get(id);
		BeanUtils.copyProperties(userDO, form);
		if (userDO.getHeadPic() != null) {
			form.setHeadPic(qiNiuBasePath + userDO.getHeadPic());
		}
		return form;
	}
	public Result create(DoctorForm doctorForm) {
		doctorForm.setType(1);
		Result<Long> result = adminApiManager.adminDoctorApi.create(doctorForm);
		if (result.getStatus() == 0) {
			SysUserRoleDO sysUserRoleDO = new SysUserRoleDO(result.getData(), 2);
			sysUserRoleCacheDao.insert(sysUserRoleDO);
		}
		return result;

	}

	public Result<Void> update(long id, DoctorForm doctorForm) {
		Result result = adminApiManager.adminDoctorApi.update(id, doctorForm);
		return result;
	}

	public Result<Void> delete(long id) {
		return adminApiManager.adminDoctorApi.delete(id);
	}

	public Result<Void> delete(List<Long> ids) {
		return adminApiManager.adminDoctorApi.delete(ids);
	}

	public boolean mobileExist(String mobile) {
		if (mobile.equals("")){
			return false;
		}
		SysUserDO doctorDO = sysUserReadOnlyDao.findObject(
				SysUserDO.ThisTableInfo.MOBILE_DB_NAME, mobile);
		if (doctorDO != null) {
			return true;
		} else {
			return false;
		}
	}
	public boolean usernameExist(String username) {
		SysUserDO doctorDO = sysUserReadOnlyDao.findObject(
				SysUserDO.ThisTableInfo.USERNAME_DB_NAME, username);
		if (doctorDO != null) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 获取医生回复
	 * 
	 * @param doctorId
	 * @return
	 */
	public List<AdviceModel> getDoctorReply(long doctorId) {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(AdviceDO.ThisTableInfo.DOCTOR_ID_DB_NAME, doctorId);
		queryParams.add(AdviceDO.ThisTableInfo.STATUS_DB_NAME, 1)
				.or(AdviceDO.ThisTableInfo.STATUS_DB_NAME, 2)
				.add(AdviceDO.ThisTableInfo.DOCTOR_ID_DB_NAME, doctorId);
		List<AdviceDO> templist = adviceReadOnlyDao.find(MAX, queryParams,
				Order.asc(AdviceDO.ThisTableInfo.CREATE_TIME_DB_NAME));
		List<AdviceModel> list = new ArrayList<>();
		for (AdviceDO adviceDO : templist) {
			AdviceModel advice = new AdviceModel();
			BeanUtils.copyProperties(adviceDO, advice);
			advice.setUserDO(userReadOnlyDao.get(adviceDO.getUserId()));
			list.add(advice);
		}
		return list;
	}
	public DepartmentDO getDoctorDepartment(long doctorId) {
		SysUserDO doctorDO = sysUserReadOnlyDao.get(doctorId);
		DepartmentDO departmentDO = departmentReadOnlyDao.get(doctorDO
				.getDepartmentId());
		return departmentDO;
	}
	public Map<String, Long> getReplyCount(long doctorId) {
		Map<String, Long> map = new HashMap<>();
		long countWei = adviceReadOnlyDao.getCount(QueryParams.create()
				.add(AdviceDO.ThisTableInfo.DOCTOR_ID_DB_NAME, doctorId)
				.add(AdviceDO.ThisTableInfo.STATUS_DB_NAME, 1));
		long countYi = adviceReadOnlyDao.getCount(QueryParams.create()
				.add(AdviceDO.ThisTableInfo.DOCTOR_ID_DB_NAME, doctorId)
				.add(AdviceDO.ThisTableInfo.STATUS_DB_NAME, 2));
		map.put("whf", countWei);
		map.put("yhf", countYi);
		return map;
	}
	public Result passwordModify(long id,String password){
//		password=DigestUtils.digest(password);
		return adminApiManager.adminDoctorApi.passwordModify(id,password);
	}
}
