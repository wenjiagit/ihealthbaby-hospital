package cn.ihealthbaby.hospital.admin.client.api;

import java.util.List;
import java.util.Map;
import cn.ihealthbaby.hospital.admin.client.collecton.ApiList;
import cn.ihealthbaby.hospital.admin.client.form.DepartmentForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalAddForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalForm;
import cn.ihealthbaby.hospital.admin.client.form.HospitalStatusForm;
import cn.ihealthbaby.hospital.admin.client.model.Department;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * 医院相关订的api,包括增加,删除,更新
 * @author  gwc
 */
public class AdminHospitalApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminHospitalApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 新建医院
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>HospitalAddFormcreate</li>
	 * <li><b>Model:</b> Map&lt;java.lang.String,java.lang.Long&gt;</li>
	 * </ul>
	 * </div>
	 * @param hospitalForm 添加医院所需信息表单 
	 * @see Map
	 * @see HospitalAddForm

	 */
	public Map<java.lang.String, java.lang.Long> createData(HospitalAddForm hospitalForm) {
		Result<Map<java.lang.String, java.lang.Long>> result = create(hospitalForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 新建医院
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>HospitalAddFormcreate</li>
	 * <li><b>Model:</b> Map&lt;java.lang.String,java.lang.Long&gt;</li>
	 * </ul>
	 * </div>
	 * @param hospitalForm 添加医院所需信息表单 
	 * @see Map
	 * @see HospitalAddForm

	 */
	public Result<Map<java.lang.String, java.lang.Long>> create(HospitalAddForm hospitalForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("hospital/", uriVariables);

		return httpClientAdapter.request("POST", url, hospitalForm.encode("", new ArrayList<Entry<String, Object>>()),
				createType, false);
	}

	/**
	 * 新建医院
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>HospitalAddFormcreate</li>
	 * <li><b>Model:</b> Map&lt;java.lang.String,java.lang.Long&gt;</li>
	 * </ul>
	 * </div>
	 * @param hospitalForm 添加医院所需信息表单 
	 * @see Map
	 * @see HospitalAddForm

	 */
	public Future<?> create(HospitalAddForm hospitalForm, Callback<Map<java.lang.String, java.lang.Long>> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("hospital/", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				hospitalForm.encode("", new ArrayList<Entry<String, Object>>()), createType, false, callable);
	}

	/**
	 * 更改医院的信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>HospitalFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param hospitalForm 添加医院所需信息表单 
	 * @see HospitalForm

	 */
	public Void updateData(long id, HospitalForm hospitalForm) {
		Result<Void> result = update(id, hospitalForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 更改医院的信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>HospitalFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param hospitalForm 添加医院所需信息表单 
	 * @see HospitalForm

	 */
	public Result<Void> update(long id, HospitalForm hospitalForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("hospital/{id}", uriVariables);

		return httpClientAdapter.request("POST", url, hospitalForm.encode("", new ArrayList<Entry<String, Object>>()),
				updateType, false);
	}

	/**
	 * 更改医院的信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>HospitalFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param hospitalForm 添加医院所需信息表单 
	 * @see HospitalForm

	 */
	public Future<?> update(long id, HospitalForm hospitalForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("hospital/{id}", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				hospitalForm.encode("", new ArrayList<Entry<String, Object>>()), updateType, false, callable);
	}

	/**
	 * 禁用或者启用医院
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/status/{id}/{status}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> long id <span>医院id </span></li>
	 * <li><b>PathVariable:</b> int status <span>0 禁用 , 1启用(目前的默认值) </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id 医院id 
	 * @param status 0 禁用 , 1启用(目前的默认值) 

	 */
	public Void updateHospitalStatusData(long id, int status) {
		Result<Void> result = updateHospitalStatus(id, status);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 禁用或者启用医院
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/status/{id}/{status}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> long id <span>医院id </span></li>
	 * <li><b>PathVariable:</b> int status <span>0 禁用 , 1启用(目前的默认值) </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id 医院id 
	 * @param status 0 禁用 , 1启用(目前的默认值) 

	 */
	public Result<Void> updateHospitalStatus(long id, int status) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		uriVariables.put("status", status);
		String url = expandUriComponent("hospital/status/{id}/{status}", uriVariables);

		return httpClientAdapter.request("GET", url, null, updateHospitalStatusType, false);
	}

	/**
	 * 禁用或者启用医院
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/status/{id}/{status}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> long id <span>医院id </span></li>
	 * <li><b>PathVariable:</b> int status <span>0 禁用 , 1启用(目前的默认值) </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id 医院id 
	 * @param status 0 禁用 , 1启用(目前的默认值) 

	 */
	public Future<?> updateHospitalStatus(long id, int status, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		uriVariables.put("status", status);
		String url = expandUriComponent("hospital/status/{id}/{status}", uriVariables);

		return httpClientAdapter.requestAsync("GET", url, null, updateHospitalStatusType, false, callable);
	}

	/**
	 * 修改医院的业务状态
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/status</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>HospitalStatusFormupdateHospitalStatus</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param hospitalStatusForm 医院状态表单 
	 * @see HospitalStatusForm

	 */
	public Void updateHospitalStatusData(HospitalStatusForm hospitalStatusForm) {
		Result<Void> result = updateHospitalStatus(hospitalStatusForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 修改医院的业务状态
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/status</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>HospitalStatusFormupdateHospitalStatus</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param hospitalStatusForm 医院状态表单 
	 * @see HospitalStatusForm

	 */
	public Result<Void> updateHospitalStatus(HospitalStatusForm hospitalStatusForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("hospital/status", uriVariables);

		return httpClientAdapter
				.request("PUT", url, hospitalStatusForm.encode("", new ArrayList<Entry<String, Object>>()),
						updateHospitalStatus0Type, false);
	}

	/**
	 * 修改医院的业务状态
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/status</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>HospitalStatusFormupdateHospitalStatus</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param hospitalStatusForm 医院状态表单 
	 * @see HospitalStatusForm

	 */
	public Future<?> updateHospitalStatus(HospitalStatusForm hospitalStatusForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("hospital/status", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url,
				hospitalStatusForm.encode("", new ArrayList<Entry<String, Object>>()), updateHospitalStatus0Type,
				false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>department/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Void deleteDepartmentData(long id) {
		Result<Void> result = deleteDepartment(id);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>department/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Result<Void> deleteDepartment(long id) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("department/{id}", uriVariables);

		return httpClientAdapter.request("POST", url, null, deleteDepartmentType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>department/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Future<?> deleteDepartment(long id, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("department/{id}", uriVariables);

		return httpClientAdapter.requestAsync("POST", url, null, deleteDepartmentType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>addDepartment</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DepartmentFormaddDepartment</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see DepartmentForm

	 */
	public Void addDepartmentData(DepartmentForm form) {
		Result<Void> result = addDepartment(form);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>addDepartment</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DepartmentFormaddDepartment</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see DepartmentForm

	 */
	public Result<Void> addDepartment(DepartmentForm form) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("addDepartment", uriVariables);

		return httpClientAdapter.request("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				addDepartmentType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>addDepartment</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DepartmentFormaddDepartment</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see DepartmentForm

	 */
	public Future<?> addDepartment(DepartmentForm form, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("addDepartment", uriVariables);

		return httpClientAdapter.requestAsync("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				addDepartmentType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>updateDepartment</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DepartmentFormupdateDepartment</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see DepartmentForm

	 */
	public Void updateDepartmentData(DepartmentForm form) {
		Result<Void> result = updateDepartment(form);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>updateDepartment</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DepartmentFormupdateDepartment</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see DepartmentForm

	 */
	public Result<Void> updateDepartment(DepartmentForm form) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("updateDepartment", uriVariables);

		return httpClientAdapter.request("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				updateDepartmentType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>updateDepartment</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DepartmentFormupdateDepartment</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see DepartmentForm

	 */
	public Future<?> updateDepartment(DepartmentForm form, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("updateDepartment", uriVariables);

		return httpClientAdapter.requestAsync("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				updateDepartmentType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/{hospitalId}/departments/{departments}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.String&gt; departments</li>
	 * <li><b>Model:</b> ApiList&lt;Department&gt;</li>
	 * </ul>
	 * </div>
	 * @see ApiList

	 */
	public ApiList<Department> syncDepartmentsData(long hospitalId, List<java.lang.String> departments) {
		Result<ApiList<Department>> result = syncDepartments(hospitalId, departments);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/{hospitalId}/departments/{departments}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.String&gt; departments</li>
	 * <li><b>Model:</b> ApiList&lt;Department&gt;</li>
	 * </ul>
	 * </div>
	 * @see ApiList

	 */
	public Result<ApiList<Department>> syncDepartments(long hospitalId, List<java.lang.String> departments) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalId", hospitalId);
		uriVariables.put("departments", departments);
		String url = expandUriComponent("hospital/{hospitalId}/departments/{departments}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, syncDepartmentsType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>hospital/{hospitalId}/departments/{departments}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.String&gt; departments</li>
	 * <li><b>Model:</b> ApiList&lt;Department&gt;</li>
	 * </ul>
	 * </div>
	 * @see ApiList

	 */
	public Future<?> syncDepartments(long hospitalId, List<java.lang.String> departments,
			Callback<ApiList<Department>> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalId", hospitalId);
		uriVariables.put("departments", departments);
		String url = expandUriComponent("hospital/{hospitalId}/departments/{departments}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, syncDepartmentsType, false, callable);
	}

	private static final ApiType createType = type(Result.class,
			type(Map.class, type(java.lang.String.class), type(java.lang.Long.class)));
	private static final ApiType updateType = type(Result.class, type(Void.class));
	private static final ApiType updateHospitalStatusType = type(Result.class, type(Void.class));
	private static final ApiType updateHospitalStatus0Type = type(Result.class, type(Void.class));
	private static final ApiType deleteDepartmentType = type(Result.class, type(Void.class));
	private static final ApiType addDepartmentType = type(Result.class, type(Void.class));
	private static final ApiType updateDepartmentType = type(Result.class, type(Void.class));
	private static final ApiType syncDepartmentsType = type(Result.class, type(ApiList.class, type(Department.class)));
}