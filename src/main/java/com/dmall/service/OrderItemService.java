package com.dmall.service;

import java.util.List;

import com.dmall.beans.Client;
import com.dmall.beans.OrderItem;

public interface OrderItemService {
	int addOrderItem(Client client, Integer productId, int productQuantity);
	
	List<OrderItem> queryOrderItem(Client client);
	
	double querySumOfUnPackedOrderItem(Client client);
}
