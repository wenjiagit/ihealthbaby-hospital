package cn.ihealthbaby.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ihealthbaby.data.db.entity.AreasDO;
import cn.ihealthbaby.data.db.entity.CitiesDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.DepartmentForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalAddForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalQueryForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalStatusForm;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.model.HospitalInfo;
import cn.ihealthbaby.hospital.model.HospitalModel;
import cn.ihealthbaby.hospital.services.DoctorService;
import cn.ihealthbaby.hospital.services.HospitalService;

import com.isnowfox.core.PageResult;
import com.isnowfox.spring.I18nResult;
import com.isnowfox.spring.annotation.AccountParam;

@Controller
@RequestMapping("/sysManage")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private DoctorService doctorService;

	@RequestMapping("/hospitalInfo")
	@Permission("hosManage.hosptialInfo")
	public ModelAndView hospitalInfo(@AccountParam UserAccount account) {
		HospitalInfo hospital = hospitalService.query(account);
		ModelAndView mv = new ModelAndView("/hospital/hospitalInfo");
		mv.addObject("hospital", hospital);
		return mv;
	}
	@RequestMapping("/hospitalInfoList")
	@Permission("hosManage.hosptialInfoList")
	public ModelAndView hospitalInfoList(@Valid HospitalQueryForm form) {
		PageResult<HospitalInfo> result = hospitalService.queryForList(form);
		ModelAndView mv = new ModelAndView("/hospital/hospitalInfoList");
		mv.addObject("page", result);
		mv.addObject("province", hospitalService.getAllProvince());
		mv.addObject("form",form);
		return mv;
	}
	@ResponseBody
	@Permission("hosManage.hosptialInfoList.update")
	@RequestMapping(value = "/{id}/updatehospital", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result updateHospitalInfo(@Valid HospitalForm form,
			@PathVariable long id) {
		return hospitalService.updateHospitalInfo(form, id);
	}
	@Permission("hosManage.hosptialInfoList.update")
	@RequestMapping(value = "/{id}/updatehospital", method = RequestMethod.GET)
	public ModelAndView updateHospital(@PathVariable long id) {
		HospitalModel info = hospitalService.queryById(id);
		ModelAndView mv = new ModelAndView("/hospital/hospitalInfoUpdate");
		mv.addObject("hospital", info);
		mv.addObject("province", hospitalService.getAllProvince());
		return mv;

	}
	@Permission("hosManage.hosptialInfoList.update")
	@RequestMapping(value = "/{id}/updateHospitalStatus", method = RequestMethod.GET)
	public ModelAndView updateHospitalStatus(@PathVariable long id) {
		HospitalDO hospitalDO = hospitalService.get(id);
		ModelAndView mv = new ModelAndView("/hospital/updateHospitalStatus");
		mv.addObject("hospital", hospitalDO);
		return mv;
	}
	@ResponseBody
	@Permission("hosManage.hosptialInfoList.update")
	@RequestMapping(value = "/updateHospitalStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result updateHospitalStatus(@Valid HospitalStatusForm form) {
		return hospitalService.updateHospitalStatus(form);
	}
	@ResponseBody
	@Permission("hosManage.hosptialInfoList.add")
	@RequestMapping(value = "/addhospital", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public com.isnowfox.spring.Result addHospitalInfo(
			@Valid HospitalAddForm form) {
		if (hospitalService.isHospitalExsit(form.getName())) {
			return I18nResult.of("name", "hospital.exsit", "name");
		}
		if (doctorService.usernameExist(form.getUsername())) {
			return I18nResult.of("username", "account.userNameExsit",
					"username");
		}
		Result result = hospitalService.addHospitalInfo(form);
		com.isnowfox.spring.Result result1 = com.isnowfox.spring.Result
				.createSuccess();
		BeanUtils.copyProperties(result, result1);
		return result1;
	}
	@RequestMapping(value = "/addhospital", method = RequestMethod.GET)
	@Permission("hosManage.hosptialInfoList.add")
	public ModelAndView addHospitalInfo() {
		ModelAndView mv = new ModelAndView("/hospital/hospitalInfoAdd");
		mv.addObject("province", hospitalService.getAllProvince());
		return mv;
	}

	/**
	 * 根据省份获取城市
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/getCityByProvinceId")
	@ResponseBody
	@Permission("hosManage.hosptialInfoList")
	public Result getCityByProvinceId(@PathVariable("id") long id) {
		List<CitiesDO> cityList = hospitalService.getCityByProvinceId(id);
		if (cityList != null) {
			return new Result(0, "success", cityList);
		} else {
			return new Result(1, "fail", null);
		}
	}

	/**
	 * 根据城市获取区域
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/getAreaByCityId")
	@ResponseBody
	@Permission("hosManage.hosptialInfoList")
	public Result getAreaByCityId(@PathVariable("id") long id) {
		List<AreasDO> areaList = hospitalService.getAreaByCityId(id);
		if (areaList != null) {
			return new Result(0, "success", areaList);
		} else {
			return new Result(1, "fail", null);
		}
	}
	@RequestMapping(value = "/{id}/getHospitalDepartment", method = RequestMethod.GET)
	@Permission("hosManage.hosptialInfoList.update")
	public ModelAndView getHospitalDepartment(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("/hospital/updateDepartment");
		mv.addObject("departmentlist", hospitalService.getDepartmentByHosid(id));
		mv.addObject("hosId", id);
		return mv;
	}
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Permission("hosManage.hosptialInfoList.update")
	public Result addDepartment(DepartmentForm form) {
		return hospitalService.addDepartment(form);
	}
	@RequestMapping(value = "/updateDepartment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Permission("hosManage.hosptialInfoList.update")
	public Result updateDepartment(DepartmentForm form) {
		return hospitalService.updateDepartment(form);
	}

}
