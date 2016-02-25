package cn.ihealthbaby.hospital.admin.client.model;

import java.util.Date;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class Gravida implements ApiMessage {

	private long id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 手机电话
	 */
	private String mobile;

	/**
	 * 预产期
	 */
	private Date deliveryTime;

	/**
	 * 医生名
	 */
	private String doctorname;

	/**
	 * 设备编号
	 */
	private String serialnum;

	public Gravida() {
	}

	public Gravida(long id, String name, String mobile, Date deliveryTime, String doctorname, String serialnum) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.deliveryTime = deliveryTime;
		this.doctorname = doctorname;
		this.serialnum = serialnum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 手机电话
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 手机电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 预产期
	 */
	public Date getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * 预产期
	 */
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * 医生名
	 */
	public String getDoctorname() {
		return doctorname;
	}

	/**
	 * 医生名
	 */
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	/**
	 * 设备编号
	 */
	public String getSerialnum() {
		return serialnum;
	}

	/**
	 * 设备编号
	 */
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "deliveryTime", deliveryTime));

		if (doctorname != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "doctorname", doctorname));
		}

		if (serialnum != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "serialnum", serialnum));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "Gravida [id=" + id + ",name=" + name + ",mobile=" + mobile + ",deliveryTime=" + deliveryTime
				+ ",doctorname=" + doctorname + ",serialnum=" + serialnum + ", ]";
	}
}