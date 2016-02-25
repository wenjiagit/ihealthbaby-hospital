package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 医生的查询条件表单
 * @author  gwc
 */
public class DoctorQueryForm implements ApiMessage {

	/**
	 * 医生姓名 
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
	 * 部门名称 
	 */
	private String department;

	/**
	 * 职称 
	 */
	private String title;

	/**
	 * 当前页码 
	 */
	private int page;

	/**
	 * 每页数据 
	 */
	private int pageSize;

	public DoctorQueryForm() {
	}

	public DoctorQueryForm(String name, String telephone, String mobile, String department, String title, int page,
			int pageSize) {
		this.name = name;
		this.telephone = telephone;
		this.mobile = mobile;
		this.department = department;
		this.title = title;
		this.page = page;
		this.pageSize = pageSize;
	}

	/**
	 * 医生姓名 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 医生姓名 
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
	 * 部门名称 
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 部门名称 
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 职称 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 职称 
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 当前页码 
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 当前页码 
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 每页数据 
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 每页数据 
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

		if (department != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "department", department));
		}

		if (title != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "title", title));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "page", page));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "pageSize", pageSize));

		return $list;
	}

	@Override
	public String toString() {
		return "DoctorQueryForm [name=" + name + ",telephone=" + telephone + ",mobile=" + mobile + ",department="
				+ department + ",title=" + title + ",page=" + page + ",pageSize=" + pageSize + ", ]";
	}
}