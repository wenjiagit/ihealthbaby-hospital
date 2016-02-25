package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.ReportSettingsDO;

import org.springframework.stereotype.Component;

@Component
public class ReportSettingsCacheDao extends  CacheDao<ReportSettingsDO,ReportSettingsDO.Key>  {
	public ReportSettingsCacheDao() {
		super(ReportSettingsDO.TABLE_INFO);
	}

	public ReportSettingsDO get(long id) {
		return get(new ReportSettingsDO.Key(id));
	}
}