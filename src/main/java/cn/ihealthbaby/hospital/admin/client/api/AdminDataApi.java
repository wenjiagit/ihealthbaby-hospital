package cn.ihealthbaby.hospital.admin.client.api;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * 初始修改数据
 */
public class AdminDataApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminDataApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 使用gzip压缩advice_ecg_data里面的data数据
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/data</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Void compressDataData() {
		Result<Void> result = compressData();
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 使用gzip压缩advice_ecg_data里面的data数据
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/data</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Result<Void> compressData() {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("advice/data", uriVariables);

		return httpClientAdapter.request("GET", url, null, compressDataType, false);
	}

	/**
	 * 使用gzip压缩advice_ecg_data里面的data数据
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>advice/data</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Future<?> compressData(Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("advice/data", uriVariables);

		return httpClientAdapter.requestAsync("GET", url, null, compressDataType, false, callable);
	}

	private static final ApiType compressDataType = type(Result.class, type(Void.class));
}