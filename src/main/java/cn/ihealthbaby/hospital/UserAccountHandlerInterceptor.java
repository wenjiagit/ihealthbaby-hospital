package cn.ihealthbaby.hospital;

import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.services.LoginService;
import com.isnowfox.spring.AccountHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zuoge85 on 15/4/25.
 */
public class UserAccountHandlerInterceptor extends AccountHandlerInterceptor<UserAccount> {
    @Autowired
    private LoginService loginService;

    @Override
    protected UserAccount getAccountObject(HttpServletRequest request) {
        return loginService.getLoginUser(request);
    }

    /**
     * 检查权限，默认没声明权限的表示，无人能访问！
     */
    @Override
    protected boolean check(HandlerMethod handlerMethod, UserAccount userAccount) {
        Permission permissionAnnotation = handlerMethod.getMethodAnnotation(Permission.class);
        if (permissionAnnotation == null) {
            return false;
        }

        String[] value = permissionAnnotation.value();
        if (value.length == 0) {
            return false;
        }
        return userAccount.checkPermission(value);
    }
}
