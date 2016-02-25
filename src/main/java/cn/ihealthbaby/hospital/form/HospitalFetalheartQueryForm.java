package cn.ihealthbaby.hospital.form;

import org.apache.http.client.utils.URIBuilder;

/**
 * Created by qiang on 2015/7/31.
 */
public class HospitalFetalheartQueryForm {
    private int page=1;

    private int pageSize=10;

    private String hospitalName;
    private String departmentName;
    private int useType=-1;
    private int status=-1;
    private String serialnum;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getUseType() {
        return useType;
    }

    public void setUseType(int useType) {
        this.useType = useType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String toUrl()  {
        URIBuilder uri  = new URIBuilder();
             uri.addParameter("serialnum", getSerialnum())
                .addParameter("hospitalName", getHospitalName())
                .addParameter("departmentName", getDepartmentName())
                .addParameter("useType", String.valueOf(getUseType()))
                .addParameter("status", String.valueOf(getStatus()));

        return  uri.toString().substring(1);
    }
}
