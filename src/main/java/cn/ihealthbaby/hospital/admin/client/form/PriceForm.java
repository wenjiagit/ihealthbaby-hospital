package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class PriceForm implements ApiMessage {

	/**
	 * 主键 
	 */
	private long id;

	/**
	 * 套装名称 
	 */
	private String name;

	/**
	 * 套餐类型 0 单个出售,1 满减 2 打包出售,3定额,4 限额,5最高费用 
	 */
	private int type;

	/**
	 * 计算金额的参数1 对于type(0,2)是商品数量 对于type(1)是满减的金额值 对于type(3,4,5,)是固定金额 
	 */
	private int num1;

	/**
	 * 计算金额的参数2 对于type(0,2)是打包金额 对于type(1)是减的金额 对于type(3,4,5)是0无效 
	 */
	private int num2;

	/**
	 * 组合价格 
	 */
	private int price;

	/**
	 * 是否启用 
	 */
	private boolean isUsable;

	/**
	 * 商品套装描述 
	 */
	private String description;

	public PriceForm() {
	}

	public PriceForm(long id, String name, int type, int num1, int num2, int price, boolean isUsable, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.num1 = num1;
		this.num2 = num2;
		this.price = price;
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
	 * 套装名称 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 套装名称 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 套餐类型 0 单个出售,1 满减 2 打包出售,3定额,4 限额,5最高费用 
	 */
	public int getType() {
		return type;
	}

	/**
	 * 套餐类型 0 单个出售,1 满减 2 打包出售,3定额,4 限额,5最高费用 
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 计算金额的参数1 对于type(0,2)是商品数量 对于type(1)是满减的金额值 对于type(3,4,5,)是固定金额 
	 */
	public int getNum1() {
		return num1;
	}

	/**
	 * 计算金额的参数1 对于type(0,2)是商品数量 对于type(1)是满减的金额值 对于type(3,4,5,)是固定金额 
	 */
	public void setNum1(int num1) {
		this.num1 = num1;
	}

	/**
	 * 计算金额的参数2 对于type(0,2)是打包金额 对于type(1)是减的金额 对于type(3,4,5)是0无效 
	 */
	public int getNum2() {
		return num2;
	}

	/**
	 * 计算金额的参数2 对于type(0,2)是打包金额 对于type(1)是减的金额 对于type(3,4,5)是0无效 
	 */
	public void setNum2(int num2) {
		this.num2 = num2;
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
	 * 商品套装描述 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 商品套装描述 
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "type", type));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "num1", num1));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "num2", num2));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "price", price));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "isUsable", isUsable));

		if (description != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "description", description));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "PriceForm [id=" + id + ",name=" + name + ",type=" + type + ",num1=" + num1 + ",num2=" + num2
				+ ",price=" + price + ",isUsable=" + isUsable + ",description=" + description + ", ]";
	}
}