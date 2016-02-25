package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * Created by qiang on 2015/8/10.
 */
public class ProductForm implements ApiMessage {

	/**
	 * 主键
	 */
	private long id;

	/**
	 * 医院id
	 */
	private long hospitalId;

	/**
	 * 商品类型 0 押金, 1 耗材包 , 2 租金 ,3 咨询费
	 */
	private int productType;

	/**
	 * 是否需要运输  0 不需要 ,1 需要
	 */
	private boolean needDelivery;

	/**
	 * 收费类型 0 我们 ,1 医院,2 押金扣除
	 */
	private int chargeType;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 所含数量(如果为-1,表示可以无限使用)
	 */
	private int innerAmount;

	/**
	 * 组合价格
	 */
	private int price;

	/**
	 * 最大的购买数量
	 */
	private int maxAmount;

	/**
	 * 是否启用
	 */
	private boolean isUsable;

	/**
	 * 商品描述
	 */
	private String description;

	public ProductForm() {
	}

	public ProductForm(long id, long hospitalId, int productType, boolean needDelivery, int chargeType, String name,
			int innerAmount, int price, int maxAmount, boolean isUsable, String description) {
		this.id = id;
		this.hospitalId = hospitalId;
		this.productType = productType;
		this.needDelivery = needDelivery;
		this.chargeType = chargeType;
		this.name = name;
		this.innerAmount = innerAmount;
		this.price = price;
		this.maxAmount = maxAmount;
		this.isUsable = isUsable;
		this.description = description;
	}

	/**
	 * 主键
	 */
	public long getId() {
		return id;
	}

	/**
	 * 主键
	 */
	public void setId(long id) {
		this.id = id;
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

	/**
	 * 商品类型 0 押金, 1 耗材包 , 2 租金 ,3 咨询费
	 */
	public int getProductType() {
		return productType;
	}

	/**
	 * 商品类型 0 押金, 1 耗材包 , 2 租金 ,3 咨询费
	 */
	public void setProductType(int productType) {
		this.productType = productType;
	}

	/**
	 * 是否需要运输  0 不需要 ,1 需要
	 */
	public boolean getNeedDelivery() {
		return needDelivery;
	}

	/**
	 * 是否需要运输  0 不需要 ,1 需要
	 */
	public void setNeedDelivery(boolean needDelivery) {
		this.needDelivery = needDelivery;
	}

	/**
	 * 收费类型 0 我们 ,1 医院,2 押金扣除
	 */
	public int getChargeType() {
		return chargeType;
	}

	/**
	 * 收费类型 0 我们 ,1 医院,2 押金扣除
	 */
	public void setChargeType(int chargeType) {
		this.chargeType = chargeType;
	}

	/**
	 * 商品名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 商品名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 所含数量(如果为-1,表示可以无限使用)
	 */
	public int getInnerAmount() {
		return innerAmount;
	}

	/**
	 * 所含数量(如果为-1,表示可以无限使用)
	 */
	public void setInnerAmount(int innerAmount) {
		this.innerAmount = innerAmount;
	}

	/**
	 * 组合价格
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 组合价格
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 最大的购买数量
	 */
	public int getMaxAmount() {
		return maxAmount;
	}

	/**
	 * 最大的购买数量
	 */
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	/**
	 * 是否启用
	 */
	public boolean getIsUsable() {
		return isUsable;
	}

	/**
	 * 是否启用
	 */
	public void setIsUsable(boolean isUsable) {
		this.isUsable = isUsable;
	}

	/**
	 * 商品描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 商品描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "productType", productType));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "needDelivery", needDelivery));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "chargeType", chargeType));

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "innerAmount", innerAmount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "price", price));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "maxAmount", maxAmount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "isUsable", isUsable));

		if (description != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "description", description));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "ProductForm [id=" + id + ",hospitalId=" + hospitalId + ",productType=" + productType + ",needDelivery="
				+ needDelivery + ",chargeType=" + chargeType + ",name=" + name + ",innerAmount=" + innerAmount
				+ ",price=" + price + ",maxAmount=" + maxAmount + ",isUsable=" + isUsable + ",description="
				+ description + ", ]";
	}
}