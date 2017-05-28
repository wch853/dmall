package com.dmall.service;

import java.util.Map;

public interface ProductService {
	
	int getTotal();
	
	Map<String, Object> queryProduct(int offset, int limit, String search);
	
}
