package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.SysRoleDO;

import org.springframework.stereotype.Component;

@Component
public class SysRoleCacheDao extends  CacheDao<SysRoleDO,SysRoleDO.Key>  {
	public SysRoleCacheDao() {
		super(SysRoleDO.TABLE_INFO);
	}

	public SysRoleDO get(long id) {
		return get(new SysRoleDO.Key(id));
	}
}