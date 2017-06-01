package com.dmall.service;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class OrderServiceTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderService service;
	
	@Test
	public void testPackOrder() {
		Client client = new Client(1);
		int packOrder = service.packOrder(client);
		
		log.info(packOrder + "");
	}
	
	@Test
	public void testQueryOrders() {
		Client client = new Client(1);
		
		List<Order> orders = service.queryOrders(client);
		
		log.info((orders == null) + "");
		
		for (Order order : orders) {
			log.info(order.getOrderId() + "");
			log.info(order.getOrderItems().toString());
		}
	}
}
