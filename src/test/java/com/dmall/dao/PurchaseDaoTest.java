package com.dmall.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmall.beans.purchase.Provider;
import com.dmall.beans.purchase.Purchase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class PurchaseDaoTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PurchaseDao dao;
	
	@Test
	public void testInsertPurchase() {
		Purchase purchase = new Purchase(new Provider(1), 1);
		int res = dao.insertPurchase(purchase);
		
		log.info(res + "");
		log.info(purchase.getPurchaseId() + "");
	}
	
	@Test
	public void testSelectPurchase() {
		List<Purchase> purchases = dao.selectPurchase(2);
		
		log.info(purchases.toString());
	}
}
