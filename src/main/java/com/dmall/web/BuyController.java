package com.dmall.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmall.beans.Client;
import com.dmall.service.OrderItemService;
import com.dmall.service.ProductService;

@Controller
public class BuyController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@RequestMapping("/product")
	public String product() {
		return "listAllProducts";
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
	@RequestMapping("/getProducts")
	@ResponseBody
	public Map<String, Object> getProducts(int offset, int limit, String search) {
		return productService.queryProduct(offset, limit, search);
	}
	
	
	/**
	 * 购物车增加订单项
	 * @param productId
	 * @param productQuantity
	 * @param session
	 */
	@RequestMapping("addOrderItem")
	@ResponseBody
	public String addOrderItem(Integer productId, int productQuantity, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		Integer clientId = client.getClientId();
		System.out.println(productId + " " + productQuantity + " " + clientId);
		orderItemService.addOrderItem(clientId, productId, productQuantity);
		// $.ajax方法，不返回参数就无法使用success回调，待查
		return "success";
	}
	
}
