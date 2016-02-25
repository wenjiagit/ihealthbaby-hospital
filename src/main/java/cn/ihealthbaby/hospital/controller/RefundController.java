package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.data.db.entity.RefundDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.ConfirmRefundForm;
import cn.ihealthbaby.hospital.admin.client.form.NewApplyForm;
import cn.ihealthbaby.hospital.admin.client.form.RejectForm;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.RefundQueryForm;
import cn.ihealthbaby.hospital.model.BalanceModel;
import cn.ihealthbaby.hospital.services.RefundService;
import cn.ihealthbaby.hospital.services.ServiceService;
import com.isnowfox.spring.annotation.AccountParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author  qiang on 2015/9/4.
 */
@Controller
@RequestMapping("/refund")
public class RefundController {
    @Autowired
    private RefundService refundService;
    @Autowired
    private ServiceService serviceService;
    @RequestMapping(value = "/refundApplyList",method = RequestMethod.GET)
    @Permission("refundManage.refundApplyList")
    public ModelAndView refundApplyList(@Valid RefundQueryForm form){
        ModelAndView mv =new ModelAndView("/refund/refundApplyList");
        mv.addObject("page", refundService.refundApplyList(form));
        mv.addObject("form",form);
        return mv;
    }
    @RequestMapping(value = "/refundHistoryList",method = RequestMethod.GET)
    @Permission("refundManage.refundHistoryList")
    public ModelAndView refundHistoryList(@Valid RefundQueryForm form){
        ModelAndView mv = new ModelAndView("/refund/refundHistoryList");
        mv.addObject("page",refundService.refundHistoryList(form));
        mv.addObject("form",form);
        return mv;
    }
    @Permission({"outsideService.serviceList.refund","outsideService.serviceListHospital.refund"})
    @RequestMapping(value = "newRefundApply",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Result newApply(NewApplyForm form,@AccountParam UserAccount account){
        return refundService.newApply(form,account);
    }
    @RequestMapping(value = "refundDetail",method = RequestMethod.GET)
    @Permission("refundManage.refundApplyList.approval")
    public ModelAndView refundDetail(@RequestParam long serviceId){
        ModelAndView mv = new ModelAndView("/refund/refundDetail");
        BalanceModel model = serviceService.balanceDetail(serviceId);
        RefundDO refundDO = refundService.getRefund(serviceId);
        mv.addObject("balance", model);
        mv.addObject("refund", refundDO);
        return mv;
    }
    @RequestMapping(value = "rejectRefund",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("refundManage.refundApplyList.approval")
    @ResponseBody
    public Result rejectRefund(RejectForm form,@AccountParam UserAccount account){
     return  refundService.rejectRefund(form,account);
    }
    @RequestMapping(value = "rejectDeal",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Permission("refundManage.refundApplyList.approval")
    public Result refundDeal(ConfirmRefundForm form){
        return refundService.refundDeal(form);
    }
}
