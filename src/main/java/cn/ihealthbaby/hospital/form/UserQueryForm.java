package cn.ihealthbaby.hospital.form;

import org.apache.http.client.utils.URIBuilder;

public class UserQueryForm {

	private int page = 1;

	private int pageSize = 10;
	private String name;
	private String mobile;
	private String hospitalName;

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

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public UserQueryForm(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}

	public UserQueryForm() {
	}
	public String toUrl()  {
		URIBuilder uri  = new URIBuilder();
		uri.addParameter("name", getName())
				.addParameter("hospitalName", getHospitalName())
				.addParameter("mobile", getMobile());
		return  uri.toString().substring(1);
	}
}
