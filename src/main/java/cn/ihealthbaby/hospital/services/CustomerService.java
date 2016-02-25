package cn.ihealthbaby.hospital.services;

import java.util.ArrayList;
import java.util.List;

import cn.ihealthbaby.hospital.form.DoctorQueryForm;
import cn.ihealthbaby.hospital.helps.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.ihealthbaby.data.db.dao.readonly.DepartmentReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.DoctorForm;
import cn.ihealthbaby.hospital.db.dao.cache.SysUserRoleCacheDao;
import cn.ihealthbaby.hospital.db.entity.SysUserRoleDO;
import cn.ihealthbaby.hospital.model.DoctorModel;

import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.QueryParams;

@Service
public class CustomerService {
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
				"sys_user.type = 0\n";
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
		PageResult<SysUserDO> customerPage = sysUserReadOnlyDao.fastQueryPage(sql, (new SysUserDO()).getTableInfo().getRowMapper(), page, pageSize);
		List<DoctorModel> list = new ArrayList<>();
		for (SysUserDO sysUserDO : customerPage.getValue()) {
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
		return PageResult.createPage(customerPage.getCount(),
				customerPage.getPage(), customerPage.getPageSize(), list);
	}
	public PageResult<DoctorModel> queryWithHospital(long hospitalId, DoctorQueryForm doctorQueryForm) {
		int pageSize = Math.min(doctorQueryForm.getPageSize(), PAGE_MAX);
		int page = doctorQueryForm.getPage();
		String sql="SELECT %s FROM (\n" +
				"SELECT sys_user.*\n" +
				"FROM\n" +
				"sys_user\n" +
				"Left JOIN hospital ON sys_user.hospital_id = hospital.id\n" +
				"Left JOIN department ON sys_user.department_id = department.id\n" +
				"WHERE\n" +
				"sys_user.type = 0\n"+
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
		PageResult<SysUserDO> customerPage = sysUserReadOnlyDao.fastQueryPage(sql, (new SysUserDO()).getTableInfo().getRowMapper(), page, pageSize);
		List<DoctorModel> list = new ArrayList<>();
		for (SysUserDO sysUserDO : customerPage.getValue()) {
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
		return PageResult.createPage(customerPage.getCount(),
				customerPage.getPage(), customerPage.getPageSize(), list);
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
				"sys_user.type = 0\n"+
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
		PageResult<SysUserDO> customerPage = sysUserReadOnlyDao.fastQueryPage(sql, (new SysUserDO()).getTableInfo().getRowMapper(), page, pageSize);
		List<DoctorModel> list = new ArrayList<>();
		for (SysUserDO sysUserDO : customerPage.getValue()) {
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
		return PageResult.createPage(customerPage.getCount(),
				customerPage.getPage(), customerPage.getPageSize(), list);
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
	public Result<Long> create(DoctorForm doctorForm) {
		doctorForm.setType(0);
		Result<Long> result = adminApiManager.adminDoctorApi.create(doctorForm);
		if (result.getStatus() == 0) {
			if (doctorForm.getTitle().equals("管理员")){
				SysUserRoleDO sysUserRoleDO = new SysUserRoleDO(result.getData(), 3);
			sysUserRoleCacheDao.insert(sysUserRoleDO);
			}else if(doctorForm.getTitle().equals("医院管理员")){
				SysUserRoleDO sysUserRoleDO = new SysUserRoleDO(result.getData(), 4);
				sysUserRoleCacheDao.insert(sysUserRoleDO);
			}
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
}
