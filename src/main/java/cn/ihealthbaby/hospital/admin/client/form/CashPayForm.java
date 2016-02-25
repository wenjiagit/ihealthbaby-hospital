package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class CashPayForm implements ApiMessage {

	/**
	 * 订单id 
	 */
	private long orderId;

	/**
	 * pos机刷卡交易号后六位 
	 */
	private String tradeNo;

	public CashPayForm() {
	}

	public CashPayForm(long orderId, String tradeNo) {
		this.orderId = orderId;
		this.tradeNo = tradeNo;
	}

	/**
	 * 订单id 
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * 订单id 
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * pos机刷卡交易号后六位 
	 */
	public String getTradeNo() {
		return tradeNo;
	}

	/**
	 * pos机刷卡交易号后六位 
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "orderId", orderId));

		if (tradeNo != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "tradeNo", tradeNo));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "CashPayForm [orderId=" + orderId + ",tradeNo=" + tradeNo + ", ]";
	}
}