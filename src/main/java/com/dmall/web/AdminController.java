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
import com.dmall.beans.purchase.Purchase;
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
	
	@RequestMapping
	public String adminLogin() {
		return "admin";
	}

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
	 * 根据存货状态返回发货请求的结果
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/deliver/{orderId}")
	@ResponseBody
	public boolean deliverOrder(@PathVariable("orderId") Integer orderId) {
		return orderService.deliverOrder(orderId);
	}
	
	/**
	 * 返回采购页面数据
	 * @return
	 */
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
	
	/**
	 * 接收采购数据
	 * @param providerId
	 * @param cata
	 */
	@RequestMapping("/sendCata")
	@ResponseBody
	public void sendCata(String providerId, String cata) {
		purchaseService.addPurchase(providerId, cata);
	}
	
	@RequestMapping("/receive")
	public ModelAndView receive() {
		ModelAndView mv = new ModelAndView();
		
		List<Purchase> purchases = purchaseService.queryUnreceivedPurchase();
		mv.addObject("purchases", purchases);
		mv.setViewName("receive");
		
		return mv;
	}
	
	@RequestMapping("/sendRece")
	@ResponseBody
	public void sendRece(Integer productId, String rece) {
		// TODO
		System.out.println(productId);
		
		System.out.println(rece);
	}
}
