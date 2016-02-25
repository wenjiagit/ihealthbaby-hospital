package cn.ihealthbaby.hospital.admin.client.api;

import cn.ihealthbaby.hospital.admin.client.form.ConfirmRefundForm;
import cn.ihealthbaby.hospital.admin.client.form.NewApplyForm;
import cn.ihealthbaby.hospital.admin.client.form.RejectForm;

import java.util.*;
import java.util.concurrent.Future;
import java.util.Map.Entry;

import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.HttpClientAdapter.Callback;

/**
 * @author  qiang on 2015/9/6. jinliqiang@ihbaby.com
 */
public class AdminRefundApi extends cn.ihealthbaby.hospital.admin.client.Api {
	private cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter;

	public AdminRefundApi(cn.ihealthbaby.hospital.admin.client.HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>newApply</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>NewApplyFormnewApply</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see NewApplyForm

	 */
	public Void newApplyData(NewApplyForm newApplyForm) {
		Result<Void> result = newApply(newApplyForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>newApply</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>NewApplyFormnewApply</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see NewApplyForm

	 */
	public Result<Void> newApply(NewApplyForm newApplyForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("newApply", uriVariables);

		return httpClientAdapter.request("POST", url, newApplyForm.encode("", new ArrayList<Entry<String, Object>>()),
				newApplyType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>newApply</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>NewApplyFormnewApply</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see NewApplyForm

	 */
	public Future<?> newApply(NewApplyForm newApplyForm, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("newApply", uriVariables);

		return httpClientAdapter.requestAsync("POST", url,
				newApplyForm.encode("", new ArrayList<Entry<String, Object>>()), newApplyType, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>RejectRefund</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>RejectFormrejectRefund</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see RejectForm

	 */
	public Void rejectRefundData(RejectForm form) {
		Result<Void> result = rejectRefund(form);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>RejectRefund</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>RejectFormrejectRefund</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see RejectForm

	 */
	public Result<Void> rejectRefund(RejectForm form) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("RejectRefund", uriVariables);

		return httpClientAdapter.request("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				rejectRefundType, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>RejectRefund</b>
	 * <ul>
	 * <li><b>Method:</b> POST</li>
	 * <li><b>Form:</b>RejectFormrejectRefund</li>
	 * <li><b>Model:</b> Void</li>
	 * </ul>
	 * </div>
	 * @see RejectForm

	 */
	public Future<?> rejectRefund(RejectForm form, Callback<Void> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("RejectRefund", uriVariables);

		return httpClientAdapter.requestAsync("POST", url, form.encode("", new ArrayList<Entry<String, Object>>()),
				rejectRefundType, false, callable);
	}

	/**
	 * 确认退款
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>refund/Confirm</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>Form:</b>ConfirmRefundFormrefund</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @param confirmRefundForm 退款id和退款金额 
	 * @see java.lang.String
	 * @see ConfirmRefundForm

	 */
	public java.lang.String refundData(ConfirmRefundForm confirmRefundForm) {
		Result<java.lang.String> result = refund(confirmRefundForm);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			throw new RuntimeException(ex.getMessage(), ex);
		}
		return result.getData();
	}

	/**
	 * 确认退款
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>refund/Confirm</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>Form:</b>ConfirmRefundFormrefund</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @param confirmRefundForm 退款id和退款金额 
	 * @see java.lang.String
	 * @see ConfirmRefundForm

	 */
	public Result<java.lang.String> refund(ConfirmRefundForm confirmRefundForm) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("refund/Confirm", uriVariables);

		return httpClientAdapter.request("GET", url,
				confirmRefundForm.encode("", new ArrayList<Entry<String, Object>>()), refundType, false);
	}

	/**
	 * 确认退款
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>refund/Confirm</b>
	 * <ul>
	 * <li><b>Method:</b> GET</li>
	 * <li><b>Form:</b>ConfirmRefundFormrefund</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @param confirmRefundForm 退款id和退款金额 
	 * @see java.lang.String
	 * @see ConfirmRefundForm

	 */
	public Future<?> refund(ConfirmRefundForm confirmRefundForm, Callback<java.lang.String> callable) {
		Map<String, Object> uriVariables = new HashMap<>();
		String url = expandUriComponent("refund/Confirm", uriVariables);

		return httpClientAdapter.requestAsync("GET", url,
				confirmRefundForm.encode("", new ArrayList<Entry<String, Object>>()), refundType, false, callable);
	}

	private static final ApiType newApplyType = type(Result.class, type(Void.class));
	private static final ApiType rejectRefundType = type(Result.class, type(Void.class));
	private static final ApiType refundType = type(Result.class, type(java.lang.String.class));
}