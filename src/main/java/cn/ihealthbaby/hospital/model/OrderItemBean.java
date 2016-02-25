package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.OrderItemDO;
import cn.ihealthbaby.data.db.entity.ProductDO;

/**
 * Created by qiang on 2015/8/22.
 */
public class OrderItemBean {
    private OrderItemDO orderItemDO;
    private ProductDO productDO;

    public OrderItemDO getOrderItemDO() {
        return orderItemDO;
    }

    public void setOrderItemDO(OrderItemDO orderItemDO) {
        this.orderItemDO = orderItemDO;
    }

    public ProductDO getProductDO() {
        return productDO;
    }

    public void setProductDO(ProductDO productDO) {
        this.productDO = productDO;
    }
}
