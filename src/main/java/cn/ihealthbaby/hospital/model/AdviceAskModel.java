package cn.ihealthbaby.hospital.model;

import java.util.Date;

import cn.ihealthbaby.data.db.entity.AdviceDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;

/**
 * @author qiang on 2015/9/2. jinliqiang@ihbaby.com
 */
public class AdviceAskModel {
	private long id;
	/** 用户id */
	private long userId;
	/** 监护信息id */
	private AdviceDO adviceDO;
	/** 询问医生id */
	private SysUserDO sysUserDO;
	/** 询问时间 */
	private java.util.Date askTime;
	/** 询问的问题 */
	private String question;
	/** 服务ID */
	private long serviceId;
	/** 医院id */
	private long hospitalId;

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

	public AdviceDO getAdviceDO() {
		return adviceDO;
	}

	public void setAdviceDO(AdviceDO adviceDO) {
		this.adviceDO = adviceDO;
	}

	public SysUserDO getSysUserDO() {
		return sysUserDO;
	}

	public void setSysUserDO(SysUserDO sysUserDO) {
		this.sysUserDO = sysUserDO;
	}

	public Date getAskTime() {
		return askTime;
	}

	public void setAskTime(Date askTime) {
		this.askTime = askTime;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}
}
