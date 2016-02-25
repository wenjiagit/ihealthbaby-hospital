package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.HospitalDO;

import java.util.Date;

/**
 * @author qiang on 2015/9/25.
 *         jinliqiang@ihbaby.com
 */
public class UserModel {

    private long id;
    /**名称允许重复*/
    private String name;
    /**拼音简写*/
    private String pinyin;
    /**座机电话*/
    private String telephone;
    /**手机电话*/
    private String mobile;
    /**密码*/
    private String password;
    /**头像*/
    private String headPic;
    /**生日*/
    private java.util.Date birthday;
    /**创建时间*/
    private java.util.Date createTime;
    /**更新记录时间*/
    private java.util.Date updateTime;
    /**预产期*/
    private java.util.Date deliveryTime;
    /**医院id  0 表示未绑定医院*/
    private HospitalDO hospitalDO;
    /**是否已开通服务 0 未开通,1已开通*/
    private boolean hasService;
    /**是否为初始状态 0 不是 ,1 是 */
    private boolean isInit;
    /**是否被删除*/
    private boolean isDelete;
    /**是否进行过高危评分*/
    private boolean hasRiskscore;
    /**经度*/
    private double longitude;
    /**纬度*/
    private double latitude;
    /**哈希值*/
    private String geoHash;

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

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public boolean isHasService() {
        return hasService;
    }

    public void setHasService(boolean hasService) {
        this.hasService = hasService;
    }

    public boolean isInit() {
        return isInit;
    }

    public void setIsInit(boolean isInit) {
        this.isInit = isInit;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean isHasRiskscore() {
        return hasRiskscore;
    }

    public void setHasRiskscore(boolean hasRiskscore) {
        this.hasRiskscore = hasRiskscore;
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
}
