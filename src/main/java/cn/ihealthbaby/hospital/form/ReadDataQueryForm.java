package cn.ihealthbaby.hospital.form;

import org.apache.http.client.utils.URIBuilder;

/**
 * Created by qiang on 2015/8/11.
 */
public class ReadDataQueryForm {
    private int page = 1;
    private int pageSize=10;
    private String username;
    private String doctorname;
    private String adviceId;
    private int adviceType=-1;

    public int getAdviceType() {
        return adviceType;
    }
    public void setAdviceType(int adviceType) {
        this.adviceType = adviceType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(String adviceId) {
        this.adviceId = adviceId;
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
        uri.addParameter("username", getUsername())
                .addParameter("doctorname",getDoctorname())
                .addParameter("adviceType",String.valueOf(getAdviceType()))
                .addParameter("adviceId", getAdviceId());

        return  uri.toString().substring(1);
    }
}
