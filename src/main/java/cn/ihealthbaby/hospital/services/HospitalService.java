package cn.ihealthbaby.hospital.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.ihealthbaby.hospital.helps.SqlUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ihealthbaby.data.db.dao.readonly.AreasReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.CitiesReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.DepartmentReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.ProvincesReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.AreasDO;
import cn.ihealthbaby.data.db.entity.CitiesDO;
import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.ProvincesDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.DepartmentForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalAddForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalQueryForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalStatusForm;
import cn.ihealthbaby.hospital.db.dao.cache.CatOptionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.NstOptionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.ReportSettingsCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysUserRoleCacheDao;
import cn.ihealthbaby.hospital.db.entity.CatOptionDO;
import cn.ihealthbaby.hospital.db.entity.NstOptionDO;
import cn.ihealthbaby.hospital.db.entity.ReportSettingsDO;
import cn.ihealthbaby.hospital.db.entity.SysUserRoleDO;
import cn.ihealthbaby.hospital.model.HospitalInfo;
import cn.ihealthbaby.hospital.model.HospitalModel;

import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParams;

@Service
public class HospitalService {
	@Autowired
	private HospitalReadOnlyDao hospitalReadOnlyDao;
	@Autowired
	private SysUserReadOnlyDao sysUserReadOnlyDao;
	@Autowired
	private ProvincesReadOnlyDao provincesReadOnlyDao;
	@Autowired
	private CitiesReadOnlyDao citiesReadOnlyDao;
	@Autowired
	private AreasReadOnlyDao areasReadOnlyDao;
	@Autowired
	private DepartmentReadOnlyDao departmentReadOnlyDao;
	@Autowired
	private NstOptionCacheDao nstOptionCacheDao;
	@Autowired
	private CatOptionCacheDao catOptionCacheDao;
	@Autowired
	private ReportSettingsCacheDao reportSettingsCacheDao;
	@Autowired
	private ApiManager apiManager;
	@Autowired
	private SysUserRoleCacheDao sysUserRoleCacheDao;

	public static final int MAX = 200;
	public HospitalInfo query(UserAccount account) {

		HospitalDO hospitalDO = hospitalReadOnlyDao.get(account.getSysUserDO()
				.getHospitalId());
		ProvincesDO provinceDO = provincesReadOnlyDao.findObject(
				ProvincesDO.ThisTableInfo.PROVINCEID_DB_NAME,
				hospitalDO.getProvince());
		CitiesDO cityDO = citiesReadOnlyDao.findObject(
				CitiesDO.ThisTableInfo.CITYID_DB_NAME, hospitalDO.getCity());
		AreasDO areasDO = areasReadOnlyDao.findObject(
				AreasDO.ThisTableInfo.AREAID_DB_NAME, hospitalDO.getCounty());
		HospitalInfo hospital = new HospitalInfo();
		BeanUtils.copyProperties(hospitalDO, hospital);
		hospital.setProvince(provinceDO.getProvince());
		hospital.setCity(cityDO.getCity());
		hospital.setCounty(areasDO.getArea());
		List<SysUserDO> admin = sysUserReadOnlyDao.find(
				1000,
				QueryParams
						.create()
						.add(SysUserDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
								account.getSysUserDO().getHospitalId())
						.add(SysUserDO.ThisTableInfo.ISADMIN_DB_NAME, true)
						.add(SysUserDO.ThisTableInfo.TYPE_DB_NAME, 0));
		if (!admin.isEmpty()) {
			StringBuffer buffer = new StringBuffer();
			for (SysUserDO sysUserDO : admin) {
				buffer.append(sysUserDO.getName()).append(" ");
			}
			hospital.setAdministrator(buffer.toString());
		}
		List<DepartmentDO> departmentDOs = departmentReadOnlyDao.find(
				MAX,
				QueryParams.create().add(
						DepartmentDO.ThisTableInfo.HOSPITALID_DB_NAME,
						hospitalDO.getId()));
		StringBuffer buffer = new StringBuffer();
		for (DepartmentDO departmentDO : departmentDOs) {
			buffer.append(departmentDO.getDepartment()).append(",");
		}
		hospital.setDepartment(buffer.substring(0, buffer.lastIndexOf(",")));
		return hospital;
	}

