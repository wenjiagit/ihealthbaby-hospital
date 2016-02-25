package cn.ihealthbaby.hospital.services;

import java.util.ArrayList;
import java.util.List;

import cn.ihealthbaby.data.db.dao.readonly.*;
import cn.ihealthbaby.data.db.entity.*;
import cn.ihealthbaby.data.db.entity.UserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.form.*;
import cn.ihealthbaby.hospital.helps.ContractNumUtils;
import cn.ihealthbaby.hospital.helps.SqlUtils;
import cn.ihealthbaby.hospital.model.SingleOrderModel;
import com.isnowfox.core.dao.QueryParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Service;

import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.form.OrderQueryForm;
import cn.ihealthbaby.hospital.model.OrderDetailModel;
import cn.ihealthbaby.hospital.model.OrderItemModel;
import cn.ihealthbaby.hospital.model.OrderModel;

import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.QueryParams;

/**
 * @author qiang on 2015/8/25.
 */
@Service
public class OrderService {
	private static final int MAX = 10000;
	private static final int PAGE_MAX = 200;
	@Autowired
	private OrderReadOnlyDao orderReadOnlyDao;
	@Autowired
	private OrderItemReadOnlyDao orderItemReadOnlyDao;
	@Autowired
	private UserReadOnlyDao userReadOnlyDao;
	@Autowired
	private AddressReadOnlyDao addressReadOnlyDao;
	@Autowired
	private ProductReadOnlyDao productReadOnlyDao;
	@Autowired
	private ServiceReadOnlyDao serviceReadOnlyDao;
	@Autowired
	private HospitalReadOnlyDao hospitalReadOnlyDao;
	@Autowired
	private ApiManager apiManager;

