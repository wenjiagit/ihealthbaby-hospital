package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  qiang on 2015/8/29.
 * jinliqiang@ihbaby.com
 */
public class OrderItemForm implements ApiMessage {

	private long productId;

	private int amount;

	public OrderItemForm() {
	}

	public OrderItemForm(long productId, int amount) {
		this.productId = productId;
		this.amount = amount;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "productId", productId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "amount", amount));

		return $list;
	}

	@Override
	public String toString() {
		return "OrderItemForm [productId=" + productId + ",amount=" + amount + ", ]";
	}
}