package com.dmall.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmall.beans.project.Order;
import com.dmall.beans.user.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrderDaoTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void testInsertOrder() {
		Order order = new Order(new Client(1), 2222);
		
		int res = orderDao.insertOrder(order);
		
		log.info("res=" + res);
		log.info("orderId=" + order.getOrderId());
	}
	
	@Test
	public void testSelectOrder() {
		Client client = new Client(1);
		List<Order> orders = orderDao.selectOrder(new Order(client));
		log.info(orders.toString());
	}
	
	@Test
	public void testSelectOrder2() {
		List<Order> orders = orderDao.selectOrder(new Order(1));
		log.info(orders.toString());
	}
	
	@Test
	public void testUpdateOrderState() {
		Order order = new Order(29, 2);
		int res = orderDao.updateOrderState(order);
		
		log.info(res + "");
	}
}
