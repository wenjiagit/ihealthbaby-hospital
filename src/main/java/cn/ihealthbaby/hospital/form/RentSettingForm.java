package cn.ihealthbaby.hospital.form;

import cn.ihealthbaby.hospital.model.RentGroupModel;

import java.util.List;

/**
 * Created by qiang on 2015/8/10.
 */
public class RentSettingForm {
    /**设备押金*/
    private int foregift;
    /**咨询单价*/
    private int askPrice;
    /**是否代收*/
    private boolean collection;
    /**代收类型*/
    private int coltype;
    /**代收金额**/
    private int colcost;
    /**日租费**/
    private int dayrent;
    /**耦合剂单价**/
    private int couplant;
    /***一次性付费***/
    private int disposable;
    /**周——钱组合*/
    private List<RentGroupModel> rentGroupModels;

    public int getForegift() {
        return foregift;
    }

    public void setForegift(int foregift) {
        this.foregift = foregift;
    }

    public int getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(int askPrice) {
        this.askPrice = askPrice;
    }

    public boolean isCollection() {
        return collection;
    }

    public void setCollection(boolean collection) {
        this.collection = collection;
    }

    public int getColtype() {
        return coltype;
    }

    public void setColtype(int coltype) {
        this.coltype = coltype;
    }

    public int getColcost() {
        return colcost;
    }

    public void setColcost(int colcost) {
        this.colcost = colcost;
    }

    public int getDayrent() {
        return dayrent;
    }

    public void setDayrent(int dayrent) {
        this.dayrent = dayrent;
    }

    public int getCouplant() {
        return couplant;
    }

    public void setCouplant(int couplant) {
        this.couplant = couplant;
    }

    public int getDisposable() {
        return disposable;
    }

    public void setDisposable(int disposable) {
        this.disposable = disposable;
    }

    public List<RentGroupModel> getRentGroupModels() {
        return rentGroupModels;
    }

    public void setRentGroupModels(List<RentGroupModel> rentGroupModels) {
        this.rentGroupModels = rentGroupModels;
    }
}
