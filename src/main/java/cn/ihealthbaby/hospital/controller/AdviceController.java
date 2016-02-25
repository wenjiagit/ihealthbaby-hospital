package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.data.db.entity.AdviceEcgDataDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.AdviceDataForm;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.AdviceAskForm;
import cn.ihealthbaby.hospital.form.AdviceForm;
import cn.ihealthbaby.hospital.form.AdviceReadDataForm;
import cn.ihealthbaby.hospital.form.ReplyQueryForm;
import cn.ihealthbaby.hospital.model.ReplyDataModel;
import cn.ihealthbaby.hospital.services.AdviceService;
import com.isnowfox.core.PageResult;
import com.isnowfox.spring.annotation.Account;
import com.isnowfox.spring.annotation.AccountParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author  qiang on 2015/8/10.
 */
@RequestMapping("/advice")
@Controller
public class AdviceController {
    @Autowired
    private AdviceService adviceService;
    @RequestMapping(value = "/ecgData", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @Account(false)
    @ResponseBody
    public Result getAdviceEcgData(@RequestParam long id) throws Exception{
        AdviceEcgDataDO adviceEcgDataDO = adviceService.getAdviceEcgData(id);
        return Result.createSuccess(adviceEcgDataDO);
    }

    @Permission("readData.askDetail")
    @RequestMapping(value = "/adviceDetail", method = RequestMethod.GET)
    public ModelAndView adviceDetail(long id,String templ) throws Exception {
        //URLEncoder 防止注入字符串攻击，然并卵
        if (StringUtils.isEmpty(templ)) {
            templ = "default";
        }
        ModelAndView mv = new ModelAndView("/advice/templ/" + URLEncoder.encode(templ, "utf-8"));
        AdviceAskForm form =adviceService.getAdivceDetail(id);
        mv.addObject("advice",form);
        mv.addObject("adviceEcgData", adviceService.getAdviceEcgData(form.getAdviceDO().getId()));
        mv.addObject("adviceData",adviceService.getAdviceData(form.getAdviceDO().getId(), 0));
        mv.addObject("hospitalAdviceSettingDO",adviceService.getSettingDO(form.getHospitalDO().getId()));
        return mv;
    }

    @RequestMapping(value = "/replyDataList",method = RequestMethod.GET)
    @Permission({"readData.replyList","readData.replyListHospital"})
    public ModelAndView getReplyDataList(@Valid ReplyQueryForm form,@AccountParam UserAccount account){
        PageResult<ReplyDataModel> page = null;
        if(account.checkPermission("readData.replyList")){
            page= adviceService.getReplyList(form);
        }else if (account.checkPermission("readData.replyListHospital")){
            page=adviceService.getReplyListHospital(form,account);
        }
        ModelAndView mv = new ModelAndView("/advice/replyDataList");
        mv.addObject("page",page);
        mv.addObject("form",form);
        return mv;
    }

    @RequestMapping(value = "/replyDetail",method = RequestMethod.GET)
    @Permission("readData.replyDetail")
    public ModelAndView getReplyDataDetail(@RequestParam long id) throws Exception{
        ModelAndView mv =new ModelAndView("/advice/replyDetail");
        ReplyDataModel model =adviceService.getReplyDataDetail(id);
        mv.addObject("advice",model);
        mv.addObject("adviceData",adviceService.getAdviceData(model.getAdviceDO().getId(),1));
        mv.addObject("adviceEcgData", adviceService.getAdviceEcgData(model.getAdviceDO().getId()));
        mv.addObject("hospitalAdviceSettingDO",adviceService.getSettingDO(model.getHospitalDO().getId()));
        return mv;
    }
    @RequestMapping(value = "/saveReadData",method = RequestMethod.POST)
    @Permission("readData.askDetail")
    @ResponseBody
    public Result readDataSave(AdviceReadDataForm dataForm) throws Exception{
       return adviceService.readData(dataForm);
    }
    @Permission("readData.askDetail")
    @RequestMapping(value = "/getReportPDF", method = RequestMethod.GET)
    public String getReportPDF(long id,HttpServletResponse response) throws  Exception{
       ByteArrayOutputStream outputStream= adviceService.createReportPDF(id);
        OutputStream out = null;
        response.setContentType("application/pdf");
        out = response.getOutputStream();
        out.write(outputStream.toByteArray());
        return null;
    }
    @Permission("readData.askDetail")
    @RequestMapping(value = "/getDrawPDF", method = RequestMethod.GET)
    public String getDrawPDF(long id,HttpServletResponse response) throws  Exception{
        ByteArrayOutputStream outputStream= adviceService.createDrawPDF(id);
        OutputStream out = null;
        response.setContentType("application/pdf");
        out = response.getOutputStream();
        out.write(outputStream.toByteArray());
        return null;
    }
}
