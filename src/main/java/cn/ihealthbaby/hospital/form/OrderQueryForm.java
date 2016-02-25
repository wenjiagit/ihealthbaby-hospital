package cn.ihealthbaby.hospital.form;

import org.apache.http.client.utils.URIBuilder;
/**
 * @author qiang on 2015/8/25.
 * jinliqiang@ihbaby.com
 */
public class OrderQueryForm {
    private int page=1;
    private int pageSize=10;
    private String userName;
    private String orderId;
    private String hospitalName;
    private int orderType=-1;
    private int payType=-1;
    private int deliverType=-1;
    private int orderStatus=-1;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(int deliverType) {
        this.deliverType = deliverType;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String toUrl()  {
        URIBuilder uri  = new URIBuilder();
        uri.addParameter("userName", getUserName())
                .addParameter("hospitalName", getHospitalName())
                .addParameter("orderId", getOrderId())
                .addParameter("orderType", String.valueOf(getOrderType()))
                .addParameter("payType", String.valueOf(getPayType()))
                .addParameter("deliverType", String.valueOf(getDeliverType()))
                .addParameter("orderStatus", String.valueOf(getOrderStatus()));

        return  uri.toString().substring(1);
    }
}
