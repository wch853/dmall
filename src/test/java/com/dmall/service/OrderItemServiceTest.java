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
import com.dmall.beans.OrderItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class OrderItemServiceTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderItemService service;

	@Test
	public void testAddOrderItem() {
		Client client = new Client(1);
		Integer productId = 2;
		int productQuantity = 12;

		int res = service.addOrderItem(client, productId, productQuantity);

		log.info(res + "");
	}
	
	@Test
	public void testQueryOrderItem() {
		Client client = new Client(2);
		
		List<OrderItem> orderItems = service.queryOrderItem(client);
		
		log.info(orderItems.size() + "");
		
		for (OrderItem orderItem : orderItems) {
			log.info(orderItem.toString());
		}
	}
	
	@Test
	public void testQuerySum() {
		Client client = new Client(4);
		
		double sum = service.querySumOfUnPackedOrderItem(client);
		
		log.info(sum + "");
	}
}
