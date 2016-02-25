package cn.ihealthbaby.hospital.services;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.isnowfox.util.ZipUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ihealthbaby.data.db.dao.readonly.AdviceAskReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.AdviceDataReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.AdviceEcgDataReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.AdviceReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.AdviceReplyReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalAdviceSettingReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.ServiceInsideReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.ServiceReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.UserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.AdviceAskDO;
import cn.ihealthbaby.data.db.entity.AdviceDO;
import cn.ihealthbaby.data.db.entity.AdviceDataDO;
import cn.ihealthbaby.data.db.entity.AdviceEcgDataDO;
import cn.ihealthbaby.data.db.entity.AdviceReplyDO;
import cn.ihealthbaby.data.db.entity.HospitalAdviceSettingDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.data.db.entity.UserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.AdviceDataForm;
import cn.ihealthbaby.hospital.db.dao.cache.CatOptionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.NstOptionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.ReportSettingsCacheDao;
import cn.ihealthbaby.hospital.db.entity.CatOptionDO;
import cn.ihealthbaby.hospital.db.entity.NstOptionDO;
import cn.ihealthbaby.hospital.db.entity.ReportSettingsDO;
import cn.ihealthbaby.hospital.form.AdviceAskForm;
import cn.ihealthbaby.hospital.form.AdviceReadDataForm;
import cn.ihealthbaby.hospital.form.ReplyQueryForm;
import cn.ihealthbaby.hospital.helps.SqlUtils;
import cn.ihealthbaby.hospital.model.Advice;
import cn.ihealthbaby.hospital.model.PDFModel;
import cn.ihealthbaby.hospital.model.ReplyDataModel;

import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParams;
import com.isnowfox.util.DateTimeUtils;

/**
 * Created by qiangon 2015/8/10.
 */
@Service
public class AdviceService {
	private static final int MAX = 10000;
	private static final int PAGE_MAX = 200;
	@Autowired
	private AdviceEcgDataReadOnlyDao adviceEcgDataReadOnlyDao;
	@Autowired
	private AdviceReadOnlyDao adviceReadOnlyDao;
	@Autowired
	private AdviceAskReadOnlyDao adviceAskReadOnlyDao;
	@Autowired
	private UserReadOnlyDao userReadOnlyDao;
	@Autowired
	private SysUserReadOnlyDao sysUserReadOnlyDao;
	@Autowired
	private HospitalReadOnlyDao hospitalReadOnlyDao;
	@Autowired
	private NstOptionCacheDao nstOptionCacheDao;
	@Autowired
	private CatOptionCacheDao catOptionCacheDao;
	@Autowired
	private ServiceReadOnlyDao serviceReadOnlyDao;
	@Autowired
	private AdviceReplyReadOnlyDao adviceReplyReadOnlyDao;
	@Autowired
	private ReportSettingsCacheDao reportSettingsCacheDao;
	@Autowired
	private AdviceDataReadOnlyDao adviceDataReadOnlyDao;
	@Autowired
	private PDFReportService pdfReportService;
	@Autowired
	private PDFDrawService pdfDrawService;
	@Autowired
	private ServiceInsideReadOnlyDao serviceInsideReadOnlyDao;
	@Autowired
	private ApiManager apiManager;
	@Autowired
	private HospitalAdviceSettingReadOnlyDao hospitalAdviceSettingReadOnlyDao;

	public AdviceEcgDataDO getAdviceEcgData(long id) throws Exception {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(AdviceEcgDataDO.ThisTableInfo.ADVICE_ID_DB_NAME, id);
		AdviceEcgDataDO adviceEcgDataDO=adviceEcgDataReadOnlyDao.findObject(queryParams);
		adviceEcgDataDO.setData(ZipUtils.decompression(adviceEcgDataDO.getDataBlob()));
		return adviceEcgDataDO;
	}