	public PageResult<OrderModel> getOrderList(OrderQueryForm form) {
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
		String sql="SELECT %s FROM (\n" +"SELECT `order`.id, `order`.user_id, `order`.service_id, `order`.order_type, `order`.order_fee, `order`.deliver_fee, `order`.total_fee, `order`.create_time, `order`.order_status, `order`.pay_type, `order`.deliver_type, `order`.address_id, `order`.pay_time, `order`.deliver_time, `order`.receive_time, `order`.is_delete, `order`.express_com, `order`.express_no, `order`.hospital_id, `order`.description FROM `order` LEFT JOIN `user` ON `order`.user_id = `user`.id LEFT JOIN hospital ON `order`.hospital_id = hospital.id\n" +
				"WHERE 1 = 1\n" ;
                if(StringUtils.isNotBlank(form.getOrderId())){
					if(form.getOrderId().matches("\\d*")) {
						sql += "AND `order`.`id`=" + Long.valueOf(form.getOrderId()) + "\n";
					}
				}
				if(StringUtils.isNotBlank(form.getUserName())){
					sql+="AND `user`.`name`like '%%"+ SqlUtils.Sqlfilter(form.getUserName())+"%%'\n";
				}
				if(StringUtils.isNotBlank(form.getHospitalName())){
					sql+="AND `hospital`.`name` like '%%"+ SqlUtils.Sqlfilter(form.getHospitalName())+"%%'\n";
				}
				if(form.getOrderStatus()!=-1){
					sql+="AND `order`.`order_status` = "+form.getOrderStatus()+"\n";
				}
				if(form.getOrderType()!=-1){
					sql+="AND `order`.`order_type` ="+form.getOrderType()+"\n";
				}
				if(form.getDeliverType()!=-1){
					sql+="AND `order`.`deliver_type` ="+form.getDeliverType()+"\n";
				}
				if(form.getPayType()!=-1){
					sql+="AND `order`.`pay_type` ="+form.getPayType()+"\n";
				}
		sql+=	"ORDER BY\n" +
				"order.create_time DESC\n";
		sql+=") tt";
		PageResult<OrderDO> result = orderReadOnlyDao.fastQueryPage(sql, (new OrderDO()).getTableInfo().getRowMapper(),
				form.getPage(), pageSize);
		List<OrderModel> list = new ArrayList<>();
		for (OrderDO orderDO : result.getValue()) {
			OrderModel model = new OrderModel();
			BeanUtils.copyProperties(orderDO, model);
			model.setUserDO(userReadOnlyDao.get(orderDO.getUserId()));
			model.setHospitalDO(hospitalReadOnlyDao.get(orderDO.getHospitalId()));
			model.setServiceDO(serviceReadOnlyDao.get(orderDO.getServiceId()));
			list.add(model);
		}
		return PageResult.createPage(result.getCount(), result.getPage(),
				result.getPageSize(), list);
	}
	public PageResult<OrderModel> getOrderListHospital(OrderQueryForm form,
													   long hospitalId) {
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
		String sql="SELECT %s FROM (\n" +"SELECT `order`.id, `order`.user_id, `order`.service_id, `order`.order_type, `order`.order_fee, `order`.deliver_fee, `order`.total_fee, `order`.create_time, `order`.order_status, `order`.pay_type, `order`.deliver_type, `order`.address_id, `order`.pay_time, `order`.deliver_time, `order`.receive_time, `order`.is_delete, `order`.express_com, `order`.express_no, `order`.hospital_id, `order`.description FROM `order` LEFT JOIN `user` ON `order`.user_id = `user`.id LEFT JOIN hospital ON `order`.hospital_id = hospital.id\n" +
				"WHERE `hospital`.`id` = "+hospitalId+"\n" ;
		if(StringUtils.isNotBlank(form.getOrderId())){
			if(form.getOrderId().matches("\\d*")) {
				sql += "AND `order`.`id`=" + Long.valueOf(form.getOrderId()) + "\n";
			}
		}
		if(StringUtils.isNotBlank(form.getUserName())){
			sql+="AND `user`.`name`like '%%"+ SqlUtils.Sqlfilter(form.getUserName())+"%%'\n";
		}
		if(StringUtils.isNotBlank(form.getHospitalName())){
			sql+="AND `hospital`.`name` like '%%"+ SqlUtils.Sqlfilter(form.getHospitalName())+"%%'\n";
		}
		if(form.getOrderStatus()!=-1){
			sql+="AND `order`.`order_status` = "+form.getOrderStatus()+"\n";
		}
		if(form.getOrderType()!=-1){
			sql+="AND `order`.`order_type` ="+form.getOrderType()+"\n";
		}
		if(form.getDeliverType()!=-1){
			sql+="AND `order`.`deliver_type` ="+form.getDeliverType()+"\n";
		}
		if(form.getPayType()!=-1){
			sql+="AND `order`.`pay_type` ="+form.getPayType()+"\n";
		}
		sql+=	"ORDER BY\n" +
				"order.create_time DESC\n";
		sql+=") tt";
		PageResult<OrderDO> result = orderReadOnlyDao.fastQueryPage(sql, (new OrderDO()).getTableInfo().getRowMapper(),
				form.getPage(), pageSize);
		List<OrderModel> list = new ArrayList<>();
		for (OrderDO orderDO : result.getValue()) {
			OrderModel model = new OrderModel();
			BeanUtils.copyProperties(orderDO, model);
			model.setUserDO(userReadOnlyDao.get(orderDO.getUserId()));
			model.setHospitalDO(hospitalReadOnlyDao.get(orderDO.getHospitalId()));
			model.setServiceDO(serviceReadOnlyDao.get(orderDO.getServiceId()));
			list.add(model);
		}
		return PageResult.createPage(result.getCount(), result.getPage(),
				result.getPageSize(), list);
	}

