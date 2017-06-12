package com.dmall.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmall.beans.project.Order;
import com.dmall.beans.project.OrderItem;
import com.dmall.beans.user.Client;
import com.dmall.dao.OrderDao;
import com.dmall.dao.OrderItemDao;
import com.dmall.dao.ProductDao;
import com.dmall.enums.OrderItemStateEnum;
import com.dmall.enums.OrderStateEnum;
import com.dmall.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public int packOrder(Client client) {
		int packState = OrderItemStateEnum.UNPACKED.getState();
		OrderItem orderItem = new OrderItem(client, packState);

		try {
			// 处理空订单返回null值异常
			int orderPrice = orderItemDao.selectSumOfUnPackedOrderItem(orderItem);
			
			// 通过客户信息和订单总额构建订单
			Order order = new Order(client, orderPrice);
			orderDao.insertOrder(order);
			
			Integer orderId = order.getOrderId();
			Integer clientId = client.getClientId();
			int changeState = OrderItemStateEnum.PACKED.getState();
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
	public List<Order> queryOrdersByClient(Client client) {
		Order selectOrder = new Order(client);
		List<Order> orders = orderDao.selectOrder(selectOrder);
		
		if (orders.size() == 0) {
			return null;
		}
		
		// 查询的是已打包的订单项
		int packState = OrderItemStateEnum.PACKED.getState();
		
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

	/**
	 * 查询所有未发货的订单
	 */
	@Override
	public List<Order> queryUndeliveredOrders() {
		int orderState = OrderStateEnum.UNDELIVERED.getState();
		Order selectOrder = new Order(orderState);
		List<Order> orders = orderDao.selectOrder(selectOrder);
		
		if (orders.size() == 0) {
			return null;
		}
		
		Iterator<Order> it = orders.iterator();
		while (it.hasNext()) {
			Order order = it.next();
			// 展示的是以分为单位的价格
			order.setDoublePrice(order.getOrderPrice() / 100.0);
			
			// 为相应订单加载订单项
			OrderItem orderItem = new OrderItem(order);
			List<OrderItem> orderItems = orderItemDao.selectOrderItem(orderItem);
			order.setOrderItems(orderItems);
		}
		
		return orders;
	}

	/**
	 * 根据订单id发货
	 */
	@Override
	public boolean deliverOrder(Integer orderId) {
		int orderState = OrderStateEnum.DELIVERED.getState();
		Order order = new Order(orderId, orderState);
		
		OrderItem orderItem = new OrderItem(order);
		List<OrderItem> orderItems = orderItemDao.selectOrderItem(orderItem);
		
		for (OrderItem item : orderItems) {
			int productQuantity = item.getProductQuantity();
			int storage = item.getProduct().getStorage();
			
			// 一旦出现商品数量大于库存，阻止发货
			if (productQuantity > storage) {
				return false;
			}
		}
		
		// 发货操作包括更改发货状态和减库存
		orderDao.updateOrderState(order);
		for (OrderItem item : orderItems) {
			Integer productId = item.getProduct().getProductId();
			int productQuantity = item.getProductQuantity();
			productDao.updateDownStorage(productId, productQuantity);
		}
		
		return true;
	}

}
