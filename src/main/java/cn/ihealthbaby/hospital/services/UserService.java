package cn.ihealthbaby.hospital.services;

import java.util.ArrayList;
import java.util.List;

import cn.ihealthbaby.data.db.dao.readonly.*;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.helps.SqlUtils;
import cn.ihealthbaby.hospital.model.OrderServiceModel;
import cn.ihealthbaby.hospital.model.UserModel;
import com.isnowfox.util.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.ihealthbaby.data.db.entity.AdviceAskDO;
import cn.ihealthbaby.data.db.entity.OrderDO;
import cn.ihealthbaby.data.db.entity.ServiceDO;
import cn.ihealthbaby.data.db.entity.UserDO;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.UserForm;
import cn.ihealthbaby.hospital.form.UserQueryForm;
import cn.ihealthbaby.hospital.model.AdviceAskModel;
import cn.ihealthbaby.hospital.model.ServiceModel;

import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParams;
@Service
public class UserService {
	private static final int MAX = 10000;
	@Value("${qiniu.base.path}")
	private String qiNiuBasePath;
	@Autowired
	private UserReadOnlyDao userReadOnlyDao;
	@Autowired
	private ServiceReadOnlyDao serviceReadOnlyDao;
	@Autowired
	private SysUserReadOnlyDao sysUserReadOnlyDao;
	@Autowired
	private OrderReadOnlyDao orderReadOnlyDao;
	@Autowired
	private AdviceReadOnlyDao adviceReadOnlyDao;
	@Autowired
	private AdviceAskReadOnlyDao adviceAskReadOnlyDao;
    @Autowired
	private HospitalReadOnlyDao hospitalReadOnlyDao;
	@Autowired
	private ApiManager adminApiManager;

	public PageResult<UserModel> query(UserQueryForm userQueryForm) {
		String sql="SELECT %s FROM (\n" +
				"SELECT `user`.*\n" +
				"FROM\n" +
				"`user`\n" +
				"Left JOIN hospital ON `user`.hospital_id = hospital.id\n" +
				"WHERE 1 = 1\n";
		if(StringUtils.isNotBlank(userQueryForm.getName())){
			sql += "AND `user`.name like '%%"+ SqlUtils.Sqlfilter(userQueryForm.getName()) +"%%'\n";
		}
		if(StringUtils.isNotBlank(userQueryForm.getMobile())){
			sql += "AND `user`.mobile = '"+SqlUtils.Sqlfilter(userQueryForm.getMobile()) +"'\n";
		}
		if(StringUtils.isNotBlank(userQueryForm.getHospitalName())){
			sql += "AND hospital.name like '%%"+SqlUtils.Sqlfilter(userQueryForm.getHospitalName()) +"%%'\n";
		}
		sql+=	"ORDER BY\n" +
				"`user`.create_time DESC\n";
		sql+=") tt";
		PageResult<UserDO> pageResult = userReadOnlyDao.fastQueryPage(sql, (new UserDO()).getTableInfo().getRowMapper(),
				userQueryForm.getPage(), userQueryForm.getPageSize());
		List<UserModel> list =new ArrayList<>();
		for (UserDO userDO : pageResult.getValue()) {
			if (userDO.getHeadPic() != null) {
				userDO.setHeadPic(qiNiuBasePath + userDO.getHeadPic());
			}
			UserModel model =new UserModel();
			BeanUtils.copyProperties(userDO,model);
			model.setHospitalDO(hospitalReadOnlyDao.get(userDO.getHospitalId()));
			list.add(model);
		}
		return PageResult.createPage(pageResult.getCount(),pageResult.getPage(),pageResult.getPageSize(),list);
	}
	public PageResult<UserModel> queryHospital(UserQueryForm userQueryForm,UserAccount account) {
		String sql="SELECT %s FROM (\n" +
				"SELECT `user`.*\n" +
				"FROM\n" +
				"`user`\n" +
				"Left JOIN hospital ON `user`.hospital_id = hospital.id\n" +
				"WHERE hospital.id = "+account.getSysUserDO().getHospitalId()+"\n";
		if(StringUtils.isNotBlank(userQueryForm.getName())){
			sql += "AND `user`.name like '%%"+ SqlUtils.Sqlfilter(userQueryForm.getName()) +"%%'\n";
		}
		if(StringUtils.isNotBlank(userQueryForm.getMobile())){
			sql += "AND `user`.mobile = '"+SqlUtils.Sqlfilter(userQueryForm.getMobile()) +"'\n";
		}
		if(StringUtils.isNotBlank(userQueryForm.getHospitalName())){
			sql += "AND hospital.name like '%%"+SqlUtils.Sqlfilter(userQueryForm.getHospitalName()) +"%%'\n";
		}
		sql+=	"ORDER BY\n" +
				"`user`.create_time DESC\n";
		sql+=") tt";
		PageResult<UserDO> pageResult = userReadOnlyDao.fastQueryPage(sql, (new UserDO()).getTableInfo().getRowMapper(),
				userQueryForm.getPage(), userQueryForm.getPageSize());
		List<UserModel> list =new ArrayList<>();
		for (UserDO userDO : pageResult.getValue()) {
			if (userDO.getHeadPic() != null) {
				userDO.setHeadPic(qiNiuBasePath + userDO.getHeadPic());
			}
			UserModel model =new UserModel();
			BeanUtils.copyProperties(userDO,model);
			model.setHospitalDO(hospitalReadOnlyDao.get(userDO.getHospitalId()));
			list.add(model);
		}
		return PageResult.createPage(pageResult.getCount(),pageResult.getPage(),pageResult.getPageSize(),list);
	}
	public UserDO get(long id) {
		UserDO userDO = userReadOnlyDao.get(id);
		if (userDO.getHeadPic() != null) {
			userDO.setHeadPic(qiNiuBasePath + userDO.getHeadPic());
		}
		return userDO;

	}

