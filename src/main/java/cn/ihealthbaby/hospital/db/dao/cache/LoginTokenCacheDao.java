package cn.ihealthbaby.hospital.db.dao.cache;

import com.isnowfox.core.dao.impi.CacheDao;
import cn.ihealthbaby.hospital.db.entity.LoginTokenDO;

import org.springframework.stereotype.Component;

@Component
public class LoginTokenCacheDao extends  CacheDao<LoginTokenDO,LoginTokenDO.Key>  {
	public LoginTokenCacheDao() {
		super(LoginTokenDO.TABLE_INFO);
	}

	public LoginTokenDO get(String token) {
		return get(new LoginTokenDO.Key(token));
	}
}