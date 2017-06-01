package com.dmall.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmall.beans.Client;
import com.dmall.beans.Order;
import com.dmall.beans.OrderItem;
import com.dmall.beans.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class OrderItemDaoTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderItemDao dao;
	
	@Test
	public void testInsertOrderItem() {
		Client client = new Client(1);
		Product product = new Product(11);
		int productQuantity = 14;
		
		OrderItem orderItem = new OrderItem(client, product, productQuantity);
		
		int insertOrderItem = dao.insertOrderItem(orderItem);
		
		log.info(insertOrderItem + "");
	}
	
	@Test
	public void testSelectOrderItem() {
		Client client = new Client(1);
		int packState = 2;
		
		OrderItem orderItem = new OrderItem(client, packState);
		
		List<OrderItem> orderItems = dao.selectOrderItem(orderItem);
		
		log.info(orderItems.toString());
	}
	
	@Test
	public void testSelectOrderItem2() {
		Order order = new Order(16);
		Client client = new Client(1);
		int packState = 2;
		
		OrderItem orderItem = new OrderItem(order, client, packState);
		
		List<OrderItem> orderItems = dao.selectOrderItem(orderItem);
		
		log.info(orderItems.toString());
	}
	
	@Test
	public void testUpdateOrderItemPrice() {
		Integer orderItemId = 15;
		int orderItemPrice = 1234;
		OrderItem orderItem = new OrderItem(orderItemId, orderItemPrice);
		
		dao.updateOrderItemPrice(orderItem);
	}
	
	@Test
	public void testSelectSum() {
		Client client = new Client(1);
		int packState = 1;
		
		OrderItem orderItem = new OrderItem(client, packState);
		int sum = dao.selectSumOfUnPackedOrderItem(orderItem);
		
		log.info(sum + "");
	}
	
	@Test
	public void testUpdateOrderId() {
		Integer clientId = 1;
		Integer orderId = 233;
		int packState = 1;
		int changeState = 2;
		dao.updateOrderId(clientId, orderId, packState, changeState);
	}
}
