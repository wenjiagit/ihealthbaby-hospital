package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  qiang on 2015/9/6.
 * jinliqiang@ihbaby.com
 */
public class NewApplyForm implements ApiMessage {

	private long serviceId;

	/**
	 * 订单号
	 */
	private long orderId;

	/**
	 * 姓名
	 */
	private String name;

	private String mobile;

	private long hospitalId;

	/**
	 * 医院名称
	 */
	private String hospitalName;

	/**
	 * 所属状态（0：申请中，1：已退款）
	 */
	private int status;

	/**
	 * 支付类型
	 */
	private int payType;

	private int payAmount;

	/**
	 * 申请退款金额
	 */
	private int applyAmount;

	/**
	 * 申请时间
	 */
	private Date applyTime;

	/**
	 * 申请人
	 */
	private String applicant;

	/**
	 * 申请理由
	 */
	private String applyReason;

	public NewApplyForm() {
	}

	public NewApplyForm(long serviceId, long orderId, String name, String mobile, long hospitalId, String hospitalName,
			int status, int payType, int payAmount, int applyAmount, Date applyTime, String applicant,
			String applyReason) {
		this.serviceId = serviceId;
		this.orderId = orderId;
		this.name = name;
		this.mobile = mobile;
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.status = status;
		this.payType = payType;
		this.payAmount = payAmount;
		this.applyAmount = applyAmount;
		this.applyTime = applyTime;
		this.applicant = applicant;
		this.applyReason = applyReason;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * 订单号
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * 订单号
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * 医院名称
	 */
	public String getHospitalName() {
		return hospitalName;
	}

	/**
	 * 医院名称
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	/**
	 * 所属状态（0：申请中，1：已退款）
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 所属状态（0：申请中，1：已退款）
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * 支付类型
	 */
	public int getPayType() {
		return payType;
	}

	/**
	 * 支付类型
	 */
	public void setPayType(int payType) {
		this.payType = payType;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * 申请退款金额
	 */
	public int getApplyAmount() {
		return applyAmount;
	}

	/**
	 * 申请退款金额
	 */
	public void setApplyAmount(int applyAmount) {
		this.applyAmount = applyAmount;
	}

	/**
	 * 申请时间
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * 申请时间
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * 申请人
	 */
	public String getApplicant() {
		return applicant;
	}

	/**
	 * 申请人
	 */
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	/**
	 * 申请理由
	 */
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * 申请理由
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "serviceId", serviceId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "orderId", orderId));

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		if (hospitalName != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalName", hospitalName));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "status", status));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "payType", payType));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "payAmount", payAmount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "applyAmount", applyAmount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "applyTime", applyTime));

		if (applicant != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "applicant", applicant));
		}

		if (applyReason != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "applyReason", applyReason));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "NewApplyForm [serviceId=" + serviceId + ",orderId=" + orderId + ",name=" + name + ",mobile=" + mobile
				+ ",hospitalId=" + hospitalId + ",hospitalName=" + hospitalName + ",status=" + status + ",payType="
				+ payType + ",payAmount=" + payAmount + ",applyAmount=" + applyAmount + ",applyTime=" + applyTime
				+ ",applicant=" + applicant + ",applyReason=" + applyReason + ", ]";
	}
}