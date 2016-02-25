package cn.ihealthbaby.hospital.admin.client.model;

import java.util.Date;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class User implements ApiMessage {

	private long id;

	/**
	 * 姓名 
	 */
	private String name;

	/**
	 * 名称允许重复 
	 */
	private String pinyin;

	/**
	 * 座机电话 
	 */
	private String telephone;

	/**
	 * 手机电话 
	 */
	private String mobile;

	/**
	 * 密码 
	 */
	private String password;

	/**
	 * 头像 
	 */
	private String headPic;

	/**
	 * 生日 
	 */
	private Date birthday;

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

	/**
	 * geo_hash 
	 */
	private String geoHash;

	public User() {
	}

	public User(long id, String name, String pinyin, String telephone, String mobile, String password, String headPic,
			Date birthday, Date deliveryTime, String doctorname, String serialnum, String geoHash) {
		this.id = id;
		this.name = name;
		this.pinyin = pinyin;
		this.telephone = telephone;
		this.mobile = mobile;
		this.password = password;
		this.headPic = headPic;
		this.birthday = birthday;
		this.deliveryTime = deliveryTime;
		this.doctorname = doctorname;
		this.serialnum = serialnum;
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
	 * 名称允许重复 
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * 名称允许重复 
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
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
	 * 密码 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 密码 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 头像 
	 */
	public String getHeadPic() {
		return headPic;
	}

	/**
	 * 头像 
	 */
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
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

		if (pinyin != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "pinyin", pinyin));
		}

		if (telephone != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "telephone", telephone));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		if (password != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "password", password));
		}

		if (headPic != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "headPic", headPic));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "birthday", birthday));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "deliveryTime", deliveryTime));

		if (doctorname != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "doctorname", doctorname));
		}

		if (serialnum != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "serialnum", serialnum));
		}

		if (geoHash != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "geoHash", geoHash));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ",name=" + name + ",pinyin=" + pinyin + ",telephone=" + telephone + ",mobile="
				+ mobile + ",password=" + password + ",headPic=" + headPic + ",birthday=" + birthday + ",deliveryTime="
				+ deliveryTime + ",doctorname=" + doctorname + ",serialnum=" + serialnum + ",geoHash=" + geoHash
				+ ", ]";
	}
}