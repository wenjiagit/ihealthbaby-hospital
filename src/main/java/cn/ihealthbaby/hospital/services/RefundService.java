package cn.ihealthbaby.hospital.services;

import cn.ihealthbaby.data.db.dao.readonly.*;
import cn.ihealthbaby.data.db.entity.*;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.*;
import cn.ihealthbaby.hospital.db.dao.cache.CatOptionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.NstOptionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.ReportSettingsCacheDao;
import cn.ihealthbaby.hospital.db.entity.CatOptionDO;
import cn.ihealthbaby.hospital.db.entity.NstOptionDO;
import cn.ihealthbaby.hospital.db.entity.ReportSettingsDO;
import cn.ihealthbaby.hospital.form.RefundQueryForm;
import cn.ihealthbaby.hospital.model.HospitalPackageModel;
import cn.ihealthbaby.hospital.model.RefundModel;
import cn.ihealthbaby.hospital.model.RentSetModel;
import cn.ihealthbaby.hospital.model.ReportSettingModel;
import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParam;
import com.isnowfox.core.dao.QueryParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by qiang on 2015/8/10.
 */
@Service
public class RefundService {
    private static final Logger logger = Logger.getLogger(RefundService.class);
    private static final int PAGESIZE_MAX = 200;
    private static  final  int MAX=10000;
    @Autowired
    private ApiManager apiManager;
    @Autowired
    private ServiceReadOnlyDao serviceReadOnlyDao;
    @Autowired
    private RefundReadOnlyDao refundReadOnlyDao;

    public PageResult<RefundModel> refundApplyList(RefundQueryForm form){
        QueryParams queryParams = QueryParams.create();
        queryParams.add(RefundDO.ThisTableInfo.STATUS_DB_NAME,0);
        if(StringUtils.isNotBlank(form.getName())){
            queryParams.add(RefundDO.ThisTableInfo.NAME_DB_NAME,"%"+form.getName()+"%", QueryParam.OperatorType.LIKE);
        }
        if(StringUtils.isNotBlank(form.getMobile())){
            queryParams.add(RefundDO.ThisTableInfo.MOBILE_DB_NAME,form.getMobile());
        }
        if(StringUtils.isNotBlank(form.getHospitalName())){
            queryParams.add(RefundDO.ThisTableInfo.HOSPITAL_NAME_DB_NAME,form.getHospitalName());
        }
        if(form.getPayType()!=-1){
            queryParams.add(RefundDO.ThisTableInfo.PAY_TYPE_DB_NAME,form.getPayType());
        }
        if(StringUtils.isNotBlank(form.getOrderId())){
            if(form.getOrderId().matches("\\d*")) {
                queryParams.add(RefundDO.ThisTableInfo.ORDER_ID_DB_NAME,form.getOrderId());
            }
        }
        List<RefundModel> list = new ArrayList<>();
        int pageSize=form.getPageSize();
        pageSize=Math.min(pageSize,PAGESIZE_MAX);
        PageResult<RefundDO> result = refundReadOnlyDao.findPage(queryParams,form.getPage(),pageSize);
        for (RefundDO refundDO:result.getValue()){
            RefundModel refundModel = new RefundModel();
            BeanUtils.copyProperties(refundDO, refundModel);
            refundModel.setServiceDO(serviceReadOnlyDao.get(refundDO.getServiceId()));
            list.add(refundModel);
        }
        return PageResult.createPage(result.getCount(),result.getPage(),result.getPageSize(),list);
    }

    public PageResult<RefundModel> refundHistoryList(RefundQueryForm form) {
        QueryParams queryParams = QueryParams.create();
        queryParams.add(RefundDO.ThisTableInfo.STATUS_DB_NAME,0,QueryParam.OperatorType.GT);
        if(StringUtils.isNotBlank(form.getName())){
            queryParams.add(RefundDO.ThisTableInfo.NAME_DB_NAME,"%"+form.getName()+"%", QueryParam.OperatorType.LIKE);
        }
        if(StringUtils.isNotBlank(form.getMobile())){
            queryParams.add(RefundDO.ThisTableInfo.MOBILE_DB_NAME,form.getMobile());
        }
        if(StringUtils.isNotBlank(form.getHospitalName())){
            queryParams.add(RefundDO.ThisTableInfo.HOSPITAL_NAME_DB_NAME,form.getHospitalName());
        }
        if(form.getPayType()!=-1){
            queryParams.add(RefundDO.ThisTableInfo.PAY_TYPE_DB_NAME,form.getPayType());
        }
        if(StringUtils.isNotBlank(form.getOrderId())){
            if(form.getOrderId().matches("\\d*")) {
                queryParams.add(RefundDO.ThisTableInfo.ORDER_ID_DB_NAME,form.getOrderId());
            }
        }
        int pageSize=form.getPageSize();
        List<RefundModel> list = new ArrayList<>();
        pageSize=Math.min(pageSize, PAGESIZE_MAX);
        PageResult<RefundDO> result = refundReadOnlyDao.findPage(queryParams,form.getPage(),pageSize);
        for (RefundDO refundDO:result.getValue()){
            RefundModel refundModel = new RefundModel();
            BeanUtils.copyProperties(refundDO, refundModel);
            refundModel.setServiceDO(serviceReadOnlyDao.get(refundDO.getServiceId()));
            list.add(refundModel);
        }
        return PageResult.createPage(result.getCount(),result.getPage(),result.getPageSize(),list);
    }
    public Result newApply(NewApplyForm form,UserAccount account){
        form.setApplicant(account.getSysUserDO().getName());
        return apiManager.adminRefundApi.newApply(form);
    }

    public RefundDO getRefund(long serviceId) {
        RefundDO refundDO = refundReadOnlyDao.findObject(RefundDO.ThisTableInfo.SERVICE_ID_DB_NAME,serviceId);
        return refundDO;
    }

    public Result rejectRefund(RejectForm form, UserAccount account) {
        form.setApprover(account.getSysUserDO().getName());
        return apiManager.adminRefundApi.rejectRefund(form);
    }
    public Result refundDeal(ConfirmRefundForm form){
        return apiManager.adminRefundApi.refund(form);
    }
}
