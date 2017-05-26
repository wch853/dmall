package com.dmall.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmall.beans.Product;
import com.dmall.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@RequestMapping("/product")
	public String product() {
		return "listAllProducts";
	}
	
	@RequestMapping("/getProducts")
	@ResponseBody
	public Map<String, Object> getProducts(int offset, int limit, String search) {
		Map<String, Object> map = new HashMap<>();

		if (search.length() == 0) {
			int total = service.getTotal();
			List<Product> allProducts = service.queryProduct(offset, limit);
			
			map.put("total", total);
			map.put("rows", allProducts);
		} else {
			List<Product> products = service.queryProductByName(search);
			
			map.put("total", products.size());
			map.put("rows", products);
		}
		
		return map;
	}
}
