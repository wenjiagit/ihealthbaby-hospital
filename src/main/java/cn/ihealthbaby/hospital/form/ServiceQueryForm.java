package cn.ihealthbaby.hospital.form;

import org.apache.http.client.utils.URIBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by qiang on 2015/8/5.
 */
public class ServiceQueryForm {
    private int page=1;
    private int pageSize=10;
    private String username;
    private String serialnum;
    private String serviceId;
    private int serviceStatus=-1;
    private String hospitalName;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public int getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    public String toUrl()  {
        URIBuilder uri  = new URIBuilder();
        uri.addParameter("username",getUsername())
            .addParameter("serialnum",getSerialnum())
                .addParameter("serviceId", getServiceId())
                .addParameter("serviceStatus", String.valueOf(getServiceStatus()))
                .addParameter("hospitalName",getHospitalName());

        return  uri.toString().substring(1);
    }
}
