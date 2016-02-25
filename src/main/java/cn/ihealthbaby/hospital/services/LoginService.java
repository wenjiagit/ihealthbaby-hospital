package cn.ihealthbaby.hospital.services;

import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.db.dao.cache.LoginTokenCacheDao;
import cn.ihealthbaby.hospital.db.entity.LoginTokenDO;
import cn.ihealthbaby.hospital.form.LoginForm;
import cn.ihealthbaby.hospital.permission.Roles;
import com.isnowfox.core.dao.QueryParams;
import com.isnowfox.spring.BindingResultUtils;
import com.isnowfox.util.CookieUtils;
import com.isnowfox.util.DigestUtils;
import com.isnowfox.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * INSERT INTO `manager`.`admin` (`name`, `password`, `update_time`,
 * `create_time`) VALUES ('zuoge85',
 * 'ubIIokHl/sEMxYnSMQlcSmJZEI+zhY0+arPY/jNI9rU=', now(), now());
 *
 * @author zuoge85 on 15/5/17.
 */
@Service
public class LoginService {
    private static final String LOGIN_TOKEN_NAME = "loginid";
    //
    private static final Logger log = LoggerFactory
            .getLogger(LoginService.class);

    @Value("${qiniu.base.path}")
    private String qiNiuBasePath;
    @Autowired
    private LoginTokenCacheDao loginTokenCacheDao;

    @Autowired
    private SysUserReadOnlyDao sysUserReadOnlyDao;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private DoctorService doctorService;

    public boolean login(HttpServletResponse response, LoginForm form,
                         BindingResult bindingResult) {
        QueryParams queryParams = QueryParams.create();
        String password = form.getPassword();
        String name = form.getName();
        queryParams.add(
                    SysUserDO.ThisTableInfo.USERNAME_DB_NAME, name)
                    .add(SysUserDO.ThisTableInfo.PASSWORD_DB_NAME, DigestUtils.digest(password))
                    .add(SysUserDO.ThisTableInfo.ISSTOPPED_DB_NAME, false)
                    .or(SysUserDO.ThisTableInfo.MOBILE_DB_NAME, name)
                    .add(SysUserDO.ThisTableInfo.PASSWORD_DB_NAME, DigestUtils.digest(password))
                    .add(SysUserDO.ThisTableInfo.ISSTOPPED_DB_NAME, false
                    );


        SysUserDO object = sysUserReadOnlyDao.findObject(queryParams);
        if(object == null){
            object = oldLogin(name, password);
        }
        if (object != null) {
            LoginTokenDO loginTokenDO = new LoginTokenDO();
            loginTokenDO.setName(object.getUsername());
            loginTokenDO.setToken(randomId());
            loginTokenDO.setCreateDate(new Date());

            loginTokenCacheDao.replace(loginTokenDO);

            Cookie cookie = new Cookie(LOGIN_TOKEN_NAME,
                    loginTokenDO.getToken());
            cookie.setMaxAge(-1);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return true;
        } else {
            BindingResultUtils.addMsg(bindingResult, "error1", "name",
                    "password");
        }
        return false;
    }

    public SysUserDO oldLogin(String name, String password) {
        log.info("oldLogin name:{},pwd:{}", password);
        QueryParams queryParams = QueryParams.create();
        queryParams.add(
                SysUserDO.ThisTableInfo.USERNAME_DB_NAME, name)
                .add(SysUserDO.ThisTableInfo.PASSWORD_DB_NAME, DigestUtils.digestSha1(password))
                .add(SysUserDO.ThisTableInfo.ISSTOPPED_DB_NAME, false)
                .or(SysUserDO.ThisTableInfo.MOBILE_DB_NAME, name)
                .add(SysUserDO.ThisTableInfo.PASSWORD_DB_NAME, DigestUtils.digestSha1(password))
                .add(SysUserDO.ThisTableInfo.ISSTOPPED_DB_NAME, false
        );

        SysUserDO object = sysUserReadOnlyDao.findObject(queryParams);
        if(object != null){
            doctorService.passwordModify(object.getId(), password);
        }
        return object;
    }

    public UserAccount getLoginUser(HttpServletRequest request) {
        String loginToken = CookieUtils.get(request, LOGIN_TOKEN_NAME);
        if (loginToken == null) {
            return null;
        }

        LoginTokenDO loginTokenDO = loginTokenCacheDao.get(loginToken);
        if (loginTokenDO != null) {
            return get(loginTokenDO.getName());
        }
        return null;
    }

    private UserAccount get(String name) {
        QueryParams queryParams = QueryParams.create();
        queryParams.add(SysUserDO.ThisTableInfo.USERNAME_DB_NAME, name).or(SysUserDO.ThisTableInfo.MOBILE_DB_NAME, name);
        SysUserDO userDO = sysUserReadOnlyDao.findObject(queryParams);
        if (userDO != null) {

            Roles roles = permissionService.getRoles(userDO.getId());
            UserAccount userAccount = new UserAccount();
            if (userDO.getHeadPic() != null) {
                userDO.setHeadPic(qiNiuBasePath + userDO.getHeadPic());
            }
            userAccount.setSysUserDO(userDO);
            userAccount.setRoles(roles);
            return userAccount;
        }
        return null;
    }

    public void logout(HttpServletRequest request) {
        String loginToken = CookieUtils.get(request, LOGIN_TOKEN_NAME);
        log.info("logout {}", loginToken);
        loginTokenCacheDao.del(new LoginTokenDO.Key(loginToken));
    }

    private String randomId() {
        return UUID.random() + RandomStringUtils.randomAlphanumeric(16);
    }

	/*
     * public static void main(String[] args) {
	 * System.out.println(digest("123456"));
	 * System.out.printf(RandomStringUtils.randomAlphanumeric(6));
	 * System.out.println(DigestUtils.sha256Hex(salt + "123456")); }
	 */

}