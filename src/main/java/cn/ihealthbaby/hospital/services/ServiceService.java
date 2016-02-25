package cn.ihealthbaby.hospital.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ihealthbaby.hospital.helps.SqlUtils;
import cn.ihealthbaby.hospital.model.*;
import com.isnowfox.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ihealthbaby.data.db.dao.readonly.AdviceAskReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.AdviceReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.AdviceReplyReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.DepartmentReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalFetalheartReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.OrderItemReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.OrderReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.ProductReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.RefundReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.ServiceReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.UserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.AdviceAskDO;
import cn.ihealthbaby.data.db.entity.AdviceDO;
import cn.ihealthbaby.data.db.entity.AdviceReplyDO;
import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.HospitalFetalheartDO;
import cn.ihealthbaby.data.db.entity.OrderDO;
import cn.ihealthbaby.data.db.entity.OrderItemDO;
import cn.ihealthbaby.data.db.entity.ProductDO;
import cn.ihealthbaby.data.db.entity.RefundDO;
import cn.ihealthbaby.data.db.entity.ServiceDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.data.db.entity.UserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.ServiceForm;
import cn.ihealthbaby.hospital.form.ReadDataQueryForm;
import cn.ihealthbaby.hospital.form.ServiceDealForm;
import cn.ihealthbaby.hospital.form.ServiceQueryForm;

import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParam;
import com.isnowfox.core.dao.QueryParams;
import com.isnowfox.util.DateTimeUtils;

/**
 * Created by qiang on 2015/8/5.
 */
