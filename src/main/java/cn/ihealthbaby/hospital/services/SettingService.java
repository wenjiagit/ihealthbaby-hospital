package cn.ihealthbaby.hospital.services;

import cn.ihealthbaby.data.db.dao.readonly.HospitalAdviceSettingReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalPackageSettingReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.ProductReadOnlyDao;
import cn.ihealthbaby.data.db.entity.HospitalAdviceSettingDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.HospitalPackageSettingDO;
import cn.ihealthbaby.data.db.entity.ProductDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.admin.client.form.ProductForm;
import cn.ihealthbaby.hospital.admin.client.form.ServiceSettingForm;
import cn.ihealthbaby.hospital.db.dao.cache.CatOptionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.NstOptionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.ReportSettingsCacheDao;
import cn.ihealthbaby.hospital.db.entity.CatOptionDO;
import cn.ihealthbaby.hospital.db.entity.NstOptionDO;
import cn.ihealthbaby.hospital.db.entity.ReportSettingsDO;
import cn.ihealthbaby.hospital.model.HospitalPackageModel;
import cn.ihealthbaby.hospital.model.RentSetModel;
import cn.ihealthbaby.hospital.model.ReportSettingModel;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParams;
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
public class SettingService {
    private static final Logger logger = Logger.getLogger(SettingService.class);
    @Autowired
    private ApiManager apiManager;
    @Autowired
    private ReportSettingsCacheDao reportSettingsCacheDao;
    @Autowired
    private NstOptionCacheDao nstOptionCacheDao;
    @Autowired
    private CatOptionCacheDao catOptionCacheDao;
    @Autowired
    private ProductReadOnlyDao productReadOnlyDao;
    @Autowired
    private HospitalPackageSettingReadOnlyDao hospitalPackageSettingReadOnlyDao;
    @Autowired
    private HospitalReadOnlyDao hospitalReadOnlyDao;
    @Autowired
    private HospitalAdviceSettingReadOnlyDao hospitalAdviceSettingReadOnlyDao;

    private static  final  int MAX=10000;
    public ReportSettingModel getReportSetting(UserAccount account){
        QueryParams params = QueryParams.create();
        params.add(ReportSettingsDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, account.getSysUserDO().getHospitalId());
        ReportSettingsDO reportSettingsDO = reportSettingsCacheDao.findObject(params);
        List<NstOptionDO> nstOptionDOlist = nstOptionCacheDao.find(MAX, QueryParams.create()
                .add(NstOptionDO.ThisTableInfo.HOSPITAL_ID_DB_NAME
                        , account.getSysUserDO().getHospitalId()),Order.asc(NstOptionDO.ThisTableInfo.ID_DB_NAME));
        List<CatOptionDO> catOptionDOlist = catOptionCacheDao.find(MAX, QueryParams.create()
                .add(CatOptionDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, account.getSysUserDO().getHospitalId()), Order.asc(CatOptionDO.ThisTableInfo.ID_DB_NAME));
        ReportSettingModel model =new ReportSettingModel();
        if(reportSettingsDO!=null) {
            BeanUtils.copyProperties(reportSettingsDO, model);
        }
        model.setCatOptionlist(catOptionDOlist);
        model.setNstOptionlist(nstOptionDOlist);
        return model;
    }
    public void addCat(String name,String detail,int level,UserAccount account){
        CatOptionDO catOptionDO = new CatOptionDO();
        catOptionDO.setCatOptionName(name);
        catOptionDO.setCatOptionDetail(detail);
        catOptionDO.setLevel(level);
        catOptionDO.setHospitalId(account.getSysUserDO().getHospitalId());
        catOptionCacheDao.insert(catOptionDO);
    }
    public void addNst(String name,String detail,int level,UserAccount account){
        NstOptionDO nstOptionDO = new NstOptionDO();
        nstOptionDO.setNstOptionName(name);
        nstOptionDO.setNstOptionDetail(detail);
        nstOptionDO.setLevel(level);
        nstOptionDO.setHospitalId(account.getSysUserDO().getHospitalId());
        nstOptionCacheDao.insert(nstOptionDO);
    }
    public void delNst(long id){
        nstOptionCacheDao.del(nstOptionCacheDao.get(id).getKey());
    }
    public void delCat(long id){
        catOptionCacheDao.del(catOptionCacheDao.get(id).getKey());
    }
    public void updateSetParams(int paperspeed,int divisionX,int divisionY,long id,double zoom){
        ReportSettingsDO reportSettingsDO = reportSettingsCacheDao.get(id);
        reportSettingsDO.setPaperspeed(paperspeed);
        reportSettingsDO.setDivisionX(divisionX);
        reportSettingsDO.setDivisionY(divisionY);
        reportSettingsDO.setZoom(zoom);
        reportSettingsCacheDao.update(reportSettingsDO);
    }

