package cn.ihealthbaby.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.form.*;
import cn.ihealthbaby.hospital.model.SysUserModel;
import com.isnowfox.core.dao.QueryParams;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.isnowfox.core.PageResult;
import com.isnowfox.spring.I18nResult;
import com.isnowfox.spring.annotation.Account;
import com.isnowfox.spring.annotation.AccountParam;

import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.db.entity.SysRoleDO;
import cn.ihealthbaby.hospital.permission.TreeNode;
import cn.ihealthbaby.hospital.services.SysService;

@Controller
@RequestMapping(value = "sys")
public class SysController {
    public static final int PAGE_MAX = 200;
    @Autowired
	private SysService sysService;

	@ResponseBody
	@Permission("permission.user")
	@RequestMapping(value = "/sysUsers", method = RequestMethod.GET)
	public ModelAndView sysUserQuery(@Valid SysUserQueryForm queryForm, @AccountParam UserAccount account) {
        int pageSize = Math.min(queryForm.getPageSize(), PAGE_MAX);
        int page=queryForm.getPage();
		PageResult<SysUserModel> result = sysService.sysUserQuery(page,pageSize);
		ModelAndView mv = new ModelAndView("/sys/sysUserList");
		mv.addObject("page", result);
		return mv;

	}

	@ResponseBody
	@Permission("permission.user.add")
	@RequestMapping(value = "/sysUserAdd", method = RequestMethod.GET)
	public ModelAndView initSysUserAdd() {
		ModelAndView mv = new ModelAndView("/sys/sysUserAdd");
		mv.addObject("rolelist", sysService.queryRole());
		mv.addObject("hospital",sysService.queryAllHospital());
		return mv;
	}

//    @ResponseBody
//    @Permission("permission.user.add")
//    @RequestMapping(
//            value = "/sysUserAdd", method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public com.isnowfox.spring.Result sysUserAdd(@Valid SysUserForm sysUserform, @AccountParam UserAccount account) {
//        if (sysService.isUserNameExsit(sysUserform.getUsername())) {
//            return I18nResult.of("username", "account.userNameExsit", "username");
//        } else {
//            sysService.sysUserAdd(sysUserform, account);
//            return com.isnowfox.spring.Result.createSuccess();
//        }
//    }

	@Permission("permission.user.update")
	@RequestMapping(value = "/{id}/sysUserUpdate", method = RequestMethod.GET)
	public ModelAndView SysUserUpdate(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("/sys/sysUserUpdate");
		mv.addObject("rolelist", sysService.queryRole());
		mv.addObject("form", sysService.getSysUserDetail(id));
		mv.addObject("usrRole", sysService.getUserRole(id));
		return mv;

	}

