package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.form.AdviceDataForm;
import cn.ihealthbaby.hospital.admin.client.form.SyncAdviceDataForm;
import cn.ihealthbaby.hospital.admin.client.model.SyncResult;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * @author  qiang
 */
public class AdminAdviceApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminAdviceApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/addAdviceReadData</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>AdviceDataFormaddAdviceReadData</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see AdviceDataForm

	 */
	public Void addAdviceReadDataData(AdviceDataForm adviceDataForm) {
		Result<Void> result = addAdviceReadData(adviceDataForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/addAdviceReadData</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>AdviceDataFormaddAdviceReadData</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see AdviceDataForm

	 */
	public Result<Void> addAdviceReadData(AdviceDataForm adviceDataForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("advice/addAdviceReadData", uriVariables);

		return httpClientAdapter.request("POST", url,
				adviceDataForm.encode("", new ArrayList<Entry<String, Object>>()), addAdviceReadDataType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/addAdviceReadData</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>AdviceDataFormaddAdviceReadData</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see AdviceDataForm

	 */
	public Future<?> addAdviceReadData(AdviceDataForm adviceDataForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("advice/addAdviceReadData", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				adviceDataForm.encode("", new ArrayList<Entry<String, Object>>()), addAdviceReadDataType, false,
				callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/syncAdviceReadData</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>SyncAdviceDataFormsyncAdviceReadData</li>
	 * <li><b>Model:</b> SyncResult</li>
	 * </ul>
	 * </div>
	 * @see SyncResult
	 * @see SyncAdviceDataForm

	 */
	public SyncResult syncAdviceReadDataData(SyncAdviceDataForm adviceDataForm) {
		Result<SyncResult> result = syncAdviceReadData(adviceDataForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/syncAdviceReadData</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>SyncAdviceDataFormsyncAdviceReadData</li>
	 * <li><b>Model:</b> SyncResult</li>
	 * </ul>
	 * </div>
	 * @see SyncResult
	 * @see SyncAdviceDataForm

	 */
	public Result<SyncResult> syncAdviceReadData(SyncAdviceDataForm adviceDataForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("advice/syncAdviceReadData", uriVariables);

		return httpClientAdapter.request("PUT", url, adviceDataForm.encode("", new ArrayList<Entry<String, Object>>()),
				syncAdviceReadDataType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/syncAdviceReadData</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>SyncAdviceDataFormsyncAdviceReadData</li>
	 * <li><b>Model:</b> SyncResult</li>
	 * </ul>
	 * </div>
	 * @see SyncResult
	 * @see SyncAdviceDataForm

	 */
	public Future<?> syncAdviceReadData(SyncAdviceDataForm adviceDataForm, Callback<SyncResult> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("advice/syncAdviceReadData", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url,
				adviceDataForm.encode("", new ArrayList<Entry<String, Object>>()), syncAdviceReadDataType, false,
				callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/syncCheck/{oldId}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> long oldId <span> 老系统记录id </span></li>
	 * <li><b>Model:</b> boolean</li>
	 * </ul>
	 * </div>
	 * @param oldId  老系统记录id 
	 * @see java.lang.Boolean

	 */
	public java.lang.Boolean syncCheckData(long oldId) {
		Result<java.lang.Boolean> result = syncCheck(oldId);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/syncCheck/{oldId}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> long oldId <span> 老系统记录id </span></li>
	 * <li><b>Model:</b> boolean</li>
	 * </ul>
	 * </div>
	 * @param oldId  老系统记录id 
	 * @see java.lang.Boolean

	 */
	public Result<java.lang.Boolean> syncCheck(long oldId) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("oldId", oldId);
		String url = expandUriComponent("advice/syncCheck/{oldId}", uriVariables);

		return httpClientAdapter.request("GET", url, null, syncCheckType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/syncCheck/{oldId}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> long oldId <span> 老系统记录id </span></li>
	 * <li><b>Model:</b> boolean</li>
	 * </ul>
	 * </div>
	 * @param oldId  老系统记录id 
	 * @see java.lang.Boolean

	 */
	public Future<?> syncCheck(long oldId, Callback<java.lang.Boolean> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("oldId", oldId);
		String url = expandUriComponent("advice/syncCheck/{oldId}", uriVariables);

		return httpClientAdapter.requestAsync("GET", url, null, syncCheckType, false, callable);
	}

	private static final ApiType addAdviceReadDataType = type(Result.class, type(Void.class));
	private static final ApiType syncAdviceReadDataType = type(Result.class, type(SyncResult.class));
	private static final ApiType syncCheckType = type(Result.class, type(java.lang.Boolean.class));
}