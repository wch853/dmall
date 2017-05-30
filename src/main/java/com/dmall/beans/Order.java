package com.dmall.beans;

import java.util.Date;

/**
 * 订单项实体类
 * 
 * @author wch
 *
 */
public class Order {
	private Integer orderId;
	private Client client;
	private int orderPrice;
	private Date createDate;

	public Order() {
		super();
	}

	public Order(Integer orderId) {
		this.orderId = orderId;
	}

	public Order(Client client, int orderPrice) {
		super();
		this.client = client;
		this.orderPrice = orderPrice;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", client=" + client + ", orderPrice=" + orderPrice + ", createDate="
				+ createDate + "]";
	}

}
