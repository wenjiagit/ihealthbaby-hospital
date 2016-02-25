package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.form.ProductForm;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * Created by qiang on 2015/8/10.
 */
public class AdminProductApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminProductApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/addProduct</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>ProductFormaddProuct</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see ProductForm

	 */
	public Void addProuctData(ProductForm productForm) {
		Result<Void> result = addProuct(productForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/addProduct</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>ProductFormaddProuct</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see ProductForm

	 */
	public Result<Void> addProuct(ProductForm productForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("/addProduct", uriVariables);

		return httpClientAdapter.request("POST", url, productForm.encode("", new ArrayList<Entry<String, Object>>()),
				addProuctType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/addProduct</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>ProductFormaddProuct</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see ProductForm

	 */
	public Future<?> addProuct(ProductForm productForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("/addProduct", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				productForm.encode("", new ArrayList<Entry<String, Object>>()), addProuctType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/updateProduct/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>ProductFormupdateProuct</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see ProductForm

	 */
	public Void updateProuctData(long id, ProductForm productForm) {
		Result<Void> result = updateProuct(id, productForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/updateProduct/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>ProductFormupdateProuct</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see ProductForm

	 */
	public Result<Void> updateProuct(long id, ProductForm productForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("/updateProduct/{id}", uriVariables);

		return httpClientAdapter.request("POST", url, productForm.encode("", new ArrayList<Entry<String, Object>>()),
				updateProuctType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/updateProduct/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>ProductFormupdateProuct</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see ProductForm

	 */
	public Future<?> updateProuct(long id, ProductForm productForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("/updateProduct/{id}", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				productForm.encode("", new ArrayList<Entry<String, Object>>()), updateProuctType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/delProduct/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Void delProductData(long id) {
		Result<Void> result = delProduct(id);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/delProduct/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Result<Void> delProduct(long id) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("/delProduct/{id}", uriVariables);

		return httpClientAdapter.request("DELETE", url, null, delProductType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>/delProduct/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Future<?> delProduct(long id, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("/delProduct/{id}", uriVariables);

		return httpClientAdapter.requestAsync("DELETE", url, null, delProductType, false, callable);
	}

	private static final ApiType addProuctType = type(Result.class, type(Void.class));
	private static final ApiType updateProuctType = type(Result.class, type(Void.class));
	private static final ApiType delProductType = type(Result.class, type(Void.class));
}