package com.dmall.service.impl;

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
	
	@Override
	public List<Provider> queryProviders() {
		return providerDao.selectProviders();
	}

	@Override
	public List<Product> queryProduct() {
		return productDao.selectProduct(0, Short.MAX_VALUE, "");
	}

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

}
