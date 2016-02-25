package cn.ihealthbaby.hospital.model;

import java.util.List;

import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.ServiceDO;
import cn.ihealthbaby.data.db.entity.UserDO;

/**
 * Created by qiang on 2015/8/19.
 */
public class BalanceModel {

	/** 用户信息 */
	private UserDO user;
    private HospitalDO hospitalDO;
	// 收费类型 0 我们 ,1 医院,2 押金扣除
	private int askChargeType;
	// 年龄
	private int age;
	// 使用的费用(应收)
	private int realTotal;
	// 真实的咨询费
	private int realAskTotal;
	// 耦合剂总数
	private int realCoupling;
	// 耦合剂的总花销
	private int realCouplingTotal;
	// 总的咨询数
	private int realAskCount;
	// 总的使用天数
	private int realRentCount;
	// 真是的租金
	private int realRentTotal;
	// 预付总额
	private int prePayTotal;
	// 退款总额
	private int refundTotal;

	/** 服务信息 */
	private ServiceDO service;

	public int getAskChargeType() {
		return askChargeType;
	}

	public void setAskChargeType(int askChargeType) {
		this.askChargeType = askChargeType;
	}

	/** 订单信息 */
	private List<OrderDetailModel> orderDetailModels;

	public int getRealCoupling() {
		return realCoupling;
	}

	public void setRealCoupling(int realCoupling) {
		this.realCoupling = realCoupling;
	}

	public int getRealCouplingTotal() {
		return realCouplingTotal;
	}

	public void setRealCouplingTotal(int realCouplingTotal) {
		this.realCouplingTotal = realCouplingTotal;
	}

	public int getRealAskCount() {
		return realAskCount;
	}

	public int getPrePayTotal() {
		return prePayTotal;
	}

	public void setPrePayTotal(int prePayTotal) {
		this.prePayTotal = prePayTotal;
	}

	public int getRefundTotal() {
		return refundTotal;
	}

	public void setRefundTotal(int refundTotal) {
		this.refundTotal = refundTotal;
	}

	public void setRealAskCount(int realAskCount) {
		this.realAskCount = realAskCount;
	}

	public int getRealRentCount() {
		return realRentCount;
	}

	public void setRealRentCount(int realRentCount) {
		this.realRentCount = realRentCount;
	}

	public UserDO getUser() {
		return user;
	}

