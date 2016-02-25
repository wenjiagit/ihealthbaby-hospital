package cn.ihealthbaby.hospital.admin.client.api;

import java.util.List;
import cn.ihealthbaby.hospital.admin.client.form.SyncUserForm;
import cn.ihealthbaby.hospital.admin.client.model.SyncResult;
import cn.ihealthbaby.hospital.admin.client.form.UserForm;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * 孕妇用户管理的api,
 * @author  gwc
 */
public class AdminUserApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminUserApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 新建用户
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>user</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>UserFormcreate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param userForm 用户数据的表单 
	 * @see UserForm

	 */
	public Void createData(UserForm userForm) {
		Result<Void> result = create(userForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 新建用户
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>user</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>UserFormcreate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param userForm 用户数据的表单 
	 * @see UserForm

	 */
	public Result<Void> create(UserForm userForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("user", uriVariables);

		return httpClientAdapter.request("POST", url, userForm.encode("", new ArrayList<Entry<String, Object>>()),
				createType, false);
	}

	/**
	 * 新建用户
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>user</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>UserFormcreate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param userForm 用户数据的表单 
	 * @see UserForm

	 */
	public Future<?> create(UserForm userForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("user", uriVariables);

		return httpClientAdapter.requestAsync("POST", url, userForm.encode("", new ArrayList<Entry<String, Object>>()),
				createType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncUser</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>SyncUserFormsync</li>
	 * <li><b>Model:</b> SyncResult</li>
	 * </ul>
	 * </div>
	 * @see SyncResult
	 * @see SyncUserForm

	 */
	public SyncResult syncData(SyncUserForm userForm) {
		Result<SyncResult> result = sync(userForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncUser</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>SyncUserFormsync</li>
	 * <li><b>Model:</b> SyncResult</li>
	 * </ul>
	 * </div>
	 * @see SyncResult
	 * @see SyncUserForm

	 */
	public Result<SyncResult> sync(SyncUserForm userForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("syncUser", uriVariables);

		return httpClientAdapter.request("PUT", url, userForm.encode("", new ArrayList<Entry<String, Object>>()),
				syncType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncUser</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>SyncUserFormsync</li>
	 * <li><b>Model:</b> SyncResult</li>
	 * </ul>
	 * </div>
	 * @see SyncResult
	 * @see SyncUserForm

	 */
	public Future<?> sync(SyncUserForm userForm, Callback<SyncResult> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("syncUser", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, userForm.encode("", new ArrayList<Entry<String, Object>>()),
				syncType, false, callable);
	}

	/**
	 * 根据用户id修改用户的信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>user/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id <span>用户的id </span></li>
	 * <li><b>Form:</b>UserFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id 用户的id 
	 * @param userForm 用户信息表单 
	 * @see UserForm

	 */
	public Void updateData(long id, UserForm userForm) {
		Result<Void> result = update(id, userForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 根据用户id修改用户的信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>user/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id <span>用户的id </span></li>
	 * <li><b>Form:</b>UserFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id 用户的id 
	 * @param userForm 用户信息表单 
	 * @see UserForm

	 */
	public Result<Void> update(long id, UserForm userForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("user/{id}", uriVariables);

		return httpClientAdapter.request("PUT", url, userForm.encode("", new ArrayList<Entry<String, Object>>()),
				updateType, false);
	}

	/**
	 * 根据用户id修改用户的信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>user/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id <span>用户的id </span></li>
	 * <li><b>Form:</b>UserFormupdate</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param id 用户的id 
	 * @param userForm 用户信息表单 
	 * @see UserForm

	 */
	public Future<?> update(long id, UserForm userForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("user/{id}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, userForm.encode("", new ArrayList<Entry<String, Object>>()),
				updateType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>users/{ids}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.Long&gt; ids <span>批量删除的id数组 </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param ids 批量删除的id数组 

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
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>users/{ids}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.Long&gt; ids <span>批量删除的id数组 </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param ids 批量删除的id数组 

	 */
	public Result<Void> delete(List<java.lang.Long> ids) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("ids", ids);
		String url = expandUriComponent("users/{ids}", uriVariables);

		return httpClientAdapter.request("DELETE", url, null, deleteType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>users/{ids}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.Long&gt; ids <span>批量删除的id数组 </span></li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param ids 批量删除的id数组 

	 */
	public Future<?> delete(List<java.lang.Long> ids, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("ids", ids);
		String url = expandUriComponent("users/{ids}", uriVariables);

		return httpClientAdapter.requestAsync("DELETE", url, null, deleteType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>password/{id}/{password}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>PathVariable:</b> String password</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Void passwordModifyData(long id, String password) {
		Result<Void> result = passwordModify(id, password);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>password/{id}/{password}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>PathVariable:</b> String password</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Result<Void> passwordModify(long id, String password) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		uriVariables.put("password", password);
		String url = expandUriComponent("password/{id}/{password}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, passwordModifyType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>password/{id}/{password}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>PathVariable:</b> String password</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Future<?> passwordModify(long id, String password, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		uriVariables.put("password", password);
		String url = expandUriComponent("password/{id}/{password}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, passwordModifyType, false, callable);
	}

	private static final ApiType createType = type(Result.class, type(Void.class));
	private static final ApiType syncType = type(Result.class, type(SyncResult.class));
	private static final ApiType updateType = type(Result.class, type(Void.class));
	private static final ApiType deleteType = type(Result.class, type(Void.class));
	private static final ApiType passwordModifyType = type(Result.class, type(Void.class));
}