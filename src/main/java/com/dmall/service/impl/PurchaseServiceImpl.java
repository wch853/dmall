package com.dmall.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dmall.beans.purchase.Provider;
import com.dmall.beans.purchase.Purchase;
import com.dmall.beans.purchase.PurchaseItem;
import com.dmall.beans.repository.Product;
import com.dmall.dao.ProductDao;
import com.dmall.dao.ProviderDao;
import com.dmall.dao.PurchaseDao;
import com.dmall.dao.PurchaseItemDao;
import com.dmall.enums.PurchaseStateEnum;
import com.dmall.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private ProviderDao providerDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	@Autowired
	private PurchaseItemDao purchaseItemDao;
	
	/**
	 * 查询所有供应商
	 */
	@Override
	public List<Provider> queryProviders() {
		return providerDao.selectProviders();
	}

	/**
	 * 查询所有商品
	 */
	@Override
	public List<Product> queryProduct() {
		return productDao.selectProduct(0, Short.MAX_VALUE, "");
	}

	/**
	 * 根据供应商编号和采购信息生成采购订单
	 */
	@Override
	public void addPurchase(String providerId, String cata) {
		Integer provId = Integer.valueOf(providerId.split("-")[1]);
		
		// 插入订单
		Provider provider = new Provider(provId);
		int purchaseState = PurchaseStateEnum.UNRECEIVED.getState();
		Purchase purchase = new Purchase(provider, purchaseState);
		purchaseDao.insertPurchase(purchase);
		
		JSONObject obj = JSON.parseObject(cata);
		for (String key : obj.keySet()) {
			Integer productId = Integer.valueOf(key);
			Product product = new Product(productId);
			int purchaseNum = obj.getIntValue(key);
			
			PurchaseItem purchaseItem = new PurchaseItem(purchase, product, purchaseNum);
			purchaseItemDao.insertPurchaseItem(purchaseItem);
		}
	}

	/**
	 * 查询未收货采购订单
	 */
	@Override
	public List<Purchase> queryUnreceivedPurchase() {
		int purchaseState = PurchaseStateEnum.UNRECEIVED.getState();
		List<Purchase> purchases = purchaseDao.selectPurchase(purchaseState);
		
		if (purchases.size() == 0) {
			purchases = null;
		}
		
		Iterator<Purchase> it = purchases.iterator();
		while (it.hasNext()) {
			Purchase purchase = it.next();
			PurchaseItem purchaseItem = new PurchaseItem(purchase);
			List<PurchaseItem> purchaseItems = purchaseItemDao.selectPurchaseItem(purchaseItem);
			
			purchase.setPurchaseItems(purchaseItems);
		}
		
		return purchases;
	}

}
