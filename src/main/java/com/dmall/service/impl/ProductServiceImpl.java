package com.dmall.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	public int getTotal() {
		return dao.getCount();
	}

	/**
	 * 查询商品目录
	 * 对于boostrap-table，返回的json必须包含total(总数)和rows(数据)
	 * 
	 * @param offset 偏移量
	 * @param limit 每页数量
	 * @param search 搜索关键字
	 * @return
	 */
	@Override
	public Map<String, Object> queryProduct(int offset, int limit, String search) {
		Map<String, Object> map = new HashMap<>();

		List<Product> products = new ArrayList<Product>();
		int total = 0;
		
		if(search.length() == 0) {
			products = dao.selectProduct(offset, limit, search);
			total = dao.getCount();
		} else {
			// 使得从其它页开始关键字搜索时选取的记录从头开始
			products = dao.selectProduct(0, limit, search);
			total = products.size();
		}
		
		Iterator<Product> it = products.iterator();
		while (it.hasNext()) {
			Product product = it.next();
			int price = product.getProductPrice();
			// 展示的是以分为单位的商品价格
			product.setDoublePrice(price / 100.0);
		}
		
		map.put("total", total);
		map.put("rows", products);
		
		return map;
	}
	
}
