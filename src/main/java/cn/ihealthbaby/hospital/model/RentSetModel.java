package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.ProductDO;

import java.util.List;

/**
 * Created by qiang on 2015/8/15.
 */
public class RentSetModel {
    /**设备租金*/
    private List<ProductDO> foregift;
    /**日租金*/
    private List<ProductDO> dayRent;
    /**耦合剂*/
    private List<ProductDO> couplant;
    /**咨询费*/
    private List<ProductDO> askPrice;

    public List<ProductDO> getForegift() {
        return foregift;
    }

    public void setForegift(List<ProductDO> foregift) {
        this.foregift = foregift;
    }

    public List<ProductDO> getDayRent() {
        return dayRent;
    }

    public void setDayRent(List<ProductDO> dayRent) {
        this.dayRent = dayRent;
    }

    public List<ProductDO> getCouplant() {
        return couplant;
    }

    public void setCouplant(List<ProductDO> couplant) {
        this.couplant = couplant;
    }

    public List<ProductDO> getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(List<ProductDO> askPrice) {
        this.askPrice = askPrice;
    }
}