	public OrderDetailModel getOrderDetail(long id) {

		OrderDetailModel model = new OrderDetailModel();
		OrderDO orderDO = orderReadOnlyDao.get(id);
		BeanUtils.copyProperties(orderDO, model);
		ServiceDO serviceDO=serviceReadOnlyDao.get(orderDO.getServiceId());
		model.setServiceDO(serviceDO);
		model.setUserDO(userReadOnlyDao.get(orderDO.getUserId()));
		model.setAddressDO(addressReadOnlyDao.get(orderDO.getAddressId()));
		model.setContractNum(ContractNumUtils.generateContractNum(orderDO.getCreateTime(),serviceDO.getServiceNumber()));
		List<OrderItemDO> itemDOs = orderItemReadOnlyDao.find(MAX,
				OrderItemDO.ThisTableInfo.ORDER_ID_DB_NAME, id);
		List<OrderItemModel> itemList = new ArrayList<>();
		for (OrderItemDO itemDO : itemDOs) {
			OrderItemModel itemModel = new OrderItemModel();
			BeanUtils.copyProperties(itemDO, itemModel);
			int price =0;
			if (itemDO.getChargeType()!=1) {
				price = itemDO.getPrice();
			}
			itemModel.setPrice(price);
			itemList.add(itemModel);
		}
		model.setOrderItems(itemList);
		return model;
	}
	public Result orderPay(CashPayForm cashPayForm) {
		return apiManager.adminOrderApi.posOrCashPay(cashPayForm);

	}
	public Result orderCancel(long orderId) {
		return apiManager.adminOrderApi.orderCancel(orderId);
	}

	public Result confirmDelivery(ConfirmDeliveryForm form) {
		return apiManager.adminOrderApi.confirmDelivery(form);
	}
	public Result addSN(long orderId, String serialnum) {
		return apiManager.adminOrderApi.addSN(orderId, serialnum.toUpperCase());
	}

	public SingleOrderModel addSingleOrder(String mobile,UserAccount userAccount) {
		SingleOrderModel model = isUserHasService(mobile);
		List<ProductDO> productDOs = productReadOnlyDao.find(MAX, QueryParams.create()
				.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, userAccount.getSysUserDO().getHospitalId())
				.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, 1)
				.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 1).or(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME, 3)
				.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, userAccount.getSysUserDO().getHospitalId())
				.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, 1));
		model.setProductDOs(productDOs);
		List<AddressDO> addressDOs =addressReadOnlyDao.find(MAX, AddressDO.ThisTableInfo.USER_ID_DB_NAME, model.getUserDO().getId());
		model.setAddressDOs(addressDOs);
		return model;
	}

	/**
	 * 判断用户是否有服务
	 * @param mobile
	 * @return
	 */
	public SingleOrderModel isUserHasService(String mobile){
		UserDO userDO = userReadOnlyDao.findObject(UserDO.ThisTableInfo.MOBILE_DB_NAME, mobile);
		if (userDO==null){
			return null;
		}
		ServiceDO serviceDO =serviceReadOnlyDao.findObject(QueryParams.create()
				.add(ServiceDO.ThisTableInfo.SERVICE_STATUS_DB_NAME, 3, QueryParam.OperatorType.LT)
				.add(ServiceDO.ThisTableInfo.USER_ID_DB_NAME, userDO.getId()));
		if (serviceDO == null){
			return null;
		}
		SingleOrderModel model = new SingleOrderModel();
		model.setServiceDO(serviceDO);
		model.setUserDO(userDO);
		return model;
	}

	public Result addNewAddress(long userId, AddressForm form) {
		return apiManager.adminOrderApi.addNewAddress(userId,form);
	}
	public Result<Long> createSingleOrder(SingleOrderForm form){
		return  apiManager.adminOrderApi.createSingleOrder(form);
	}

	public Result<String> getWxQr(WXPayForm form){
		return apiManager.adminOrderApi.getWxQr(form);
	}

	public Result<String> getAlipayQr(long orderId){
		return apiManager.adminOrderApi.getAlipayQr(orderId);
	}
}
