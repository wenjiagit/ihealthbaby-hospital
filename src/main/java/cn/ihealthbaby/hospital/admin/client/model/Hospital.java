package cn.ihealthbaby.hospital.admin.client.model;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class Hospital implements ApiMessage {

	/**
	 * 主键ID 
	 */
	private long id;

	/**
	 * 所在省份 
	 */
	private String province;

	/**
	 * 所在城市 
	 */
	private String city;

	/**
	 * 所在区县 
	 */
	private String county;

	/**
	 * 具体地址 
	 */
	private String address;

	/**
	 * 医院名称 
	 */
	private String name;

	/**
	 * 联系人姓名 
	 */
	private String linkMan;

	/**
	 * 联系人电话 
	 */
	private String mobile;

	public Hospital() {
	}

	public Hospital(long id, String province, String city, String county, String address, String name, String linkMan,
			String mobile) {
		this.id = id;
		this.province = province;
		this.city = city;
		this.county = county;
		this.address = address;
		this.name = name;
		this.linkMan = linkMan;
		this.mobile = mobile;
	}

	/**
	 * 主键ID 
	 */
	public long getId() {
		return id;
	}

	/**
	 * 主键ID 
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 所在省份 
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 所在省份 
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 所在城市 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 所在城市 
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 所在区县 
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * 所在区县 
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * 具体地址 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 具体地址 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 医院名称 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 医院名称 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 联系人姓名 
	 */
	public String getLinkMan() {
		return linkMan;
	}

	/**
	 * 联系人姓名 
	 */
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	/**
	 * 联系人电话 
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 联系人电话 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		if (province != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "province", province));
		}

		if (city != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "city", city));
		}

		if (county != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "county", county));
		}

		if (address != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "address", address));
		}

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
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
		return "Hospital [id=" + id + ",province=" + province + ",city=" + city + ",county=" + county + ",address="
				+ address + ",name=" + name + ",linkMan=" + linkMan + ",mobile=" + mobile + ", ]";
	}
}