package com.dmall.service;

import java.util.List;

import com.dmall.beans.purchase.Provider;
import com.dmall.beans.purchase.Purchase;
import com.dmall.beans.repository.Product;

public interface PurchaseService {

	// 供应商信息
	List<Provider> queryProviders();
	
	// 商品库存信息
	List<Product> queryProduct();
	
	// 增加采购订单
	void addPurchase(String providerId, String cata);
	
	// 查询未收货采购订单
	List<Purchase> queryUnreceivedPurchase();
}