	public Result<Void> create(UserForm userForm) {
		return adminApiManager.adminUserApi.create(userForm);
	}

	public Result<Void> update(long id, UserForm userForm) {
		return adminApiManager.adminUserApi.update(id, userForm);
	}

	public Result<Void> delete(List<Long> ids) {
		return adminApiManager.adminUserApi.delete(ids);
	}
	public List<ServiceModel> getUserService(long userId) {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(ServiceDO.ThisTableInfo.USER_ID_DB_NAME, userId);
		List<ServiceModel> list = new ArrayList<>();
		List<ServiceDO> templist = serviceReadOnlyDao.find(MAX, queryParams,
				Order.asc(ServiceDO.ThisTableInfo.BEGIN_TIME_DB_NAME));
		for (ServiceDO serviceDO : templist) {
			ServiceModel model = new ServiceModel();
			BeanUtils.copyProperties(serviceDO, model);
			model.setSysUserDO(sysUserReadOnlyDao.get(serviceDO.getDoctorId()));
			list.add(model);
		}

		return list;
	}
	public List<AdviceAskModel> getUserAdvice(long userId) {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(AdviceAskDO.ThisTableInfo.USER_ID_DB_NAME, userId);
		List<AdviceAskModel> list = new ArrayList<>();
		List<AdviceAskDO> templist = adviceAskReadOnlyDao.find(MAX,
				queryParams,
				Order.asc(AdviceAskDO.ThisTableInfo.ASK_TIME_DB_NAME));
		for (AdviceAskDO adviceAskDO : templist) {
			AdviceAskModel model = new AdviceAskModel();
			BeanUtils.copyProperties(adviceAskDO, model);
			model.setAdviceDO(adviceReadOnlyDao.get(adviceAskDO.getAdviceId()));
			model.setSysUserDO(sysUserReadOnlyDao.get(adviceAskDO.getDoctorId()));
			list.add(model);
		}
		return list;
	}
	public List<OrderServiceModel> getUserOrder(long userId) {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(OrderDO.ThisTableInfo.USER_ID_DB_NAME, userId);
		List<OrderDO> templist = orderReadOnlyDao.find(MAX, queryParams,
				Order.asc(OrderDO.ThisTableInfo.CREATE_TIME_DB_NAME));
		List<OrderServiceModel> list = new ArrayList<>();
        for(OrderDO orderDO : templist){
			OrderServiceModel orderServiceModel =new OrderServiceModel();
			BeanUtils.copyProperties(orderDO,orderServiceModel);
			orderServiceModel.setServiceDO(serviceReadOnlyDao.get(orderDO.getServiceId()));
			list.add(orderServiceModel);
		}
		return list;
	}
    public Result passwordModify(long id,String password){
//		password= DigestUtils.digest(password);//在port 端口加密
		return adminApiManager.adminUserApi.passwordModify(id, password);
	}
}
