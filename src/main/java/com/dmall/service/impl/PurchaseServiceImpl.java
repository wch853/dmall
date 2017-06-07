package com.dmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmall.beans.purchase.Provider;
import com.dmall.beans.repository.Product;
import com.dmall.dao.ProductDao;
import com.dmall.dao.ProviderDao;
import com.dmall.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private ProviderDao providerDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Provider> queryProviders() {
		return providerDao.selectProviders();
	}

	@Override
	public List<Product> queryProduct() {
		return productDao.selectProduct(0, Short.MAX_VALUE, "");
	}

}
