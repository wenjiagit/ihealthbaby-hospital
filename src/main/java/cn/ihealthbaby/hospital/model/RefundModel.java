package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.ServiceDO;

import java.util.Date;

/**
 * @author qiang on 2015/10/21.
 *         jinliqiang@ihbaby.com
 */
public class RefundModel {
    private long id;
    /**监护单号*/
    private ServiceDO serviceDO;
    /**订单号*/
    private Long orderId;
    /**姓名*/
    private String name;
    private String mobile;
    private Long hospitalId;
    /**医院名称*/
    private String hospitalName;
    /**所属状态（0：申请中，1：已退款）*/
    private Integer status;
    /**支付金额*/
    private Integer payAmount;
    /**支付类型*/
    private Integer payType;
    /**实际退款金额*/
    private Integer refundAmount;
    /**申请退款金额*/
    private Integer applyAmount;
    /**退款时间*/
    private java.util.Date refundTime;
    /**申请时间*/
    private java.util.Date applyTime;
    /**审批人*/
    private String approver;
    /**申请人*/
    private String applicant;
    /**申请理由*/
    private String applyReason;
    /**驳回理由*/
    private String rejectReason;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ServiceDO getServiceDO() {
        return serviceDO;
    }

    public void setServiceDO(ServiceDO serviceDO) {
        this.serviceDO = serviceDO;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Integer applyAmount) {
        this.applyAmount = applyAmount;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}