	public AdviceAskForm getAdivceDetail(long id) throws Exception {
		AdviceAskDO adviceAskDO = adviceAskReadOnlyDao.get(id);
		AdviceDO adviceDO = adviceReadOnlyDao.get(adviceAskDO.getAdviceId());
		UserDO userDO = userReadOnlyDao.get(adviceAskDO.getUserId());
		HospitalDO hospitalDO = hospitalReadOnlyDao.get(adviceAskDO
				.getHospitalId());
		SysUserDO sysUserDO = sysUserReadOnlyDao.get(adviceAskDO.getDoctorId());

		AdviceAskForm form = new AdviceAskForm();
		BeanUtils.copyProperties(adviceAskDO, form);
		form.setAdviceDO(adviceDO);
		form.setHospitalDO(hospitalDO);
		form.setSysUserDO(sysUserDO);
		form.setUserDO(userDO);
		form.setAge(DateTimeUtils.getAge(userDO.getBirthday()));
		if (adviceDO.getAdviceType() == 1) {

			form.setServiceDO(serviceReadOnlyDao.get(adviceDO.getServiceId()));
		} else {

			form.setServiceInsideDO(serviceInsideReadOnlyDao.get(adviceDO
					.getServiceId()));
		}

		form.setNstList(nstOptionCacheDao.find(
				MAX,
				QueryParams.create().add(
						NstOptionDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
						adviceAskDO.getHospitalId()),
				Order.asc(NstOptionDO.ThisTableInfo.LEVEL_DB_NAME)));
		form.setCatList(catOptionCacheDao.find(
				MAX,
				QueryParams.create().add(
						CatOptionDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
						adviceAskDO.getHospitalId()),
				Order.asc(CatOptionDO.ThisTableInfo.LEVEL_DB_NAME)));
		form.setReportSettingsDO(reportSettingsCacheDao.findObject(QueryParams
				.create().add(
						ReportSettingsDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
						adviceAskDO.getHospitalId())));
		return form;
	}

	public PageResult<ReplyDataModel> getReplyList(ReplyQueryForm form) {
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
		List<ReplyDataModel> list = new ArrayList<>();
		String sql = "SELECT %s FROM (\n"
				+ "SELECT\n"
				+ "advice_reply.*\n"
				+ "FROM\n"
				+ "advice_reply\n"
				+ "LEFT JOIN advice ON advice_reply.advice_id = advice.id\n"
				+ "LEFT JOIN sys_user ON advice_reply.doctor_id = sys_user.id\n"
				+ "LEFT JOIN `user` ON advice_reply.user_id = `user`.id\n"
				+ "WHERE\n" + "1 = 1\n";
		if (form.getAdviceType() != -1) {
			sql += "AND `advice`.`advice_type` = '" + form.getAdviceType()
					+ "'\n";
		}
		if (StringUtils.isNotBlank(form.getUsername())) {
			sql += "AND `user`.`name` like '%%"
					+ SqlUtils.Sqlfilter(form.getUsername()) + "%%'\n";
		}
		if (StringUtils.isNotBlank(form.getDoctorname())) {
			sql += "AND `sys_user`.`name` like '%%"
					+ SqlUtils.Sqlfilter(form.getDoctorname()) + "%%'\n";
		}
		if (StringUtils.isNotBlank(form.getAdviceId())) {
			sql += "AND `advice`.`advice_number` ='"
					+ SqlUtils.Sqlfilter(form.getAdviceId()) + "'\n";
		}
		if (form.getReplyResult() != -2) {
			sql += "AND `advice_reply`.`reply_result` ='"
					+ form.getReplyResult() + "'\n";
		}
		sql += "ORDER BY\n" + "advice_reply.reply_time DESC\n";
		sql += ") tt";
		PageResult<AdviceReplyDO> page = adviceReplyReadOnlyDao.fastQueryPage(
				sql, (new AdviceReplyDO()).getTableInfo().getRowMapper(),
				form.getPage(), pageSize);
		for (AdviceReplyDO adviceReplyDO : page.getValue()) {
			ReplyDataModel model = new ReplyDataModel();
			BeanUtils.copyProperties(adviceReplyDO, model);
			AdviceAskDO adviceAskDO = adviceAskReadOnlyDao.get(adviceReplyDO
					.getAskId());
			model.setAdviceDO(adviceReadOnlyDao.get(adviceReplyDO.getAdviceId()));
			model.setAdviceAskDO(adviceAskDO);
			model.setSysUserDO(sysUserReadOnlyDao.get(adviceReplyDO
					.getDoctorId()));
			model.setServiceDO(serviceReadOnlyDao.get(adviceAskDO
					.getServiceId()));
			model.setUserDO(userReadOnlyDao.get(adviceReplyDO.getUserId()));
			list.add(model);
		}
		return PageResult.createPage(page.getCount(), page.getPage(),
				page.getPageSize(), list);
	}

