package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.NstOptionDO;

import org.springframework.stereotype.Component;

@Component
public class NstOptionCacheDao extends  CacheDao<NstOptionDO,NstOptionDO.Key>  {
	public NstOptionCacheDao() {
		super(NstOptionDO.TABLE_INFO);
	}

	public NstOptionDO get(long id) {
		return get(new NstOptionDO.Key(id));
	}
}