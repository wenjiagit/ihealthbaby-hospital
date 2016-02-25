package cn.ihealthbaby.hospital.model;

import java.sql.Date;

import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;

/**
 * Created by qiang on 2015/8/20.
 */
public class InsideServiceModel {
	private long id;
	/** 孕妇姓名 */
	private String name;
	/** 手机号 */
	private String mobile;
	/** 孕妇生日 */
	private java.sql.Date birthday;
	/** 预产期 */
	private java.sql.Date deliveryTime;
	/** 医院id */
	private HospitalDO hospitalDO;
	/** 医生id */
	private SysUserDO sysUserDO;
	/** 科室id */
	private DepartmentDO departmentDO;
	/** 创建时间 */
	private java.util.Date createtime;
	/** 0为监测，1已检测 */
	private int status;
	/** 用户port端id */
	private long userId;
	/** 产检编号 */
	private String caseNumber;
	/** 怀孕周数 */
	private String gestationalWeeks;

	private long serviceNumber;

	public long getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(long serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
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

	public DepartmentDO getDepartmentDO() {
		return departmentDO;
	}

	public void setDepartmentDO(DepartmentDO departmentDO) {
		this.departmentDO = departmentDO;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getGestationalWeeks() {
		return gestationalWeeks;
	}

	public void setGestationalWeeks(String gestationalWeeks) {
		this.gestationalWeeks = gestationalWeeks;
	}
}
