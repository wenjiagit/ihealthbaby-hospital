package cn.ihealthbaby.hospital.model;

import java.util.Date;
import java.util.List;

import cn.ihealthbaby.data.db.entity.*;
import cn.ihealthbaby.hospital.db.entity.CatOptionDO;
import cn.ihealthbaby.hospital.db.entity.NstOptionDO;
import cn.ihealthbaby.hospital.db.entity.ReportSettingsDO;

/**
 * Created by qiang on 2015/8/17.
 */
public class ReplyDataModel {
	/** 主键id */
	private long id;
	/** 问题的id */
	private AdviceAskDO adviceAskDO;
	/** 用户id */
	private UserDO userDO;
	/** 监护id */
	private AdviceDO adviceDO;
	/** 回复内容 */
	private String replyContext;
	private int replyResult;
	/** 回复时间 */
	private java.util.Date replyTime;
	/** 回复的类型 1 院方医生回复 2 远程值班医生回复 */
	private int replyType;
	/** 评分 */
	private double score;
	/** 回复医生id */
	private SysUserDO sysUserDO;
	/** 医院id */
	private HospitalDO hospitalDO;
	/** nst分析结果 1 正常NST(+) , 2 不典型NST（+-）, 3 异常NST(-),4 NST无法判读,5 由医生判读 */
	private int nstResult;
	/** cat结果 1 Cat.I,2 Cat.II , 3 Cat.III */
	private int catResult;

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

	public ServiceDO getServiceDO() {
		return serviceDO;
	}

	public void setServiceDO(ServiceDO serviceDO) {
		this.serviceDO = serviceDO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AdviceAskDO getAdviceAskDO() {
		return adviceAskDO;
	}

	public void setAdviceAskDO(AdviceAskDO adviceAskDO) {
		this.adviceAskDO = adviceAskDO;
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

	public String getReplyContext() {
		return replyContext;
	}

	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public int getReplyType() {
		return replyType;
	}

	public void setReplyType(int replyType) {
		this.replyType = replyType;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public SysUserDO getSysUserDO() {
		return sysUserDO;
	}

	public void setSysUserDO(SysUserDO sysUserDO) {
		this.sysUserDO = sysUserDO;
	}

	public HospitalDO getHospitalDO() {
		return hospitalDO;
	}

	public void setHospitalDO(HospitalDO hospitalDO) {
		this.hospitalDO = hospitalDO;
	}

	public int getNstResult() {
		return nstResult;
	}

	public void setNstResult(int nstResult) {
		this.nstResult = nstResult;
	}

	public int getCatResult() {
		return catResult;
	}

	public void setCatResult(int catResult) {
		this.catResult = catResult;
	}

	public int getReplyResult() {
		return replyResult;
	}

	public void setReplyResult(int replyResult) {
		this.replyResult = replyResult;
	}

	public ServiceInsideDO getServiceInsideDO() {
		return serviceInsideDO;
	}

	public void setServiceInsideDO(ServiceInsideDO serviceInsideDO) {
		this.serviceInsideDO = serviceInsideDO;
	}
}
