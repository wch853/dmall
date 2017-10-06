package com.dmall.dao;

import java.util.List;

import com.dmall.beans.project.Order;

public interface OrderDao {
	
	// 增加订单
	int insertOrder(Order order);
	
	// 根据客户id/订单状态查询订单
	List<Order> selectOrder(Order order);
	
	// 改变订单发货状态
	int updateOrderState(Order order);
}
