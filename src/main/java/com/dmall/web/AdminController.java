package com.dmall.web;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.dmall.beans.user.Admin;
import com.dmall.service.AdminService;
import com.dmall.service.OrderService;
import com.dmall.service.PurchaseService;

/**
 * 关于管理员的控制
 * 
 * @author wch
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PurchaseService purchaseService;
	
	/**
	 * 管理员登录页跳转
	 * @return
	 */
	@RequestMapping
	public String adminLogin() {
		return "adminLogin";
	}
	
	/**
	 * 验证管理员登录
	 * @param session
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Object checkAdminLogin(HttpSession session, String username, String password) {
		Admin admin = adminService.checkAdmin(username, password);
		
		if (null == admin) {
			return false;
		} else {
			session.setAttribute("admin", admin);
			return true;
		}
	}

	/**
	 * 管理员下线
	 * @param session
	 * @return
	 */
	@RequestMapping("/offline")
	public String adminOffline(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
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
	public void sendRece(Integer purchaseId, String rece) {
		purchaseService.receivePruchase(purchaseId, rece);
	}
}
