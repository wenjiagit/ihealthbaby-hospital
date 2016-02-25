package cn.ihealthbaby.hospital.model;

/**
 * Created by qiang on 2015/8/19.
 */
public class OrderItemModel {
	/** 订单项id */
	private long id;
	/** 订单id */
	private long orderId;
	/** 商品id */
	private long productId;
	/** 套装名称 */
	private String productName;
	/** 购买数量 */
	private int amount;
	/** 所含单品数量 */
	private int innerAmount;
	/** 商品的价格 */
	private int price;
	/** 收费类型 0 我们 ,1 医院,2 押金扣除 */
	private int chargeType;
	/** 商品类型 0 押金, 1 耗材包 , 2 租金 ,3 咨询费 */
	private int productType;
	/** 是否需要运输 0 不需要 ,1 需要 */
	private boolean needDelivery;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getInnerAmount() {
		return innerAmount;
	}
	public void setInnerAmount(int innerAmount) {
		this.innerAmount = innerAmount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getChargeType() {
		return chargeType;
	}
	public void setChargeType(int chargeType) {
		this.chargeType = chargeType;
	}
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public boolean isNeedDelivery() {
		return needDelivery;
	}
	public void setNeedDelivery(boolean needDelivery) {
		this.needDelivery = needDelivery;
	}
	public OrderItemModel(long id, long orderId, long productId,
			String productName, int amount, int innerAmount, int price,
			int chargeType, int productType, boolean needDelivery) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.amount = amount;
		this.innerAmount = innerAmount;
		this.price = price;
		this.chargeType = chargeType;
		this.productType = productType;
		this.needDelivery = needDelivery;
	}
	public OrderItemModel() {
		super();
	}

}
