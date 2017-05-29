package com.dmall.service;

import java.util.List;

import com.dmall.beans.OrderItem;

public interface OrderItemService {
	int addOrderItem(Integer clientId, Integer productId, int productQuantity);
	
	List<OrderItem> queryOrderItem(Integer clientId);
	
	double querySumOfUnPackedOrderItem(Integer clientId);
}
