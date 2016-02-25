package cn.ihealthbaby.hospital.model;

import cn.ihealthbaby.data.db.entity.AddressDO;
import cn.ihealthbaby.data.db.entity.ProductDO;
import cn.ihealthbaby.data.db.entity.ServiceDO;
import cn.ihealthbaby.data.db.entity.UserDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiang on 2015/8/28.
 *         jinliqiang@ihbaby.com
 */
public class SingleOrderModel {
    private ServiceDO serviceDO;
    private UserDO userDO;
    private List<ProductDO> productDOs;
    private List<AddressDO> addressDOs;

    public ServiceDO getServiceDO() {
        return serviceDO;
    }

    public void setServiceDO(ServiceDO serviceDO) {
        this.serviceDO = serviceDO;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public List<ProductDO> getProductDOs() {
        return productDOs;
    }

    public void setProductDOs(List<ProductDO> productDOs) {
        this.productDOs = productDOs;
    }

    public List<AddressDO> getAddressDOs() {
        return addressDOs;
    }

    public void setAddressDOs(List<AddressDO> addressDOs) {
        this.addressDOs = addressDOs;
    }
}
