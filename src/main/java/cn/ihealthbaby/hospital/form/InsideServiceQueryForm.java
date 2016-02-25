package cn.ihealthbaby.hospital.form;

import org.apache.http.client.utils.URIBuilder;

/**
 * Created by qiang on 2015/8/20.
 */
public class InsideServiceQueryForm {
    private int page=1;
    private int pageSize=10;
    private String name;
    private String mobile;
    private int status=-1;
    private String serviceNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
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
        uri.addParameter("name", getName())
                .addParameter("mobile", getMobile())
                .addParameter("serviceNumber", getServiceNumber())
                .addParameter("status", String.valueOf(getStatus()));

        return  uri.toString().substring(1);
    }
}
