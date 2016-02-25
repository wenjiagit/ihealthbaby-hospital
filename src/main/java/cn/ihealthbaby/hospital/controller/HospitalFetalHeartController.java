package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.DeviceForm;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.HospitalFetalheartQueryForm;
import cn.ihealthbaby.hospital.model.HospitalFetalHeartInfo;
import cn.ihealthbaby.hospital.services.HospitalFetalHeartService;
import cn.ihealthbaby.hospital.services.HospitalService;
import com.isnowfox.core.PageResult;
import com.isnowfox.spring.annotation.AccountParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by qiang on 2015/7/31.
 */
@Controller
@RequestMapping("/fetalheart")
public class HospitalFetalHeartController {
    @Autowired
    private HospitalFetalHeartService hospitalFetalHeartService;
    @Autowired
    private HospitalService hospitalService;

    @Permission("devmanage.devlist")
    @RequestMapping(value = "/devList")
    public ModelAndView queryFetalHeartListInside(HospitalFetalheartQueryForm form, @AccountParam UserAccount account){
        PageResult<HospitalFetalHeartInfo> result = hospitalFetalHeartService.queryForList(form,account.getSysUserDO().getHospitalId(),0);
        ModelAndView mv =new ModelAndView("/fetalHeart/devList");
        mv.addObject("permission","devList");
        mv.addObject("page",result);
        mv.addObject("form",form);
        return mv;
    }
    @Permission("devmanage.devOutsidelist")
    @RequestMapping(value = "/devOutsidelist")
    public ModelAndView queryFetalHeartListOutSide(HospitalFetalheartQueryForm form, @AccountParam UserAccount account){
        PageResult<HospitalFetalHeartInfo> result = hospitalFetalHeartService.queryForList(form,account.getSysUserDO().getHospitalId(),1);
        ModelAndView mv =new ModelAndView("/fetalHeart/devList");
        mv.addObject("permission","devOutsidelist");
        mv.addObject("page",result);
        mv.addObject("form",form);
        return mv;
    }
    @ResponseBody
    @Permission("devmanage.devlist.add")
    @RequestMapping(value = "/addDev",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result addHospitalFetalHeart(@Valid DeviceForm form){
        return hospitalFetalHeartService.addDeviceToHospital(form);
    }
    @Permission("devmanage.devlist.add")
    @RequestMapping(value="/addDev",method = RequestMethod.GET)
    public ModelAndView addHospitalFetalHeart(@AccountParam UserAccount account){
        ModelAndView mv = new ModelAndView("/fetalHeart/devAdd");
        mv.addObject("hospital",hospitalFetalHeartService.getHospitalbyAccount(account));
        return mv;
    }
    @ResponseBody
    @Permission("devmanage.devOutsidelist.add")
    @RequestMapping(value = "/addOutsideDev",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result addHospitalFetalHeartOutside(@Valid DeviceForm form){
        return hospitalFetalHeartService.addDeviceToHospital(form);
    }
    @Permission("devmanage.devOutsidelist.add")
    @RequestMapping(value="/addOutsideDev",method = RequestMethod.GET)
    public ModelAndView addHospitalFetalHeartOutside(@AccountParam UserAccount account){
        ModelAndView mv = new ModelAndView("/fetalHeart/devOutsideAdd");
        mv.addObject("hospital",hospitalFetalHeartService.getHospitalbyAccount(account));
        return mv;
    }
    @ResponseBody
    @Permission("devmanage.devlist.update")
    @RequestMapping(value = "/{id}/updateDev",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result updateHospitalFetalHeart(@PathVariable long id,@Valid DeviceForm form){
        return  hospitalFetalHeartService.updateDeviceToHospital(id, form);
    }
    @Permission("devmanage.devlist.update")
    @RequestMapping(value="/{id}/updateDev",method = RequestMethod.GET)
    public ModelAndView updateHospitalFetalHeart(@PathVariable long id,@AccountParam UserAccount account){
        ModelAndView mv =new ModelAndView("/fetalHeart/devUpdate");
        mv.addObject("info",hospitalFetalHeartService.queryById(id));
        mv.addObject("hospital",hospitalFetalHeartService.getHospitalbyAccount(account));
        return mv;
    }
    @Permission("devmanage.devlist.add")
    @RequestMapping(value="/belongDepartment",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result belongDepartment(@RequestParam long hospitalId){
        return Result.createSuccess(hospitalFetalHeartService.belongDepartment(hospitalId));
    }
    @Permission("devmanage.devOutsidelist.delete")
    @ResponseBody
    @RequestMapping(value="/delHospitalDev",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Result delHospitalFetalheart(long id){
        return hospitalFetalHeartService.delHospitalFetalheart(id);
    }
    @Permission("devmanage.devAdminList")
    @RequestMapping(value="/devAdminList",method = RequestMethod.GET)
    public ModelAndView adminDevList(HospitalFetalheartQueryForm form){
        ModelAndView mv =new ModelAndView("/fetalHeart/devAdminList");
        mv.addObject("page",hospitalFetalHeartService.queryForAdminList(form));
        mv.addObject("form",form);
        return mv;
    }

    @ResponseBody
    @Permission("devmanage.devAdminList.add")
    @RequestMapping(value = "/addAdminDev",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result addAdminFetalHeart(@Valid DeviceForm form){
        return hospitalFetalHeartService.addDeviceToHospital(form);
    }
    @Permission("devmanage.devAdminList.add")
    @RequestMapping(value="/addAdminDev",method = RequestMethod.GET)
    public ModelAndView addAdminFetalHeart(){
        ModelAndView mv = new ModelAndView("/fetalHeart/devAdminAdd");
        mv.addObject("hospitals",hospitalService.getAllHospital());
        return mv;
    }

    @ResponseBody
    @Permission("devmanage.devAdminList.update")
    @RequestMapping(value = "/{id}/updateAdminDev",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result updateAdminFetalHeart(@PathVariable long id,@Valid DeviceForm form){
        return hospitalFetalHeartService.updateDeviceToHospital(id, form);
    }
    @Permission("devmanage.devAdminList.update")
    @RequestMapping(value="/{id}/updateAdminDev",method = RequestMethod.GET)
    public ModelAndView updateAdminFetalHeart(@PathVariable long id){
        ModelAndView mv = new ModelAndView("/fetalHeart/devAdminUpdate");
        mv.addObject("info",hospitalFetalHeartService.queryById(id));
        mv.addObject("hospitals",hospitalService.getAllHospital());
        return mv;
    }
}
