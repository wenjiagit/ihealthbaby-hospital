package cn.ihealthbaby.hospital.form;

import java.util.Date;
import java.util.List;

import cn.ihealthbaby.data.db.entity.*;
import cn.ihealthbaby.hospital.db.entity.CatOptionDO;
import cn.ihealthbaby.hospital.db.entity.NstOptionDO;
import cn.ihealthbaby.hospital.db.entity.ReportSettingsDO;

/**
 * Created by qiang on 2015/8/14.
 */
public class AdviceAskForm {
	/** 主键id */
	private long id;
	/** 用户id */
	private UserDO userDO;
	/** 监护信息id */
	private AdviceDO adviceDO;
	/** 询问医生id */
	private SysUserDO sysUserDO;
	/** 询问时间 */
	private java.util.Date askTime;
	/** 询问的问题 */
	private String question;
	/** 监护单编号 */
	private long adviceNumber;
	/** 服务ID */
	private HospitalDO hospitalDO;
	private ServiceDO serviceDO;
	private ServiceInsideDO serviceInsideDO;
	private List<NstOptionDO> nstList;
	private List<CatOptionDO> catList;
	private ReportSettingsDO reportSettingsDO;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public HospitalDO getHospitalDO() {
		return hospitalDO;
	}

	public void setHospitalDO(HospitalDO hospitalDO) {
		this.hospitalDO = hospitalDO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDO getUserDO() {
		return userDO;
	}

	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
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

	public long getAdviceNumber() {
		return adviceNumber;
	}

	public void setAdviceNumber(long adviceNumber) {
		this.adviceNumber = adviceNumber;
	}

	public ServiceDO getServiceDO() {
		return serviceDO;
	}

	public void setServiceDO(ServiceDO serviceDO) {
		this.serviceDO = serviceDO;
	}

	public List<NstOptionDO> getNstList() {
		return nstList;
	}

	public void setNstList(List<NstOptionDO> nstList) {
		this.nstList = nstList;
	}

	public List<CatOptionDO> getCatList() {
		return catList;
	}

	public void setCatList(List<CatOptionDO> catList) {
		this.catList = catList;
	}

	public ReportSettingsDO getReportSettingsDO() {
		return reportSettingsDO;
	}

	public void setReportSettingsDO(ReportSettingsDO reportSettingsDO) {
		this.reportSettingsDO = reportSettingsDO;
	}

	public ServiceInsideDO getServiceInsideDO() {
		return serviceInsideDO;
	}

	public void setServiceInsideDO(ServiceInsideDO serviceInsideDO) {
		this.serviceInsideDO = serviceInsideDO;
	}
}
