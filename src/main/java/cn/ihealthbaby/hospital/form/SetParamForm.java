package cn.ihealthbaby.hospital.form;

/**
 * Created by qiang on 2015/8/15.
 */
public class SetParamForm {
    //产品名称
    private String name;
   //价钱
    private int price;
    //数量
    private int amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
