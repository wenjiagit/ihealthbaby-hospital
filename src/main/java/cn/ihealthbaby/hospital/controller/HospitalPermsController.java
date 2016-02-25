package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.db.entity.SysRoleDO;
import cn.ihealthbaby.hospital.form.SysRoleForm;
import cn.ihealthbaby.hospital.form.SysRoleQueryForm;
import cn.ihealthbaby.hospital.form.SysUserQueryForm;
import cn.ihealthbaby.hospital.model.SysUserModel;
import cn.ihealthbaby.hospital.permission.TreeNode;
import cn.ihealthbaby.hospital.services.HospitalPermService;
import cn.ihealthbaby.hospital.services.SysService;
import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.QueryParam;
import com.isnowfox.spring.annotation.AccountParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @author qiang on 2015/10/17.
 *         jinliqiang@ihbaby.com
 */
@Controller
@RequestMapping(value = "hospitalPerm")
public class HospitalPermsController {
    public static final int PAGE_MAX = 200;
    @Autowired
    private HospitalPermService hospitalPermService;
    @ResponseBody
    @Permission("permission.groupHospital")
    @RequestMapping(value = "/sysRoles")
    public ModelAndView SysRoleQuery(@Valid SysRoleQueryForm form,@AccountParam UserAccount account) {
        int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
        int page=form.getPage();
        PageResult<SysRoleDO> result = hospitalPermService.roleQuery(page, pageSize,account);
        ModelAndView mv = new ModelAndView("/hospitalPerm/sysRoleList");
        mv.addObject("page", result);
        return mv;

    }
    @ResponseBody
    @Permission("permission.userHospital")
    @RequestMapping(value = "/sysUsers", method = RequestMethod.GET)
    public ModelAndView sysUserQuery(@Valid SysUserQueryForm queryForm, @AccountParam UserAccount account) {
        int pageSize = Math.min(queryForm.getPageSize(), PAGE_MAX);
        int page=queryForm.getPage();
        PageResult<SysUserModel> result = hospitalPermService.sysUserQuery(page, pageSize, account);
        ModelAndView mv = new ModelAndView("/hospitalPerm/sysUserList");
        mv.addObject("page", result);
        return mv;
    }

    @RequestMapping(value="/addSysRole",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Permission("permission.groupHospital.add")
    public Result addSysRole(@Valid @ModelAttribute("sysRoleForm") SysRoleForm roleForm,@AccountParam UserAccount account) {
        hospitalPermService.addRole(roleForm, account);
        return Result.createSuccess();
    }
    @RequestMapping(value="/addSysRole",method = RequestMethod.GET)
    @Permission("permission.groupHospital.add")
    public ModelAndView addSysRole() {
        ModelAndView mv = new ModelAndView("hospitalPerm/sysRoleAdd");
        return mv;

    }

    @ResponseBody
    @Permission("permission.groupHospital.permset")
    @RequestMapping(value = "/{id}/permSet")
    public ModelAndView SysRolePermission(@PathVariable long id) {
        //List<TreeNode> list = sysService.getRolePermission(id);
        List<Long> list = hospitalPermService.getRolePermIds(id);
        List<TreeNode> allPerm = hospitalPermService.buildTree();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permlist", list);
        mv.addObject("allPerm", allPerm);
        return mv;
    }

    @ResponseBody
    @Permission("permission.groupHospital.permset")
    @RequestMapping(value = "/{id}/initpermSet")
    public ModelAndView builtPermSet(@PathVariable long id) {
        return new ModelAndView("/hospitalPerm/permSet").addObject("id", id);

    }

    @Permission("permission.userHospital.update")
    @RequestMapping(value = "/{id}/sysUserUpdate", method = RequestMethod.GET)
    public ModelAndView SysUserUpdate(@PathVariable("id") long id,@AccountParam UserAccount account) {
        ModelAndView mv = new ModelAndView("/hospitalPerm/sysUserUpdate");
        mv.addObject("rolelist", hospitalPermService.queryRole(account));
        mv.addObject("form", hospitalPermService.getSysUserDetail(id));
        mv.addObject("usrRole", hospitalPermService.getUserRole(id));
        return mv;

    }
    @ResponseBody
    @Permission("permission.groupHospital.permset")
    @RequestMapping(value = "/{id}/permSetDetail")
    public ModelAndView SysRolePermissionDetail(@PathVariable long id) {
        List<TreeNode> allPerm = hospitalPermService.getRolePermList(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("allPerm", allPerm);
        return mv;
    }

    @ResponseBody
    @Permission("permission.groupHospital.permset")
    @RequestMapping(value = "/{id}/initpermSetDetail")
    public ModelAndView builtPermSetDetail(@PathVariable long id) {
        return new ModelAndView("/hospitalPerm/permSetDetail").addObject("id", id);

    }
}
