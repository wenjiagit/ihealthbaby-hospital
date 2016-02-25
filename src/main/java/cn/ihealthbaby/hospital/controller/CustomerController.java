package cn.ihealthbaby.hospital.controller;

import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.form.DoctorForm;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.DoctorQueryForm;
import cn.ihealthbaby.hospital.model.DoctorModel;
import cn.ihealthbaby.hospital.services.CustomerService;
import cn.ihealthbaby.hospital.services.DoctorService;
import cn.ihealthbaby.hospital.services.HospitalService;
import com.isnowfox.core.PageResult;
import com.isnowfox.spring.I18nResult;
import com.isnowfox.spring.Result;
import com.isnowfox.spring.annotation.AccountParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 人员管理的医生管理模块
 *
 */
@Controller
@RequestMapping("/staffManage")
public class CustomerController {



	@Autowired
	private CustomerService customerService;

	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private DoctorService doctorService;
	/**
	 * @param doctorQueryForm
	 *            查询表单数据
	 * @param account
	 *            当前用户
	 * @return 医生列表
	 * 
	 */
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	@Permission({"customer","customerHospital","customerDepartment"})
	public ModelAndView getDoctors(DoctorQueryForm doctorQueryForm,
			@AccountParam UserAccount account) {
		ModelAndView mv = new ModelAndView("/customer/customerList");
		PageResult<DoctorModel> result=null;
		if(account.checkPermission("customer")){
			result= customerService.query(doctorQueryForm);
			mv.addObject("permission","All");
		}else if(account.checkPermission("customerHospital")){
			result= customerService.queryWithHospital(account.getSysUserDO().getHospitalId(),doctorQueryForm);
			mv.addObject("permission","Hospital");
		}else if (account.checkPermission("customerDepartment")){
			result= customerService.queryWithDepartment(account.getSysUserDO().getHospitalId(), account.getSysUserDO().getDepartmentId(), doctorQueryForm);
			mv.addObject("permission","Department");
		}
		mv.addObject("form",doctorQueryForm);
		mv.addObject("page", result);
		return mv;
	}

	@ResponseBody
	@Permission({"customer.add","customerHospital.add","customerDepartment.add"})
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView addDoctor(@AccountParam UserAccount account,@RequestParam String permission) {
		ModelAndView mv = new ModelAndView("/customer/addCustomer");
		if(permission.equals("All")){
			List<HospitalDO> list=hospitalService.getAllHospital();
			mv.addObject("hospitals", list);
			mv.addObject("permission","All");
		}else if(permission.equals("Hospital")){
			List<HospitalDO> list=hospitalService.getHospital(account);
			mv.addObject("hospitals", list);
			mv.addObject("permission","Hospital");
		}else {
			List<HospitalDO> list=hospitalService.getHospital(account);
			DepartmentDO departmentDO =hospitalService.getDepartmentDO(account.getSysUserDO().getDepartmentId());
			mv.addObject("hospitals", list);
			mv.addObject("departmentDO", departmentDO);
			mv.addObject("permission","Department");
		}
		return mv;
	}
	@ResponseBody
	@Permission({"customer.add","customerHospital.add","customerDepartment.add"})
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result addDoctor(@Valid DoctorForm doctorForm,
			@AccountParam UserAccount account) {
		if (customerService.mobileExist(doctorForm.getMobile())){
			return I18nResult.of("mobile","mobile.exsit","mobile");
		}
		if (customerService.usernameExist(doctorForm.getUsername())){
			return I18nResult.of("username","account.userNameExsit","username");
		}
		cn.ihealthbaby.hospital.admin.client.Result result = customerService.create(doctorForm);
		Result result1 =new Result();
		BeanUtils.copyProperties(result, result1);
		result1.setMsgMap(result.getMsgMap());
		return result1;
	}

	@ResponseBody
	@Permission({"customer.update","customerHospital.update","customerDepartment.update"})
	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@PathVariable long id,@AccountParam UserAccount account) {
		ModelAndView mv = new ModelAndView("/customer/updateCustomer");

		List<HospitalDO> list =null;

		if(account.checkPermission("customer.update")){
			list=hospitalService.getAllHospital();
		}else{
			list = hospitalService.getHospital(account);
		}
		mv.addObject("hospitals",list);
		DoctorForm form = customerService.get(id);
		mv.addObject("form", form);
		return mv;
	}

	@ResponseBody
	@Permission({"customer.update","customerHospital.update","customerDepartment.update"})
	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Void> updateCustomer(@PathVariable long id,
			DoctorForm doctorForm, @AccountParam UserAccount account) {
		cn.ihealthbaby.hospital.admin.client.Result result = customerService.update(id, doctorForm);
		Result result1 =new Result();
		BeanUtils.copyProperties(result, result1);
		return result1;
	}
	@RequestMapping(value = "/cusPassword", method = RequestMethod.GET)
	@Permission({"customer.customerPwdReset","customerHospital.customerPwdReset","customerDepartment.customerPwdReset"})
	public ModelAndView passwordModify(@RequestParam long id){
		ModelAndView mv = new ModelAndView("/customer/customerPwdModify");
		mv.addObject("id", id);
		return mv;
	}
	@Permission({"customer.customerPwdReset","customerHospital.customerPwdReset","customerDepartment.customerPwdReset"})
	@ResponseBody
	@RequestMapping(value = "/cusPassword", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public cn.ihealthbaby.hospital.admin.client.Result passwordModify(@RequestParam long id,@RequestParam String password){
		return doctorService.passwordModify(id,password);
	}
}
