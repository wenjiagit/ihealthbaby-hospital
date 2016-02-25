package cn.ihealthbaby.hospital;


import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.hospital.permission.Menu;
import cn.ihealthbaby.hospital.permission.Roles;

import java.util.List;

/**
 * @author zuoge85 on 15/7/13.
 */
public class UserAccount {
    private SysUserDO sysUserDO;
    private Roles roles;

    public UserAccount() {
    }

    public SysUserDO getSysUserDO() {
        return sysUserDO;
    }

    public void setSysUserDO(SysUserDO sysUserDO) {
        this.sysUserDO = sysUserDO;
    }

    /**
     * 检查权限，注意权限是必须声明才有，没声明表示没有任何权限
     */
    public boolean checkPermission(String... value) {
        return roles.checkPermission(value);
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Menu> getSidebar() {
        return roles.getSidebar();
    }
}
