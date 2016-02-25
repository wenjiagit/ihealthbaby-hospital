package cn.ihealthbaby.hospital.admin.client.model;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class Doctor implements ApiMessage {

	/**
	 * 主键ID 
	 */
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
	 * 姓名的拼音 
	 */
	private String pinyin;

	/**
	 * 头像地址 
	 */
	private String headPic;

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
	 * 回复的次数 
	 */
	private int replyCount;

	/**
	 * 最新一次的回复时间 
	 */
	private Date lastReplyTime;

	/**
	 * 是否被删除 0 没删除 1 删除 
	 */
	private boolean isDelete;

	public Doctor() {
	}

	public Doctor(long id, long hospitalId, String name, String pinyin, String headPic, String telephone,
			String mobile, String department, String title, int replyCount, Date lastReplyTime, boolean isDelete) {
		this.id = id;
		this.hospitalId = hospitalId;
		this.name = name;
		this.pinyin = pinyin;
		this.headPic = headPic;
		this.telephone = telephone;
		this.mobile = mobile;
		this.department = department;
		this.title = title;
		this.replyCount = replyCount;
		this.lastReplyTime = lastReplyTime;
		this.isDelete = isDelete;
	}

	/**
	 * 主键ID 
	 */
	public long getId() {
		return id;
	}

	/**
	 * 主键ID 
	 */
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
	 * 姓名的拼音 
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * 姓名的拼音 
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * 头像地址 
	 */
	public String getHeadPic() {
		return headPic;
	}

	/**
	 * 头像地址 
	 */
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
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
	 * 回复的次数 
	 */
	public int getReplyCount() {
		return replyCount;
	}

	/**
	 * 回复的次数 
	 */
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	/**
	 * 最新一次的回复时间 
	 */
	public Date getLastReplyTime() {
		return lastReplyTime;
	}

	/**
	 * 最新一次的回复时间 
	 */
	public void setLastReplyTime(Date lastReplyTime) {
		this.lastReplyTime = lastReplyTime;
	}

	/**
	 * 是否被删除 0 没删除 1 删除 
	 */
	public boolean getIsDelete() {
		return isDelete;
	}

	/**
	 * 是否被删除 0 没删除 1 删除 
	 */
	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		if (pinyin != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "pinyin", pinyin));
		}

		if (headPic != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "headPic", headPic));
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

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "replyCount", replyCount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "lastReplyTime", lastReplyTime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "isDelete", isDelete));

		return $list;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ",hospitalId=" + hospitalId + ",name=" + name + ",pinyin=" + pinyin + ",headPic="
				+ headPic + ",telephone=" + telephone + ",mobile=" + mobile + ",department=" + department + ",title="
				+ title + ",replyCount=" + replyCount + ",lastReplyTime=" + lastReplyTime + ",isDelete=" + isDelete
				+ ", ]";
	}
}