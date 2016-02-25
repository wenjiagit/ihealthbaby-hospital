package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.data.db.entity.HospitalAdviceSettingDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.ServiceSettingForm;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.model.HospitalPackageModel;
import cn.ihealthbaby.hospital.model.RentSetModel;
import cn.ihealthbaby.hospital.model.ReportSettingModel;
import cn.ihealthbaby.hospital.services.SettingService;
import com.isnowfox.spring.annotation.AccountParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qiang on 2015/8/4.
 */
@Controller
@RequestMapping("/setting")
public class SettingsController {
    @Autowired
    private SettingService settingService;
    @RequestMapping(value = "/rentSetting",method = RequestMethod.GET)
    @Permission("sysManage.rentSetting")
    public  ModelAndView rentSetting(@AccountParam UserAccount account){
        ModelAndView mv= new ModelAndView("/setting/rentSetting");
        RentSetModel rentSetModel =settingService.getRentInitData(account.getSysUserDO().getHospitalId());
        mv.addObject("model", rentSetModel);
        return mv;
    }

    /**
     * 报告设置
     */
    @RequestMapping(value = "/reportSettingList",method = RequestMethod.GET)
    @Permission("sysManage.reportSetting")
    public ModelAndView reportSetting(@AccountParam UserAccount account){
        ReportSettingModel model = settingService.getReportSetting(account);
        ModelAndView mv = new ModelAndView("/setting/reportSetting");
        mv.addObject("model", model);
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "addCat",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.reportSetting")
    public Result addCat(@RequestParam String catOptionName,@RequestParam String catOptionDetail,@RequestParam int level,@AccountParam UserAccount account){
        settingService.addCat(catOptionName, catOptionDetail,level,account);
        return Result.createSuccess();
    }
    @ResponseBody
    @RequestMapping(value = "addNst",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.reportSetting")
    public Result addNst(@RequestParam String nstOptionName,@RequestParam String nstOptionDetail,@RequestParam int level,@AccountParam UserAccount account){
        settingService.addNst(nstOptionName, nstOptionDetail,level, account);
        return Result.createSuccess();
    }
    @RequestMapping(value = "delNst",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.reportSetting")
    @ResponseBody
    public Result delNst(@RequestParam long id){
        settingService.delNst(id);
        return Result.createSuccess();
    }
    @RequestMapping(value = "delCat",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.reportSetting")
    @ResponseBody
    public Result delCat(@RequestParam long id){
        settingService.delCat(id);
        return Result.createSuccess();
    }
    @RequestMapping(value="updateSetParams",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
         @Permission("sysManage.reportSetting")
         @ResponseBody
         public Result updateSetParams(@RequestParam int paperspeed,@RequestParam int divisionX,@RequestParam int divisionY,@RequestParam long id,@RequestParam double zoom){
        settingService.updateSetParams(paperspeed, divisionX, divisionY, id, zoom);
        return Result.createSuccess();
    }
    @RequestMapping(value="updateshowhide",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.reportSetting")
    @ResponseBody
    public Result updateShowHide(@RequestParam boolean reportPrintView,@RequestParam boolean reportPrintNstView,@RequestParam boolean reportPrintCatView,@RequestParam long id){
        settingService.updateShowHide(reportPrintView, reportPrintNstView, reportPrintCatView, id);
        return Result.createSuccess();
    }

    @RequestMapping(value="updateSignShowHide",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.reportSetting")
    @ResponseBody
    public Result updateSignShowHide(@RequestParam boolean signpageView,@RequestParam boolean signpageNstView,@RequestParam boolean signpageCatView,@RequestParam long id){
        settingService.updateSignShowHide(signpageView, signpageNstView, signpageCatView, id);
        return Result.createSuccess();
    }
    @RequestMapping(value="addproduct",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.rentSetting")
    @ResponseBody
    public Result addProduct(@RequestParam String name,@RequestParam int price,@RequestParam int amount,
                             @RequestParam int maxamount,@RequestParam int chargeType,@RequestParam String type,
                             @RequestParam String description,@AccountParam UserAccount account){
        settingService.addProduct(name, price, amount, maxamount, chargeType, type, description, account);
        return Result.createSuccess();
    }
    @RequestMapping(value="updateForgift",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.rentSetting")
    @ResponseBody
    public Result updateForgift(@RequestParam long id,@RequestParam String name,@RequestParam int price,@RequestParam int amount,
                                @RequestParam int maxamount,@RequestParam String description){
            return settingService.updateForgift(id, name, price, amount, maxamount, description);
    }
    @RequestMapping(value="delForgift",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.rentSetting")
    @ResponseBody
    public Result delForegift(@RequestParam long id){
            return settingService.delForegift(id);
    }
    @RequestMapping(value="updateDayRent",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.rentSetting")
    @ResponseBody
    public Result updateDayRent(@RequestParam long id,@RequestParam String name,@RequestParam int price,@RequestParam int amount,
                                @RequestParam int maxamount,@RequestParam String description){
            return settingService.updateDayRent(id, name, price, amount, maxamount, description);
    }
    @RequestMapping(value="updateAskPrice",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.rentSetting")
    @ResponseBody
    public Result updateAskPrice(@RequestParam long id,@RequestParam String name,@RequestParam int price,@RequestParam int amount,@RequestParam int chargeType,
                                 @RequestParam int maxamount,@RequestParam String description,@AccountParam UserAccount account){
            return settingService.updateAskPrice(id, name, price, amount, chargeType, maxamount, description, account.getSysUserDO().getHospitalId());
    }
    @RequestMapping(value="updateCouplant",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.rentSetting")
    @ResponseBody
    public Result updateCouplant(@RequestParam long id,@RequestParam String name,@RequestParam int price,@RequestParam int amount,
                                 @RequestParam int maxamount,@RequestParam String description){
        return settingService.updateCounplant(id, name, price, amount, maxamount, description);
    }

    /**
     * 监护设置
     * @return
     */
    @RequestMapping(value = "serviceSetting",method = RequestMethod.GET)
    @Permission("sysManage.serviceSetting")
    public ModelAndView serviceSetting(@AccountParam UserAccount account){
        ModelAndView mv =new ModelAndView("/setting/serviceSetting");
        HospitalAdviceSettingDO adviceSettingDO = settingService.getAdvieSettingDetail(account.getSysUserDO().getHospitalId());
        mv.addObject("adviceSetting",adviceSettingDO);
        return mv;
    }
    /**
     *
     */
    @RequestMapping(value = "saveServiceSetting",method = RequestMethod.POST)
    @Permission("sysManage.serviceSetting")
    @ResponseBody
     public Result saveServiceSetting(ServiceSettingForm form,@AccountParam UserAccount account){
        return  settingService.serviceSetting(form,account.getSysUserDO().getHospitalId());
     }
    /**
     * 套餐设置
     * @param account
     * @return
     */
    @RequestMapping(value="packageSetting",method = RequestMethod.GET)
    @Permission("sysManage.packageSetting")
    public ModelAndView HospitalPackageSet(@AccountParam UserAccount account){
        ModelAndView mv = new ModelAndView("/setting/packageSetting");
        HospitalPackageModel model = settingService.getHospitalPackage(account.getSysUserDO().getHospitalId());
        RentSetModel rentSetModel = settingService.getRentInitData(account.getSysUserDO().getHospitalId());
        mv.addObject("model",model);
        mv.addObject("rentModel",rentSetModel);
        return mv;
    }
    @RequestMapping(value="addPackageItem",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.packageSetting")
    @ResponseBody
    public Result addPackageItem(@RequestParam long id,@RequestParam long productId){
         return settingService.addPackageItem(id,productId);
    }

    @RequestMapping(value="delPackageItem",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("sysManage.packageSetting")
    @ResponseBody
    public Result removePackageItem(@RequestParam long id,@RequestParam long productId){
        return settingService.removePackageItem(id, productId);
    }
    @RequestMapping(value = "/getHospitalPackageSet",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Permission("custody.serviceDeal")
    public Result getHospitalPackageSet(@AccountParam UserAccount account){
        HospitalPackageModel model = settingService.getHospitalPackage(account.getSysUserDO().getHospitalId());
        return Result.createSuccess(model);
    }

}