	public PageResult<ReplyDataModel> getReplyListHospital(ReplyQueryForm form,
			UserAccount account) {
		int pageSize = Math.min(form.getPageSize(), PAGE_MAX);
		List<ReplyDataModel> list = new ArrayList<>();
		String sql = "SELECT %s FROM (\n"
				+ "SELECT\n"
				+ "advice_reply.*\n"
				+ "FROM\n"
				+ "advice_reply\n"
				+ "LEFT JOIN advice ON advice_reply.advice_id = advice.id\n"
				+ "LEFT JOIN sys_user ON advice_reply.doctor_id = sys_user.id\n"
				+ "LEFT JOIN `user` ON advice_reply.user_id = `user`.id\n"
				+ "WHERE\n" + "advice_reply.hospital_id = "
				+ account.getSysUserDO().getHospitalId() + "\n";
		if (form.getAdviceType() != -1) {
			sql += "AND `advice`.`advice_type` = '" + form.getAdviceType()
					+ "'\n";
		}
		if (StringUtils.isNotBlank(form.getUsername())) {
			sql += "AND `user`.`name` like '%%"
					+ SqlUtils.Sqlfilter(form.getUsername()) + "%%'\n";
		}
		if (StringUtils.isNotBlank(form.getDoctorname())) {
			sql += "AND `sys_user`.`name` like '%%"
					+ SqlUtils.Sqlfilter(form.getDoctorname()) + "%%'\n";
		}
		if (StringUtils.isNotBlank(form.getAdviceId())) {
			sql += "AND `advice`.`advice_number` ='"
					+ SqlUtils.Sqlfilter(form.getAdviceId()) + "'\n";
		}
		if (form.getReplyResult() != -2) {
			sql += "AND `advice_reply`.`reply_result` ='"
					+ form.getReplyResult() + "'\n";
		}
		sql += "ORDER BY\n" + "advice_reply.reply_time DESC\n";
		sql += ") tt";
		PageResult<AdviceReplyDO> page = adviceReplyReadOnlyDao.fastQueryPage(
				sql, (new AdviceReplyDO()).getTableInfo().getRowMapper(),
				form.getPage(), pageSize);
		for (AdviceReplyDO adviceReplyDO : page.getValue()) {
			ReplyDataModel model = new ReplyDataModel();
			BeanUtils.copyProperties(adviceReplyDO, model);
			AdviceAskDO adviceAskDO = adviceAskReadOnlyDao.get(adviceReplyDO
					.getAskId());
			model.setAdviceDO(adviceReadOnlyDao.get(adviceReplyDO.getAdviceId()));
			model.setAdviceAskDO(adviceAskDO);
			model.setSysUserDO(sysUserReadOnlyDao.get(adviceReplyDO
					.getDoctorId()));
			model.setServiceDO(serviceReadOnlyDao.get(adviceAskDO
					.getServiceId()));
			model.setUserDO(userReadOnlyDao.get(adviceReplyDO.getUserId()));
			list.add(model);
		}
		return PageResult.createPage(page.getCount(), page.getPage(),
				page.getPageSize(), list);
	}

	public ReplyDataModel getReplyDataDetail(long id) throws Exception {
		AdviceReplyDO adviceReplyDO = adviceReplyReadOnlyDao.get(id);
		ReplyDataModel model = new ReplyDataModel();
		BeanUtils.copyProperties(adviceReplyDO, model);
		HospitalDO hospitalDO = hospitalReadOnlyDao.get(adviceReplyDO
				.getHospitalId());
		AdviceAskDO adviceAskDO = adviceAskReadOnlyDao.get(adviceReplyDO
				.getAskId());
		AdviceDO adviceDO = adviceReadOnlyDao.get(adviceReplyDO.getAdviceId());
		model.setAdviceDO(adviceDO);
		model.setAdviceAskDO(adviceAskDO);
		model.setSysUserDO(sysUserReadOnlyDao.get(adviceReplyDO.getDoctorId()));

		UserDO userDO = userReadOnlyDao.get(adviceReplyDO.getUserId());
		model.setUserDO(userDO);
		model.setHospitalDO(hospitalDO);
		if (adviceDO.getAdviceType() == 1) {

			model.setServiceDO(serviceReadOnlyDao.get(adviceDO.getServiceId()));
		} else {

			model.setServiceInsideDO(serviceInsideReadOnlyDao.get(adviceDO
					.getServiceId()));
		}
		model.setNstList(nstOptionCacheDao.find(
				MAX,
				QueryParams.create().add(
						NstOptionDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
						adviceAskDO.getHospitalId())));
		model.setCatList(catOptionCacheDao.find(
				MAX,
				QueryParams.create().add(
						CatOptionDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
						adviceAskDO.getHospitalId())));
		model.setAge(DateTimeUtils.getAge(userDO.getBirthday()));
		model.setReportSettingsDO(reportSettingsCacheDao.findObject(QueryParams
				.create().add(
						ReportSettingsDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
						adviceAskDO.getHospitalId())));
		return model;
	}

