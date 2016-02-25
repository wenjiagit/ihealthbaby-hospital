package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.*;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.OrderQueryForm;
import cn.ihealthbaby.hospital.model.OrderDetailModel;
import cn.ihealthbaby.hospital.model.OrderModel;
import cn.ihealthbaby.hospital.services.OrderService;
import com.isnowfox.core.PageResult;
import com.isnowfox.spring.annotation.AccountParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  qiang on 2015/8/25.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param form
     * @param account
     * @return
     */
    @RequestMapping(value = "/orderList",method = RequestMethod.GET)
    @Permission({"orderManage.orderList","orderManage.orderListHospital"})
    public ModelAndView orderList(@Valid OrderQueryForm form,@AccountParam UserAccount account){
        PageResult<OrderModel> page=null;
        if(account.checkPermission("orderManage.orderList")){
            page = orderService.getOrderList(form);
        }else if(account.checkPermission("orderManage.orderListHospital")){
            page = orderService.getOrderListHospital(form,account.getSysUserDO().getHospitalId());
        }
        ModelAndView mv = new ModelAndView("/order/orderList");
        mv.addObject("page",page);
        mv.addObject("form",form);
        return mv;
    }
    @RequestMapping(value = "/{id}/orderDetail",method = RequestMethod.GET)
    @Permission("orderManage.orderDetail")
    public ModelAndView orderDetail(@PathVariable long id,HttpServletRequest request){
        OrderDetailModel model=orderService.getOrderDetail(id);
        ModelAndView mv = new ModelAndView("/order/orderDetail");
        mv.addObject("model",model);
        return mv;
    }
    @RequestMapping(value = "orderPay",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("orderManage.orderPay")
    @ResponseBody
    public Result orderpay(CashPayForm cashPayForm){
        return orderService.orderPay(cashPayForm);
    }
    @RequestMapping(value ="orderCancel",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("orderManage.orderCancel")
    @ResponseBody
    public Result orderCancel(@RequestParam long orderId){
        return orderService.orderCancel(orderId);
    }
    @RequestMapping(value = "confirmDelivery",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("orderManage.confirmDelivery")
    @ResponseBody
    public Result confirmDelivery(@Valid ConfirmDeliveryForm form){
        return orderService.confirmDelivery(form);
    }

    /**
     * app内订单绑定sn
     * @param id
     * @param serialnum
     * @return
     */
    @RequestMapping(value = "addSN",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("orderManage.orderDetail")
    @ResponseBody
    public Result addSN(@RequestParam long id,@RequestParam String serialnum){
        return orderService.addSN(id, serialnum);
    }
    @RequestMapping(value = "singleOrder",method = RequestMethod.GET)
    @Permission("orderManage.singleOrder")
    public ModelAndView singleOrder(@RequestParam String mobile,@AccountParam UserAccount account){
        ModelAndView mv = new ModelAndView("/order/singleOrder");
        if(StringUtils.isBlank(mobile)){
            mv.addObject("init","1");
            return mv;
        }
        if(orderService.isUserHasService(mobile)==null){
            mv.addObject("model",null);
        }else{
            mv.addObject("model",orderService.addSingleOrder(mobile,account));
        }
        return mv;
    }
    @RequestMapping(value = "addNewAddress",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("orderManage.singleOrder")
    @ResponseBody
    public Result addNewAddres(@RequestParam long userId,@Valid AddressForm form){
        return orderService.addNewAddress(userId,form);
    }
    @RequestMapping(value = "addNewAddress",method = RequestMethod.GET)
    @Permission("orderManage.singleOrder")
    public ModelAndView addNewAddres(@RequestParam long userId){
        ModelAndView mv = new ModelAndView("/order/newAddress");
        mv.addObject("userId",userId);
        return mv;
    }
    @RequestMapping(value = "singleOrderDeal",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("orderManage.singleOrder")
    @ResponseBody
    public Result singleOrderDeal(@Valid SingleOrderForm form){
        Result<Long> result=orderService.createSingleOrder(form);
        return result;
    }
    @RequestMapping(value = "orderQr",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @Permission("orderManage.orderPay")
    @ResponseBody
    public Result orderQr(long orderId,HttpServletRequest request){
        WXPayForm form =new WXPayForm();
        form.setOrderId(orderId);
        form.setSpbillCreateIp(request.getRemoteAddr());
        List<String> list =new ArrayList<>();
        list.add(orderService.getWxQr(form).getData());
        list.add(orderService.getAlipayQr(orderId).getData());
      return  Result.createSuccess(list);
    }
}
