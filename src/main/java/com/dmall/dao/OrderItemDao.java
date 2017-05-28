package com.dmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.OrderItem;

public interface OrderItemDao {

	// 插入订单项
	int insertOrderItem(@Param("clientId") Integer clientId,
						@Param("productId") Integer productId, 
						@Param("productQuantity") int productQuantity);

	// 查询订单项 
	List<OrderItem> selectOrderItem(@Param("clientId") Integer clientId,
									@Param("packState") int packState);
	
	// 添加订单项价格
	int updateOrderItemPrice(@Param("orderItemId") Integer orderItemId, 
							 @Param("orderItemPrice") int orderItemPrice);
}
