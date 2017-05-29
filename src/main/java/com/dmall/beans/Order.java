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
	private Integer clientId;
	private int orderPrice;
	private Date createDate;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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
		return "Order [orderId=" + orderId + ", clientId=" + clientId + ", orderPrice=" + orderPrice + ", createDate="
				+ createDate + "]";
	}

}
