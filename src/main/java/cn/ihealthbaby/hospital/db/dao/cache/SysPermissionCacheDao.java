package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.SysPermissionDO;

import org.springframework.stereotype.Component;

@Component
public class SysPermissionCacheDao extends  CacheDao<SysPermissionDO,SysPermissionDO.Key>  {
	public SysPermissionCacheDao() {
		super(SysPermissionDO.TABLE_INFO);
	}

	public SysPermissionDO get(long id) {
		return get(new SysPermissionDO.Key(id));
	}
}