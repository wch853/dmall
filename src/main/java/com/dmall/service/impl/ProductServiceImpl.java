package com.dmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmall.beans.Product;
import com.dmall.dao.ProductDao;
import com.dmall.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<Product> queryProduct(int offset, int limit) {
		List<Product> products = dao.selectProduct(offset, limit);
		for (Product product : products) {
			product.setDoublePrice(product.getProductPrice() / 100.0);
		}
		
		return products;
	}

	@Override
	public int getTotal() {
		return dao.getCount();
	}

	@Override
	public Product queryProuctById(Integer productId) {
		return dao.selectProductById(productId);
	}

	@Override
	public List<Product> queryProductByName(String productName) {
		return dao.selectProductByName(productName);
	}
	
}
