package cn.ihealthbaby.hospital.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class SysUserForm {
	/**用户名*/
	@NotNull
	@Length(max=20,min=6)
	private String username;
	/**密码*/
	@NotNull
	@Length(max=30,min=6)
	private String password;
	/**真实姓名*/
	@NotNull
	@Length(max=10,min=2)
	private String truename;
	/**性别*/
	@NotNull
	private String gender;
	/**手机号*/
	@NotNull
	@Length(min=11,max=11)
	private String cellphone;
	/**邮箱*/
	@NotNull
	@Email
	private String email;
	/**用户组编号*/
	private long[] roleid;
    
	private String status;
	private Long hospitalId;
	private Long departmentId;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long[] getRoleid() {
		return roleid;
	}
	public void setRoleid(long[] roleid) {
		this.roleid = roleid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
}
