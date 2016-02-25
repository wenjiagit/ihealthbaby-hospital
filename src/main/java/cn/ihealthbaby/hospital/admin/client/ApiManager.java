package cn.ihealthbaby.hospital.admin.client;

import cn.ihealthbaby.hospital.admin.client.api.AdminAdviceApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminDataApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminDeviceApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminDoctorApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminErpUserApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminHospitalApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminOrderApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminProductApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminRedisApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminRefundApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminServiceApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminSettingApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminTestApi;
import cn.ihealthbaby.hospital.admin.client.api.AdminUserApi;

/**
 * api 管理器，单例，使用之前需要初始化
 * @author zuoge85 on 15/6/15.
 */
public class ApiManager {
	private static ApiManager instance;

	/**
	 * 初始化
	 */
	public static void init(HttpClientAdapter httpClientAdapter) {
		instance = new ApiManager(httpClientAdapter);
	}

	public static ApiManager getInstance() {
		return instance;
	}

	private HttpClientAdapter httpClientAdapter;

	/**
	 * @author  qiang
	 */
	public final AdminAdviceApi adminAdviceApi;

	/**
	 * 初始修改数据
	 */
	public final AdminDataApi adminDataApi;

	/**
	 * 设备相关的api,包括添加设备到医院,
	 * @author  gwc
	 */
	public final AdminDeviceApi adminDeviceApi;

	/**
	 * 医生相关的api,包括添加,修改,删除,条件查询
	 * @author  gwc
	 */
	public final AdminDoctorApi adminDoctorApi;

	/**
	 * erp用户相关的api,包括添加,修改,条件查询
	 * @author  qiang
	 */
	public final AdminErpUserApi adminErpUserApi;

	/**
	 * 医院相关订的api,包括增加,删除,更新
	 * @author  gwc
	 */
	public final AdminHospitalApi adminHospitalApi;

	/**
	 * @author  qiang on 2015/8/26. jinliqiang@ihbaby.com
	 */
	public final AdminOrderApi adminOrderApi;

	/**
	 * Created by qiang on 2015/8/10.
	 */
	public final AdminProductApi adminProductApi;

	/**
	 * @author  设置redis服务单号和咨询单号的redis初始值
	 */
	public final AdminRedisApi adminRedisApi;

	/**
	 * @author  qiang on 2015/9/6. jinliqiang@ihbaby.com
	 */
	public final AdminRefundApi adminRefundApi;

	/**
	 * 监护服务的相关api,包括开通监护,结算,打印清单等
	 * @author  qiang
	 */
	public final AdminServiceApi adminServiceApi;

	/**
	 * 设置相关的api,租赁设置,监护设置
	 * @author  gwc
	 */
	public final AdminSettingApi adminSettingApi;

	/**
	 * http://www.cnblogs.com/yuzhongwusan/p/3152526.html
	 * http://www.ruanyifeng.com/blog/2014/05/restful_api.html
	 * @author  zuoge85 on 15/6/11.
	 */
	public final AdminTestApi adminTestApi;

	/**
	 * 孕妇用户管理的api,
	 * @author  gwc
	 */
	public final AdminUserApi adminUserApi;

	public ApiManager(HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;

		adminAdviceApi = new AdminAdviceApi(httpClientAdapter);
		adminDataApi = new AdminDataApi(httpClientAdapter);
		adminDeviceApi = new AdminDeviceApi(httpClientAdapter);
		adminDoctorApi = new AdminDoctorApi(httpClientAdapter);
		adminErpUserApi = new AdminErpUserApi(httpClientAdapter);
		adminHospitalApi = new AdminHospitalApi(httpClientAdapter);
		adminOrderApi = new AdminOrderApi(httpClientAdapter);
		adminProductApi = new AdminProductApi(httpClientAdapter);
		adminRedisApi = new AdminRedisApi(httpClientAdapter);
		adminRefundApi = new AdminRefundApi(httpClientAdapter);
		adminServiceApi = new AdminServiceApi(httpClientAdapter);
		adminSettingApi = new AdminSettingApi(httpClientAdapter);
		adminTestApi = new AdminTestApi(httpClientAdapter);
		adminUserApi = new AdminUserApi(httpClientAdapter);
	}
}
