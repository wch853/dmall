package com.dmall.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Override
	public int packOrder(Client client) {
		int packState = PackStateEnum.UNPACKED.getState();
		OrderItem orderItem = new OrderItem(client, packState);

		try {
			// 处理空订单返回null值异常
			int orderPrice = orderItemDao.selectSumOfUnPackedOrderItem(orderItem);
			
			// 通过客户信息和订单总额构建订单
			Order order = new Order(client, orderPrice);
			orderDao.insertOrder(order);
			
			Integer orderId = order.getOrderId();
			Integer clientId = client.getClientId();
			int changeState = PackStateEnum.PACKED.getState();
			// 更新各订单项中的订单id并将未打包状态更改为已打包
			return orderItemDao.updateOrderId(clientId, orderId, packState, changeState);
		} catch (BindingException e) {
			log.error("Exception : 没有符合条件的订单");
		}
		
		return 0;
	}

	/**
	 * 查询所有订单（历史订单）
	 */
	@Override
	public List<Order> queryOrders(Client client) {
		List<Order> orders = orderDao.selectOrderByClient(client);
		
		if (orders.size() == 0) {
			return null;
		}
		
		// 查询的是已打包的订单项
		int packState = PackStateEnum.PACKED.getState();
		
		Iterator<Order> it = orders.iterator();
		while (it.hasNext()) {
			Order order = it.next();
			// 展示的是以分为单位的价格
			order.setDoublePrice(order.getOrderPrice() / 100.0);
			
			// 为相应订单加载订单项
			OrderItem orderItem = new OrderItem(order, client, packState);
			List<OrderItem> orderItems = orderItemDao.selectOrderItem(orderItem);
			order.setOrderItems(orderItems);
		}
		
		return orders;
	}

}
