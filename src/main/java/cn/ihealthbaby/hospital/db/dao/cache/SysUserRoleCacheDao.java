package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.SysUserRoleDO;

import org.springframework.stereotype.Component;

@Component
public class SysUserRoleCacheDao extends  CacheDao<SysUserRoleDO,SysUserRoleDO.Key>  {
	public SysUserRoleCacheDao() {
		super(SysUserRoleDO.TABLE_INFO);
	}

	public SysUserRoleDO get(long userId,long roleId) {
		return get(new SysUserRoleDO.Key(userId,roleId));
	}
}