package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.UserDO;

import java.util.Date;

/**
 * @author qiang on 2015/9/15.
 *         jinliqiang@ihbaby.com
 */
public class AdviceModel {
    private long id;
    /**客户端用于标识记录的唯一id*/
    private String clientId;
    /**用户ID*/
    private UserDO userDO;
    /**设备编号*/
    private String serialnum;
    /**检测开始时间*/
    private java.util.Date testTime;
    /**怀孕周数*/
    private String gestationalWeeks;
    /**检测时长*/
    private Integer testTimeLong;
    /**医生的ID*/
    private long doctorId;
    /**医院的ID*/
    private long hospitalId;
    /**科室id*/
    private long departmentId;
    /**咨询的状态 0 提交但为咨询 1咨询未回复 2 咨询已回复 3 咨询已删除 */
    private int status;
    /**胎音文件的存放路径*/
    private String fetalTonePath;
    /**监护数据的类型 1,胎心仪监护数据*/
    private int dataType;
    /**创建时间*/
    private java.util.Date createTime;
    /**医院持有设备id  0 为院外监护*/
    private long hospitalFetalheartId;
    /**是否删除*/
    private boolean isDelete;
    /**上传状态 0 初始上传 1 上传完毕*/
    private int uploadStatus;
    /**经度*/
    private double longitude;
    /**纬度*/
    private double latitude;
    /**哈希值*/
    private String geoHash;
    /**监护单编号 未问医生则为空*/
    private Long adviceNumber;
    /**监护的目的*/
    private String askPurpose;
    /**监护时的心情*/
    private String feeling;
    /**胎音文件版本*/
    private int fetalToneVersion;
    /**胎音文件的格式*/
    private String fetalToneFormat;
    /**设备类型 0 胎心仪*/
    private int deviceType;
    /**监护的类型0 院内, 1 院外*/
    private int adviceType;
    /**询问时间*/
    private java.util.Date askTime;
    /**回复时间*/
    private java.util.Date replyTime;
    private long serviceId;

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

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
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

    public Long getAdviceNumber() {
        return adviceNumber;
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

    public int getFetalToneVersion() {
        return fetalToneVersion;
    }

    public void setFetalToneVersion(int fetalToneVersion) {
        this.fetalToneVersion = fetalToneVersion;
    }

    public String getFetalToneFormat() {
        return fetalToneFormat;
    }

    public void setFetalToneFormat(String fetalToneFormat) {
        this.fetalToneFormat = fetalToneFormat;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

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

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }
}
