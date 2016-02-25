package cn.ihealthbaby.hospital.form;

import java.util.Date;
import java.util.List;

import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.data.db.entity.UserDO;
import cn.ihealthbaby.hospital.db.entity.CatOptionDO;
import cn.ihealthbaby.hospital.db.entity.NstOptionDO;

/**
 * Created by qiang on 2015/8/14.
 */
public class AdviceForm {
	/** 主键ID */
	private long id;
	/** 客户端id */
	private String clientId;
	/** 用户ID */
	private UserDO userDO;
	/** age */
	private int age;
	/** 设备编号 */
	private String serialnum;
	/** 检测开始时间 */
	private java.util.Date testTime;
	/** 怀孕周数 */
	private String gestationalWeeks;
	/** 检测时长 */
	private Integer testTimeLong;
	/** 医生的ID */
	private SysUserDO sysUserDO;
	/** 医院的ID */
	private HospitalDO hospitalDO;
	/** 咨询的状态 0 提交但为咨询 1咨询未回复 2 咨询已回复 3 咨询已删除 */
	private int status;
	/** 胎音文件的存放路径 */
	private String fetalTonePath;
	/** 监护数据的类型 1,胎心仪监护数据 */
	private int dataType;
	/** 创建时间 */
	private long createTime;
	/** 医院持有设备id 0 为院外监护 */
	private long hospitalFetalheartId;
	/** 是否删除 */
	private boolean isDelete;
	/** 上传状态 0 初始上传 1 上传完毕 */
	private int uploadStatus;

	private List<NstOptionDO> nstList;
	private List<CatOptionDO> catList;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public UserDO getUserDO() {
		return userDO;
	}

	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public Date getTestTime() {
		return testTime;
	}

	public void setTestTime(Date testTime) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFetalTonePath() {
		return fetalTonePath;
	}

	public void setFetalTonePath(String fetalTonePath) {
		this.fetalTonePath = fetalTonePath;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getHospitalFetalheartId() {
		return hospitalFetalheartId;
	}

	public void setHospitalFetalheartId(long hospitalFetalheartId) {
		this.hospitalFetalheartId = hospitalFetalheartId;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public int getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(int uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
}
