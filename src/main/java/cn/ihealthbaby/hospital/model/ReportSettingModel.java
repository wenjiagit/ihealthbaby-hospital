package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.hospital.db.entity.CatOptionDO;
import cn.ihealthbaby.hospital.db.entity.NstOptionDO;

import java.util.List;

/**
 * Created by qiang on 2015/8/13.
 */
public class ReportSettingModel {
    /**id*/
    private long id;
    /**走纸速度*/
    private int paperspeed;
    /**打印报告显示设置 (0:不显示 1：显示)*/
    private boolean reportPrintView;
    /**打印页cat显隐*/
    private boolean reportPrintCatView;
    /**打印报告nst显示设置 (0:不显示 1：显示)*/
    private boolean reportPrintNstView;
    /**签发页显示(0:不显示 1：显示)*/
    private boolean signpageView;
    /**签发页cat显示(0:不显示 1：显示)*/
    private boolean signpageCatView;
    /**签发页nst显示(0:不显示 1：显示)*/
    private boolean signpageNstView;
    /**nst选项*/
    private List<NstOptionDO> nstOptionlist;
    /**cat选项*/
    private List<CatOptionDO> catOptionlist;
    /**所属医院*/
    private Long hospitalId;
    /**横轴刻度*/
    private int divisionX;
    /**纵轴刻度*/
    private int divisionY;
    /**缩放倍数*/
    private double zoom;

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPaperspeed() {
        return paperspeed;
    }

    public void setPaperspeed(int paperspeed) {
        this.paperspeed = paperspeed;
    }

    public boolean isReportPrintView() {
        return reportPrintView;
    }

    public void setReportPrintView(boolean reportPrintView) {
        this.reportPrintView = reportPrintView;
    }

    public boolean isReportPrintCatView() {
        return reportPrintCatView;
    }

    public void setReportPrintCatView(boolean reportPrintCatView) {
        this.reportPrintCatView = reportPrintCatView;
    }

    public boolean isReportPrintNstView() {
        return reportPrintNstView;
    }

    public void setReportPrintNstView(boolean reportPrintNstView) {
        this.reportPrintNstView = reportPrintNstView;
    }

    public boolean isSignpageView() {
        return signpageView;
    }

    public void setSignpageView(boolean signpageView) {
        this.signpageView = signpageView;
    }

    public boolean isSignpageCatView() {
        return signpageCatView;
    }

    public void setSignpageCatView(boolean signpageCatView) {
        this.signpageCatView = signpageCatView;
    }

    public boolean isSignpageNstView() {
        return signpageNstView;
    }

    public void setSignpageNstView(boolean signpageNstView) {
        this.signpageNstView = signpageNstView;
    }

    public List<NstOptionDO> getNstOptionlist() {
        return nstOptionlist;
    }

    public void setNstOptionlist(List<NstOptionDO> nstOptionlist) {
        this.nstOptionlist = nstOptionlist;
    }

    public List<CatOptionDO> getCatOptionlist() {
        return catOptionlist;
    }

    public void setCatOptionlist(List<CatOptionDO> catOptionlist) {
        this.catOptionlist = catOptionlist;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getDivisionX() {
        return divisionX;
    }

    public void setDivisionX(int divisionX) {
        this.divisionX = divisionX;
    }

    public int getDivisionY() {
        return divisionY;
    }

    public void setDivisionY(int divisionY) {
        this.divisionY = divisionY;
    }
}
