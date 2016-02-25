package cn.ihealthbaby.hospital.admin.client.form;

import java.util.List;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 医院数据表单
 * @author  gwc
 */
public class DepartmentForm implements ApiMessage {

	private long id;

	private long hosId;

	private String department;

	public DepartmentForm() {
	}

	public DepartmentForm(long id, long hosId, String department) {
		this.id = id;
		this.hosId = hosId;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getHosId() {
		return hosId;
	}

	public void setHosId(long hosId) {
		this.hosId = hosId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hosId", hosId));

		if (department != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "department", department));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "DepartmentForm [id=" + id + ",hosId=" + hosId + ",department=" + department + ", ]";
	}
}