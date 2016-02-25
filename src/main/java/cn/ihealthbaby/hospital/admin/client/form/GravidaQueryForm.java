package cn.ihealthbaby.hospital.admin.client.form;

import java.util.Date;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class GravidaQueryForm implements ApiMessage {

	private int page;

	private int pagesize;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 设备编号
	 */
	private String serialnum;

	public GravidaQueryForm() {
	}

	public GravidaQueryForm(int page, int pagesize, String name, String mobile, String serialnum) {
		this.page = page;
		this.pagesize = pagesize;
		this.name = name;
		this.mobile = mobile;
		this.serialnum = serialnum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
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

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "page", page));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "pagesize", pagesize));

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		if (serialnum != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "serialnum", serialnum));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "GravidaQueryForm [page=" + page + ",pagesize=" + pagesize + ",name=" + name + ",mobile=" + mobile
				+ ",serialnum=" + serialnum + ", ]";
	}
}