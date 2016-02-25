package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.AdminDO;

import org.springframework.stereotype.Component;

@Component
public class AdminCacheDao extends  CacheDao<AdminDO,AdminDO.Key>  {
	public AdminCacheDao() {
		super(AdminDO.TABLE_INFO);
	}

	public AdminDO get(String name) {
		return get(new AdminDO.Key(name));
	}
}