package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  qiang on 2015/11/17.
 * jinliqiang@ihbaby.com
 */
public class EmployeeUpdateForm implements ApiMessage {

	private String name;

	private String mobile;

	private String gender;

	public EmployeeUpdateForm() {
	}

	public EmployeeUpdateForm(String name, String mobile, String gender) {
		this.name = name;
		this.mobile = mobile;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		if (gender != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "gender", gender));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "EmployeeUpdateForm [name=" + name + ",mobile=" + mobile + ",gender=" + gender + ", ]";
	}
}