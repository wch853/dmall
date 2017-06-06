package com.dmall.service;

import java.util.List;

import com.dmall.beans.project.OrderItem;
import com.dmall.beans.user.Client;

public interface OrderItemService {
	
	// 增加订单项（加入购物车）
	int addOrderItem(Client client, Integer productId, int productQuantity);
	
	// 查询订单项（查看购物车）
	List<OrderItem> queryOrderItem(Client client);
	
	// 计算购物车总额
	double querySumOfUnPackedOrderItem(Client client);
}
