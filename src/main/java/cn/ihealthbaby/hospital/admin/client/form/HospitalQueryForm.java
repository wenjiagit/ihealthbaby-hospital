package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;
import org.apache.http.client.utils.URIBuilder;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 医院条件查询表单
 * @author  gwc
 */
public class HospitalQueryForm implements ApiMessage {

	/**
	 * 所在省份 
	 */
	private String province;

	/**
	 * 所在城市 
	 */
	private String city;

	/**
	 * 所在区县 
	 */
	private String county;

	/**
	 * 具体地址 
	 */
	private String address;

	/**
	 * 医院名称 
	 */
	private String name;

	/**
	 * 当前页码 
	 */
	private int page=1;

	/**
	 * 每页数据 
	 */
	private int pageSize=10;

	public HospitalQueryForm() {
	}

	public HospitalQueryForm(String province, String city, String county, String address, String name, int page,
			int pageSize) {
		this.province = province;
		this.city = city;
		this.county = county;
		this.address = address;
		this.name = name;
		this.page = page;
		this.pageSize = pageSize;
	}

	/**
	 * 所在省份 
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 所在省份 
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 所在城市 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 所在城市 
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 所在区县 
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * 所在区县 
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * 具体地址 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 具体地址 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 医院名称 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 医院名称 
	 */
	public void setName(String name) {
		this.name = name;
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

		if (province != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "province", province));
		}

		if (city != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "city", city));
		}

		if (county != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "county", county));
		}

		if (address != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "address", address));
		}

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "page", page));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "pageSize", pageSize));

		return $list;
	}

	@Override
	public String toString() {
		return "HospitalQueryForm [province=" + province + ",city=" + city + ",county=" + county + ",address="
				+ address + ",name=" + name + ",page=" + page + ",pageSize=" + pageSize + ", ]";
	}
	public String toUrl()  {
		URIBuilder uri  = new URIBuilder();
		uri.addParameter("name", getName())
				.addParameter("province", getProvince())
				.addParameter("county", getCounty())
				.addParameter("city", getCity());
		return  uri.toString().substring(1);
	}
}