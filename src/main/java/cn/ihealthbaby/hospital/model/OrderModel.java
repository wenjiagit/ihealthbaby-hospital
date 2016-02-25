package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.ServiceDO;
import cn.ihealthbaby.data.db.entity.UserDO;
import cn.ihealthbaby.hospital.admin.client.model.Hospital;

import java.util.Date;

/**
 * @author qiang on 2015/8/25.
 * jinliqiang@ihbaby.com
 */
public class OrderModel {
    private long id;
    private HospitalDO hospitalDO;
    /**用户ID*/
    private UserDO userDO;
    /**服务id*/
    private long serviceId;
    /**订单类型  0 院内订单  1院外订单  */
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
    private int payType;
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

    private ServiceDO serviceDO;

    public ServiceDO getServiceDO() {
        return serviceDO;
    }

    public void setServiceDO(ServiceDO serviceDO) {
        this.serviceDO = serviceDO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
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

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
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

    public HospitalDO getHospitalDO() {
        return hospitalDO;
    }

    public void setHospitalDO(HospitalDO hospitalDO) {
        this.hospitalDO = hospitalDO;
    }
}
