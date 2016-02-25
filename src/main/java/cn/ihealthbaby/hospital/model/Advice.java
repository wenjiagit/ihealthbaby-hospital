package cn.ihealthbaby.hospital.model;

import java.util.Date;

public class Advice {

	/** 主键ID */
	private long id;
	/** 用户ID */
	private long userId;
	/** 设备编号 */
	private String serialnum;
	/** 检测开始时间 */
	private java.util.Date testTime;
	/** 怀孕周数 */
	private String gestationalWeeks;
	/** 检测时长 */
	private Integer testTimeLong;
	/**咨询的状态 0 提交但为咨询 1咨询未回复 2 咨询已回复 3 咨询已删除 */
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/** 询问时间 */
	private java.util.Date askTime;

	/** 回复时间时间 */
	private java.util.Date replyTime;

	/** 回复医生姓名 */
	private String doctorName;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public java.util.Date getTestTime() {
		return testTime;
	}

	public void setTestTime(java.util.Date testTime) {
		this.testTime = testTime;
	}

	public String getGestationalWeeks() {
		return gestationalWeeks;
	}

	public void setGestationalWeeks(String gestationalWeeks) {
		this.gestationalWeeks = gestationalWeeks;
	}

	public Integer getTestTimeLong() {
		return testTimeLong;
	}

	public void setTestTimeLong(Integer testTimeLong) {
		this.testTimeLong = testTimeLong;
	}

	public java.util.Date getAskTime() {
		return askTime;
	}

	public void setAskTime(java.util.Date askTime) {
		this.askTime = askTime;
	}

	public java.util.Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(java.util.Date replyTime) {
		this.replyTime = replyTime;
	}

	public Advice(long id, long userId, String serialnum, Date testTime,
			String gestationalWeeks, Integer testTimeLong, Date askTime,
			Date replyTime, String doctorName) {
		super();
		this.id = id;
		this.userId = userId;
		this.serialnum = serialnum;
		this.testTime = testTime;
		this.gestationalWeeks = gestationalWeeks;
		this.testTimeLong = testTimeLong;
		this.askTime = askTime;
		this.replyTime = replyTime;
		this.doctorName = doctorName;
	}

	public Advice() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Advice [id=" + id + ", userId=" + userId + ", serialnum="
				+ serialnum + ", testTime=" + testTime + ", gestationalWeeks="
				+ gestationalWeeks + ", testTimeLong=" + testTimeLong
				+ ", askTime=" + askTime + ", replyTime=" + replyTime
				+ ", doctorName=" + doctorName + "]";
	}

}
