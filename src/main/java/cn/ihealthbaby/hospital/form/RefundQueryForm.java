package cn.ihealthbaby.hospital.form;

import org.apache.http.client.utils.URIBuilder;

/**
 * @author  qiang on 2015/9/4.
 */
public class RefundQueryForm {
    int page=1;
    int pageSize=10;

    private String name;
    private String mobile;
    private String hospitalName;
    private int payType = -1;
    private String orderId;
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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String toUrl()  {
        URIBuilder uri  = new URIBuilder();
        uri.addParameter("name", getName())
                .addParameter("mobile", getMobile())
                .addParameter("hospitalName",getHospitalName())
                .addParameter("orderId",getOrderId())
                .addParameter("payType", String.valueOf(getPayType()));

        return  uri.toString().substring(1);
    }
}
