package com.dmall.service;

import java.util.List;

import com.dmall.beans.Client;
import com.dmall.beans.Order;

public interface OrderService {
	
	// 通过客户信息生成订单，包括计算订单总额和将订单id插入到各订单中
	int packOrder(Client client);
	
	// 通过客户信息查询订单及对应订单项（历史订单）
	List<Order> queryOrders(Client client);
}
