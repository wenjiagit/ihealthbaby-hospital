package cn.ihealthbaby.hospital.model;

import java.util.Date;

import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.RefundDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.data.db.entity.UserDO;

/**
 * Created by qiang on 2015/8/5.
 */
public class ServiceModel {
	/** 主键ID */
	private long id;
	/** 用户ID */
	private long userId;
	/** 医院ID */
	private long hospitalId;
	/** 医生ID */
	private long doctorId;
	/** 设备编号 */
	private String serialnum;
	/** 产检编号 */
	private String caseNumber;
	/** 服务类型 0 院内监护服务 1 院外监护服务 */
	private int serviceType;
	/** 总的购买次数 */
	private int totalCount;
	/** 已经使用的次数 */
	private int usedCount;
	/** 服务开始时间(即开始计算租金的时间) */
	private java.util.Date beginTime;
	/** 服务的结束时间 */
	private java.util.Date endTime;
	/** 服务更新时间 */
	private java.util.Date updateTime;
	/** 创建服务的时间 */
	private java.util.Date createTime;
	/** 服务状态 0 开通未绑定设备,1已绑定设备,2服务结束 */
	private int serviceStatus;
	/**服务单号*/
	private long serviceNumber;

	private UserDO userDO;

	private HospitalDO hospitalDO;

	private SysUserDO sysUserDO;

	private RefundDO refundDO;

	public RefundDO getRefundDO() {
		return refundDO;
	}

	public void setRefundDO(RefundDO refundDO) {
		this.refundDO = refundDO;
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

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(int serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public UserDO getUserDO() {
		return userDO;
	}

	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}

	public HospitalDO getHospitalDO() {
		return hospitalDO;
	}

	public void setHospitalDO(HospitalDO hospitalDO) {
		this.hospitalDO = hospitalDO;
	}

	public SysUserDO getSysUserDO() {
		return sysUserDO;
	}

	public void setSysUserDO(SysUserDO sysUserDO) {
		this.sysUserDO = sysUserDO;
	}

	public long getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(long serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
}
