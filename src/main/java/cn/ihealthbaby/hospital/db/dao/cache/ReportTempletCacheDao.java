package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.ReportTempletDO;

import org.springframework.stereotype.Component;

@Component
public class ReportTempletCacheDao extends  CacheDao<ReportTempletDO,ReportTempletDO.Key>  {
	public ReportTempletCacheDao() {
		super(ReportTempletDO.TABLE_INFO);
	}

	public ReportTempletDO get(long id) {
		return get(new ReportTempletDO.Key(id));
	}
}