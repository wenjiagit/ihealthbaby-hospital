package cn.ihealthbaby.hospital.admin.client.form;

import java.util.List;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  qiang on 2015/8/29.
 * jinliqiang@ihbaby.com
 */
public class SingleOrderForm implements ApiMessage {

	private long userId;

	/**
	 * 服务id
	 */
	private long serviceId;

	/**
	 * 订单类型  0 APP内服务订单 ,1 APP外服务订单  ,2 APP内商品订单 ,APP外商品订单  
	 */
	private int orderType;

	/**
	 * 配送类型 0 到院自提,1 邮寄
	 */
	private int deliverType;

	/**
	 * 用户地址id
	 */
	private long addressId;

	/**
	 * 医院id
	 */
	private long hospitalId;

	private List<OrderItemForm> orderitemlist;

	public SingleOrderForm() {
	}

	public SingleOrderForm(long userId, long serviceId, int orderType, int deliverType, long addressId,
			long hospitalId, List<OrderItemForm> orderitemlist) {
		this.userId = userId;
		this.serviceId = serviceId;
		this.orderType = orderType;
		this.deliverType = deliverType;
		this.addressId = addressId;
		this.hospitalId = hospitalId;
		this.orderitemlist = orderitemlist;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * 服务id
	 */
	public long getServiceId() {
		return serviceId;
	}

	/**
	 * 服务id
	 */
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * 订单类型  0 APP内服务订单 ,1 APP外服务订单  ,2 APP内商品订单 ,APP外商品订单  
	 */
	public int getOrderType() {
		return orderType;
	}

	/**
	 * 订单类型  0 APP内服务订单 ,1 APP外服务订单  ,2 APP内商品订单 ,APP外商品订单  
	 */
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	/**
	 * 配送类型 0 到院自提,1 邮寄
	 */
	public int getDeliverType() {
		return deliverType;
	}

	/**
	 * 配送类型 0 到院自提,1 邮寄
	 */
	public void setDeliverType(int deliverType) {
		this.deliverType = deliverType;
	}

	/**
	 * 用户地址id
	 */
	public long getAddressId() {
		return addressId;
	}

	/**
	 * 用户地址id
	 */
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	/**
	 * 医院id
	 */
	public long getHospitalId() {
		return hospitalId;
	}

	/**
	 * 医院id
	 */
	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public List<OrderItemForm> getOrderitemlist() {
		return orderitemlist;
	}

	public void setOrderitemlist(List<OrderItemForm> orderitemlist) {
		this.orderitemlist = orderitemlist;
	}

	public void addOrderitemlist(OrderItemForm orderitemlist) {
		if (this.orderitemlist == null) {
			this.orderitemlist = new java.util.ArrayList<OrderItemForm>();
		}
		this.orderitemlist.add(orderitemlist);
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "userId", userId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "serviceId", serviceId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "orderType", orderType));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "deliverType", deliverType));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "addressId", addressId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		if (orderitemlist != null && (!orderitemlist.isEmpty())) {
			for (int i = 0; i < orderitemlist.size(); i++) {
				orderitemlist.get(i).encode(parent + "orderitemlist" + "[" + i + "].", $list);
			}
		}

		return $list;
	}

	@Override
	public String toString() {
		return "SingleOrderForm [userId=" + userId + ",serviceId=" + serviceId + ",orderType=" + orderType
				+ ",deliverType=" + deliverType + ",addressId=" + addressId + ",hospitalId=" + hospitalId
				+ ",orderitemlist=" + orderitemlist + ", ]";
	}
}