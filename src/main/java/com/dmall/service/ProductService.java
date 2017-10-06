package com.dmall.service;

import java.util.Map;

public interface ProductService {
	
	// 获取商品总数
	int getTotal();
	
	// 返回给商品展示页的数据
	Map<String, Object> queryProduct(int offset, int limit, String search);
	
}
