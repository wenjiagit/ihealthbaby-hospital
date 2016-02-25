package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class DeviceQueryForm implements ApiMessage {

	/**
	 * 设备编号 
	 */
	private String serialnum;

	/**
	 * 绑定的手机设备编号 
	 */
	private String deviceId;

	/**
	 * 医院内部对设备的编号 
	 */
	private long indexNumber;

	/**
	 * 设备的状态 0,空置；1、出租；2、出售，3问题设备返修 
	 */
	private int status;

	public DeviceQueryForm() {
	}

	public DeviceQueryForm(String serialnum, String deviceId, long indexNumber, int status) {
		this.serialnum = serialnum;
		this.deviceId = deviceId;
		this.indexNumber = indexNumber;
		this.status = status;
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

	/**
	 * 医院内部对设备的编号 
	 */
	public long getIndexNumber() {
		return indexNumber;
	}

	/**
	 * 医院内部对设备的编号 
	 */
	public void setIndexNumber(long indexNumber) {
		this.indexNumber = indexNumber;
	}

	/**
	 * 设备的状态 0,空置；1、出租；2、出售，3问题设备返修 
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 设备的状态 0,空置；1、出租；2、出售，3问题设备返修 
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (serialnum != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "serialnum", serialnum));
		}

		if (deviceId != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "deviceId", deviceId));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "indexNumber", indexNumber));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "status", status));

		return $list;
	}

	@Override
	public String toString() {
		return "DeviceQueryForm [serialnum=" + serialnum + ",deviceId=" + deviceId + ",indexNumber=" + indexNumber
				+ ",status=" + status + ", ]";
	}
}