	public List<Advice> getAdvices(long serviceId) throws Exception {

		QueryParams params = QueryParams.create();
		params.add(AdviceDO.ThisTableInfo.SERVICE_ID_DB_NAME, serviceId)
				.add(AdviceDO.ThisTableInfo.ADVICE_TYPE_DB_NAME, 1)
				.add(AdviceDO.ThisTableInfo.STATUS_DB_NAME, 2);
		List<AdviceDO> adviceDOs = adviceReadOnlyDao.find(MAX, params);
		List<Advice> advices = new ArrayList<Advice>();
		for (AdviceDO adviceDO : adviceDOs) {
			Advice advice = new Advice();
			BeanUtils.copyProperties(adviceDO, advice);
			advice.setDoctorName(sysUserReadOnlyDao.get(adviceDO.getDoctorId())
					.getName());
			advices.add(advice);
		}
		return advices;
	}
	public Result readData(AdviceReadDataForm adviceReadDataForm)
			throws Exception {
		AdviceDataForm dataForm = new AdviceDataForm();
		BeanUtils.copyProperties(adviceReadDataForm, dataForm);
		dataForm.setReplyType(1);
		dataForm.setReplyTime(new Date());
		return apiManager.adminAdviceApi.addAdviceReadData(dataForm);
	}

	public AdviceDataDO getAdviceData(long id, int type) throws Exception {
		AdviceDataDO adviceDataDO = adviceDataReadOnlyDao.findObject(
				AdviceDataDO.ThisTableInfo.ADVICE_ID_DB_NAME, id,
				AdviceDataDO.ThisTableInfo.TYPE_DB_NAME, type);
		return adviceDataDO;
	}

	public ByteArrayOutputStream createReportPDF(long id) throws Exception {
		PDFModel pdfModel = new PDFModel();
		AdviceAskForm form = getAdivceDetail(id);
		BeanUtils.copyProperties(form, pdfModel);
		AdviceEcgDataDO adviceEcgDataDO = getAdviceEcgData(form.getAdviceDO()
				.getId());
		AdviceDataDO adviceDataDO = getAdviceData(form.getAdviceDO().getId(), 0);
		AdviceReplyDO adviceReplyDO = adviceReplyReadOnlyDao.findObject(
				AdviceReplyDO.ThisTableInfo.ADVICE_ID_DB_NAME, form
						.getAdviceDO().getId());
		if (adviceReplyDO != null) {
			pdfModel.setAdviceReplyDO(adviceReplyDO);
		}
		pdfModel.setAdviceDataDO(adviceDataDO);
		pdfModel.setAdviceEcgDataDO(adviceEcgDataDO);
		pdfModel.setHospitalAdviceSettingDO(hospitalAdviceSettingReadOnlyDao
				.findObject(
						HospitalAdviceSettingDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
						pdfModel.getHospitalDO().getId()));
		return pdfReportService.createPdf(pdfModel);
	}

	public ByteArrayOutputStream createDrawPDF(long id) throws Exception {
		PDFModel pdfModel = new PDFModel();
		AdviceAskForm form = getAdivceDetail(id);
		BeanUtils.copyProperties(form, pdfModel);
		AdviceEcgDataDO adviceEcgDataDO = getAdviceEcgData(form.getAdviceDO()
				.getId());
		pdfModel.setAdviceEcgDataDO(adviceEcgDataDO);
		pdfModel.setHospitalAdviceSettingDO(hospitalAdviceSettingReadOnlyDao
				.findObject(
						HospitalAdviceSettingDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,
						pdfModel.getHospitalDO().getId()));
		return pdfDrawService.createPdf(pdfModel);
	}

	public HospitalAdviceSettingDO getSettingDO(long id) {
		return hospitalAdviceSettingReadOnlyDao.findObject(
				HospitalAdviceSettingDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, id);
	}
}
