package cn.ihealthbaby.hospital.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.form.DoctorForm;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.DoctorQueryForm;
import cn.ihealthbaby.hospital.model.DoctorModel;
import cn.ihealthbaby.hospital.services.DoctorService;
import cn.ihealthbaby.hospital.services.HospitalService;

import com.isnowfox.core.PageResult;
import com.isnowfox.spring.I18nResult;
import com.isnowfox.spring.Result;
import com.isnowfox.spring.annotation.Account;
import com.isnowfox.spring.annotation.AccountParam;

/**
 * 人员管理的医生管理模块
 *
 */
@Controller
@RequestMapping("/staffManage")
public class DoctorController {


	@Autowired
	private DoctorService doctorService;

	@Autowired
	private HospitalService hospitalService;

	/**
	 * @param doctorQueryForm
	 *            查询表单数据
	 * @param account
	 *            当前用户
	 * @return 医生列表
	 * 
	 */
	@RequestMapping(value = "/doctors", method = RequestMethod.GET)
	@Permission({"doctor", "doctorHospital",
			"doctorDepartment"})
	public ModelAndView getDoctors(DoctorQueryForm doctorQueryForm,
			@AccountParam UserAccount account) {

		ModelAndView mv = new ModelAndView("/doctor/doctorList");
		PageResult<DoctorModel> result = null;
		if (account.checkPermission("doctor")) {
			result = doctorService.query(doctorQueryForm);
			mv.addObject("permission", "All");
		} else if (account.checkPermission("doctorHospital")) {
			result = doctorService.queryWithHospital(account.getSysUserDO()
					.getHospitalId(),doctorQueryForm);
			mv.addObject("permission", "Hospital");
		} else if (account.checkPermission("doctorDepartment")) {
			result = doctorService.queryWithDepartment(account.getSysUserDO()
					.getHospitalId(), account.getSysUserDO().getDepartmentId(),
					doctorQueryForm);
			mv.addObject("permission", "Department");
		}
        mv.addObject("form",doctorQueryForm);
		mv.addObject("page", result);
		return mv;
	}

