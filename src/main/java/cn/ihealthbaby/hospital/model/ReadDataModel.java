package cn.ihealthbaby.hospital.model;

import java.util.Date;

import cn.ihealthbaby.data.db.entity.AdviceAskDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.data.db.entity.UserDO;

/**
 * Created by qiang on 2015/8/11.
 */
public class ReadDataModel {

	/** 用户id */
	private UserDO userDO;
	/** 监护信息id */
	private AdviceAskDO adviceAskDO;
	/** 询问医生id */
	private SysUserDO sysUserDO;
	private long id;
	/** 客户端id */
	private String clientId;
	/** 用户ID */
	private long userId;
	/** 设备编号 */
	private String serialnum;
	/** 检测开始时间 */
	private Date testTime;
	/** 怀孕周数 */
	private String gestationalWeeks;
	/** 检测时长 */
	private Integer testTimeLong;
	/** 医生的ID */
	private long doctorId;
	/** 医院的ID */
	private long hospitalId;
	/** 咨询的状态 0 提交但为咨询 1咨询未回复 2 咨询已回复 3 咨询已删除 */
	private int status;
	/** 胎音文件的存放路径 */
	private String fetalTonePath;
	/** 监护数据的类型 1,胎心仪监护数据 */
	private int dataType;
	/** 创建时间 */
	private Date createTime;
	/** 医院持有设备id 0 为院外监护 */
	private long hospitalFetalheartId;
	/** 是否删除 */
	private boolean isDelete;
	/** 上传状态 0 初始上传 1 上传完毕 */
	private int uploadStatus;
	/** 经度 */
	private double longitude;
	/** 纬度 */
	private double latitude;
	/** 哈希值 */
	private String geoHash;
	/** 监护单编号 未问医生则为空 */
	private Long adviceNumber;
	/** 监护的目的 */
	private String askPurpose;
	/** 监护时的心情 */
	private String feeling;
	/** 询问的问题 */
	private String question;

	private HospitalDO hospitalDO;
	/**询问时间*/
	private Date askTime;
	/**回复时间*/
	private Date replyTime;

	private String waitTime;
	private int adviceType;

	public int getAdviceType() {
		return adviceType;
	}

	public void setAdviceType(int adviceType) {
		this.adviceType = adviceType;
	}

	public Date getAskTime() {
		return askTime;
	}

	public void setAskTime(Date askTime) {
		this.askTime = askTime;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
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

	public String getQuestion() {
		return question;
	}

	public SysUserDO getSysUserDO() {
		return sysUserDO;
	}

	public void setSysUserDO(SysUserDO sysUserDO) {
		this.sysUserDO = sysUserDO;
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

	public HospitalDO getHospitalDO() {
		return hospitalDO;
	}

	public void setHospitalDO(HospitalDO hospitalDO) {
		this.hospitalDO = hospitalDO;
	}

	public AdviceAskDO getAdviceAskDO() {
		return adviceAskDO;
	}

	public void setAdviceAskDO(AdviceAskDO adviceAskDO) {
		this.adviceAskDO = adviceAskDO;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
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

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
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

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getGeoHash() {
		return geoHash;
	}

	public void setGeoHash(String geoHash) {
		this.geoHash = geoHash;
	}

	public void setAdviceNumber(Long adviceNumber) {
		this.adviceNumber = adviceNumber;
	}

	public String getAskPurpose() {
		return askPurpose;
	}

	public void setAskPurpose(String askPurpose) {
		this.askPurpose = askPurpose;
	}

	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	public String getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
}
