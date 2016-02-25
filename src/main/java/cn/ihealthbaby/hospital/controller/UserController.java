package cn.ihealthbaby.hospital.controller;

import java.util.Arrays;
import java.util.Map;

import javax.validation.Valid;

import cn.ihealthbaby.hospital.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import cn.ihealthbaby.data.db.entity.UserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.UserForm;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.UserQueryForm;
import cn.ihealthbaby.hospital.services.UserService;

import com.isnowfox.core.PageResult;
import com.isnowfox.spring.annotation.AccountParam;

@Controller
@RequestMapping(value = "/staffManage")
public class UserController {

	public static final int PAGE_MAX = 200;

	@Autowired
	private UserService userService;

	@ResponseBody
	@Permission({"gravida","gravidaHospital"})
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView query(@Valid UserQueryForm userQueryForm,@AccountParam UserAccount account)
			throws Exception {
		int pageSize = Math.min(userQueryForm.getPageSize(), PAGE_MAX);
		int page = userQueryForm.getPage();
		PageResult<UserModel> result = null;
		if(account.checkPermission("gravida")){
			result=userService.query(userQueryForm);
		}else if(account.checkPermission("gravidaHospital")){
			result=userService.queryHospital(userQueryForm,account);
		}
		ModelAndView mv = new ModelAndView("/user/userList");
		mv.addObject("page", result);
		mv.addObject("form",userQueryForm);
		return mv;
	}

	@ResponseBody
	@Permission({"gravida.add","gravidaHospital.add"})
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView mv = new ModelAndView("/user/addUser");
		return mv;
	}

	@ResponseBody
	@Permission({"gravida.add","gravidaHospital.add"})
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Void> addUser(@Valid UserForm userForm,
			@AccountParam UserAccount account) {
		userForm.setHospitalId(account.getSysUserDO().getHospitalId());
		return userService.create(userForm);
	}

	@ResponseBody
	@Permission({"gravida.update","gravidaHospital.update"})
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
	public ModelAndView updateUser(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("/user/updateUser");
		UserDO user = userService.get(id);
		mv.addObject("form", user);
		return mv;
	}

	@ResponseBody
	@Permission({"gravida.update","gravidaHospital.update"})
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Void> updateUser(@PathVariable long id,
			@Valid UserForm userForm, @AccountParam UserAccount account) {
		userForm.setHospitalId(account.getSysUserDO().getHospitalId());
		return userService.update(id, userForm);
	}

	@ResponseBody
	@Permission({"gravida.delete","gravidaHospital.delete"})
	@RequestMapping(value = "/deleteUsers", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Void> deleteDoctors(@RequestBody Map<String, Long[]> params,
			@AccountParam UserAccount account) {
		return userService.delete(Arrays.asList(params.get("ids")));
	}
	@RequestMapping(value = "userDetail",method = RequestMethod.GET)
	@Permission({"gravida.gravidaDetail","gravidaHospital.gravidaDetail"})
	public ModelAndView userDetail(@RequestParam long userId){
		ModelAndView mv = new ModelAndView("/user/userDetail");
		mv.addObject("user",userService.get(userId));
		mv.addObject("service",userService.getUserService(userId));
		mv.addObject("advice",userService.getUserAdvice(userId));
		mv.addObject("order",userService.getUserOrder(userId));
		return mv;
	}
	@RequestMapping(value = "passwordModify",method = RequestMethod.GET)
	@Permission({"gravida.gravidaPwdReset","gravidaHospital.gravidaPwdReset"})
	public ModelAndView passwordModify(@RequestParam long id){
		ModelAndView mv = new ModelAndView("user/userPwdModify");
		mv.addObject("id",id);
		return mv;
	}
	@RequestMapping(value = "passwordModify",method = RequestMethod.POST)
	@Permission({"gravida.gravidaPwdReset","gravidaHospital.gravidaPwdReset"})
	@ResponseBody
	public Result passwordModify(@RequestParam long id,@RequestParam String password){
		return userService.passwordModify(id, password);
	}

}
