package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.ServiceDO;

import java.util.Date;

/**
 * @author qiang on 2015/10/20.
 *         jinliqiang@ihbaby.com
 */
public class OrderServiceModel {
    private long id;
    /**用户ID*/
    private long userId;
    /**服务id*/
    private ServiceDO serviceDO;
    /**订单类型  0 APP内服务订单 ,1 APP外服务订单  ,2 APP内商品订单 ,APP外商品订单  */
    private int orderType;
    /**订单金额*/
    private int orderFee;
    /**运费*/
    private int deliverFee;
    /**总金额*/
    private int totalFee;
    /**创建服务的时间*/
    private java.util.Date createTime;
    /**订单状态 0 未支付,1 待发货,2待收货,3订单结束,4 订单取消*/
    private int orderStatus;
    /**付款方式 0 院内现金支付,1 支付宝,2微信支付,3银联支付*/
    private Integer payType;
    /**配送类型 0 到院自提,1 邮寄*/
    private int deliverType;
    /**用户地址id*/
    private long addressId;
    /**付款时间*/
    private java.util.Date payTime;
    /**发货时间*/
    private java.util.Date deliverTime;
    /**收货时间*/
    private java.util.Date receiveTime;
    /**是否被删除*/
    private boolean isDelete;
    /**快递公司*/
    private String expressCom;
    /**快递单号*/
    private String expressNo;
    /**医院id*/
    private long hospitalId;
    /**订单描述*/
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public ServiceDO getServiceDO() {
        return serviceDO;
    }

    public void setServiceDO(ServiceDO serviceDO) {
        this.serviceDO = serviceDO;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(int orderFee) {
        this.orderFee = orderFee;
    }

    public int getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(int deliverFee) {
        this.deliverFee = deliverFee;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public int getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(int deliverType) {
        this.deliverType = deliverType;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getExpressCom() {
        return expressCom;
    }

    public void setExpressCom(String expressCom) {
        this.expressCom = expressCom;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
