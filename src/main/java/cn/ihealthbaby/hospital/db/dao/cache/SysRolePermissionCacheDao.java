package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.SysRolePermissionDO;

import org.springframework.stereotype.Component;

@Component
public class SysRolePermissionCacheDao extends  CacheDao<SysRolePermissionDO,SysRolePermissionDO.Key>  {
	public SysRolePermissionCacheDao() {
		super(SysRolePermissionDO.TABLE_INFO);
	}

	public SysRolePermissionDO get(long roleId,long permissionId) {
		return get(new SysRolePermissionDO.Key(roleId,permissionId));
	}
}