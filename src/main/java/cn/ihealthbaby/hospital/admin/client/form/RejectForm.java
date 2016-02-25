package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  qiang on 2015/9/6.
 * jinliqiang@ihbaby.com
 */
public class RejectForm implements ApiMessage {

	private long refundId;

	private long serviceId;

	private String rejectReason;

	private String approver;

	public RejectForm() {
	}

	public RejectForm(long refundId, long serviceId, String rejectReason, String approver) {
		this.refundId = refundId;
		this.serviceId = serviceId;
		this.rejectReason = rejectReason;
		this.approver = approver;
	}

	public long getRefundId() {
		return refundId;
	}

	public void setRefundId(long refundId) {
		this.refundId = refundId;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "refundId", refundId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "serviceId", serviceId));

		if (rejectReason != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "rejectReason", rejectReason));
		}

		if (approver != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "approver", approver));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "RejectForm [refundId=" + refundId + ",serviceId=" + serviceId + ",rejectReason=" + rejectReason
				+ ",approver=" + approver + ", ]";
	}
}