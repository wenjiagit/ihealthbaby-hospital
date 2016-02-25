package cn.ihealthbaby.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import cn.ihealthbaby.hospital.admin.client.form.ServiceForm;
import com.isnowfox.spring.annotation.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.HospitalFetalheartDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.data.db.entity.UserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.ReadDataQueryForm;
import cn.ihealthbaby.hospital.form.ServiceDealForm;
import cn.ihealthbaby.hospital.form.ServiceQueryForm;
import cn.ihealthbaby.hospital.model.BalanceModel;
import cn.ihealthbaby.hospital.model.HospitalPackageModel;
import cn.ihealthbaby.hospital.model.ReadDataModel;
import cn.ihealthbaby.hospital.model.ServiceModel;
import cn.ihealthbaby.hospital.services.AdviceService;
import cn.ihealthbaby.hospital.services.ServiceService;
import cn.ihealthbaby.hospital.services.SettingService;

import com.isnowfox.core.PageResult;
import com.isnowfox.spring.I18nResult;
import com.isnowfox.spring.Result;
import com.isnowfox.spring.annotation.AccountParam;

/**
 * Created by qiang on 2015/8/5.
 */
@Controller
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	private ServiceService serviceService;

	@Autowired
	private AdviceService adviceService;
	@Autowired
	private SettingService settingService;

	/**
	 * 开通服务列表
	 * 
	 * @param form
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/ServiceList")
	@Permission({"outsideService.serviceList","outsideService.serviceListHospital"})
	public ModelAndView queryServiceList(ServiceQueryForm form,
			@AccountParam UserAccount account) {
		PageResult<ServiceModel> page =null;
		if(account.checkPermission("outsideService.serviceList")){
			page=serviceService.queryServiceList(form,account);
		}else{
			page=serviceService.queryServiceListHospital(form,account);
		}
		ModelAndView mv = new ModelAndView("/service/serviceInfoList");
		mv.addObject("page", page);
		mv.addObject("form",form);
		return mv;
	}

	@RequestMapping(value = "/initServiceDeal")
	@Permission("outsideService.serviceDeal")
	public ModelAndView initServiceDeal(@AccountParam UserAccount account) {
		ModelAndView mv = new ModelAndView("/service/serviceDeal");
/*		HospitalPackageModel model = settingService.getHospitalPackage(account
				.getSysUserDO().getHospitalId());*/
		HospitalPackageModel model = serviceService.findProduct(account.getSysUserDO().getHospitalId());
		List<HospitalFetalheartDO> list = serviceService.SNList(account.getSysUserDO().getHospitalId());
		mv.addObject("model", model);
		mv.addObject("snList", list);
		return mv;
	}

	/**
	 * 通过手机号码拉用户信息
	 *
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/autoComplete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Account(false)
	@ResponseBody
	public Result autoCompleteUserInfo(@RequestParam String mobile) {
		UserDO userDO = serviceService.autoCompleteUserInfo(mobile);
		return Result.createSuccess(userDO);
	}

	/**
	 * 通过手机号码拉用户信息
	 *
	 * @param caseNumber
	 * @return
	 */
	@RequestMapping(value = "/autoCompleteBycaseNum", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Account(false)
	@ResponseBody
	public Result autoCompleteBycaseNum(@RequestParam String caseNumber) {
		UserDO userDO = serviceService.autoCompleteBycaseNum(caseNumber);
		return Result.createSuccess(userDO);
	}

	/**
	 * 所属医院
	 *
	 * @return
	 */
	@RequestMapping(value = "/belongHospital", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Permission("outsideService.serviceDeal")
	@ResponseBody
	public Result belongHospital(@AccountParam UserAccount account) {
		List<HospitalDO> list = serviceService.belongHospital(account);
		return Result.createSuccess(list);
	}
	@RequestMapping(value = "/belongDepartment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Permission("outsideService.serviceDeal")
	@ResponseBody
	public Result belongDepartment(@AccountParam UserAccount account) {
		List<DepartmentDO> list = serviceService.belongDepartment(account);
		return Result.createSuccess(list);
	}
	/**
	 * 负责医生
	 *
	 * @return
	 */
	@RequestMapping(value = "/doctorList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Permission("outsideService.serviceDeal")
	@ResponseBody
	public Result doctorList(@RequestParam long departmentid,
			@AccountParam UserAccount account) {
		List<SysUserDO> list = serviceService.doctorList(departmentid, account);
		return Result.createSuccess(list);
	}

	@RequestMapping(value = "/snList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Permission("outsideService.serviceDeal")
	@ResponseBody
	public Result SNList(@RequestParam long id) {
		List<HospitalFetalheartDO> list = serviceService.SNList(id);
		return Result.createSuccess(list);
	}
	@RequestMapping(value = "/costType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Permission("outsideService.serviceDeal")
	@ResponseBody
	public Result costType(@RequestParam long id) {
		return Result.createSuccess(serviceService.productDOList(id));
	}
	@RequestMapping(value = "/dealService", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Permission("outsideService.serviceDeal")
	@ResponseBody
	public Result dealService(@Valid ServiceForm form) throws Exception {
		if (!serviceService.checkSerialnumExsit(form.getSerialnum(),
				form.getHospitalId())) {
			return I18nResult.of("serialnum", "service.serialnumExsit","serialnum");
		}
		if (form.getPforegift() == 0) {
			Result result = Result.createSuccess();
			result.setMsg("套餐配置错误：设备押金不能为空");
			return result;
		}
		cn.ihealthbaby.hospital.admin.client.Result result = serviceService
				.dealService(form);
		Result result1 = new Result(result.getStatus(), result.getMsg(),
				result.getData());
		result1.setMsgMap(result.getMsgMap());
		return result1;
	}

	/**
	 * 判读列表
	 */
	@Permission({"readData.readDataList","readData.readDataListHospital","readData.readDataListDepartment"})
	@RequestMapping(value = "/readDataList", method = RequestMethod.GET)
	public ModelAndView readDataList(ReadDataQueryForm form,
			@AccountParam UserAccount account) {
		PageResult<ReadDataModel> page = null;
		if (account.checkPermission("readData.readDataList")){
			page = serviceService.readDataList(form);
		}else if(account.checkPermission("readData.readDataListHospital")){
			page = serviceService.readDataListHospital(form,account);
		}else if(account.checkPermission("readData.readDataListDepartment")){
            page = serviceService.readDataListDepartment(form,account);
		}
		ModelAndView mv = new ModelAndView("/service/readDataList");
		mv.addObject("form",form);
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * 开通服务结算
	 * 
	 * @param id
	 * @return
	 */
	@Permission({"outsideService.serviceList.balance","outsideService.serviceListHospital.balance"})
	@RequestMapping(value = "/balanceDetail", method = RequestMethod.GET)
	public ModelAndView balanceDetail(@RequestParam long id) throws Exception{
		ModelAndView mv = new ModelAndView("/service/balanceDetail");
		BalanceModel model = serviceService.balanceDetail(id);
		mv.addObject("balance", model);
		mv.addObject("advices", adviceService.getAdvices(id));
		return mv;
	}

	/**
	 * 结算，改变服务状态
	 * 
	 * @param serviceId
	 * @return
	 */
	@RequestMapping(value = "/balanceService", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Permission({"outsideService.serviceList.balance","outsideService.serviceListHospital.balance"})
	@ResponseBody
	public cn.ihealthbaby.hospital.admin.client.Result balance(
			@RequestParam long serviceId) {
		return serviceService.balance(serviceId);
	}
}
