package com.dmall.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmall.beans.OrderItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class OrderItemDaoTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderItemDao dao;
	
	@Test
	public void testInsertOrderItem() {
		Integer clientId = 1;
		Integer productId = 1;
		int productQuantity = 14;
		
		int insertOrderItem = dao.insertOrderItem(clientId, productId, productQuantity);
		
		log.info(insertOrderItem + "");
	}
	
	@Test
	public void testSelectOrderItem() {
		Integer clientId = 1;
		int packState = 1;
		
		List<OrderItem> orderItems = dao.selectOrderItem(clientId, packState);
		
		log.info(orderItems.toString());
	}
	
	@Test
	public void testUpdateOrderItemPrice() {
		Integer orderItemId = 14;
		int orderItemPrice = 1234;
		
		dao.updateOrderItemPrice(orderItemId, orderItemPrice);
	}
	
	@Test
	public void testSelectSum() {
		Integer clientId = 1;
		int packState = 1;
		int sum = dao.selectSumOfUnPackedOrderItem(clientId, packState);
		
		log.info(sum + "");
	}
}
