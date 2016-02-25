package cn.ihealthbaby.hospital.form;


import org.apache.http.client.utils.URIBuilder;

/**
 * 医生的查询条件表单
 * 
 * @author gwc
 */
public class DoctorQueryForm {

	private int page = 1;

	private int pageSize = 10;

	private String name;

	private String mobile;

	private String hospitalName;

	private String departmentName;

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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String toUrl()  {
		URIBuilder uri  = new URIBuilder();
		uri.addParameter("name", getName())
				.addParameter("mobile",getMobile())
				.addParameter("hospitalName",getHospitalName())
				.addParameter("departmentName", getDepartmentName());

		return  uri.toString().substring(1);
	}
}