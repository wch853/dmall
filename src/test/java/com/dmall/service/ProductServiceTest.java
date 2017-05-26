package com.dmall.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmall.beans.Product;
import com.dmall.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class ProductServiceTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService service;
	
	@Test
	public void testQueryAllProducts() {
		List<Product> allProducts = service.queryProduct(0, 5);
		log.info(allProducts.toString());
	}
	
	@Test
	public void testQueryProductById() {
		int productId = 4;
		Product product = service.queryProuctById(productId);
		log.info(product.toString());
	}
	
	@Test
	public void testQueryProductByName() {
		String productName = "j";
		List<Product> products = service.queryProductByName(productName);
		
		log.info(products.toString());
	}
}
