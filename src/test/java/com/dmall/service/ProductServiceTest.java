package com.dmall.service;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class ProductServiceTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService service;
	
	@Test
	public void testQueryAllProducts() {
		Map<String, Object> allProducts = service.queryProduct(0, 10, "s");
		log.info(allProducts.toString());
	}
	
}
