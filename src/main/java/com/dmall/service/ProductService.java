package com.dmall.service;

import java.util.List;

import com.dmall.beans.Product;

public interface ProductService {
	
	int getTotal();
	
	List<Product> queryProduct(int offset, int limit);
	
	Product queryProuctById(Integer productId);
	
	List<Product> queryProductByName(String productName);
}