	public HospitalModel queryById(long id) {
		HospitalDO hospitalDO = hospitalReadOnlyDao.get(id);
		ProvincesDO provinceDO = provincesReadOnlyDao.findObject(
				ProvincesDO.ThisTableInfo.PROVINCEID_DB_NAME,
				hospitalDO.getProvince());
		CitiesDO cityDO = citiesReadOnlyDao.findObject(
				CitiesDO.ThisTableInfo.CITYID_DB_NAME, hospitalDO.getCity());
		AreasDO areasDO = areasReadOnlyDao.findObject(
				AreasDO.ThisTableInfo.AREAID_DB_NAME, hospitalDO.getCounty());
		HospitalModel info = new HospitalModel();
		BeanUtils.copyProperties(hospitalDO, info);
		info.setProvince(provinceDO.getProvince());
		info.setCity(cityDO.getCity());
		info.setCounty(areasDO.getArea());
		info.setCityid(cityDO.getCityid());
		info.setCountyid(areasDO.getAreaid());
		List<DepartmentDO> departmentDOs = departmentReadOnlyDao.find(
				MAX,
				QueryParams.create().add(
						DepartmentDO.ThisTableInfo.HOSPITALID_DB_NAME,
						hospitalDO.getId()));
		info.setDepartment(departmentDOs);
		return info;
	}
	public PageResult<HospitalInfo> queryForList(HospitalQueryForm form) {
		String sql="SELECT %s FROM (\n" +
				"SELECT *\n" +
				"FROM\n" +
				"hospital\n"+
				"WHERE 1 = 1\n";
		if(StringUtils.isNotBlank(form.getName())){
			sql += "AND `hospital`.name like '%%"+ SqlUtils.Sqlfilter(form.getName()) +"%%'\n";
		}
		if(StringUtils.isNotBlank(form.getProvince())&&!form.getProvince().equals("0")){
			sql += "AND `hospital`.province = '"+SqlUtils.Sqlfilter(form.getProvince()) +"'\n";
		}
		if(StringUtils.isNotBlank(form.getCity())&&!form.getCity().equals("0")){
			sql += "AND `hospital`.city = '"+SqlUtils.Sqlfilter(form.getCity()) +"'\n";
		}
		if(StringUtils.isNotBlank(form.getCounty())&&!form.getCounty().equals("0")){
			sql += "AND `hospital`.county = '"+SqlUtils.Sqlfilter(form.getCounty()) +"'\n";
		}
		sql+=	"ORDER BY\n" +
				"`hospital`.create_time DESC\n";
		sql+=") tt";
		PageResult<HospitalDO> hoslist = hospitalReadOnlyDao.fastQueryPage(sql, (new HospitalDO()).getTableInfo().getRowMapper(),
				form.getPage(), form.getPageSize());
		List<HospitalInfo> infolist = new ArrayList<>();
		for (HospitalDO hosDO : hoslist.getValue()) {
			HospitalInfo info = new HospitalInfo();
			ProvincesDO provinceDO = provincesReadOnlyDao.findObject(
					ProvincesDO.ThisTableInfo.PROVINCEID_DB_NAME,
					hosDO.getProvince());
			CitiesDO cityDO = citiesReadOnlyDao.findObject(
					CitiesDO.ThisTableInfo.CITYID_DB_NAME, hosDO.getCity());
			AreasDO areasDO = areasReadOnlyDao.findObject(
					AreasDO.ThisTableInfo.AREAID_DB_NAME, hosDO.getCounty());
			BeanUtils.copyProperties(hosDO, info);
			info.setProvince(provinceDO.getProvince());
			info.setCity(cityDO.getCity());
			info.setCounty(areasDO.getArea());
			List<SysUserDO> admin = sysUserReadOnlyDao.find(
					1000,
					QueryParams
							.create()
							.add(SysUserDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
									hosDO.getId())
							.add(SysUserDO.ThisTableInfo.ISADMIN_DB_NAME, true)
							.add(SysUserDO.ThisTableInfo.TYPE_DB_NAME, 0));
			if (!admin.isEmpty()) {
				StringBuffer buffer = new StringBuffer();
				for (SysUserDO sysUserDO : admin) {
					buffer.append(sysUserDO.getName()).append(" ");
				}
				info.setAdministrator(buffer.toString());
			}
			List<DepartmentDO> departmentDOs = departmentReadOnlyDao.find(
					MAX,
					QueryParams.create().add(
							DepartmentDO.ThisTableInfo.HOSPITALID_DB_NAME,
							hosDO.getId()));
			if (CollectionUtils.isNotEmpty(departmentDOs)) {
				StringBuffer buffer = new StringBuffer();
				for (DepartmentDO departmentDO : departmentDOs) {
					buffer.append(departmentDO.getDepartment()).append(",");
				}
				info.setDepartment(buffer.substring(0, buffer.lastIndexOf(",")));
			}
			infolist.add(info);
		}
		return PageResult.createPage(hoslist.getCount(), hoslist.getPage(),
				hoslist.getPageSize(), infolist);
	}
	public List<HospitalDO> getAllHospital() {
		return hospitalReadOnlyDao.find(MAX);
	}
	public List<DepartmentDO> getDepartmentByHosid(long hosid) {
		return departmentReadOnlyDao.find(
				MAX,
				QueryParams.create().add(
						DepartmentDO.ThisTableInfo.HOSPITALID_DB_NAME, hosid));
	}
	public List<ProvincesDO> getAllProvince() {
		return provincesReadOnlyDao.find(MAX, QueryParams.create(),
				Order.create("provinceid", false));
	}
	public List<CitiesDO> getCityByProvinceId(long id) {
		return citiesReadOnlyDao.find(
				MAX,
				QueryParams.create().add(
						CitiesDO.ThisTableInfo.PROVINCEID_DB_NAME, id));
	}

