package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class DeviceForm implements ApiMessage {

	/**
	 * 医院ID 
	 */
	private long hospitalId;

	/**
	 * 设备编号 
	 */
	private String serialnum;

	/**
	 * 绑定的手机设备编号 
	 */
	private String deviceId;

	private long departmentId;

	private int useType;

	public DeviceForm() {
	}

	public DeviceForm(long hospitalId, String serialnum, String deviceId, long departmentId, int useType) {
		this.hospitalId = hospitalId;
		this.serialnum = serialnum;
		this.deviceId = deviceId;
		this.departmentId = departmentId;
		this.useType = useType;
	}

	/**
	 * 医院ID 
	 */
	public long getHospitalId() {
		return hospitalId;
	}

	/**
	 * 医院ID 
	 */
	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
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
	 * 绑定的手机设备编号 
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * 绑定的手机设备编号 
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public int getUseType() {
		return useType;
	}

	public void setUseType(int useType) {
		this.useType = useType;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		if (serialnum != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "serialnum", serialnum));
		}

		if (deviceId != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "deviceId", deviceId));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "departmentId", departmentId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "useType", useType));

		return $list;
	}

	@Override
	public String toString() {
		return "DeviceForm [hospitalId=" + hospitalId + ",serialnum=" + serialnum + ",deviceId=" + deviceId
				+ ",departmentId=" + departmentId + ",useType=" + useType + ", ]";
	}
}