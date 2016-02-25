package cn.ihealthbaby.hospital.admin.client.form;

import java.util.List;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 医院数据表单
 * @author  gwc
 */
public class HospitalForm implements ApiMessage {

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

	private List<java.lang.String> department;

	/**
	 * 联系人姓名 
	 */
	private String linkMan;

	/**
	 * 联系人电话 
	 */
	private String mobile;

	/**
	 * pos机的编号 
	 */
	private String posNo;

	public HospitalForm() {
	}

	public HospitalForm(String province, String city, String county, String address, String name,
			List<java.lang.String> department, String linkMan, String mobile, String posNo) {
		this.province = province;
		this.city = city;
		this.county = county;
		this.address = address;
		this.name = name;
		this.department = department;
		this.linkMan = linkMan;
		this.mobile = mobile;
		this.posNo = posNo;
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

	public List<java.lang.String> getDepartment() {
		return department;
	}

	public void setDepartment(List<java.lang.String> department) {
		this.department = department;
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

	/**
	 * pos机的编号 
	 */
	public String getPosNo() {
		return posNo;
	}

	/**
	 * pos机的编号 
	 */
	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public void addDepartment(java.lang.String department) {
		if (this.department == null) {
			this.department = new java.util.ArrayList<java.lang.String>();
		}
		this.department.add(department);
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

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

		if (department != null && (!department.isEmpty())) {
			for (int i = 0; i < department.size(); i++) {
				$list.add(new SimpleImmutableEntry<String, Object>(parent + "department", department.get(i)));
			}
		}

		if (linkMan != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "linkMan", linkMan));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		if (posNo != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "posNo", posNo));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "HospitalForm [province=" + province + ",city=" + city + ",county=" + county + ",address=" + address
				+ ",name=" + name + ",department=" + department + ",linkMan=" + linkMan + ",mobile=" + mobile
				+ ",posNo=" + posNo + ", ]";
	}
}