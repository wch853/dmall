package com.dmall.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmall.beans.repository.Product;
import com.dmall.dao.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ProductDaoTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductDao dao;
	
	@Test
	public void testSelectAllProducts() {
		List<Product> allProducts = dao.selectProduct(0, 5, "s");
		log.info(allProducts.toString());
	}
	
	@Test
	public void testGetCount() {
		int count = dao.getCount();
		log.info(count + "");
	}
	
	@Test
	public void testUpdateStorage() {
		int res = dao.updateStorage(1, 1);
		
		log.info(res + "");
	}
}
