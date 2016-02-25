package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  qiang on 2015/8/26.
 * jinliqiang@ihbaby.com
 */
public class ConfirmDeliveryForm implements ApiMessage {

	private long orderId;

	/**
	 * 快递公司
	 */
	private String expressCom;

	/**
	 * 快递单号
	 */
	private String expressNo;

	private int deliverType;

	public ConfirmDeliveryForm() {
	}

	public ConfirmDeliveryForm(long orderId, String expressCom, String expressNo, int deliverType) {
		this.orderId = orderId;
		this.expressCom = expressCom;
		this.expressNo = expressNo;
		this.deliverType = deliverType;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * 快递公司
	 */
	public String getExpressCom() {
		return expressCom;
	}

	/**
	 * 快递公司
	 */
	public void setExpressCom(String expressCom) {
		this.expressCom = expressCom;
	}

	/**
	 * 快递单号
	 */
	public String getExpressNo() {
		return expressNo;
	}

	/**
	 * 快递单号
	 */
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}

	public int getDeliverType() {
		return deliverType;
	}

	public void setDeliverType(int deliverType) {
		this.deliverType = deliverType;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "orderId", orderId));

		if (expressCom != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "expressCom", expressCom));
		}

		if (expressNo != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "expressNo", expressNo));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "deliverType", deliverType));

		return $list;
	}

	@Override
	public String toString() {
		return "ConfirmDeliveryForm [orderId=" + orderId + ",expressCom=" + expressCom + ",expressNo=" + expressNo
				+ ",deliverType=" + deliverType + ", ]";
	}
}