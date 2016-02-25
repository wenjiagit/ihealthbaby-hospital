package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 新建收货地址的表单
 */
public class AddressForm implements ApiMessage {

	/**
	 * 所在地区 
	 */
	private String area;

	/**
	 * 详细地址 
	 */
	private String address;

	/**
	 * 联系人 
	 */
	private String linkMan;

	/**
	 * 联系电话 
	 */
	private String mobile;

	public AddressForm() {
	}

	public AddressForm(String area, String address, String linkMan, String mobile) {
		this.area = area;
		this.address = address;
		this.linkMan = linkMan;
		this.mobile = mobile;
	}

	/**
	 * 所在地区 
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 所在地区 
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * 详细地址 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 详细地址 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 联系人 
	 */
	public String getLinkMan() {
		return linkMan;
	}

	/**
	 * 联系人 
	 */
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	/**
	 * 联系电话 
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 联系电话 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (area != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "area", area));
		}

		if (address != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "address", address));
		}

		if (linkMan != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "linkMan", linkMan));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "AddressForm [area=" + area + ",address=" + address + ",linkMan=" + linkMan + ",mobile=" + mobile
				+ ", ]";
	}
}