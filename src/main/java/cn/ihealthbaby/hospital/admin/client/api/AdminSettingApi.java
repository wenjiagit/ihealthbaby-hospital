package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.form.ServiceSettingForm;
import cn.ihealthbaby.hospital.admin.client.form.AdviceSettingForm;
import cn.ihealthbaby.hospital.admin.client.form.PriceForm;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * 设置相关的api,租赁设置,监护设置
 * @author  gwc
 */
public class AdminSettingApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminSettingApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 根据监护信息的主键id更新监护设置
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/advice/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>AdviceSettingFormupdateAdviceSetting</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param adviceSettingForm 监护设置数据表单 
	 * @see AdviceSettingForm

	 */
	public Void updateAdviceSettingData(long id, AdviceSettingForm adviceSettingForm) {
		Result<Void> result = updateAdviceSetting(id, adviceSettingForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 根据监护信息的主键id更新监护设置
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/advice/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>AdviceSettingFormupdateAdviceSetting</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param adviceSettingForm 监护设置数据表单 
	 * @see AdviceSettingForm

	 */
	public Result<Void> updateAdviceSetting(long id, AdviceSettingForm adviceSettingForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("setting/advice/{id}", uriVariables);

		return httpClientAdapter.request("PUT", url,
				adviceSettingForm.encode("", new ArrayList<Entry<String, Object>>()), updateAdviceSettingType, false);
	}

	/**
	 * 根据监护信息的主键id更新监护设置
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/advice/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>AdviceSettingFormupdateAdviceSetting</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param adviceSettingForm 监护设置数据表单 
	 * @see AdviceSettingForm

	 */
	public Future<?> updateAdviceSetting(long id, AdviceSettingForm adviceSettingForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("setting/advice/{id}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url,
				adviceSettingForm.encode("", new ArrayList<Entry<String, Object>>()), updateAdviceSettingType, false,
				callable);
	}

	/**
	 * 修改医院的收费价格
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/price</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>PriceFormupdatePriceSetting</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see PriceForm

	 */
	public Void updatePriceSettingData(PriceForm priceForm) {
		Result<Void> result = updatePriceSetting(priceForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 修改医院的收费价格
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/price</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>PriceFormupdatePriceSetting</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see PriceForm

	 */
	public Result<Void> updatePriceSetting(PriceForm priceForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("setting/price", uriVariables);

		return httpClientAdapter.request("PUT", url, priceForm.encode("", new ArrayList<Entry<String, Object>>()),
				updatePriceSettingType, false);
	}

	/**
	 * 修改医院的收费价格
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/price</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>PriceFormupdatePriceSetting</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see PriceForm

	 */
	public Future<?> updatePriceSetting(PriceForm priceForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("setting/price", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, priceForm.encode("", new ArrayList<Entry<String, Object>>()),
				updatePriceSettingType, false, callable);
	}

	/**
	 * 从套餐中移除
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/removeItem/{hospitalPackageSettingId}/{productId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalPackageSettingId</li>
	 * <li><b>PathVariable:</b> long productId</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Void removeItemData(long hospitalPackageSettingId, long productId) {
		Result<Void> result = removeItem(hospitalPackageSettingId, productId);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 从套餐中移除
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/removeItem/{hospitalPackageSettingId}/{productId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalPackageSettingId</li>
	 * <li><b>PathVariable:</b> long productId</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Result<Void> removeItem(long hospitalPackageSettingId, long productId) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalPackageSettingId", hospitalPackageSettingId);
		uriVariables.put("productId", productId);
		String url = expandUriComponent("setting/removeItem/{hospitalPackageSettingId}/{productId}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, removeItemType, false);
	}

	/**
	 * 从套餐中移除
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/removeItem/{hospitalPackageSettingId}/{productId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalPackageSettingId</li>
	 * <li><b>PathVariable:</b> long productId</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Future<?> removeItem(long hospitalPackageSettingId, long productId, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalPackageSettingId", hospitalPackageSettingId);
		uriVariables.put("productId", productId);
		String url = expandUriComponent("setting/removeItem/{hospitalPackageSettingId}/{productId}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, removeItemType, false, callable);
	}

	/**
	 * 向套餐中添加
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/updatePackage/{hospitalPackageSettingId}/{productId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalPackageSettingId</li>
	 * <li><b>PathVariable:</b> long productId</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public java.lang.Integer createHospitalPackageSettingData(long hospitalPackageSettingId, long productId) {
		Result<java.lang.Integer> result = createHospitalPackageSetting(hospitalPackageSettingId, productId);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 向套餐中添加
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/updatePackage/{hospitalPackageSettingId}/{productId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalPackageSettingId</li>
	 * <li><b>PathVariable:</b> long productId</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public Result<java.lang.Integer> createHospitalPackageSetting(long hospitalPackageSettingId, long productId) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalPackageSettingId", hospitalPackageSettingId);
		uriVariables.put("productId", productId);
		String url = expandUriComponent("setting/updatePackage/{hospitalPackageSettingId}/{productId}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, createHospitalPackageSettingType, false);
	}

	/**
	 * 向套餐中添加
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/updatePackage/{hospitalPackageSettingId}/{productId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalPackageSettingId</li>
	 * <li><b>PathVariable:</b> long productId</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public Future<?> createHospitalPackageSetting(long hospitalPackageSettingId, long productId,
			Callback<java.lang.Integer> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalPackageSettingId", hospitalPackageSettingId);
		uriVariables.put("productId", productId);
		String url = expandUriComponent("setting/updatePackage/{hospitalPackageSettingId}/{productId}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, createHospitalPackageSettingType, false, callable);
	}

	/**
	 * 保存监护设置
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/seviceSetting/{hospitalId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>Form:</b>ServiceSettingFormserviceSetting</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see ServiceSettingForm

	 */
	public Void serviceSettingData(long hospitalId, ServiceSettingForm form) {
		Result<Void> result = serviceSetting(hospitalId, form);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 保存监护设置
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/seviceSetting/{hospitalId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>Form:</b>ServiceSettingFormserviceSetting</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see ServiceSettingForm

	 */
	public Result<Void> serviceSetting(long hospitalId, ServiceSettingForm form) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalId", hospitalId);
		String url = expandUriComponent("setting/seviceSetting/{hospitalId}", uriVariables);

		return httpClientAdapter.request("PUT", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				serviceSettingType, false);
	}

	/**
	 * 保存监护设置
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>setting/seviceSetting/{hospitalId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long hospitalId</li>
	 * <li><b>Form:</b>ServiceSettingFormserviceSetting</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see ServiceSettingForm

	 */
	public Future<?> serviceSetting(long hospitalId, ServiceSettingForm form, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("hospitalId", hospitalId);
		String url = expandUriComponent("setting/seviceSetting/{hospitalId}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				serviceSettingType, false, callable);
	}

	private static final ApiType updateAdviceSettingType = type(Result.class, type(Void.class));
	private static final ApiType updatePriceSettingType = type(Result.class, type(Void.class));
	private static final ApiType removeItemType = type(Result.class, type(Void.class));
	private static final ApiType createHospitalPackageSettingType = type(Result.class, type(java.lang.Integer.class));
	private static final ApiType serviceSettingType = type(Result.class, type(Void.class));
}