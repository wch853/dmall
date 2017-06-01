package com.dmall.beans;

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 * 
 * @author wch
 *
 */
public class Order {
	private Integer orderId;
	private Client client;
	private int orderPrice;
	private Date createDate;
	private List<OrderItem> orderItems;
	private double doublePrice;

	public Order() {
		super();
	}

	public Order(Integer orderId) {
		this.orderId = orderId;
	}

	public Order(Client client, int orderPrice) {
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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public double getDoublePrice() {
		return doublePrice;
	}

	public void setDoublePrice(double doublePrice) {
		this.doublePrice = doublePrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", client=" + client + ", orderPrice=" + orderPrice + ", createDate="
				+ createDate + ", orderItems=" + orderItems + "]";
	}

}
