package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.collecton.ApiEntry;
import cn.ihealthbaby.hospital.admin.client.form.ServiceForm;
import cn.ihealthbaby.hospital.admin.client.form.ServiceInsideForm;
import cn.ihealthbaby.hospital.admin.client.form.SyncServiceInsideForm;
import cn.ihealthbaby.hospital.admin.client.model.SyncResult;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * 监护服务的相关api,包括开通监护,结算,打印清单等
 * @author  qiang
 */
public class AdminServiceApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminServiceApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 开通服务
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>service</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>ServiceFormnewService</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see ServiceForm

	 */
	public java.lang.Long newServiceData(ServiceForm serviceForm) {
		Result<java.lang.Long> result = newService(serviceForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 开通服务
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>service</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>ServiceFormnewService</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see ServiceForm

	 */
	public Result<java.lang.Long> newService(ServiceForm serviceForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("service", uriVariables);

		return httpClientAdapter.request("POST", url, serviceForm.encode("", new ArrayList<Entry<String, Object>>()),
				newServiceType, false);
	}

	/**
	 * 开通服务
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>service</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>ServiceFormnewService</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see ServiceForm

	 */
	public Future<?> newService(ServiceForm serviceForm, Callback<java.lang.Long> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("service", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				serviceForm.encode("", new ArrayList<Entry<String, Object>>()), newServiceType, false, callable);
	}

	/**
	 * 同步服务
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncService</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>ServiceFormsyncService</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see ServiceForm

	 */
	public java.lang.Long syncServiceData(ServiceForm serviceForm) {
		Result<java.lang.Long> result = syncService(serviceForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 同步服务
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncService</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>ServiceFormsyncService</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see ServiceForm

	 */
	public Result<java.lang.Long> syncService(ServiceForm serviceForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("syncService", uriVariables);

		return httpClientAdapter.request("PUT", url, serviceForm.encode("", new ArrayList<Entry<String, Object>>()),
				syncServiceType, false);
	}

	/**
	 * 同步服务
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncService</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>ServiceFormsyncService</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see ServiceForm

	 */
	public Future<?> syncService(ServiceForm serviceForm, Callback<java.lang.Long> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("syncService", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url,
				serviceForm.encode("", new ArrayList<Entry<String, Object>>()), syncServiceType, false, callable);
	}

	/**
	 * 添加院内服务
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>serviceInside</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>ServiceInsideFormaddServiceInside</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer
	 * @see ServiceInsideForm

	 */
	public java.lang.Integer addServiceInsideData(ServiceInsideForm serviceInsideForm) {
		Result<java.lang.Integer> result = addServiceInside(serviceInsideForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 添加院内服务
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>serviceInside</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>ServiceInsideFormaddServiceInside</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer
	 * @see ServiceInsideForm

	 */
	public Result<java.lang.Integer> addServiceInside(ServiceInsideForm serviceInsideForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("serviceInside", uriVariables);

		return httpClientAdapter.request("POST", url,
				serviceInsideForm.encode("", new ArrayList<Entry<String, Object>>()), addServiceInsideType, false);
	}

	/**
	 * 添加院内服务
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>serviceInside</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>ServiceInsideFormaddServiceInside</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer
	 * @see ServiceInsideForm

	 */
	public Future<?> addServiceInside(ServiceInsideForm serviceInsideForm, Callback<java.lang.Integer> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("serviceInside", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				serviceInsideForm.encode("", new ArrayList<Entry<String, Object>>()), addServiceInsideType, false,
				callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncServiceInside</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>SyncServiceInsideFormsyncServiceInside</li>
	 * <li><b>Model:</b> SyncResult</li>
	 * </ul>
	 * </div>
	 * @see SyncResult
	 * @see SyncServiceInsideForm

	 */
	public SyncResult syncServiceInsideData(SyncServiceInsideForm serviceInsideForm) {
		Result<SyncResult> result = syncServiceInside(serviceInsideForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncServiceInside</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>SyncServiceInsideFormsyncServiceInside</li>
	 * <li><b>Model:</b> SyncResult</li>
	 * </ul>
	 * </div>
	 * @see SyncResult
	 * @see SyncServiceInsideForm

	 */
	public Result<SyncResult> syncServiceInside(SyncServiceInsideForm serviceInsideForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("syncServiceInside", uriVariables);

		return httpClientAdapter.request("POST", url,
				serviceInsideForm.encode("", new ArrayList<Entry<String, Object>>()), syncServiceInsideType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>syncServiceInside</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>SyncServiceInsideFormsyncServiceInside</li>
	 * <li><b>Model:</b> SyncResult</li>
	 * </ul>
	 * </div>
	 * @see SyncResult
	 * @see SyncServiceInsideForm

	 */
	public Future<?> syncServiceInside(SyncServiceInsideForm serviceInsideForm, Callback<SyncResult> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("syncServiceInside", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				serviceInsideForm.encode("", new ArrayList<Entry<String, Object>>()), syncServiceInsideType, false,
				callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>balanceService/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Void balanceOutsideServiceData(long id) {
		Result<Void> result = balanceOutsideService(id);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>balanceService/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Result<Void> balanceOutsideService(long id) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("balanceService/{id}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, balanceOutsideServiceType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>balanceService/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Future<?> balanceOutsideService(long id, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("balanceService/{id}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, balanceOutsideServiceType, false, callable);
	}

	private static final ApiType newServiceType = type(Result.class, type(java.lang.Long.class));
	private static final ApiType syncServiceType = type(Result.class, type(java.lang.Long.class));
	private static final ApiType addServiceInsideType = type(Result.class, type(java.lang.Integer.class));
	private static final ApiType syncServiceInsideType = type(Result.class, type(SyncResult.class));
	private static final ApiType balanceOutsideServiceType = type(Result.class, type(Void.class));
}