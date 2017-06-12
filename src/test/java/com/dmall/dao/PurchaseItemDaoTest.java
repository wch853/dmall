package com.dmall.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmall.beans.purchase.Purchase;
import com.dmall.beans.purchase.PurchaseItem;
import com.dmall.beans.repository.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class PurchaseItemDaoTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PurchaseItemDao dao;
	
	@Test
	public void testInsertPurchaseItem() {
		Purchase purchase = new Purchase(1);
		Product product = new Product(1);
		int purchaseNum = 3;
		
		PurchaseItem purchaseItem = new PurchaseItem(purchase, product, purchaseNum);
		int res = dao.insertPurchaseItem(purchaseItem);
		
		log.info(res + "");
	}
	
	@Test
	public void testSelectPurchaseItem() {
		Purchase purchase = new Purchase(8);
		PurchaseItem purchaseItem = new PurchaseItem(purchase);
		List<PurchaseItem> purchaseItems = dao.selectPurchaseItem(purchaseItem);
		
		log.info(purchaseItems.toString());
	}
	
	@Test
	public void testUpdateReceiveNum() {
		Purchase purchase = new Purchase(13);
		Product product = new Product(1);
		PurchaseItem purchaseItem = new PurchaseItem(purchase);
		purchaseItem.setProduct(product);
		purchaseItem.setReceiveNum(100);
		
		dao.updateReceiveNum(purchaseItem);
	}
}
