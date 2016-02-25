package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.CatOptionDO;

import org.springframework.stereotype.Component;

@Component
public class CatOptionCacheDao extends  CacheDao<CatOptionDO,CatOptionDO.Key>  {
	public CatOptionCacheDao() {
		super(CatOptionDO.TABLE_INFO);
	}

	public CatOptionDO get(long id) {
		return get(new CatOptionDO.Key(id));
	}
}