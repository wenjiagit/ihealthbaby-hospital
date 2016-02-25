package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;

import java.util.Date;

/**
 * Created by qiang on 2015/8/5.
 */
public class SysUserModel {
    /**用户ID*/
    /**用户ID*/
    private long id;
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**真实姓名*/
    private String name;
    /**性别*/
    private String gender;
    /**手机号*/
    private String mobile;
    /**座机电话*/
    private String telephone;
    private String email;
    /**医院id*/
    private HospitalDO hospitalDO;
    /**创建时间*/
    private java.util.Date createTime;
    /**修改时间*/
    private java.util.Date updateTime;
    /**是否禁用 0：启用 1：禁用*/
    private boolean isStopped;
    /**姓名Pinyin*/
    private String pinyin;
    /**头像地址*/
    private String headPic;
    /**部门id*/
    private DepartmentDO departmentDO;
    /**职称*/
    private String title;
    /**是否为管理员*/
    private boolean isAdmin;
    /**0：客服 1：医生*/
    private int type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isStopped() {
        return isStopped;
    }

    public void setIsStopped(boolean isStopped) {
        this.isStopped = isStopped;
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



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public HospitalDO getHospitalDO() {
        return hospitalDO;
    }

    public void setHospitalDO(HospitalDO hospitalDO) {
        this.hospitalDO = hospitalDO;
    }

    public DepartmentDO getDepartmentDO() {
        return departmentDO;
    }

    public void setDepartmentDO(DepartmentDO departmentDO) {
        this.departmentDO = departmentDO;
    }
}
