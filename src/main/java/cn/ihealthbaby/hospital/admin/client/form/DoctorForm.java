package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class DoctorForm implements ApiMessage {

	private long id;

	/**
	 * 医院ID 
	 */
	private long hospitalId;

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
	private long departmentId;

	private String title;

	private String username;

	private String email;

	private String gender;

	private int type;

	private String headPic;

	public DoctorForm() {
	}

	public DoctorForm(long id, long hospitalId, String name, String telephone, String mobile, long departmentId,
			String title, String username, String email, String gender, int type, String headPic) {
		this.id = id;
		this.hospitalId = hospitalId;
		this.name = name;
		this.telephone = telephone;
		this.mobile = mobile;
		this.departmentId = departmentId;
		this.title = title;
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.type = type;
		this.headPic = headPic;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 医院ID 
	 */
	public long getHospitalId() {
		return hospitalId;
	}

	/**
	 * 医院ID 
	 */
	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
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
	public long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 部门名称 
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		if (telephone != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "telephone", telephone));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "departmentId", departmentId));

		if (title != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "title", title));
		}

		if (username != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "username", username));
		}

		if (email != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "email", email));
		}

		if (gender != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "gender", gender));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "type", type));

		if (headPic != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "headPic", headPic));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "DoctorForm [id=" + id + ",hospitalId=" + hospitalId + ",name=" + name + ",telephone=" + telephone
				+ ",mobile=" + mobile + ",departmentId=" + departmentId + ",title=" + title + ",username=" + username
				+ ",email=" + email + ",gender=" + gender + ",type=" + type + ",headPic=" + headPic + ", ]";
	}
}