	public List<AreasDO> getAreaByCityId(long id) {
		return areasReadOnlyDao.find(
				MAX,
				QueryParams.create().add(AreasDO.ThisTableInfo.CITYID_DB_NAME,
						id));
	}

	public Result addHospitalInfo(HospitalAddForm form) {
		Result<Map<String, Long>> result = apiManager.adminHospitalApi
				.create(form);
		if (result.getStatus() == 0) {
			long hospitalId = result.getData().get("hosId");
			long userId = result.getData().get("sysUserId");
			NstOptionDO nstOptionDO = new NstOptionDO();
			nstOptionDO.setHospitalId(hospitalId);
			nstOptionDO.setNstOptionName("正常NST(+)");
			nstOptionDO.setNstOptionDetail("继续常规监护，具备条件的每日监护");
			nstOptionDO.setLevel(0);
			nstOptionCacheDao.insert(nstOptionDO);
			NstOptionDO nstOptionDO2 = new NstOptionDO();
			nstOptionDO2.setHospitalId(hospitalId);
			nstOptionDO2.setNstOptionName("不典型NST(+-)");
			nstOptionDO2.setNstOptionDetail("二十四小时来院进一步检查评估");
			nstOptionDO2.setLevel(1);
			nstOptionCacheDao.insert(nstOptionDO2);
			NstOptionDO nstOptionDO3 = new NstOptionDO();
			nstOptionDO3.setHospitalId(hospitalId);
			nstOptionDO3.setNstOptionName("异常NST(-)");
			nstOptionDO3.setNstOptionDetail("立即来院，全面评估胎儿状况");
			nstOptionDO3.setLevel(2);
			nstOptionCacheDao.insert(nstOptionDO3);
			NstOptionDO nstOptionDO4 = new NstOptionDO();
			nstOptionDO4.setHospitalId(hospitalId);
			nstOptionDO4.setNstOptionName(" NST无法判读");
			nstOptionDO4.setNstOptionDetail(" 继续20分钟监测");
			nstOptionDO4.setLevel(3);
			nstOptionCacheDao.insert(nstOptionDO4);
			CatOptionDO catOptionDO = new CatOptionDO();
			catOptionDO.setCatOptionName("Cat.I");
			catOptionDO.setCatOptionDetail("继续常规监护");
			catOptionDO.setHospitalId(hospitalId);
			catOptionDO.setLevel(0);
			catOptionCacheDao.insert(catOptionDO);
			CatOptionDO catOptionDO2 = new CatOptionDO();
			catOptionDO2.setCatOptionName("Cat.II");
			catOptionDO2.setCatOptionDetail("二十四小时来院评估");
			catOptionDO2.setHospitalId(hospitalId);
			catOptionDO2.setLevel(1);
			catOptionCacheDao.insert(catOptionDO2);
			CatOptionDO catOptionDO3 = new CatOptionDO();
			catOptionDO3.setCatOptionName("Cat.III");
			catOptionDO3.setCatOptionDetail("立即来院处理");
			catOptionDO3.setLevel(2);
			catOptionDO3.setHospitalId(hospitalId);
			catOptionCacheDao.insert(catOptionDO3);
			ReportSettingsDO reportSettingsDO = new ReportSettingsDO();
			reportSettingsDO.setPaperspeed(2);
			reportSettingsDO.setDivisionX(4);
			reportSettingsDO.setDivisionY(5);
			reportSettingsDO.setHospitalId(hospitalId);
			reportSettingsDO.setSignpageNstView(true);
			reportSettingsDO.setSignpageCatView(true);
			reportSettingsDO.setSignpageView(true);
			reportSettingsDO.setReportPrintCatView(true);
			reportSettingsDO.setReportPrintNstView(true);
			reportSettingsDO.setReportPrintView(true);
			reportSettingsDO.setTemplate("default");
			reportSettingsDO.setZoom(1.0);
			reportSettingsCacheDao.insert(reportSettingsDO);
			SysUserRoleDO userRoleDO = new SysUserRoleDO();
			userRoleDO.setUserId(userId);
			userRoleDO.setRoleId(4);
			sysUserRoleCacheDao.insert(userRoleDO);
		}
		return result;
	}
	public Result updateHospitalInfo(HospitalForm form, long id) {
		return apiManager.adminHospitalApi.update(id, form);
	}

	public List<HospitalDO> getHospital(UserAccount account) {
		return hospitalReadOnlyDao.find(MAX,
				HospitalDO.ThisTableInfo.ID_DB_NAME, account.getSysUserDO()
						.getHospitalId());
	}
	public DepartmentDO getDepartmentDO(long id) {
		return departmentReadOnlyDao.get(id);
	}

	public Result addDepartment(DepartmentForm form) {
		return apiManager.adminHospitalApi.addDepartment(form);
	}
	public Result updateDepartment(DepartmentForm form) {
		return apiManager.adminHospitalApi.updateDepartment(form);
	}

	public boolean isHospitalExsit(String hospitalname) {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(HospitalDO.ThisTableInfo.NAME_DB_NAME, hospitalname);
		HospitalDO hospitalDO = hospitalReadOnlyDao.findObject(queryParams);
		if (hospitalDO != null) {
			return true;
		} else {
			return false;
		}
	}

	public HospitalDO get(long id) {
		HospitalDO hospitalDO = hospitalReadOnlyDao.get(id);
		return hospitalDO;
	}

	public Result updateHospitalStatus(HospitalStatusForm form) {
		return apiManager.adminHospitalApi.updateHospitalStatus(form);
	}

}
