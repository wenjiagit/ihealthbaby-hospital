package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.form.DoctorForm;
import cn.ihealthbaby.hospital.admin.client.form.SyncDoctorForm;
import java.util.List;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * 医生相关的api,包括添加,修改,删除,条件查询
 * @author  gwc
 */
public class AdminDoctorApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminDoctorApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 添加医生
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctor</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DoctorFormcreate</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @param doctorForm  医生信息表单 
	 * @see java.lang.Long
	 * @see DoctorForm

	 */
	public java.lang.Long createData(DoctorForm doctorForm) {
		Result<java.lang.Long> result = create(doctorForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 添加医生
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctor</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DoctorFormcreate</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @param doctorForm  医生信息表单 
	 * @see java.lang.Long
	 * @see DoctorForm

	 */
	public Result<java.lang.Long> create(DoctorForm doctorForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("doctor", uriVariables);

		return httpClientAdapter.request("POST", url, doctorForm.encode("", new ArrayList<Entry<String, Object>>()),
				createType, false);
	}

	/**
	 * 添加医生
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctor</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DoctorFormcreate</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @param doctorForm  医生信息表单 
	 * @see java.lang.Long
	 * @see DoctorForm

	 */
	public Future<?> create(DoctorForm doctorForm, Callback<java.lang.Long> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("doctor", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				doctorForm.encode("", new ArrayList<Entry<String, Object>>()), createType, false, callable);
	}

	/**
	 * 同步医生,如果已经存在，返回新的医生id
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncDoctor</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>SyncDoctorFormsyncDoctor</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see SyncDoctorForm

	 */
	public java.lang.Long syncDoctorData(SyncDoctorForm doctorForm) {
		Result<java.lang.Long> result = syncDoctor(doctorForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 同步医生,如果已经存在，返回新的医生id
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncDoctor</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>SyncDoctorFormsyncDoctor</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see SyncDoctorForm

	 */
	public Result<java.lang.Long> syncDoctor(SyncDoctorForm doctorForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("syncDoctor", uriVariables);

		return httpClientAdapter.request("PUT", url, doctorForm.encode("", new ArrayList<Entry<String, Object>>()),
				syncDoctorType, false);
	}

	/**
	 * 同步医生,如果已经存在，返回新的医生id
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncDoctor</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>SyncDoctorFormsyncDoctor</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see SyncDoctorForm

	 */
	public Future<?> syncDoctor(SyncDoctorForm doctorForm, Callback<java.lang.Long> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("syncDoctor", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url,
				doctorForm.encode("", new ArrayList<Entry<String, Object>>()), syncDoctorType, false, callable);
	}

	/**
	 * 修改医生数据
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctor/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id <span>         医生的主键id </span></li>
	 * <li><b>Form:</b>DoctorFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id          医生的主键id 
	 * @param doctorForm  医生的信息表单 
	 * @see DoctorForm

	 */
	public Void updateData(long id, DoctorForm doctorForm) {
		Result<Void> result = update(id, doctorForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 修改医生数据
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctor/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id <span>         医生的主键id </span></li>
	 * <li><b>Form:</b>DoctorFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id          医生的主键id 
	 * @param doctorForm  医生的信息表单 
	 * @see DoctorForm

	 */
	public Result<Void> update(long id, DoctorForm doctorForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("doctor/{id}", uriVariables);

		return httpClientAdapter.request("PUT", url, doctorForm.encode("", new ArrayList<Entry<String, Object>>()),
				updateType, false);
	}

	/**
	 * 修改医生数据
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctor/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id <span>         医生的主键id </span></li>
	 * <li><b>Form:</b>DoctorFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id          医生的主键id 
	 * @param doctorForm  医生的信息表单 
	 * @see DoctorForm

	 */
	public Future<?> update(long id, DoctorForm doctorForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("doctor/{id}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url,
				doctorForm.encode("", new ArrayList<Entry<String, Object>>()), updateType, false, callable);
	}

	/**
	 * 根据id删除医生
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctor/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id <span> 医生id </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id  医生id 

	 */
	public Void deleteData(long id) {
		Result<Void> result = delete(id);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 根据id删除医生
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctor/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id <span> 医生id </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id  医生id 

	 */
	public Result<Void> delete(long id) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("doctor/{id}", uriVariables);

		return httpClientAdapter.request("DELETE", url, null, deleteType, false);
	}

	/**
	 * 根据id删除医生
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctor/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id <span> 医生id </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id  医生id 

	 */
	public Future<?> delete(long id, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("doctor/{id}", uriVariables);

		return httpClientAdapter.requestAsync("DELETE", url, null, deleteType, false, callable);
	}

	/**
	 * 批量删除 医生数据
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctors/{ids}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.Long&gt; ids <span> id数组 </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param ids  id数组 

	 */
	public Void deleteData(List<java.lang.Long> ids) {
		Result<Void> result = delete(ids);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 批量删除 医生数据
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctors/{ids}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.Long&gt; ids <span> id数组 </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param ids  id数组 

	 */
	public Result<Void> delete(List<java.lang.Long> ids) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("ids", ids);
		String url = expandUriComponent("doctors/{ids}", uriVariables);

		return httpClientAdapter.request("DELETE", url, null, delete0Type, false);
	}

	/**
	 * 批量删除 医生数据
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>doctors/{ids}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.Long&gt; ids <span> id数组 </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param ids  id数组 

	 */
	public Future<?> delete(List<java.lang.Long> ids, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("ids", ids);
		String url = expandUriComponent("doctors/{ids}", uriVariables);

		return httpClientAdapter.requestAsync("DELETE", url, null, delete0Type, false, callable);
	}

	/**
	 * 修改密码
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>passwordModify/{id}/{passowrd}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>PathVariable:</b> String passowrd</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Void passwordModifyData(long id, String passowrd) {
		Result<Void> result = passwordModify(id, passowrd);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 修改密码
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>passwordModify/{id}/{passowrd}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>PathVariable:</b> String passowrd</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Result<Void> passwordModify(long id, String passowrd) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		uriVariables.put("passowrd", passowrd);
		String url = expandUriComponent("passwordModify/{id}/{passowrd}", uriVariables);

		return httpClientAdapter.request("DELETE", url, null, passwordModifyType, false);
	}

	/**
	 * 修改密码
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>passwordModify/{id}/{passowrd}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>PathVariable:</b> String passowrd</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Future<?> passwordModify(long id, String passowrd, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		uriVariables.put("passowrd", passowrd);
		String url = expandUriComponent("passwordModify/{id}/{passowrd}", uriVariables);

		return httpClientAdapter.requestAsync("DELETE", url, null, passwordModifyType, false, callable);
	}

	private static final ApiType createType = type(Result.class, type(java.lang.Long.class));
	private static final ApiType syncDoctorType = type(Result.class, type(java.lang.Long.class));
	private static final ApiType updateType = type(Result.class, type(Void.class));
	private static final ApiType deleteType = type(Result.class, type(Void.class));
	private static final ApiType delete0Type = type(Result.class, type(Void.class));
	private static final ApiType passwordModifyType = type(Result.class, type(Void.class));
}