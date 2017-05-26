package com.dmall.beans;

/**
 * 订单项实体类
 * 
 * @author wch
 *
 */
public class OrderItem {
	private Integer OrderItemId;
	private Order order;
	private Product product;
	private int productQuanlity;

	public Integer getOrderItemId() {
		return OrderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		OrderItemId = orderItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductQuanlity() {
		return productQuanlity;
	}

	public void setProductQuanlity(int productQuanlity) {
		this.productQuanlity = productQuanlity;
	}

	@Override
	public String toString() {
		return "OrderItem [OrderItemId=" + OrderItemId + ", order=" + order + ", product=" + product
				+ ", productQuanlity=" + productQuanlity + "]";
	}

}
