package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.hospital.BaseJunit4Test;
import cn.ihealthbaby.hospital.services.LoginService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
public class LoginControllerTest extends BaseJunit4Test {
    @Autowired
    private LoginService loginService;

    @Test
    public void logintest() {

//        SysUserDO userDo = new SysUserDO();
//        userDo.setId(1);
//        userDo.setIsStopped(false);
//        System.out.println(loginService.getPermissionMap());
//        System.out.println(loginService.initUserLeftMenu(userDo));
    }
}
