package com.dmall.dao;

import java.util.List;

import com.dmall.beans.Client;
import com.dmall.beans.Order;

public interface OrderDao {
	
	// 增加订单
	int insertOrder(Order order);
	
	// 根据客户id查找订单
	List<Order> selectOrderByClient(Client client);
}