    /**
     * 控制打印数据显隐
     * @param reportPrintView
     * @param reportPrintNstView
     * @param reportPrintCatView
     * @param id
     */
    public void updateShowHide( boolean reportPrintView, boolean reportPrintNstView,boolean reportPrintCatView,long id){
        ReportSettingsDO reportSettingsDO = reportSettingsCacheDao.get(id);
        reportSettingsDO.setReportPrintView(reportPrintView);
        reportSettingsDO.setReportPrintNstView(reportPrintNstView);
        reportSettingsDO.setReportPrintCatView(reportPrintCatView);
        reportSettingsCacheDao.update(reportSettingsDO);
    }

    /**
     *
     * @param signpageView
     * @param signpageNstView
     * @param signpageCatView
     * @param id
     */

    public void updateSignShowHide( boolean signpageView, boolean signpageNstView,boolean signpageCatView,long id){
        ReportSettingsDO reportSettingsDO = reportSettingsCacheDao.get(id);
        reportSettingsDO.setSignpageView(signpageView);
        reportSettingsDO.setSignpageNstView(signpageNstView);
        reportSettingsDO.setSignpageCatView(signpageCatView);
        reportSettingsCacheDao.update(reportSettingsDO);
    }

    /**
     * 初始化租赁设置数据
     * @param hosid
     * @return
     */
    public RentSetModel getRentInitData(Long hosid){
      //设备押金可用列表
        QueryParams params1 =QueryParams.create();
        params1.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,hosid);
        params1.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME,0);
        params1.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME,1);
        List<ProductDO> foregift = productReadOnlyDao.find(MAX, params1);
        //租金可用列表
        QueryParams params3 =QueryParams.create();
        params3.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,hosid);
        params3.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME,2);
        params3.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME,1);
        List<ProductDO> dayRent = productReadOnlyDao.find(MAX,params3);
        //耦合剂可用列表
        QueryParams params2 =QueryParams.create();
        params2.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,hosid);
        params2.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME,1);
        params2.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, 1);
        List<ProductDO> couplant = productReadOnlyDao.find(MAX,params2);
        //咨询费可用列表
        QueryParams params4 =QueryParams.create();
        params4.add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,hosid);
        params4.add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME,3);
        params4.add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME, 1);
        List<ProductDO> askPrice = productReadOnlyDao.find(MAX,params4);
        RentSetModel rentSetModel = new RentSetModel();
        rentSetModel.setForegift(foregift);
        rentSetModel.setDayRent(dayRent);
        rentSetModel.setAskPrice(askPrice);
        rentSetModel.setCouplant(couplant);
        return rentSetModel;
    }
    public void addProduct(String name,int price,int amount,int maxamount,int chargeType,String type,String description,UserAccount account){
        ProductForm form = new ProductForm();
        form.setName(name);
        form.setPrice(price);
        form.setIsUsable(true);
        form.setChargeType(chargeType);
        form.setMaxAmount(maxamount);
        form.setHospitalId(account.getSysUserDO().getHospitalId());
        form.setDescription(description);
        if(type.equals("foregift")){
            form.setProductType(0);
            form.setInnerAmount(amount);
        }else if(type.equals("dayRent")){
            form.setProductType(2);
            form.setInnerAmount(amount);
        }else if(type.equals("askPrice")){
            form.setProductType(3);
            if(amount==0){
                ProductDO productDO = getSinglePrice(account.getSysUserDO().getHospitalId(),4);
                form.setInnerAmount(price/productDO.getPrice());
            }else{
                form.setInnerAmount(amount);
            }

        }else if(type.equals("couplant")){
            form.setProductType(1);
            form.setInnerAmount(amount);
        }
        apiManager.adminProductApi.addProuct(form);
    }

    /**
     * 修改设备押金
     * @param id
     * @param name
     * @param price
     * @param amount
     * @param maxamount
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Result updateForgift( long id, String name, int price, int amount, int maxamount,String description){
        ProductDO productDO = productReadOnlyDao.get(id);
        ProductForm form =new ProductForm();
        BeanUtils.copyProperties(productDO, form);
        form.setName(name);
        form.setPrice(price);
        form.setInnerAmount(amount);
        form.setMaxAmount(maxamount);
        form.setProductType(0);
        form.setDescription(description);
        Result result=apiManager.adminProductApi.updateProuct(id,form);
        return result;
    }

    public Result delForegift(long id) {
        return apiManager.adminProductApi.delProduct(id);
    }

    /**
     * 修改租金
     * @param id
     * @param name
     * @param price
     * @param amount
     * @return
     */
    public Result updateDayRent(long id, String name, int price, int amount ,int maxamount,String description) {
        ProductDO productDO = productReadOnlyDao.get(id);
        ProductForm form =new ProductForm();
        BeanUtils.copyProperties(productDO, form);
        form.setName(name);
        form.setPrice(price);
        form.setInnerAmount(amount);
        form.setProductType(2);
        form.setMaxAmount(maxamount);
        form.setDescription(description);
        return apiManager.adminProductApi.updateProuct(id, form);
    }

    /**
     * 修改咨询费
     * @param id
     * @param name
     * @param price
     * @param amount
     * @param chargeType
     * @return
     */
    public Result updateAskPrice(long id, String name, int price, int amount, int chargeType,int maxamount,String description,long hospitalId) {
        ProductDO productDO = productReadOnlyDao.get(id);
        ProductForm form =new ProductForm();
        BeanUtils.copyProperties(productDO, form);
        form.setName(name);
        form.setPrice(price);
        if(amount==0){
            //此为单价
            if(productDO.getInnerAmount()!=1) {
                ProductDO single = getSinglePrice(hospitalId, 3);
                form.setInnerAmount(price/ single.getPrice());
            }
        }else{
            form.setInnerAmount(amount);
        }
        form.setChargeType(chargeType);
        form.setProductType(3);
        form.setMaxAmount(maxamount);
        form.setDescription(description);
        return apiManager.adminProductApi.updateProuct(id, form);
    }

    public Result updateCounplant(long id, String name, int price, int amount,int maxamount,String description) {
        ProductDO productDO = productReadOnlyDao.get(id);
        ProductForm form =new ProductForm();
        BeanUtils.copyProperties(productDO, form);
        form.setName(name);
        form.setPrice(price);
        form.setInnerAmount(amount);
        form.setProductType(1);
        form.setMaxAmount(maxamount);
        form.setDescription(description);
        return apiManager.adminProductApi.updateProuct(id, form);

    }

    /**
     * 获取医院套餐设置
     * @param hosid
     * @return
     */
    public HospitalPackageModel getHospitalPackage(Long hosid){
      HospitalPackageSettingDO hospitalPackageSettingDO= hospitalPackageSettingReadOnlyDao
              .findObject(HospitalPackageSettingDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, hosid);
        HospitalDO hospitalDO = hospitalReadOnlyDao.get(hosid);
        List<ProductDO> foregift = new ArrayList<>();
        List<ProductDO> dayRent = new ArrayList<>();
        List<ProductDO> askPrice = new ArrayList<>();
        List<ProductDO> couplant = new ArrayList<>();
        HospitalPackageModel model = new HospitalPackageModel();
        model.setHospitalDO(hospitalDO);
        for(Long id : hospitalPackageSettingDO.getProductArr()){
            ProductDO productDO = productReadOnlyDao.get(id);
            if(productDO.getProductType()==0){
                foregift.add(productDO);
            }else if(productDO.getProductType()==1){
                couplant.add(productDO);
            }else if(productDO.getProductType()==2){
                dayRent.add(productDO);
            }else {
                askPrice.add(productDO);
            }
        }
        model.setId(hospitalPackageSettingDO.getId());
        model.setAskPrice(askPrice);
        model.setCouplant(couplant);
        model.setDayRent(dayRent);
        model.setForgift(foregift);
        return model;
    }

    public Result addPackageItem(long id,long productId){
        return  apiManager.adminSettingApi.createHospitalPackageSetting(id,productId);
    }

    public Result removePackageItem(long id, long productId) {
        return  apiManager.adminSettingApi.removeItem(id, productId);
    }

    public ProductDO getSinglePrice(long hospitalId,int productType){
        ProductDO productDO = productReadOnlyDao.findObject(QueryParams.create().add(ProductDO.ThisTableInfo.PRODUCT_TYPE_DB_NAME,productType)
                .add(ProductDO.ThisTableInfo.IS_USABLE_DB_NAME,1).add(ProductDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,hospitalId)
                .add(ProductDO.ThisTableInfo.INNER_AMOUNT_DB_NAME,1));
        return productDO;
    }

    public Result serviceSetting(ServiceSettingForm form,long id){
        return apiManager.adminSettingApi.serviceSetting(id,form);
    }
    public HospitalAdviceSettingDO getAdvieSettingDetail(long hospitalId){
        return hospitalAdviceSettingReadOnlyDao.findObject(HospitalAdviceSettingDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, hospitalId);
    }
    

}
