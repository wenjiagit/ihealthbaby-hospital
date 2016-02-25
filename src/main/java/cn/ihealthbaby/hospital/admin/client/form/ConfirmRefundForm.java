package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 确认退款表单
 */
public class ConfirmRefundForm implements ApiMessage {

	/**
	 * 退款id 
	 */
	private long refundId;

	/**
	 * 退款金额 
	 */
	private double refundAmount;

	public ConfirmRefundForm() {
	}

	public ConfirmRefundForm(long refundId, double refundAmount) {
		this.refundId = refundId;
		this.refundAmount = refundAmount;
	}

	/**
	 * 退款id 
	 */
	public long getRefundId() {
		return refundId;
	}

	/**
	 * 退款id 
	 */
	public void setRefundId(long refundId) {
		this.refundId = refundId;
	}

	/**
	 * 退款金额 
	 */
	public double getRefundAmount() {
		return refundAmount;
	}

	/**
	 * 退款金额 
	 */
	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "refundId", refundId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "refundAmount", refundAmount));

		return $list;
	}

	@Override
	public String toString() {
		return "ConfirmRefundForm [refundId=" + refundId + ",refundAmount=" + refundAmount + ", ]";
	}
}