package cn.ihealthbaby.hospital.controller;

import javax.validation.Valid;

import cn.ihealthbaby.data.db.dao.readonly.DepartmentReadOnlyDao;
import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.hospital.services.ServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.annotation.Permission;
import cn.ihealthbaby.hospital.form.SysUserForm;

import com.isnowfox.core.dao.QueryParams;
import com.isnowfox.spring.annotation.Account;
import com.isnowfox.spring.annotation.AccountParam;

/**
 *
 */
@Controller
@RequestMapping
public class IndexController {
	private static final Logger log = LoggerFactory
			.getLogger(IndexController.class);
	public static final int CONFIG_MAX_LENGTH = 512;
	@Autowired
	public SysUserReadOnlyDao sysUserReadOnlyDao;
	@Autowired
	public HospitalReadOnlyDao hospitalReadOnlyDao;
	@Autowired
	public DepartmentReadOnlyDao departmentReadOnlyDao;
	@Autowired
	private ServiceService serviceService;
	@RequestMapping(value = "index")
	@Permission("index")
	public ModelAndView index(@AccountParam UserAccount userAccount)
			throws Exception {
		SysUserDO sysUserDO = sysUserReadOnlyDao.findObject(QueryParams
				.create().add(SysUserDO.ThisTableInfo.MOBILE_DB_NAME,
						userAccount.getSysUserDO().getMobile()));
		HospitalDO hospitalDO = hospitalReadOnlyDao.get(userAccount
				.getSysUserDO().getHospitalId());
		DepartmentDO departmentDO = departmentReadOnlyDao.get(userAccount.getSysUserDO().getDepartmentId());
		long count = 0;
		if (userAccount.checkPermission("readData.readDataList")){
			count = serviceService.readDataListCount();
		}else if(userAccount.checkPermission("readData.readDataListHospital")){
			count = serviceService.readDataListHospitalCount(userAccount);
		}else if(userAccount.checkPermission("readData.readDataListDepartment")){
			count = serviceService.readDataListDepartmentCount(userAccount);
		}
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("user", userAccount.getSysUserDO());
		mv.addObject("doctor", sysUserDO);
		mv.addObject("hospital", hospitalDO);
		mv.addObject("department",departmentDO);
		mv.addObject("count",count);
		return mv;
	}

	@RequestMapping(value = "test")
	@Account(false)
	public ModelAndView test(@AccountParam UserAccount userAccount)
			throws Exception {
		Thread.sleep(2000);
		return new ModelAndView("/test");
	}

	@ResponseBody
	@Account(false)
	@RequestMapping(value = "/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Result json(@Valid SysUserForm sysUserform) throws Exception {
		return Result.createSuccess();
	}
	@ResponseBody
	@Permission("index")
	@RequestMapping(value = "/getMessage",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Result getMessageOfReadData(@AccountParam UserAccount userAccount){
		long count = 0;
		if (userAccount.checkPermission("readData.readDataList")){
			count = serviceService.readDataListCount();
		}else if(userAccount.checkPermission("readData.readDataListHospital")){
			count = serviceService.readDataListHospitalCount(userAccount);
		}else if(userAccount.checkPermission("readData.readDataListDepartment")){
			count = serviceService.readDataListDepartmentCount(userAccount);
		}
		return  Result.createSuccess(count);
	}
}
