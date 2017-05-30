package com.dmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmall.beans.Client;
import com.dmall.beans.Order;
import com.dmall.beans.OrderItem;
import com.dmall.dao.OrderDao;
import com.dmall.dao.OrderItemDao;
import com.dmall.enums.PackStateEnum;
import com.dmall.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Override
	public int packOrder(Client client) {
		int packState = PackStateEnum.UNPACKED.getState();
		OrderItem orderItem = new OrderItem(client, packState);
		// TODO 关于计算返回空订单
		int orderPrice = orderItemDao.selectSumOfUnPackedOrderItem(orderItem);
		
		// 通过客户信息和订单总额构建订单
		Order order = new Order(client, orderPrice);
		
		orderDao.insertOrder(order);
		
		Integer orderId = order.getOrderId();
		Integer clientId = client.getClientId();
		int changeState = PackStateEnum.PACKED.getState();
		
		// 更新各订单项中的订单id并将未打包状态更改为已打包
		return orderItemDao.updateOrderId(clientId, orderId, packState, changeState);
	}

}
