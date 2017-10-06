package com.dmall.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmall.service.ProductService;

/**
 * 与商品有关的控制
 * 
 * @author wch
 *
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 查询商品页
	 * 
	 * @return
	 */
	@RequestMapping("/product")
	public String product() {
		return "listAllProducts";
	}

	/**
	 * 查询商品目录 对于boostrap-table，返回的json必须包含total(总数)和rows(数据)
	 * 
	 * @param offset 偏移量
	 * @param limit 每页数量
	 * @param search 搜索关键字
	 * @return
	 */
	@RequestMapping("/getProducts")
	@ResponseBody
	public Map<String, Object> getProducts(int offset, int limit, String search) {
		return productService.queryProduct(offset, limit, search);
	}

}
