package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class HospitalStatusForm implements ApiMessage {

	/**
	 * 医院id 
	 */
	private long hospitalId;

	/**
	 * 是否禁用 
	 */
	private boolean isDelete;

	/**
	 * 是否支持院内 
	 */
	private boolean supportInside;

	/**
	 * 是否支持院外 
	 */
	private boolean supportOutside;

	/**
	 * 是否支持app下单 
	 */
	private boolean supportApp;

	/**
	 * 是否支持快递 
	 */
	private boolean supportExpress;

	public HospitalStatusForm() {
	}

	public HospitalStatusForm(long hospitalId, boolean isDelete, boolean supportInside, boolean supportOutside,
			boolean supportApp, boolean supportExpress) {
		this.hospitalId = hospitalId;
		this.isDelete = isDelete;
		this.supportInside = supportInside;
		this.supportOutside = supportOutside;
		this.supportApp = supportApp;
		this.supportExpress = supportExpress;
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
	 * 是否禁用 
	 */
	public boolean getIsDelete() {
		return isDelete;
	}

	/**
	 * 是否禁用 
	 */
	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * 是否支持院内 
	 */
	public boolean getSupportInside() {
		return supportInside;
	}

	/**
	 * 是否支持院内 
	 */
	public void setSupportInside(boolean supportInside) {
		this.supportInside = supportInside;
	}

	/**
	 * 是否支持院外 
	 */
	public boolean getSupportOutside() {
		return supportOutside;
	}

	/**
	 * 是否支持院外 
	 */
	public void setSupportOutside(boolean supportOutside) {
		this.supportOutside = supportOutside;
	}

	/**
	 * 是否支持app下单 
	 */
	public boolean getSupportApp() {
		return supportApp;
	}

	/**
	 * 是否支持app下单 
	 */
	public void setSupportApp(boolean supportApp) {
		this.supportApp = supportApp;
	}

	/**
	 * 是否支持快递 
	 */
	public boolean getSupportExpress() {
		return supportExpress;
	}

	/**
	 * 是否支持快递 
	 */
	public void setSupportExpress(boolean supportExpress) {
		this.supportExpress = supportExpress;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "isDelete", isDelete));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "supportInside", supportInside));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "supportOutside", supportOutside));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "supportApp", supportApp));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "supportExpress", supportExpress));

		return $list;
	}

	@Override
	public String toString() {
		return "HospitalStatusForm [hospitalId=" + hospitalId + ",isDelete=" + isDelete + ",supportInside="
				+ supportInside + ",supportOutside=" + supportOutside + ",supportApp=" + supportApp
				+ ",supportExpress=" + supportExpress + ", ]";
	}
}