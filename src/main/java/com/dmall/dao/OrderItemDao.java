package com.dmall.dao;

import com.dmall.beans.OrderItem;
import com.dmall.beans.Product;

public interface OrderItemDao {
	
	// 通过客户id查询属于该客户的所有未打包订单项
	OrderItem selectOrderItemByClienId(Integer clientId);
	
	// 通过客户id和商品id查询未打包为订单的订单项
	int selectUnpackedOrderItem(Integer clientId, Integer productId);
	
	// 插入订单项
	int insertOrderItem(Product product, int productQuantity);
}
