package cn.ihealthbaby.hospital.admin.client.model;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  zuoge85 on 15/10/15.
 */
public class Department implements ApiMessage {

	private long id;

	/**
	 * 医院id
	 */
	private long hospitalId;

	/**
	 * 科室
	 */
	private String department;

	public Department() {
	}

	public Department(long id, long hospitalId, String department) {
		this.id = id;
		this.hospitalId = hospitalId;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	 * 科室
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 科室
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		if (department != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "department", department));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ",hospitalId=" + hospitalId + ",department=" + department + ", ]";
	}
}