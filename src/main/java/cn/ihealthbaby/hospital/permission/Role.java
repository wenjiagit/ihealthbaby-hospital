package cn.ihealthbaby.hospital.permission;

import cn.ihealthbaby.hospital.db.entity.SysPermissionDO;
import cn.ihealthbaby.hospital.db.entity.SysRoleDO;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zuoge85 on 15/7/22.
 */
public class Role {
    private SysRoleDO roleDo;
    private ConcurrentMap<String, SysPermissionDO> permissionsMap = new ConcurrentHashMap<>();

    public Role(SysRoleDO roleDo) {
        this.roleDo = roleDo;
    }

    public void addPermission(SysPermissionDO sysPermissionDO) {
        permissionsMap.put(sysPermissionDO.getPermissionKey(), sysPermissionDO);
    }

    public long getId() {
        return roleDo.getId();
    }

    public String getRoleName() {
        return roleDo.getRoleName();
    }

    public boolean checkPermission(String[] permissionkeys) {
        for (String permissionkey : permissionkeys) {
            if (permissionsMap.containsKey(permissionkey)) {
                return true;
            }
        }
        return false;
    }

    public ConcurrentMap<String, SysPermissionDO> getPermissionsMap() {
        return permissionsMap;
    }
}
