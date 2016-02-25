package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * Created by qiang on 2015/8/20.
 */
public class SyncServiceInsideForm implements ApiMessage {

	private String name;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 孕妇生日
	 */
	private Date birthday;

	/**
	 * 预产期
	 */
	private Date deliveryTime;

	/**
	 * 医院id
	 */
	private long hospitalId;

	/**
	 * 医生id
	 */
	private long doctorId;

	/**
	 * 科室id
	 */
	private long departmentId;

	/**
	 * 产检编号
	 */
	private String caseNumber;

	private Date createtime;

	private long oldId;

	public SyncServiceInsideForm() {
	}

	public SyncServiceInsideForm(String name, String mobile, Date birthday, Date deliveryTime, long hospitalId,
			long doctorId, long departmentId, String caseNumber, Date createtime, long oldId) {
		this.name = name;
		this.mobile = mobile;
		this.birthday = birthday;
		this.deliveryTime = deliveryTime;
		this.hospitalId = hospitalId;
		this.doctorId = doctorId;
		this.departmentId = departmentId;
		this.caseNumber = caseNumber;
		this.createtime = createtime;
		this.oldId = oldId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 手机号
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 孕妇生日
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 孕妇生日
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
	 * 医生id
	 */
	public long getDoctorId() {
		return doctorId;
	}

	/**
	 * 医生id
	 */
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * 科室id
	 */
	public long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 科室id
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * 产检编号
	 */
	public String getCaseNumber() {
		return caseNumber;
	}

	/**
	 * 产检编号
	 */
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public long getOldId() {
		return oldId;
	}

	public void setOldId(long oldId) {
		this.oldId = oldId;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "birthday", birthday));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "deliveryTime", deliveryTime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "doctorId", doctorId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "departmentId", departmentId));

		if (caseNumber != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "caseNumber", caseNumber));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "createtime", createtime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "oldId", oldId));

		return $list;
	}

	@Override
	public String toString() {
		return "SyncServiceInsideForm [name=" + name + ",mobile=" + mobile + ",birthday=" + birthday + ",deliveryTime="
				+ deliveryTime + ",hospitalId=" + hospitalId + ",doctorId=" + doctorId + ",departmentId="
				+ departmentId + ",caseNumber=" + caseNumber + ",createtime=" + createtime + ",oldId=" + oldId + ", ]";
	}
}