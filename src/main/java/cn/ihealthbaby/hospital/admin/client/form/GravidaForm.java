package cn.ihealthbaby.hospital.admin.client.form;

import java.util.Date;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class GravidaForm implements ApiMessage {

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
	 * 生日
	 */
	private Date birthday;

	/**
	 * 预产期
	 */
	private Date deliveryTime;

	/**
	 * geo_hash 
	 */
	private String geoHash;

	public GravidaForm() {
	}

	public GravidaForm(long id, String name, String mobile, Date birthday, Date deliveryTime, String geoHash) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.birthday = birthday;
		this.deliveryTime = deliveryTime;
		this.geoHash = geoHash;
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

	/**
	 * geo_hash 
	 */
	public String getGeoHash() {
		return geoHash;
	}

	/**
	 * geo_hash 
	 */
	public void setGeoHash(String geoHash) {
		this.geoHash = geoHash;
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

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "birthday", birthday));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "deliveryTime", deliveryTime));

		if (geoHash != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "geoHash", geoHash));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "GravidaForm [id=" + id + ",name=" + name + ",mobile=" + mobile + ",birthday=" + birthday
				+ ",deliveryTime=" + deliveryTime + ",geoHash=" + geoHash + ", ]";
	}
}