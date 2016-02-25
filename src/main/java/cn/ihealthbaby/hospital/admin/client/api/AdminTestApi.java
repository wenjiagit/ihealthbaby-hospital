package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.form.TestForm;
import cn.ihealthbaby.hospital.admin.client.model.TestObject;
import java.util.List;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * http://www.cnblogs.com/yuzhongwusan/p/3152526.html
 * http://www.ruanyifeng.com/blog/2014/05/restful_api.html
 * @author  zuoge85 on 15/6/11.
 */
public class AdminTestApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminTestApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 添加
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>TestFormcreate</li>
	 * <li><b>Model:</b> TestObject</li>
	 * </ul>
	 * </div>
	 * @see TestObject
	 * @see TestForm

	 */
	public TestObject createData(TestForm testForm) {
		Result<TestObject> result = create(testForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 添加
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>TestFormcreate</li>
	 * <li><b>Model:</b> TestObject</li>
	 * </ul>
	 * </div>
	 * @see TestObject
	 * @see TestForm

	 */
	public Result<TestObject> create(TestForm testForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("test/", uriVariables);

		return httpClientAdapter.request("POST", url, testForm.encode("", new ArrayList<Entry<String, Object>>()),
				createType, false);
	}

	/**
	 * 添加
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>TestFormcreate</li>
	 * <li><b>Model:</b> TestObject</li>
	 * </ul>
	 * </div>
	 * @see TestObject
	 * @see TestForm

	 */
	public Future<?> create(TestForm testForm, Callback<TestObject> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("test/", uriVariables);

		return httpClientAdapter.requestAsync("POST", url, testForm.encode("", new ArrayList<Entry<String, Object>>()),
				createType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String id</li>
	 * <li><b>Model:</b> TestObject</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see TestObject

	 */
	public TestObject getData(String id) {
		Result<TestObject> result = get(id);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String id</li>
	 * <li><b>Model:</b> TestObject</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see TestObject

	 */
	public Result<TestObject> get(String id) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("test/{id}", uriVariables);

		return httpClientAdapter.request("GET", url, null, getType, true);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String id</li>
	 * <li><b>Model:</b> TestObject</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see TestObject

	 */
	public Future<?> get(String id, Callback<TestObject> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("test/{id}", uriVariables);

		return httpClientAdapter.requestAsync("GET", url, null, getType, true, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>TestFormupdate</li>
	 * <li><b>Model:</b> TestObject</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see TestObject
	 * @see TestForm

	 */
	public TestObject updateData(TestForm testForm) {
		Result<TestObject> result = update(testForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>TestFormupdate</li>
	 * <li><b>Model:</b> TestObject</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see TestObject
	 * @see TestForm

	 */
	public Result<TestObject> update(TestForm testForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("test/", uriVariables);

		return httpClientAdapter.request("PUT", url, testForm.encode("", new ArrayList<Entry<String, Object>>()),
				updateType, true);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>TestFormupdate</li>
	 * <li><b>Model:</b> TestObject</li>
	 * <li>需要登录</li>
	 * </ul>
	 * </div>
	 * @see TestObject
	 * @see TestForm

	 */
	public Future<?> update(TestForm testForm, Callback<TestObject> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("test/", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, testForm.encode("", new ArrayList<Entry<String, Object>>()),
				updateType, true, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/</b>
	 * <ul>
	 * <li><b>Method:</b> PATCH</li>
	 * <li><b>Form:</b>TestFormpatchUpdate</li>
	 * <li><b>Model:</b> TestObject</li>
	 * </ul>
	 * </div>
	 * @see TestObject
	 * @see TestForm

	 */
	public TestObject patchUpdateData(TestForm testForm) {
		Result<TestObject> result = patchUpdate(testForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/</b>
	 * <ul>
	 * <li><b>Method:</b> PATCH</li>
	 * <li><b>Form:</b>TestFormpatchUpdate</li>
	 * <li><b>Model:</b> TestObject</li>
	 * </ul>
	 * </div>
	 * @see TestObject
	 * @see TestForm

	 */
	public Result<TestObject> patchUpdate(TestForm testForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("test/", uriVariables);

		return httpClientAdapter.request("PATCH", url, testForm.encode("", new ArrayList<Entry<String, Object>>()),
				patchUpdateType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/</b>
	 * <ul>
	 * <li><b>Method:</b> PATCH</li>
	 * <li><b>Form:</b>TestFormpatchUpdate</li>
	 * <li><b>Model:</b> TestObject</li>
	 * </ul>
	 * </div>
	 * @see TestObject
	 * @see TestForm

	 */
	public Future<?> patchUpdate(TestForm testForm, Callback<TestObject> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("test/", uriVariables);

		return httpClientAdapter.requestAsync("PATCH", url,
				testForm.encode("", new ArrayList<Entry<String, Object>>()), patchUpdateType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> String id</li>
	 * <li><b>Model:</b> boolean</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Boolean

	 */
	public java.lang.Boolean deleteData(String id) {
		Result<java.lang.Boolean> result = delete(id);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> String id</li>
	 * <li><b>Model:</b> boolean</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Boolean

	 */
	public Result<java.lang.Boolean> delete(String id) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("test/{id}", uriVariables);

		return httpClientAdapter.request("DELETE", url, null, deleteType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>test/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> String id</li>
	 * <li><b>Model:</b> boolean</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Boolean

	 */
	public Future<?> delete(String id, Callback<java.lang.Boolean> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("test/{id}", uriVariables);

		return httpClientAdapter.requestAsync("DELETE", url, null, deleteType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>tests/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.String&gt; id</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public java.lang.Integer deletesData(List<java.lang.String> id) {
		Result<java.lang.Integer> result = deletes(id);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>tests/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.String&gt; id</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public Result<java.lang.Integer> deletes(List<java.lang.String> id) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("tests/{id}", uriVariables);

		return httpClientAdapter.request("DELETE", url, null, deletesType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>tests/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> List&lt;java.lang.String&gt; id</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public Future<?> deletes(List<java.lang.String> id, Callback<java.lang.Integer> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("tests/{id}", uriVariables);

		return httpClientAdapter.requestAsync("DELETE", url, null, deletesType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>search/{id}/{name}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String id</li>
	 * <li><b>PathVariable:</b> String name</li>
	 * <li><b>Model:</b> TestObject</li>
	 * </ul>
	 * </div>
	 * @see TestObject

	 */
	public TestObject searchData(String id, String name) {
		Result<TestObject> result = search(id, name);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>search/{id}/{name}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String id</li>
	 * <li><b>PathVariable:</b> String name</li>
	 * <li><b>Model:</b> TestObject</li>
	 * </ul>
	 * </div>
	 * @see TestObject

	 */
	public Result<TestObject> search(String id, String name) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		uriVariables.put("name", name);
		String url = expandUriComponent("search/{id}/{name}", uriVariables);

		return httpClientAdapter.request("GET", url, null, searchType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>search/{id}/{name}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String id</li>
	 * <li><b>PathVariable:</b> String name</li>
	 * <li><b>Model:</b> TestObject</li>
	 * </ul>
	 * </div>
	 * @see TestObject

	 */
	public Future<?> search(String id, String name, Callback<TestObject> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		uriVariables.put("name", name);
		String url = expandUriComponent("search/{id}/{name}", uriVariables);

		return httpClientAdapter.requestAsync("GET", url, null, searchType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>testString/{name}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String name</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see java.lang.String

	 */
	public java.lang.String testStringData(String name) {
		Result<java.lang.String> result = testString(name);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>testString/{name}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String name</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see java.lang.String

	 */
	public Result<java.lang.String> testString(String name) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("name", name);
		String url = expandUriComponent("testString/{name}", uriVariables);

		return httpClientAdapter.request("GET", url, null, testStringType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>testString/{name}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String name</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see java.lang.String

	 */
	public Future<?> testString(String name, Callback<java.lang.String> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("name", name);
		String url = expandUriComponent("testString/{name}", uriVariables);

		return httpClientAdapter.requestAsync("GET", url, null, testStringType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>testString1/{name}/{age}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String name</li>
	 * <li><b>PathVariable:</b> String age</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see java.lang.String

	 */
	public java.lang.String testString1Data(String name, String age) {
		Result<java.lang.String> result = testString1(name, age);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>testString1/{name}/{age}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String name</li>
	 * <li><b>PathVariable:</b> String age</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see java.lang.String

	 */
	public Result<java.lang.String> testString1(String name, String age) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("name", name);
		uriVariables.put("age", age);
		String url = expandUriComponent("testString1/{name}/{age}", uriVariables);

		return httpClientAdapter.request("GET", url, null, testString1Type, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>testString1/{name}/{age}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> String name</li>
	 * <li><b>PathVariable:</b> String age</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see java.lang.String

	 */
	public Future<?> testString1(String name, String age, Callback<java.lang.String> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("name", name);
		uriVariables.put("age", age);
		String url = expandUriComponent("testString1/{name}/{age}", uriVariables);

		return httpClientAdapter.requestAsync("GET", url, null, testString1Type, false, callable);
	}

	private static final ApiType createType = type(Result.class, type(TestObject.class));
	private static final ApiType getType = type(Result.class, type(TestObject.class));
	private static final ApiType updateType = type(Result.class, type(TestObject.class));
	private static final ApiType patchUpdateType = type(Result.class, type(TestObject.class));
	private static final ApiType deleteType = type(Result.class, type(java.lang.Boolean.class));
	private static final ApiType deletesType = type(Result.class, type(java.lang.Integer.class));
	private static final ApiType searchType = type(Result.class, type(TestObject.class));
	private static final ApiType testStringType = type(Result.class, type(java.lang.String.class));
	private static final ApiType testString1Type = type(Result.class, type(java.lang.String.class));
}