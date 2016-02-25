package cn.ihealthbaby.hospital.admin.client.api;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * @author  设置redis服务单号和咨询单号的redis初始值
 */
public class AdminRedisApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminRedisApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 重置咨询单号初始值
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>redis/advicenumber/{hospitalId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long

	 */
	public java.lang.Long resetAdviceNumberData(long hospitalId) {
		Result<java.lang.Long> result = resetAdviceNumber(hospitalId);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 重置咨询单号初始值
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>redis/advicenumber/{hospitalId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long

	 */
	public Result<java.lang.Long> resetAdviceNumber(long hospitalId) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalId", hospitalId);
		String url = expandUriComponent("redis/advicenumber/{hospitalId}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, resetAdviceNumberType, false);
	}

	/**
	 * 重置咨询单号初始值
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>redis/advicenumber/{hospitalId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long

	 */
	public Future<?> resetAdviceNumber(long hospitalId, Callback<java.lang.Long> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalId", hospitalId);
		String url = expandUriComponent("redis/advicenumber/{hospitalId}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, resetAdviceNumberType, false, callable);
	}

	/**
	 * 重置服务单号初始值
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>redis/servicenumber/{hospitalId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long

	 */
	public java.lang.Long resetServiceNumberData(long hospitalId) {
		Result<java.lang.Long> result = resetServiceNumber(hospitalId);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 重置服务单号初始值
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>redis/servicenumber/{hospitalId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long

	 */
	public Result<java.lang.Long> resetServiceNumber(long hospitalId) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalId", hospitalId);
		String url = expandUriComponent("redis/servicenumber/{hospitalId}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, resetServiceNumberType, false);
	}

	/**
	 * 重置服务单号初始值
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>redis/servicenumber/{hospitalId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long

	 */
	public Future<?> resetServiceNumber(long hospitalId, Callback<java.lang.Long> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalId", hospitalId);
		String url = expandUriComponent("redis/servicenumber/{hospitalId}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, resetServiceNumberType, false, callable);
	}

	private static final ApiType resetAdviceNumberType = type(Result.class, type(java.lang.Long.class));
	private static final ApiType resetServiceNumberType = type(Result.class, type(java.lang.Long.class));
}