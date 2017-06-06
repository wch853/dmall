package com.dmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.project.OrderItem;

public interface OrderItemDao {

	// 插入订单项
	int insertOrderItem(OrderItem orderItem);

	// 查询订单项 
	List<OrderItem> selectOrderItem(OrderItem orderItem);
	
	// 添加订单项价格
	int updateOrderItemPrice(OrderItem orderItem);
	
	// 查询对应客户购物车中的商品总额
	int selectSumOfUnPackedOrderItem(OrderItem orderItem);
	
	// 结算时将订单id插入订单项中，同时将打包状态更新为已打包
	int updateOrderId(@Param("clientId") Integer clientId, 
					  @Param("orderId") Integer orderId,
					  @Param("packState") int packState,
					  @Param("changeState") int changeState);
}
