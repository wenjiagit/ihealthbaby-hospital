package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.form.AddressForm;
import cn.ihealthbaby.hospital.admin.client.form.CashPayForm;
import cn.ihealthbaby.hospital.admin.client.form.ConfirmDeliveryForm;
import cn.ihealthbaby.hospital.admin.client.form.SingleOrderForm;
import cn.ihealthbaby.hospital.admin.client.form.WXPayForm;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * @author  qiang on 2015/8/26. jinliqiang@ihbaby.com
 */
public class AdminOrderApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminOrderApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>orderPay/{orderId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long orderId</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Void orderPayData(long orderId) {
		Result<Void> result = orderPay(orderId);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>orderPay/{orderId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long orderId</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Result<Void> orderPay(long orderId) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("orderId", orderId);
		String url = expandUriComponent("orderPay/{orderId}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, orderPayType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>orderPay/{orderId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long orderId</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Future<?> orderPay(long orderId, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("orderId", orderId);
		String url = expandUriComponent("orderPay/{orderId}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, orderPayType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>orderCancle/{orderId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long orderId</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Void orderCancelData(long orderId) {
		Result<Void> result = orderCancel(orderId);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>orderCancle/{orderId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long orderId</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Result<Void> orderCancel(long orderId) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("orderId", orderId);
		String url = expandUriComponent("orderCancle/{orderId}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, orderCancelType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>orderCancle/{orderId}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long orderId</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>

	 */
	public Future<?> orderCancel(long orderId, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("orderId", orderId);
		String url = expandUriComponent("orderCancle/{orderId}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, orderCancelType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>confirmDelivery</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>ConfirmDeliveryFormconfirmDelivery</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer
	 * @see ConfirmDeliveryForm

	 */
	public java.lang.Integer confirmDeliveryData(ConfirmDeliveryForm form) {
		Result<java.lang.Integer> result = confirmDelivery(form);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>confirmDelivery</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>ConfirmDeliveryFormconfirmDelivery</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer
	 * @see ConfirmDeliveryForm

	 */
	public Result<java.lang.Integer> confirmDelivery(ConfirmDeliveryForm form) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("confirmDelivery", uriVariables);

		return httpClientAdapter.request("PUT", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				confirmDeliveryType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>confirmDelivery</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>Form:</b>ConfirmDeliveryFormconfirmDelivery</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer
	 * @see ConfirmDeliveryForm

	 */
	public Future<?> confirmDelivery(ConfirmDeliveryForm form, Callback<java.lang.Integer> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("confirmDelivery", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				confirmDeliveryType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>addsn/{orderId}/{serialnum}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long orderId</li>
	 * <li><b>PathVariable:</b> String serialnum</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public java.lang.Integer addSNData(long orderId, String serialnum) {
		Result<java.lang.Integer> result = addSN(orderId, serialnum);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>addsn/{orderId}/{serialnum}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long orderId</li>
	 * <li><b>PathVariable:</b> String serialnum</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public Result<java.lang.Integer> addSN(long orderId, String serialnum) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("orderId", orderId);
		uriVariables.put("serialnum", serialnum);
		String url = expandUriComponent("addsn/{orderId}/{serialnum}", uriVariables);

		return httpClientAdapter.request("PUT", url, null, addSNType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>addsn/{orderId}/{serialnum}</b>
	 * <ul>
	 * <li><b>Method:</b> PUT</li>
	 * <li><b>PathVariable:</b> long orderId</li>
	 * <li><b>PathVariable:</b> String serialnum</li>
	 * <li><b>Model:</b> int</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Integer

	 */
	public Future<?> addSN(long orderId, String serialnum, Callback<java.lang.Integer> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("orderId", orderId);
		uriVariables.put("serialnum", serialnum);
		String url = expandUriComponent("addsn/{orderId}/{serialnum}", uriVariables);

		return httpClientAdapter.requestAsync("PUT", url, null, addSNType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>addNewAddress/{userId}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long userId</li>
	 * <li><b>Form:</b>AddressFormaddNewAddress</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see AddressForm

	 */
	public Void addNewAddressData(long userId, AddressForm form) {
		Result<Void> result = addNewAddress(userId, form);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>addNewAddress/{userId}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long userId</li>
	 * <li><b>Form:</b>AddressFormaddNewAddress</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see AddressForm

	 */
	public Result<Void> addNewAddress(long userId, AddressForm form) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("userId", userId);
		String url = expandUriComponent("addNewAddress/{userId}", uriVariables);

		return httpClientAdapter.request("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				addNewAddressType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>addNewAddress/{userId}</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>PathVariable:</b> long userId</li>
	 * <li><b>Form:</b>AddressFormaddNewAddress</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see AddressForm

	 */
	public Future<?> addNewAddress(long userId, AddressForm form, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("userId", userId);
		String url = expandUriComponent("addNewAddress/{userId}", uriVariables);

		return httpClientAdapter.requestAsync("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				addNewAddressType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>createSingleOrder</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>SingleOrderFormcreateSingleOrder</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see SingleOrderForm

	 */
	public java.lang.Long createSingleOrderData(SingleOrderForm form) {
		Result<java.lang.Long> result = createSingleOrder(form);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>createSingleOrder</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>SingleOrderFormcreateSingleOrder</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see SingleOrderForm

	 */
	public Result<java.lang.Long> createSingleOrder(SingleOrderForm form) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("createSingleOrder", uriVariables);

		return httpClientAdapter.request("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				createSingleOrderType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>createSingleOrder</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>SingleOrderFormcreateSingleOrder</li>
	 * <li><b>Model:</b> long</li>
	 * </ul>
	 * </div>
	 * @see java.lang.Long
	 * @see SingleOrderForm

	 */
	public Future<?> createSingleOrder(SingleOrderForm form, Callback<java.lang.Long> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("createSingleOrder", uriVariables);

		return httpClientAdapter.requestAsync("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				createSingleOrderType, false, callable);
	}

	/**
	 * 生成微信支付二维码
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>pay/wxqr</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>Form:</b>WXPayFormgetWxQr</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @param wxPayForm 支付所需数据 
	 * @see java.lang.String
	 * @see WXPayForm

	 */
	public java.lang.String getWxQrData(WXPayForm wxPayForm) {
		Result<java.lang.String> result = getWxQr(wxPayForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 生成微信支付二维码
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>pay/wxqr</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>Form:</b>WXPayFormgetWxQr</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @param wxPayForm 支付所需数据 
	 * @see java.lang.String
	 * @see WXPayForm

	 */
	public Result<java.lang.String> getWxQr(WXPayForm wxPayForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("pay/wxqr", uriVariables);

		return httpClientAdapter.request("GET", url, wxPayForm.encode("", new ArrayList<Entry<String, Object>>()),
				getWxQrType, false);
	}

	/**
	 * 生成微信支付二维码
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>pay/wxqr</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>Form:</b>WXPayFormgetWxQr</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @param wxPayForm 支付所需数据 
	 * @see java.lang.String
	 * @see WXPayForm

	 */
	public Future<?> getWxQr(WXPayForm wxPayForm, Callback<java.lang.String> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("pay/wxqr", uriVariables);

		return httpClientAdapter.requestAsync("GET", url, wxPayForm.encode("", new ArrayList<Entry<String, Object>>()),
				getWxQrType, false, callable);
	}

	/**
	 * 获得支付宝支付的二维码
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>pay/alipay/qr/{orderId}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> long orderId <span>订单id </span></li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @param orderId 订单id 
	 * @see java.lang.String

	 */
	public java.lang.String getAlipayQrData(long orderId) {
		Result<java.lang.String> result = getAlipayQr(orderId);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 获得支付宝支付的二维码
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>pay/alipay/qr/{orderId}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> long orderId <span>订单id </span></li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @param orderId 订单id 
	 * @see java.lang.String

	 */
	public Result<java.lang.String> getAlipayQr(long orderId) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("orderId", orderId);
		String url = expandUriComponent("pay/alipay/qr/{orderId}", uriVariables);

		return httpClientAdapter.request("GET", url, null, getAlipayQrType, false);
	}

	/**
	 * 获得支付宝支付的二维码
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>pay/alipay/qr/{orderId}</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>PathVariable:</b> long orderId <span>订单id </span></li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @param orderId 订单id 
	 * @see java.lang.String

	 */
	public Future<?> getAlipayQr(long orderId, Callback<java.lang.String> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("orderId", orderId);
		String url = expandUriComponent("pay/alipay/qr/{orderId}", uriVariables);

		return httpClientAdapter.requestAsync("GET", url, null, getAlipayQrType, false, callable);
	}

	/**
	 * pos或者现金支付调用接口
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>orderPay/posorcash</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>CashPayFormposOrCashPay</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param cashPayForm pos或者现金支付须填写的信息 
	 * @see CashPayForm

	 */
	public Void posOrCashPayData(CashPayForm cashPayForm) {
		Result<Void> result = posOrCashPay(cashPayForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * pos或者现金支付调用接口
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>orderPay/posorcash</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>CashPayFormposOrCashPay</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param cashPayForm pos或者现金支付须填写的信息 
	 * @see CashPayForm

	 */
	public Result<Void> posOrCashPay(CashPayForm cashPayForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("orderPay/posorcash", uriVariables);

		return httpClientAdapter.request("POST", url, cashPayForm.encode("", new ArrayList<Entry<String, Object>>()),
				posOrCashPayType, false);
	}

	/**
	 * pos或者现金支付调用接口
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>orderPay/posorcash</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>CashPayFormposOrCashPay</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @param cashPayForm pos或者现金支付须填写的信息 
	 * @see CashPayForm

	 */
	public Future<?> posOrCashPay(CashPayForm cashPayForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("orderPay/posorcash", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				cashPayForm.encode("", new ArrayList<Entry<String, Object>>()), posOrCashPayType, false, callable);
	}

	private static final ApiType orderPayType = type(Result.class, type(Void.class));
	private static final ApiType orderCancelType = type(Result.class, type(Void.class));
	private static final ApiType confirmDeliveryType = type(Result.class, type(java.lang.Integer.class));
	private static final ApiType addSNType = type(Result.class, type(java.lang.Integer.class));
	private static final ApiType addNewAddressType = type(Result.class, type(Void.class));
	private static final ApiType createSingleOrderType = type(Result.class, type(java.lang.Long.class));
	private static final ApiType getWxQrType = type(Result.class, type(java.lang.String.class));
	private static final ApiType getAlipayQrType = type(Result.class, type(java.lang.String.class));
	private static final ApiType posOrCashPayType = type(Result.class, type(Void.class));
}