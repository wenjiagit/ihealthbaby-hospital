package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class WXPayForm implements ApiMessage {

	private long orderId;

	private String spbillCreateIp;

	public WXPayForm() {
	}

	public WXPayForm(long orderId, String spbillCreateIp) {
		this.orderId = orderId;
		this.spbillCreateIp = spbillCreateIp;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "orderId", orderId));

		if (spbillCreateIp != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "spbillCreateIp", spbillCreateIp));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "WXPayForm [orderId=" + orderId + ",spbillCreateIp=" + spbillCreateIp + ", ]";
	}
}