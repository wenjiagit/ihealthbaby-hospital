package cn.ihealthbaby.hospital.model;

import java.util.List;

import cn.ihealthbaby.data.db.entity.DepartmentDO;

/**
 * Created by qiang on 2015/8/5.
 */
public class HospitalModel {
	private long id;
	/** 所在省 */
	private String province;
	/** 所在城市 */
	private String city;
	private String cityid;
	private String countyid;
	/** 所在区县 */
	private String county;
	/** 具体地址 */
	private String address;
	/** 医院名称 */
	private String name;
	/** 名字拼音 */
	private String pinyin;
	/** 医院的科室 */
	private List<DepartmentDO> department;
	/** 联系人姓名 */
	private String linkMan;
	/** 联系人电话 */
	private String mobile;
	/** 管理员 */
	private String administrator;
	private String posNo;

	public String getPosNo() {
		return posNo;
	}

	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public List<DepartmentDO> getDepartment() {
		return department;
	}

	public void setDepartment(List<DepartmentDO> department) {
		this.department = department;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
}