	@Permission({"permission.user.update","permission.userHospital.update"})
    @ResponseBody
	@RequestMapping(value = "/{id}/sysUserUpdate", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Result SysUserUpdate(@PathVariable("id") long id, @Valid SysUserUpdateForm sysUserform) {
        sysService.updateSysUser(id, sysUserform);
		return Result.createSuccess();
	}

	@RequestMapping(value = "/disableUser", method = RequestMethod.POST)
	@ResponseBody
	@Permission("permission.user.delete")
	public Result disableUser(@RequestBody Map<String, Long[]> params) {
		return sysService.disableUser(params.get("ids"));

	}

	@RequestMapping(value = "/{id}/disableUser", method = RequestMethod.GET)
	@ResponseBody
	@Permission("permission.user.delete")
	public Result disableUser(@PathVariable long id) {
		Long[] ids = { id };
		return sysService.disableUser(ids);

	}

	@ResponseBody
	@Permission("permission.group")
	@RequestMapping(value = "/sysRoles")
	public ModelAndView SysRoleQuery(@Valid SysRoleQueryForm form) {
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
        int page=form.getPage();
		PageResult<SysRoleDO> result = sysService.roleQuery(page, pageSize);
		ModelAndView mv = new ModelAndView("/sys/sysRoleList");
		mv.addObject("page", result);
		return mv;

	}

	@RequestMapping("/delrole")
	@ResponseBody
	@Permission({"permission.group.delete","permission.groupHospital.delete"})
	public String delSysRole(@RequestBody Map<String, long[]> params) {
		boolean flag = sysService.delRole(params.get("ids"));
		return "{msg:" + flag + "}";

	}

	@RequestMapping(value="/addSysRole",method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Permission({"permission.group.add","permission.groupHospital.add"})
	public Result addSysRole(@Valid @ModelAttribute("sysRoleForm") SysRoleForm roleForm) {
				sysService.addRole(roleForm);
		return Result.createSuccess();
	}
	@RequestMapping(value="/addSysRole",method = RequestMethod.GET)
	@Permission("permission.group.add")
	public ModelAndView addSysRole() {
		ModelAndView mv = new ModelAndView("sys/sysRoleAdd");
		return mv;	
				
	}
	@ResponseBody
	@Permission("permission.group.permset")
	@RequestMapping(value = "/{id}/permSet")
	public ModelAndView SysRolePermission(@PathVariable long id) {
		//List<TreeNode> list = sysService.getRolePermission(id);
		List<Long> list = sysService.getRolePermIds(id);
		List<TreeNode> allPerm = sysService.buildTree();
		ModelAndView mv = new ModelAndView();
		mv.addObject("permlist", list);
		mv.addObject("allPerm", allPerm);
		return mv;
	}

	@ResponseBody
	@Permission("permission.group.permset")
	@RequestMapping(value = "/{id}/initpermSet")
	public ModelAndView builtPermSet(@PathVariable long id) {
		return new ModelAndView("/sys/permSet").addObject("id", id);

	}

	@RequestMapping(value = "/addRolePerm", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Permission({"permission.group.permset","permission.groupHospital.permset"})
	public Result addRolePermission(@Valid @ModelAttribute("RolePermForm") RolePermForm roleform,
			BindingResult bindingResult) {
		 sysService.addRolePermission(roleform.getRoleId(), roleform.getPermIds());
		
		 return Result.createSuccess();

	}

	@RequestMapping("/delRolePerm")
	@ResponseBody
	@Permission("permission.group.permset")
	public ModelAndView delRolePermission(@Valid @ModelAttribute("RolePermForm") RolePermForm roleform,
			BindingResult bindingResult) {
		boolean flag = sysService.delRolePermission(roleform.getRoleId(), roleform.getPermIds());
		ModelAndView mv = new ModelAndView("/sys/permSet");
		mv.addObject("flag", flag);
		mv.addObject("id", roleform.getRoleId());
		mv.addObject("bindingResult", bindingResult);
		return mv;
	}

	@RequestMapping(value = "/{id}/getDepartmentByHosId")
	@ResponseBody
	@Account(false)
	public Result getDepartmentByHosId(@PathVariable("id") long id){
		List<DepartmentDO> areaList = sysService.queryDepartmentByHosId(id);
		if (areaList!=null){
			return new Result(0,"success",areaList);
		} else {
			return new Result(1,"fail",null);
		}
	}
	@RequestMapping(value = "roleAddUser",method = RequestMethod.GET)
	@Permission("permission.group.addUser")
	public ModelAndView roleAddUser(@RequestParam long id){
		ModelAndView mv = new ModelAndView("sys/addUserToRole");
		List<SysUserDO> list = sysService.getUserofRole(id);
		mv.addObject("list",list);
		return mv;
	}
	@RequestMapping(value = "autoUser",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@Permission("permission.group.addUser")
	@ResponseBody
	public List<Map<String,String>> userList(@AccountParam UserAccount account,@RequestParam String term){
		List<Map<String,String>> list=sysService.userList(account,term);
		return  list;
	}
}
