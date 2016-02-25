package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.form.DeviceForm;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * 设备相关的api,包括添加设备到医院,
 * @author  gwc
 */
public class AdminDeviceApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminDeviceApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 添加院内设备 @return 0 添加成功 ,1,编号已存在 2 设备不存在 ,3 设备已经被绑定
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>device/hospital</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DeviceFormaddDeviceToHospital</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @param deviceForm 院内设备添加数据表单 
	 * @see java.lang.Integer
	 * @see DeviceForm

	 */
	public java.lang.Integer addDeviceToHospitalData(DeviceForm deviceForm) {
		Result<java.lang.Integer> result = addDeviceToHospital(deviceForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 添加院内设备 @return 0 添加成功 ,1,编号已存在 2 设备不存在 ,3 设备已经被绑定
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>device/hospital</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DeviceFormaddDeviceToHospital</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @param deviceForm 院内设备添加数据表单 
	 * @see java.lang.Integer
	 * @see DeviceForm

	 */
	public Result<java.lang.Integer> addDeviceToHospital(DeviceForm deviceForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("device/hospital", uriVariables);

		return httpClientAdapter.request("POST", url, deviceForm.encode("", new ArrayList<Entry<String, Object>>()),
				addDeviceToHospitalType, false);
	}

	/**
	 * 添加院内设备 @return 0 添加成功 ,1,编号已存在 2 设备不存在 ,3 设备已经被绑定
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>device/hospital</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>DeviceFormaddDeviceToHospital</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @param deviceForm 院内设备添加数据表单 
	 * @see java.lang.Integer
	 * @see DeviceForm

	 */
	public Future<?> addDeviceToHospital(DeviceForm deviceForm, Callback<java.lang.Integer> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("device/hospital", uriVariables);

		return httpClientAdapter
				.requestAsync("POST", url, deviceForm.encode("", new ArrayList<Entry<String, Object>>()),
						addDeviceToHospitalType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>device/syncHospital/{oldId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long oldId</li>
	 * <li><b>Form:</b>DeviceFormsyncDeviceToHospital</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer
	 * @see DeviceForm

	 */
	public java.lang.Integer syncDeviceToHospitalData(long oldId, DeviceForm deviceForm) {
		Result<java.lang.Integer> result = syncDeviceToHospital(oldId, deviceForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>device/syncHospital/{oldId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long oldId</li>
	 * <li><b>Form:</b>DeviceFormsyncDeviceToHospital</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer
	 * @see DeviceForm

	 */
	public Result<java.lang.Integer> syncDeviceToHospital(long oldId, DeviceForm deviceForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("oldId", oldId);
		String url = expandUriComponent("device/syncHospital/{oldId}", uriVariables);

		return httpClientAdapter.request("PUT", url, deviceForm.encode("", new ArrayList<Entry<String, Object>>()),
				syncDeviceToHospitalType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>device/syncHospital/{oldId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long oldId</li>
	 * <li><b>Form:</b>DeviceFormsyncDeviceToHospital</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer
	 * @see DeviceForm

	 */
	public Future<?> syncDeviceToHospital(long oldId, DeviceForm deviceForm, Callback<java.lang.Integer> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("oldId", oldId);
		String url = expandUriComponent("device/syncHospital/{oldId}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url,
				deviceForm.encode("", new ArrayList<Entry<String, Object>>()), syncDeviceToHospitalType, false,
				callable);
	}

	/**
	 * 根据院内设备的id修改院内设备的信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>device/hospital/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>DeviceFormupdateDeviceToHospital</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param deviceForm 院内设备的修改数据表单 
	 * @see DeviceForm

	 */
	public Void updateDeviceToHospitalData(long id, DeviceForm deviceForm) {
		Result<Void> result = updateDeviceToHospital(id, deviceForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 根据院内设备的id修改院内设备的信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>device/hospital/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>DeviceFormupdateDeviceToHospital</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param deviceForm 院内设备的修改数据表单 
	 * @see DeviceForm

	 */
	public Result<Void> updateDeviceToHospital(long id, DeviceForm deviceForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("device/hospital/{id}", uriVariables);

		return httpClientAdapter.request("PUT", url, deviceForm.encode("", new ArrayList<Entry<String, Object>>()),
				updateDeviceToHospitalType, false);
	}

	/**
	 * 根据院内设备的id修改院内设备的信息
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>device/hospital/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Form:</b>DeviceFormupdateDeviceToHospital</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param deviceForm 院内设备的修改数据表单 
	 * @see DeviceForm

	 */
	public Future<?> updateDeviceToHospital(long id, DeviceForm deviceForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("device/hospital/{id}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url,
				deviceForm.encode("", new ArrayList<Entry<String, Object>>()), updateDeviceToHospitalType, false,
				callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>delHospitalFetalheart/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public java.lang.Integer delHospitalFetalheartData(long id) {
		Result<java.lang.Integer> result = delHospitalFetalheart(id);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>delHospitalFetalheart/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public Result<java.lang.Integer> delHospitalFetalheart(long id) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("delHospitalFetalheart/{id}", uriVariables);

		return httpClientAdapter.request("DELETE", url, null, delHospitalFetalheartType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>delHospitalFetalheart/{id}</b>
	 * <ul>
	 * <li><b>Method:</b> DELETE</li>
	 * <li><b>PathVariable:</b> long id</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public Future<?> delHospitalFetalheart(long id, Callback<java.lang.Integer> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		String url = expandUriComponent("delHospitalFetalheart/{id}", uriVariables);

		return httpClientAdapter.requestAsync("DELETE", url, null, delHospitalFetalheartType, false, callable);
	}

	private static final ApiType addDeviceToHospitalType = type(Result.class, type(java.lang.Integer.class));
	private static final ApiType syncDeviceToHospitalType = type(Result.class, type(java.lang.Integer.class));
	private static final ApiType updateDeviceToHospitalType = type(Result.class, type(Void.class));
	private static final ApiType delHospitalFetalheartType = type(Result.class, type(java.lang.Integer.class));
}