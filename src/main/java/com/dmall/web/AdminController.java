package com.dmall.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dmall.beans.project.Order;
import com.dmall.beans.purchase.Provider;
import com.dmall.beans.repository.Product;
import com.dmall.service.OrderService;
import com.dmall.service.PurchaseService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PurchaseService purchaseService;

	/**
	 * 显示未发货订单
	 * @return
	 */
	@RequestMapping("/order")
	public ModelAndView deliverOrders() {
		ModelAndView mv = new ModelAndView();
		
		List<Order> orders = orderService.queryUndeliveredOrders();
		mv.addObject("orders", orders);
		mv.setViewName("deliverOrders");
		
		return mv;
	}
	
	/**
	 * 根据存货状态返货发货请求的结果
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/deliver/{orderId}")
	@ResponseBody
	public boolean deliverOrder(@PathVariable("orderId") Integer orderId) {
		return orderService.deliverOrder(orderId);
	}
	
	@RequestMapping("/purchase")
	public ModelAndView purchasePage() {
		ModelAndView mv = new ModelAndView();
		
		List<Provider> providers = purchaseService.queryProviders();
		List<Product> products = purchaseService.queryProduct();
		
		mv.addObject("providers", providers);
		mv.addObject("products", products);
		mv.setViewName("purchase");
		
		return mv;
	}
	
	@RequestMapping("/sendCata")
	public String sendCata(String providerId, String cata) {
		purchaseService.addPurchase(providerId, cata);
		
		return "purchase";
	}
}
