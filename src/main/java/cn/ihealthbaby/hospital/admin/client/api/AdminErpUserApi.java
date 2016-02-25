package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.form.DoctorForm;
import cn.ihealthbaby.hospital.admin.client.form.EmployeeForm;
import cn.ihealthbaby.hospital.admin.client.form.EmployeeUpdateForm;
import cn.ihealthbaby.hospital.admin.client.form.SyncDoctorForm;
import java.util.List;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * erp用户相关的api,包括添加,修改,条件查询
 * @author  qiang
 */
public class AdminErpUserApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminErpUserApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 添加erp用户
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>erpUser</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>EmployeeFormcreate</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @param employeeForm  医生信息表单 
	 * @see java.lang.Long
	 * @see EmployeeForm

	 */
	public java.lang.Long createData(EmployeeForm employeeForm) {
		Result<java.lang.Long> result = create(employeeForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 添加erp用户
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>erpUser</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>EmployeeFormcreate</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @param employeeForm  医生信息表单 
	 * @see java.lang.Long
	 * @see EmployeeForm

	 */
	public Result<java.lang.Long> create(EmployeeForm employeeForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("erpUser", uriVariables);

		return httpClientAdapter.request("POST", url, employeeForm.encode("", new ArrayList<Entry<String, Object>>()),
				createType, false);
	}

	/**
	 * 添加erp用户
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>erpUser</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>EmployeeFormcreate</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @param employeeForm  医生信息表单 
	 * @see java.lang.Long
	 * @see EmployeeForm

	 */
	public Future<?> create(EmployeeForm employeeForm, Callback<java.lang.Long> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("erpUser", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				employeeForm.encode("", new ArrayList<Entry<String, Object>>()), createType, false, callable);
	}

	/**
	 * 修改erp用户
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>erpUser/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>EmployeeUpdateFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see EmployeeUpdateForm

	 */
	public Void updateData(long id, EmployeeUpdateForm employeeUpdateForm) {
		Result<Void> result = update(id, employeeUpdateForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 修改erp用户
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>erpUser/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>EmployeeUpdateFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see EmployeeUpdateForm

	 */
	public Result<Void> update(long id, EmployeeUpdateForm employeeUpdateForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("erpUser/{id}", uriVariables);

		return httpClientAdapter.request("PUT", url,
				employeeUpdateForm.encode("", new ArrayList<Entry<String, Object>>()), updateType, false);
	}

	/**
	 * 修改erp用户
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>erpUser/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>EmployeeUpdateFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see EmployeeUpdateForm

	 */
	public Future<?> update(long id, EmployeeUpdateForm employeeUpdateForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("erpUser/{id}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url,
				employeeUpdateForm.encode("", new ArrayList<Entry<String, Object>>()), updateType, false, callable);
	}

	private static final ApiType createType = type(Result.class, type(java.lang.Long.class));
	private static final ApiType updateType = type(Result.class, type(Void.class));
}