@Service
public class ServiceService {
	private static final int MAX = 10000;
	private static final int PAGE_MAX = 200;
	@Autowired
	private AdviceService adviceService;
	@Autowired
	private ServiceReadOnlyDao serviceReadOnlyDao;
	@Autowired
	private UserReadOnlyDao userReadOnlyDao;
	@Autowired
	private SysUserReadOnlyDao sysUserReadOnlyDao;
	@Autowired
	private HospitalReadOnlyDao hospitalReadOnlyDao;
	@Autowired
	private HospitalFetalheartReadOnlyDao hospitalFetalheartReadOnlyDao;
	@Autowired
	private AdviceReadOnlyDao adviceReadOnlyDao;
	@Autowired
	private AdviceAskReadOnlyDao adviceAskReadOnlyDao;
	@Autowired
	private AdviceReplyReadOnlyDao adviceReplyReadOnlyDao;
	@Autowired
	private ProductReadOnlyDao productReadOnlyDao;
	@Autowired
	private OrderReadOnlyDao orderReadOnlyDao;
	@Autowired
	private OrderItemReadOnlyDao orderItemReadOnlyDao;
	@Autowired
	private DepartmentReadOnlyDao departmentReadOnlyDao;
	@Autowired
	private RefundReadOnlyDao refundReadOnlyDao;
	@Autowired
	private ApiManager apiManager;
	public PageResult<ServiceModel> queryServiceList(
			ServiceQueryForm ServiceQueryForm, UserAccount account) {
		ServiceDO serviceDO1= new ServiceDO();
		String sql="SELECT %s FROM (\n" +
				"SELECT\n" +
				"service.*\n" +
				"FROM\n" +
				"service\n" +
				"LEFT  JOIN hospital ON service.hospital_id = hospital.id\n" +
				"LEFT JOIN `user` ON service.user_id = `user`.id\n" +
				"WHERE\n" +
				"1=1 ";
				if(StringUtils.isNotBlank(ServiceQueryForm.getUsername())){
					sql+="and `user`.`name` like '%%"+SqlUtils.Sqlfilter(ServiceQueryForm.getUsername())+"%%'\n";
				}
				if(StringUtils.isNotBlank(ServiceQueryForm.getHospitalName())){
					sql+="and `hospital`.`name` like '%%"+SqlUtils.Sqlfilter(ServiceQueryForm.getHospitalName())+"%%'\n";
				}
				if(StringUtils.isNotBlank(ServiceQueryForm.getServiceId())){
					sql+="and `service`.`service_number` = '"+SqlUtils.Sqlfilter(ServiceQueryForm.getServiceId())+"'\n";
				}
				if(StringUtils.isNotBlank(ServiceQueryForm.getSerialnum())){
					sql+="and `serialnum` = '"+SqlUtils.Sqlfilter(ServiceQueryForm.getSerialnum())+"'\n";
				}
				if(ServiceQueryForm.getServiceStatus()!=-1){
					sql+="and `service_status` = "+ServiceQueryForm.getServiceStatus()+"\n";
				}
				sql+=	"ORDER BY\n" +
				"service.begin_time DESC\n";
		        sql+=") tt";
		PageResult<ServiceDO> page =serviceReadOnlyDao.fastQueryPage(sql,serviceDO1.getTableInfo().getRowMapper(),ServiceQueryForm.getPage(), ServiceQueryForm.getPageSize());
		List<ServiceModel> list = new ArrayList<>();
		for (ServiceDO serviceDO : page.getValue()) {
			ServiceModel model = new ServiceModel();
			BeanUtils.copyProperties(serviceDO, model);
			UserDO userDO = userReadOnlyDao.get(serviceDO.getUserId());
			SysUserDO sysUserDO = sysUserReadOnlyDao.get(serviceDO
					.getDoctorId());
			HospitalDO hospitalDO = hospitalReadOnlyDao.get(serviceDO
					.getHospitalId());
			model.setUserDO(userDO);
			model.setHospitalDO(hospitalDO);
			model.setSysUserDO(sysUserDO);
			model.setRefundDO(refundReadOnlyDao.findObject(
					RefundDO.ThisTableInfo.SERVICE_ID_DB_NAME,
					serviceDO.getId()));
			list.add(model);
		}
		return PageResult.createPage(page.getCount(), page.getPage(),
				page.getPageSize(), list);
	}
	public PageResult<ServiceModel> queryServiceListHospital(
			ServiceQueryForm ServiceQueryForm, UserAccount account) {
		ServiceDO serviceDO1= new ServiceDO();
		String sql="SELECT %s FROM (\n" +
				"SELECT\n" +
				"service.*\n" +

				"FROM\n" +
				"service\n" +
				"LEFT  JOIN hospital ON service.hospital_id = hospital.id\n" +
				"LEFT JOIN `user` ON service.user_id = `user`.id\n" +
				"WHERE\n" +
				"service.hospital_id="+account.getSysUserDO().getHospitalId()+" ";
		if(StringUtils.isNotBlank(ServiceQueryForm.getUsername())){
			sql+="and `user`.`name` like '%%"+SqlUtils.Sqlfilter(ServiceQueryForm.getUsername())+"%%'\n";
		}
		if(StringUtils.isNotBlank(ServiceQueryForm.getHospitalName())){
			sql+="and `hospital`.`name` like '%%"+SqlUtils.Sqlfilter(ServiceQueryForm.getHospitalName())+"%%'\n";
		}
		if(StringUtils.isNotBlank(ServiceQueryForm.getServiceId())){
			sql+="and `service`.`service_number` = '"+SqlUtils.Sqlfilter(ServiceQueryForm.getServiceId())+"'\n";
		}
		if(StringUtils.isNotBlank(ServiceQueryForm.getSerialnum())){
			sql+="and `serialnum` = '"+SqlUtils.Sqlfilter(ServiceQueryForm.getSerialnum())+"'\n";
		}
		if(ServiceQueryForm.getServiceStatus()!=-1){
			sql+="and `service_status` = "+ServiceQueryForm.getServiceStatus()+"\n";
		}
		sql+=	"ORDER BY\n" +
				"service.begin_time DESC\n";
		sql+=") tt";
		PageResult<ServiceDO> page =serviceReadOnlyDao.fastQueryPage(sql, serviceDO1.getTableInfo().getRowMapper(), ServiceQueryForm.getPage(), ServiceQueryForm.getPageSize());
		List<ServiceModel> list = new ArrayList<>();
		for (ServiceDO serviceDO : page.getValue()) {
			ServiceModel model = new ServiceModel();
			BeanUtils.copyProperties(serviceDO, model);
			UserDO userDO = userReadOnlyDao.get(serviceDO.getUserId());
			SysUserDO sysUserDO = sysUserReadOnlyDao.get(serviceDO
					.getDoctorId());
			HospitalDO hospitalDO = hospitalReadOnlyDao.get(serviceDO
					.getHospitalId());
			model.setUserDO(userDO);
			model.setHospitalDO(hospitalDO);
			model.setSysUserDO(sysUserDO);
			model.setRefundDO(refundReadOnlyDao.findObject(
					RefundDO.ThisTableInfo.SERVICE_ID_DB_NAME,
					serviceDO.getId()));
			list.add(model);
		}
		return PageResult.createPage(page.getCount(), page.getPage(),
				page.getPageSize(), list);
	}
	public UserDO autoCompleteUserInfo(String mobile) {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(UserDO.ThisTableInfo.MOBILE_DB_NAME, mobile);
		UserDO userDO = userReadOnlyDao.findObject(queryParams);
		return userDO;
	}

