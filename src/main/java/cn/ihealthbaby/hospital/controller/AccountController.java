package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.LoginForm;
import cn.ihealthbaby.hospital.services.DoctorService;
import cn.ihealthbaby.hospital.services.LoginService;
import com.isnowfox.spring.annotation.Account;
import com.isnowfox.spring.annotation.AccountParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 *
 */
@Controller
@RequestMapping
public class AccountController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    @Account(false)
    public ModelAndView index() throws Exception {
        return new ModelAndView("/login");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @Account(false)
    public ModelAndView login(
            @Valid @ModelAttribute LoginForm form,
            BindingResult bindingResult,
            HttpServletResponse response
    ) throws Exception {
        if (!bindingResult.hasErrors()) {
            if (loginService.login(response, form, bindingResult)) {
                return new ModelAndView(new RedirectView("/index.do",true));
            }
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("form", form);
        modelAndView.addObject("bindingResult", bindingResult);
        return modelAndView;
    }
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @Account(false)
    public ModelAndView logout(HttpServletRequest request){
        loginService.logout(request);
        return new ModelAndView("/login");
    }
    @RequestMapping(value = "sysUserPwdModify", method = RequestMethod.GET)
    @Permission("index")
    public ModelAndView passwordModify(){
        return new ModelAndView("/sysPwdModify");
    }
    @Permission("index")
    @ResponseBody
    @RequestMapping(value = "sysUserPwdModify", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Result passwordModify(@AccountParam UserAccount account,@RequestParam String password){
       return doctorService.passwordModify(account.getSysUserDO().getId(),password);
    }
}
