package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;

import java.util.Date;

/**
 * Created by qiang on 2015/8/20.
 */
public class DoctorModel {
    /**主键ID*/
    private long id;
    /**医院ID*/
    private HospitalDO hospitalDO;
    /**医生姓名*/
    private String name;
    /**姓名的拼音*/
    private String pinyin;
    /**头像地址*/
    private String headPic;
    /**座机电话*/
    private String telephone;
    /**手机电话*/
    private String mobile;
    /**登录密码*/
    private String password;
    /**部门id*/
    private DepartmentDO departmentDO;
    /**职称*/
    private String title;
    /**回复的次数*/
    private boolean isStopped;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
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

    public DepartmentDO getDepartmentDO() {
        return departmentDO;
    }

    public void setDepartmentDO(DepartmentDO departmentDO) {
        this.departmentDO = departmentDO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isStopped() {
        return isStopped;
    }

    public void setIsStopped(boolean isStopped) {
        this.isStopped = isStopped;
    }
}
