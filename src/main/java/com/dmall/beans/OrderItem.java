package com.dmall.beans;

/**
 * 订单项实体类
 * 
 * @author wch
 *
 */
public class OrderItem {
	private Integer orderItemId;
	private Order order;
	private Client client;
	private Product product;
	private int productQuantity;
	// 订单项状态，按是否打包为订单分类
	private int packState;
	// 订单项价格，以分为单位
	private int orderItemPrice;
	// 订单项价格，以元为单位
	private double doublePrice;

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuanlity) {
		this.productQuantity = productQuanlity;
	}

	public int getPackState() {
		return packState;
	}

	public void setPackState(int packState) {
		this.packState = packState;
	}

	public int getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(int orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

	public double getDoublePrice() {
		return doublePrice;
	}

	public void setDoublePrice(double doublePrice) {
		this.doublePrice = doublePrice;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", order=" + order + ", client=" + client + ", product="
				+ product + ", productQuantity=" + productQuantity + ", packState=" + packState + ", orderItemPrice="
				+ orderItemPrice + ", doublePrice=" + doublePrice + "]";
	}

}