	public void setUser(UserDO user) {
		this.user = user;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRealTotal() {
		return realTotal;
	}

	public void setRealTotal(int realTotal) {
		this.realTotal = realTotal;
	}

	public int getRealAskTotal() {
		return realAskTotal;
	}

	public void setRealAskTotal(int realAskTotal) {
		this.realAskTotal = realAskTotal;
	}

	public int getRealRentTotal() {
		return realRentTotal;
	}

	public void setRealRentTotal(int realRentTotal) {
		this.realRentTotal = realRentTotal;
	}

	public ServiceDO getService() {
		return service;
	}

	public void setService(ServiceDO service) {
		this.service = service;
	}

	public List<OrderDetailModel> getOrderDetailModels() {
		return orderDetailModels;
	}

	public void setOrderDetailModels(List<OrderDetailModel> orderDetailModels) {
		this.orderDetailModels = orderDetailModels;
	}

	public HospitalDO getHospitalDO() {
		return hospitalDO;
	}

	public void setHospitalDO(HospitalDO hospitalDO) {
		this.hospitalDO = hospitalDO;
	}

	@Override
	public String toString() {
		return "BalanceModel{" +
				"user=" + user +
				", hospitalDO=" + hospitalDO +
				", askChargeType=" + askChargeType +
				", age=" + age +
				", realTotal=" + realTotal +
				", realAskTotal=" + realAskTotal +
				", realCoupling=" + realCoupling +
				", realCouplingTotal=" + realCouplingTotal +
				", realAskCount=" + realAskCount +
				", realRentCount=" + realRentCount +
				", realRentTotal=" + realRentTotal +
				", prePayTotal=" + prePayTotal +
				", refundTotal=" + refundTotal +
				", service=" + service +
				", orderDetailModels=" + orderDetailModels +
				'}';
	}

	/*
	 * private long id;
	 *//** 用户ID */
	/*
	 * private UserDO userDO;
	 *//** 订单 */
	/*
	 * private OrderDO orderDO; private int prepayTotal;
	 *//** 订单项 */
	/*
	 * private List<OrderItemModel> orderItems; private int realTotal; private
	 * int realaskPrice; private int realdayRent; private int balanceTotal;
	 * 
	 * public int getBalanceTotal() { return balanceTotal; }
	 * 
	 * public void setBalanceTotal(int balanceTotal) { this.balanceTotal =
	 * balanceTotal; }
	 * 
	 * public int getRealTotal() { return realTotal; }
	 * 
	 * public void setRealTotal(int realTotal) { this.realTotal = realTotal; }
	 * 
	 * public int getRealaskPrice() { return realaskPrice; }
	 * 
	 * public void setRealaskPrice(int realaskPrice) { this.realaskPrice =
	 * realaskPrice; }
	 * 
	 * public int getRealdayRent() { return realdayRent; }
	 * 
	 * public void setRealdayRent(int realdayRent) { this.realdayRent =
	 * realdayRent; }
	 * 
	 * public int getUsedDay() { return usedDay; }
	 * 
	 * public void setUsedDay(int usedDay) { this.usedDay = usedDay; }
	 * 
	 * private int usedDay;
	 *//** age */
	/*
	 * private int age;
	 *//** 医生ID */
	/*
	 * private long doctorId;
	 *//** 设备编号 */
	/*
	 * private String serialnum;
	 *//** 产检编号 */
	/*
	 * private String caseNumber;
	 *//** 服务类型 0 院内监护服务 1 院外监护服务 */
	/*
	 * private int serviceType;
	 *//** 总的购买次数,如果为-1则没有限制 */
	/*
	 * private int totalCount;
	 *//** 已经使用的次数 */
	/*
	 * private int usedCount;
	 *//** 总的租用天数,如果为-1则没有限制 */
	/*
	 * private int totalDays;
	 *//** 服务开始时间(即开始计算租金的时间) */
	/*
	 * private java.util.Date beginTime;
	 *//** 服务的结束时间 */
	/*
	 * private java.util.Date endTime;
	 *//** 服务更新时间 */
	/*
	 * private java.util.Date updateTime;
	 *//** 创建服务的时间 */
	/*
	 * private java.util.Date createTime;
	 *//** 监护服务单号 */
	/*
	 * private String serviceNumber;
	 *//** 服务状态 0 开通未绑定设备,1绑定未激活服务,2服务已激活,3服务结束,4服务已取消 */
	/*
	 * private int serviceStatus;
	 * 
	 * public int getPrepayTotal() { return prepayTotal; }
	 * 
	 * public void setPrepayTotal(int prepayTotal) { this.prepayTotal =
	 * prepayTotal; }
	 * 
	 * public int getAge() { return age; }
	 * 
	 * public void setAge(int age) { this.age = age; }
	 * 
	 * public List<OrderItemModel> getOrderItems() { return orderItems; }
	 * 
	 * public void setOrderItems(List<OrderItemModel> orderItems) {
	 * this.orderItems = orderItems; }
	 * 
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 * 
	 * public UserDO getUserDO() { return userDO; }
	 * 
	 * public void setUserDO(UserDO userDO) { this.userDO = userDO; }
	 * 
	 * public OrderDO getOrderDO() { return orderDO; }
	 * 
	 * public void setOrderDO(OrderDO orderDO) { this.orderDO = orderDO; }
	 * 
	 * public long getDoctorId() { return doctorId; }
	 * 
	 * public void setDoctorId(long doctorId) { this.doctorId = doctorId; }
	 * 
	 * public String getSerialnum() { return serialnum; }
	 * 
	 * public void setSerialnum(String serialnum) { this.serialnum = serialnum;
	 * }
	 * 
	 * public String getCaseNumber() { return caseNumber; }
	 * 
	 * public void setCaseNumber(String caseNumber) { this.caseNumber =
	 * caseNumber; }
	 * 
	 * public int getServiceType() { return serviceType; }
	 * 
	 * public void setServiceType(int serviceType) { this.serviceType =
	 * serviceType; }
	 * 
	 * public int getTotalCount() { return totalCount; }
	 * 
	 * public void setTotalCount(int totalCount) { this.totalCount = totalCount;
	 * }
	 * 
	 * public int getUsedCount() { return usedCount; }
	 * 
	 * public void setUsedCount(int usedCount) { this.usedCount = usedCount; }
	 * 
	 * public int getTotalDays() { return totalDays; }
	 * 
	 * public void setTotalDays(int totalDays) { this.totalDays = totalDays; }
	 * 
	 * public Date getBeginTime() { return beginTime; }
	 * 
	 * public void setBeginTime(Date beginTime) { this.beginTime = beginTime; }
	 * 
	 * public Date getEndTime() { return endTime; }
	 * 
	 * public void setEndTime(Date endTime) { this.endTime = endTime; }
	 * 
	 * public Date getUpdateTime() { return updateTime; }
	 * 
	 * public void setUpdateTime(Date updateTime) { this.updateTime =
	 * updateTime; }
	 * 
	 * public Date getCreateTime() { return createTime; }
	 * 
	 * public void setCreateTime(Date createTime) { this.createTime =
	 * createTime; }
	 * 
	 * public String getServiceNumber() { return serviceNumber; }
	 * 
	 * public void setServiceNumber(String serviceNumber) { this.serviceNumber =
	 * serviceNumber; }
	 * 
	 * public int getServiceStatus() { return serviceStatus; }
	 * 
	 * public void setServiceStatus(int serviceStatus) { this.serviceStatus =
	 * serviceStatus; }
	 */
}