	@ResponseBody
	@Permission({"doctor.add", "doctorHospital.add",
			"doctorDepartment.add"})
	@RequestMapping(value = "/addDoctor", method = RequestMethod.GET)
	public ModelAndView addDoctor(@RequestParam String permission,
			@AccountParam UserAccount account) {
		ModelAndView mv = new ModelAndView("/doctor/addDoctor");
		if (permission.equals("All")) {
			List<HospitalDO> list = hospitalService.getAllHospital();
			mv.addObject("hospitals", list);
			mv.addObject("permission", "All");
		} else if (permission.equals("Hospital")) {
			List<HospitalDO> list = hospitalService.getHospital(account);
			mv.addObject("hospitals", list);
			mv.addObject("permission", "Hospital");
		} else {
			List<HospitalDO> list = hospitalService.getHospital(account);
			DepartmentDO departmentDO = hospitalService.getDepartmentDO(account
					.getSysUserDO().getDepartmentId());
			mv.addObject("hospitals", list);
			mv.addObject("departmentDO", departmentDO);
			mv.addObject("permission", "Department");
		}

		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/departmentList", method = RequestMethod.GET)
	@Account(false)
	public Result departmentList(@RequestParam long hosid) {
		return Result
				.createSuccess(hospitalService.getDepartmentByHosid(hosid));
	}
	@ResponseBody
	@Permission({"doctor.add", "doctorHospital.add",
			"doctorDepartment.add"})
	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result addDoctor(@Valid DoctorForm doctorForm,
			@AccountParam UserAccount account) {
		if (doctorService.mobileExist(doctorForm.getMobile())) {
			return I18nResult.of("mobile", "mobile.exsit", "mobile");
		}
		if (doctorService.usernameExist(doctorForm.getUsername())) {
			return I18nResult.of("username", "account.userNameExsit",
					"username");
		}
		cn.ihealthbaby.hospital.admin.client.Result result = doctorService
				.create(doctorForm);
		Result result1 = new Result();
		BeanUtils.copyProperties(result, result1);
		result1.setMsgMap(result.getMsgMap());
		return result1;
	}

	@ResponseBody
	@Permission({"doctor.update","doctorHospital.update","doctorDepartment.update"})
	@RequestMapping(value = "/updateDoctor/{id}", method = RequestMethod.GET)
	public ModelAndView updateDoctor(@PathVariable long id,
			@AccountParam UserAccount account) {
		ModelAndView mv = new ModelAndView("/doctor/updateDoctor");
		List<HospitalDO> list =null;

		if(account.checkPermission("doctor.update")){
			list=hospitalService.getAllHospital();
		}else{
			list = hospitalService.getHospital(account);
		}
		mv.addObject("hospitals",list);
		DoctorForm form = doctorService.get(id);
		mv.addObject("form", form);
		return mv;
	}

	@ResponseBody
	@Permission({"doctor.update","doctorHospital.update","doctorDepartment.update"})
	@RequestMapping(value = "/updateDoctor/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Void> updateDoctor(@PathVariable long id,
			DoctorForm doctorForm, @AccountParam UserAccount account) {
		cn.ihealthbaby.hospital.admin.client.Result result = doctorService
				.update(id, doctorForm);
		Result result1 = new Result();
		BeanUtils.copyProperties(result, result1);
		return result1;
	}

	@ResponseBody
	@Permission({"doctor.delete",
			"doctorHospital.delete",
			"doctorDepartment.delete"})
	@RequestMapping(value = "/deleteDoctor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Void> deleteDoctor(@PathVariable long id,
			@AccountParam UserAccount account) {
		cn.ihealthbaby.hospital.admin.client.Result result = doctorService
				.delete(id);
		Result result1 = new Result();
		BeanUtils.copyProperties(result, result1);
		return result1;
	}
	@ResponseBody
	@Permission({"doctor.delete","doctorHospital.delete","doctorDepartment.delete","customer.delete","customerHospital.delete","customerDepartment.delete"})
	@RequestMapping(value = "/deleteDoctors", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result<Void> deleteDoctors(@RequestBody Map<String, Long[]> params,
			@AccountParam UserAccount account) {

		cn.ihealthbaby.hospital.admin.client.Result result = doctorService
				.delete(Arrays.asList(params.get("ids")));
		Result result1 = new Result();
		BeanUtils.copyProperties(result, result1);
		return result1;
	}
	@RequestMapping(value = "/doctorDetail", method = RequestMethod.GET)
	@Permission({"doctor.doctorDetail","doctorHospital.doctorDetail","doctorDepartment.doctorDetail"})
	public ModelAndView doctorDetail(@RequestParam long doctorId) {
		ModelAndView mv = new ModelAndView("/doctor/doctorDetail");
		mv.addObject("sysUserDO", doctorService.get(doctorId));
		mv.addObject("advice", doctorService.getDoctorReply(doctorId));
		mv.addObject("dep", doctorService.getDoctorDepartment(doctorId));
		mv.addObject("map", doctorService.getReplyCount(doctorId));
		return mv;
	}
	@RequestMapping(value = "/docPassword", method = RequestMethod.GET)
	@Permission({"doctor.doctorPwdReset","doctorHospital.doctorPwdReset","doctorDepartment.doctorPwdReset"})
	public ModelAndView passwordModify(@RequestParam long id){
      ModelAndView mv = new ModelAndView("/doctor/doctorPwdModify");
		mv.addObject("id",id);
		return mv;
	}
	@Permission({"doctor.doctorPwdReset","doctorHospital.doctorPwdReset","doctorDepartment.doctorPwdReset"})
	@ResponseBody
	@RequestMapping(value = "/docPassword", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public cn.ihealthbaby.hospital.admin.client.Result passwordModify(@RequestParam long id,@RequestParam String password){
		return doctorService.passwordModify(id,password);
	}
}
