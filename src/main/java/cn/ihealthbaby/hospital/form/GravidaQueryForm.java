package cn.ihealthbaby.hospital.form;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;
import java.util.Map.Entry;
import javax.validation.constraints.DecimalMin;
import org.hibernate.validator.constraints.Length;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

/**
 * 
 */
public class GravidaQueryForm implements ApiMessage {

	@DecimalMin("1")
	private int page;

	@DecimalMin("1")
	private int pagesize;

	/**
	 * 姓名
	 */
	@Length(max = 10)
	private String name;

	/**
	 * 手机号
	 */
	@Length(max = 15)
	private String mobile;

	/**
	 * 设备编号
	 */
	@Length(max = 100)
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