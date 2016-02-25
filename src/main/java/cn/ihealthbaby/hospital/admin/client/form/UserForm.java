package cn.ihealthbaby.hospital.admin.client.form;

import java.util.Date;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class UserForm implements ApiMessage {

	/**
	 * 姓名 
	 */
	private String name;

	/**
	 * 座机电话 
	 */
	private String telephone;

	/**
	 * 手机电话 
	 */
	private String mobile;

	/**
	 * 生日 
	 */
	private Date birthday;

	/**
	 * 预产期 
	 */
	private Date deliveryTime;

	private long hospitalId;

	public UserForm() {
	}

	public UserForm(String name, String telephone, String mobile, Date birthday, Date deliveryTime, long hospitalId) {
		this.name = name;
		this.telephone = telephone;
		this.mobile = mobile;
		this.birthday = birthday;
		this.deliveryTime = deliveryTime;
		this.hospitalId = hospitalId;
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
	 * 座机电话 
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 座机电话 
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * 生日 
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 生日 
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		if (telephone != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "telephone", telephone));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "birthday", birthday));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "deliveryTime", deliveryTime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		return $list;
	}

	@Override
	public String toString() {
		return "UserForm [name=" + name + ",telephone=" + telephone + ",mobile=" + mobile + ",birthday=" + birthday
				+ ",deliveryTime=" + deliveryTime + ",hospitalId=" + hospitalId + ", ]";
	}
}