	public UserDO autoCompleteBycaseNum(String caseNumber) {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(UserDO.ThisTableInfo.CASE_NUMBER_DB_NAME, caseNumber);
		UserDO userDO = userReadOnlyDao.findObject(queryParams);
		return userDO;
	}
	public List<HospitalDO> belongHospital(UserAccount account) {
		QueryParams params = QueryParams.create();
		if (account.getSysUserDO().getHospitalId() != 0) {
			params.add(HospitalDO.ThisTableInfo.ID_DB_NAME, account
					.getSysUserDO().getHospitalId());
		}
		List<HospitalDO> list = hospitalReadOnlyDao.find(MAX, params,
				Order.asc(HospitalDO.ThisTableInfo.PINYIN_DB_NAME));
		return list;
	}
	public List<DepartmentDO> belongDepartment(UserAccount account) {
		QueryParams params = QueryParams.create();
		if (account.getSysUserDO().getHospitalId() != 0) {
			params.add(DepartmentDO.ThisTableInfo.HOSPITALID_DB_NAME, account
					.getSysUserDO().getHospitalId());
		}
		List<DepartmentDO> list = departmentReadOnlyDao.find(MAX, params,
				Order.asc(DepartmentDO.ThisTableInfo.DEPARTMENT_DB_NAME));
		return list;
	}
	public List<SysUserDO> doctorList(long id, UserAccount account) {
		QueryParams params = QueryParams.create();
		params.add(SysUserDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, account
				.getSysUserDO().getHospitalId());
		params.add(SysUserDO.ThisTableInfo.DEPARTMENT_ID_DB_NAME, id);
		params.add(SysUserDO.ThisTableInfo.TYPE_DB_NAME, 1);
		return sysUserReadOnlyDao.find(MAX, params,
				Order.asc(SysUserDO.ThisTableInfo.PINYIN_DB_NAME));
	}
	public List<HospitalFetalheartDO> SNList(long id) {
		QueryParams params = QueryParams.create();
		params.add(HospitalFetalheartDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, id)
				.add(HospitalFetalheartDO.ThisTableInfo.STATUS_DB_NAME, 0)
				.add(HospitalFetalheartDO.ThisTableInfo.USE_TYPE_DB_NAME, 1);
		return hospitalFetalheartReadOnlyDao.find(MAX, params);
	}
	public Map<String, List<ProductDO>> productDOList(long id) {
		QueryParams params = QueryParams.create();
		params.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, id)
				.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 2)
				.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, true);
		QueryParams params2 = QueryParams.create();
		params2.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, id)
				.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 1)
				.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, true);
		QueryParams params3 = QueryParams.create();
		params3.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, id)
				.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 3)
				.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, true);
		Map<String, List<ProductDO>> map = new HashMap<>();
		map.put("costType", productReadOnlyDao.find(MAX, params));
		map.put("couplant", productReadOnlyDao.find(MAX, params2));
		map.put("askprice", productReadOnlyDao.find(MAX, params3));
		return map;
	}
	public Result dealService(ServiceForm form) throws Exception {
		form.setSerialnum(form.getSerialnum().toUpperCase());
		Result result = apiManager.adminServiceApi.newService(form);
		return result;
	}
	public boolean checkSerialnumExsit(String serialnum, long id) {
		QueryParams params = QueryParams.create();
		params.add(HospitalFetalheartDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, id)
				.add(HospitalFetalheartDO.ThisTableInfo.SERIALNUM_DB_NAME,
						serialnum.toUpperCase());
		HospitalFetalheartDO hfetalheartDO = hospitalFetalheartReadOnlyDao
				.findObject(params);
		if (hfetalheartDO != null) {
			// 若不是外租类型
			if (hfetalheartDO.getUseType() != 1) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}

	}
	public PageResult<ReadDataModel> readDataList(ReadDataQueryForm form) {
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
		String sql="SELECT %s FROM (\n" +
				"SELECT\n" +
				"advice.*\n" +
				"FROM\n" +
				"advice\n" +
				"LEFT  JOIN sys_user ON advice.doctor_id = sys_user.id\n" +
				"LEFT  JOIN `user` ON advice.user_id = `user`.id\n" +
				"WHERE\n" +
				"advice.`status`=1\n";
		if(form.getAdviceType()!=-1){
			sql+="AND `advice`.`advice_type` = '"+form.getAdviceType()+"'\n";
		}
		if(StringUtils.isNotBlank(form.getUsername())){
			sql+="AND `user`.`name` like '%%"+SqlUtils.Sqlfilter(form.getUsername())+"%%'\n";
		}
		if(StringUtils.isNotBlank(form.getDoctorname())){
			sql+="AND `sys_user`.`name` like '%%"+SqlUtils.Sqlfilter(form.getDoctorname())+"%%'\n";
		}
		if(StringUtils.isNotBlank(form.getAdviceId())){
			sql+="AND advice.advice_number ='"+SqlUtils.Sqlfilter(form.getAdviceId())+"'\n";
		}
		sql+=	"ORDER BY\n" +
				"advice.ask_time ASC\n";
		sql+=") tt";
		PageResult<AdviceDO> page = adviceReadOnlyDao.fastQueryPage(sql,(new AdviceDO()).getTableInfo().getRowMapper(),form.getPage(),pageSize);
		List<ReadDataModel> list = new ArrayList<>();
		for (AdviceDO adviceDO : page.getValue()) {
			ReadDataModel model = new ReadDataModel();
			BeanUtils.copyProperties(adviceDO, model);
			AdviceAskDO adviceAskDO = adviceAskReadOnlyDao.findObject(
					AdviceAskDO.ThisTableInfo.ADVICE_ID_DB_NAME,
					adviceDO.getId());
			model.setAdviceAskDO(adviceAskDO);
			model.setUserDO(userReadOnlyDao.get(adviceDO.getUserId()));
			model.setSysUserDO(sysUserReadOnlyDao.get(adviceDO.getDoctorId()));
			model.setHospitalDO(hospitalReadOnlyDao.get(adviceDO
					.getHospitalId()));
			model.setWaitTime(DateUtils.getTwoDateDisparity(adviceDO.getAskTime()));
			list.add(model);
		}
		return PageResult.createPage(page.getCount(), page.getPage(), pageSize,
				list);
	}
	public PageResult<ReadDataModel> readDataListHospital(ReadDataQueryForm form, UserAccount account) {
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
		String sql="SELECT %s FROM (\n" +
				"SELECT\n" +
				"advice.*\n" +
				"FROM\n" +
				"advice\n" +
				"LEFT  JOIN sys_user ON advice.doctor_id = sys_user.id\n" +
				"LEFT  JOIN `user` ON advice.user_id = `user`.id\n" +
				"WHERE\n" +
				"advice.`status`=1\n"+
				"AND advice.hospital_id="+account.getSysUserDO().getHospitalId()+"\n";
		if(form.getAdviceType()!=-1){
			sql+="AND `advice`.`advice_type` = '"+form.getAdviceType()+"'\n";
		}
		if(StringUtils.isNotBlank(form.getUsername())){
			sql+="AND `user`.`name` like '%%"+SqlUtils.Sqlfilter(form.getUsername())+"%%'\n";
		}
		if(StringUtils.isNotBlank(form.getDoctorname())){
			sql+="AND `sys_user`.`name` like '%%"+SqlUtils.Sqlfilter(form.getDoctorname())+"%%'\n";
		}
		if(StringUtils.isNotBlank(form.getAdviceId())){
			sql+="AND advice.advice_number ='"+SqlUtils.Sqlfilter(form.getAdviceId())+"'\n";
		}
		sql+=	"ORDER BY\n" +
				"advice.ask_time ASC\n";
		sql+=") tt";
		PageResult<AdviceDO> page = adviceReadOnlyDao.fastQueryPage(sql, (new AdviceDO()).getTableInfo().getRowMapper(), form.getPage(), pageSize);
		List<ReadDataModel> list = new ArrayList<>();
		for (AdviceDO adviceDO : page.getValue()) {
			ReadDataModel model = new ReadDataModel();
			BeanUtils.copyProperties(adviceDO, model);
			AdviceAskDO adviceAskDO = adviceAskReadOnlyDao.findObject(
					AdviceAskDO.ThisTableInfo.ADVICE_ID_DB_NAME,
					adviceDO.getId());
			model.setAdviceAskDO(adviceAskDO);
			model.setUserDO(userReadOnlyDao.get(adviceDO.getUserId()));
			model.setSysUserDO(sysUserReadOnlyDao.get(adviceDO.getDoctorId()));
			model.setHospitalDO(hospitalReadOnlyDao.get(adviceDO
					.getHospitalId()));
			model.setWaitTime(DateUtils.getTwoDateDisparity(adviceDO.getAskTime()));
			list.add(model);
		}
		return PageResult.createPage(page.getCount(), page.getPage(), pageSize,
				list);
	}
	public PageResult<ReadDataModel> readDataListDepartment(ReadDataQueryForm form,UserAccount account) {
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
		String sql="SELECT %s FROM (\n" +
				"SELECT\n" +
				"advice.*\n" +
				"FROM\n" +
				"advice\n" +
				"LEFT  JOIN sys_user ON advice.doctor_id = sys_user.id\n" +
				"LEFT  JOIN `user` ON advice.user_id = `user`.id\n" +
				"WHERE\n" +
				"advice.`status`=1\n"+
				"AND advice.hospital_id="+account.getSysUserDO().getHospitalId()+"\n";
		if(account.getSysUserDO().getDepartmentId()!=0){
			sql+="AND advice.department_id="+account.getSysUserDO().getDepartmentId()+" ";
		}
		if(form.getAdviceType()!=-1){
			sql+="AND `advice`.`advice_type` = '"+form.getAdviceType()+"'\n";
		}
		if(StringUtils.isNotBlank(form.getUsername())){
			sql+="AND `user`.`name` like '%%"+ SqlUtils.Sqlfilter(form.getUsername())+"%%'\n";
		}
		if(StringUtils.isNotBlank(form.getDoctorname())){
			sql+="AND `sys_user`.`name` like '%%"+SqlUtils.Sqlfilter(form.getDoctorname())+"%%'\n";
		}
		if(StringUtils.isNotBlank(form.getAdviceId())){
			sql+="AND advice.advice_number ='"+SqlUtils.Sqlfilter(form.getAdviceId())+"'\n";
		}
		sql+=	"ORDER BY\n" +
				"advice.ask_time DESC\n";
		sql+=") tt";
		PageResult<AdviceDO> page = adviceReadOnlyDao.fastQueryPage(sql, (new AdviceDO()).getTableInfo().getRowMapper(), form.getPage(), pageSize);
		List<ReadDataModel> list = new ArrayList<>();
		for (AdviceDO adviceDO : page.getValue()) {
			ReadDataModel model = new ReadDataModel();
			BeanUtils.copyProperties(adviceDO, model);
			AdviceAskDO adviceAskDO = adviceAskReadOnlyDao.findObject(
					AdviceAskDO.ThisTableInfo.ADVICE_ID_DB_NAME,
					adviceDO.getId());
			model.setAdviceAskDO(adviceAskDO);
			model.setUserDO(userReadOnlyDao.get(adviceDO.getUserId()));
			model.setSysUserDO(sysUserReadOnlyDao.get(adviceDO.getDoctorId()));
			model.setHospitalDO(hospitalReadOnlyDao.get(adviceDO
					.getHospitalId()));
			model.setWaitTime(DateUtils.getTwoDateDisparity(adviceDO.getAskTime()));
			list.add(model);
		}
		return PageResult.createPage(page.getCount(), page.getPage(), pageSize,
				list);
	}


	public long readDataListCount() {
		QueryParams params = QueryParams.create();
		params.add(AdviceDO.ThisTableInfo.STATUS_DB_NAME, 1);
		return adviceReadOnlyDao.getCount(params);
	}
	public long readDataListHospitalCount(UserAccount account) {
		QueryParams params = QueryParams.create();
		params.add(AdviceDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,account.getSysUserDO().getHospitalId());
		params.add(AdviceDO.ThisTableInfo.STATUS_DB_NAME, 1);
		return adviceReadOnlyDao.getCount(params);
	}
	public long readDataListDepartmentCount(UserAccount account) {
		QueryParams params = QueryParams.create();
		params.add(AdviceDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,account.getSysUserDO().getHospitalId());
		params.add(AdviceDO.ThisTableInfo.DEPARTMENT_ID_DB_NAME,account.getSysUserDO().getDepartmentId());
		params.add(AdviceDO.ThisTableInfo.STATUS_DB_NAME, 1);
		return  adviceReadOnlyDao.getCount(params);
	}
	/**
	 * 结算详情
	 *
	 * @param id
	 *            服务id
	 * @return
	 */
	public BalanceModel balanceDetail(long id) {

		ServiceDO serviceDO = serviceReadOnlyDao.get(id);
		if (serviceDO != null) {
			BalanceModel balanceModel = new BalanceModel();
			balanceModel.setHospitalDO(hospitalReadOnlyDao.get(serviceDO
					.getHospitalId()));
			int oneRentPrice = productReadOnlyDao.findObject(
					ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
					serviceDO.getHospitalId(),
					ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 2,
					ProductDO.ThisTableInfo.INNER_AMOUNT_DB_NAME, 1).getPrice();
			int oneAskPrice = 0;
			// 使用的费用(应收)
			int prePayTotal = 0;
			// 真实的咨询费
			int realAskTotal = 0;
			// 耦合剂总数
			int realCoupling = 0;
			// 耦合剂的总花销
			int realCouplingTotal = 0;
			// 总的咨询数
			int realAskCount = serviceDO.getUsedCount();
			// 总的使用天数
			int realRentCount = 0;
			if (serviceDO.getBeginTime() != null) {
				realRentCount = DateTimeUtils.getDays(serviceDO.getBeginTime(),
						new Date());
			}
			// 真是的租金
			int realRentTotal = 0;
			balanceModel.setService(serviceDO);
			List<OrderDO> orderDOs = orderReadOnlyDao.find(MAX,
					OrderDO.ThisTableInfo.SERVICE_ID_DB_NAME, id,
					Order.asc(OrderDO.ThisTableInfo.CREATE_TIME_DB_NAME));
			List<OrderDetailModel> orderDetailModels = new ArrayList<OrderDetailModel>();
			for (OrderDO orderDO : orderDOs) {
				OrderDetailModel orderDetailModel = new OrderDetailModel();
				BeanUtils.copyProperties(orderDO, orderDetailModel);
				List<OrderItemDO> orderItemDOs = orderItemReadOnlyDao.find(MAX,
						OrderItemDO.ThisTableInfo.ORDER_ID_DB_NAME,
						orderDO.getId());
				List<OrderItemModel> orderItemModels = new ArrayList<OrderItemModel>();
				for (OrderItemDO orderItemDO : orderItemDOs) {
					if (orderItemDO.getProductType() == 1) {
						realCoupling = realCoupling + orderItemDO.getAmount()
								* orderItemDO.getInnerAmount();
						realCouplingTotal += orderItemDO.getAmount()
								* orderItemDO.getPrice();
					}
					if (orderItemDO.getProductType() == 2) {

						realRentTotal += orderItemDO.getAmount()
								* orderItemDO.getPrice();
					}

					if (orderItemDO.getProductType() == 3) {
						balanceModel.setAskChargeType(orderItemDO
								.getChargeType());
						oneAskPrice = orderItemDO.getPrice()
								/ orderItemDO.getInnerAmount();
						realAskTotal += orderItemDO.getAmount()
								* orderItemDO.getPrice();
					}
					OrderItemModel orderItemModel = new OrderItemModel();
					BeanUtils.copyProperties(orderItemDO, orderItemModel);
					orderItemModels.add(orderItemModel);
				}
				prePayTotal += orderDetailModel.getOrderFee();
				orderDetailModel.setOrderItems(orderItemModels);
				orderDetailModels.add(orderDetailModel);
			}
			balanceModel.setOrderDetailModels(orderDetailModels);
			UserDO userDO = userReadOnlyDao.get(serviceDO.getUserId());
			balanceModel.setUser(userDO);
			balanceModel.setAge(DateTimeUtils.getAge(userDO.getBirthday()));
			balanceModel.setRealRentCount(realRentCount);
			balanceModel.setRealCoupling(realCoupling);
			balanceModel.setRealCouplingTotal(realCouplingTotal);
			if (realRentCount <= serviceDO.getTotalDays()
					|| serviceDO.getTotalDays() == -1) {
				balanceModel.setRealRentTotal(realRentTotal);
			} else {
				balanceModel.setRealRentTotal(realRentTotal
						+ (realRentCount - serviceDO.getTotalDays())
						* oneRentPrice);
			}
			if (realAskCount == serviceDO.getTotalCount()
					|| serviceDO.getTotalCount() == -1) {

				balanceModel.setRealAskTotal(realAskTotal);
			} else {
				balanceModel.setRealAskTotal(realAskTotal
						- (serviceDO.getTotalCount() - realAskCount)
						* oneAskPrice);
			}
			balanceModel.setPrePayTotal(prePayTotal);

			balanceModel.setRealAskCount(serviceDO.getUsedCount());
			if (balanceModel.getAskChargeType() != 1) {
				balanceModel.setRealTotal(balanceModel.getRealAskTotal()
						+ balanceModel.getRealCouplingTotal()
						+ balanceModel.getRealRentTotal());

			} else {
				balanceModel.setRealTotal(balanceModel.getRealCouplingTotal()
						+ balanceModel.getRealRentTotal());

			}
			balanceModel.setRefundTotal(prePayTotal
					- balanceModel.getRealTotal());
			return balanceModel;
		}
		return null;

	}


	/**
	 * 结算
	 *
	 * @param serviceId
	 * @return
	 */
	public Result balance(long serviceId) {
		return apiManager.adminServiceApi.balanceOutsideService(serviceId);
	}

	public HospitalPackageModel findProduct(Long hospitalId) {
		QueryParams params = QueryParams.create();
		params.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, hospitalId)
				.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 2)
				.add(ProductDO.ThisTableInfo.INNER_AMOUNT_DB_NAME,1, QueryParam.OperatorType.NOT)
				.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, true);
		QueryParams params2 = QueryParams.create();
		params2.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, hospitalId)
				.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 1)
				.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, true);
		QueryParams params3 = QueryParams.create();
		params3.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, hospitalId)
				.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 3)
				.add(ProductDO.ThisTableInfo.CHARGE_TYPE_DB_NAME,0)
				.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, true);
		QueryParams params1 = QueryParams.create();
		params1.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, hospitalId)
				.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 0)
				.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, true);
		HospitalPackageModel model = new HospitalPackageModel();
		model.setForgift(productReadOnlyDao.find(MAX,params1));
		model.setDayRent(productReadOnlyDao.find(MAX, params));
		model.setAskPrice(productReadOnlyDao.find(MAX, params3));
		model.setCouplant(productReadOnlyDao.find(MAX,params2));
		model.setId(hospitalId);
		return model;
	}
}
