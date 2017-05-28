package com.dmall.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmall.beans.OrderItem;
import com.dmall.dao.OrderItemDao;
import com.dmall.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDao dao;
	
	@Override
	public int addOrderItem(Integer clientId, Integer productId, int productQuantity) {
		return dao.insertOrderItem(clientId, productId, productQuantity);
	}

	@Override
	public List<OrderItem> queryOrderItem(Integer clientId, int packState) {
		List<OrderItem> orderItems = dao.selectOrderItem(clientId, packState);
		
		// 将订单项中的以分为单位的价格转化为以元为单位并计算各订单项价格
		Iterator<OrderItem> it = orderItems.iterator();
		while (it.hasNext()) {
			OrderItem orderItem = it.next();
			int price = orderItem.getProduct().getProductPrice();
			int quantity = orderItem.getProductQuantity();
			
			// 商品单价，元为单位
			orderItem.getProduct().setDoublePrice(price / 100.0);
			
			// 将当前购物车中各订单项的小计金额写入数据库
			dao.updateOrderItemPrice(orderItem.getOrderItemId(), price * quantity);
			// 订单项小计，分为单位
			orderItem.setDoublePrice(price * quantity / 100.0);
		}
		
		return orderItems;
	}

	
}
