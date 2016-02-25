package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.ServiceInsideForm;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.InsideServiceQueryForm;
import cn.ihealthbaby.hospital.model.InsideServiceModel;
import cn.ihealthbaby.hospital.services.InsideServiceService;
import com.isnowfox.core.PageResult;
import com.isnowfox.spring.I18nResult;
import com.isnowfox.spring.annotation.AccountParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by qiang on 2015/8/5.
 */
@Controller
@RequestMapping("/insideService")
public class InsideServiceController {

    @Autowired
    private InsideServiceService insideServiceService;

    /**
     * 跳转到院内监护页面
     * @return
     */
    @RequestMapping(value = "/insideServiceDeal",method = RequestMethod.GET)
    @Permission("insideService.insideServiceDeal")
    public ModelAndView initServiceDeal(@AccountParam UserAccount account) {
        ModelAndView mv = new ModelAndView("/service/insideServiceDeal");
        mv.addObject("hosid",account.getSysUserDO().getHospitalId());
        return mv;
    }

    /**
     * 添加院内监护信息
     * @param serviceInsideForm
     * @return
     */
    @RequestMapping(value = "/insideServiceDeal",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("insideService.insideServiceDeal")
    @ResponseBody
    public Result addServiceInside(@Valid ServiceInsideForm serviceInsideForm){
        return  insideServiceService.addInsideService(serviceInsideForm);
    }
    @RequestMapping(value = "/insideServiceList",method = RequestMethod.GET)
    @Permission("insideService.insideServiceList")
    public ModelAndView insideServiceList(@Valid InsideServiceQueryForm form,@AccountParam UserAccount account){
        ModelAndView mv = new ModelAndView("/service/insideServiceInfoList");
        PageResult<InsideServiceModel> page =insideServiceService.getInsideServiceList(form,account);
        mv.addObject("page",page);
        mv.addObject("form",form);
        return  mv;
    }
    @RequestMapping(value = "/insideServiceListToDeal",method = RequestMethod.GET)
    @Permission("insideService.insideServiceListToDeal")
    public ModelAndView insideServiceListToDeal(@Valid InsideServiceQueryForm form,@AccountParam UserAccount account){
        ModelAndView mv = new ModelAndView("/service/insideServiceInfoListToDeal");
        PageResult<InsideServiceModel> page =insideServiceService.getInsideServiceListToDeal(form, account);
        mv.addObject("page",page);
        return  mv;
    }
}
