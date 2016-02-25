package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;

import java.util.Date;

/**
 * Created by qiang on 2015/7/31.
 */
public class HospitalFetalHeartInfo {
    private long id;
    /**医院ID*/
    private HospitalDO hospitalDO;
    /**设备编号*/
    private String serialnum;
    /**绑定的手机设备编号*/
    private String deviceId;
    /**医院内部对设备的编号*/
    private String indexNumber;

    private int status;
    /**设备的更新时间*/
    private Date updateTime;
    /**设备的添加时间*/
    private Date createTime;
    /**设备的状态 0,空置；1、出租；2、出售，3问题设备返修*/
    private int useType;
    private DepartmentDO departmentDO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HospitalDO getHospitalDO() {
        return hospitalDO;
    }

    public void setHospitalDO(HospitalDO hospitalDO) {
        this.hospitalDO = hospitalDO;
    }

    public String getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getUseType() {
        return useType;
    }

    public void setUseType(int useType) {
        this.useType = useType;
    }

    public DepartmentDO getDepartmentDO() {
        return departmentDO;
    }

    public void setDepartmentDO(DepartmentDO departmentDO) {
        this.departmentDO = departmentDO;
    }
}
