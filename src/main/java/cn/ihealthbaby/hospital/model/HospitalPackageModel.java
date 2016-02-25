package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.ProductDO;

import java.util.List;

/**
 * Created by qiang on 2015/8/21.
 */
public class HospitalPackageModel {
    private long id;
    /**医院id*/
    private HospitalDO hospitalDO;

    List<ProductDO> forgift;

    List<ProductDO> dayRent;

    List<ProductDO> askPrice;

    List<ProductDO> couplant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HospitalDO getHospitalDO() {
        return hospitalDO;
    }

    public void setHospitalDO(HospitalDO hospitalDO) {
        this.hospitalDO = hospitalDO;
    }

    public List<ProductDO> getForgift() {
        return forgift;
    }

    public void setForgift(List<ProductDO> forgift) {
        this.forgift = forgift;
    }

    public List<ProductDO> getDayRent() {
        return dayRent;
    }

    public void setDayRent(List<ProductDO> dayRent) {
        this.dayRent = dayRent;
    }

    public List<ProductDO> getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(List<ProductDO> askPrice) {
        this.askPrice = askPrice;
    }

    public List<ProductDO> getCouplant() {
        return couplant;
    }

    public void setCouplant(List<ProductDO> couplant) {
        this.couplant = couplant;
    }
}
