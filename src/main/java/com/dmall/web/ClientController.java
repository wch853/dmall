package com.dmall.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dmall.beans.project.Order;
import com.dmall.beans.project.OrderItem;
import com.dmall.beans.user.Client;
import com.dmall.exception.NoClientException;
import com.dmall.service.ClientService;
import com.dmall.service.OrderItemService;
import com.dmall.service.OrderService;

/**
 * 有关用户的控制
 * 
 * @author wch
 *
 */
@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private OrderService orderService;

	/**
	 * 用户登录
	 * 
	 * @param session
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Object checkLogin(HttpSession session, String username, String password) {

		Client client = clientService.checkUser(username, password);

		// client为空，即登录失败
		if (null == client) {
			return false;
		} else {
			session.setAttribute("client", client);
			return true;
		}
	}

	/**
	 * 用户下线
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/offline")
	public String clientOffline(HttpSession session) {
		session.removeAttribute("client");
		return "redirect:/";
	}

	@RequestMapping("/register")
	public String goRegister() {
		return "register";
	}

	@RequestMapping("/registerInfo")
	@ResponseBody
	public Object register(HttpSession session, String username, String password) {
		// 注册
		Client client = clientService.registerClient(username, password);

		// 注册失败
		if (null == client) {
			return false;
		}

		// 注册成功，把新注册用户信息加入session
		session.setAttribute("client", client);

		return true;
	}

	/**
	 * 处理未登录访问个人信息异常
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(NoClientException.class)
	public ModelAndView handleException(NoClientException ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("forward:ErrorPage/error.jsp");
		return mv;
	}

	/**
	 * 向购物车增加订单项
	 * 
	 * @param productId
	 * @param productQuantity
	 * @param session
	 */
	@RequestMapping("addOrderItem")
	@ResponseBody
	public Object addOrderItem(Integer productId, int productQuantity, HttpSession session) {
		Client client = (Client) session.getAttribute("client");
		// 用户未登录时无法加入购物车，返回false
		if (null == client) {
			return false;
		}

		orderItemService.addOrderItem(client, productId, productQuantity);

		return true;
	}

	/**
	 * 根据登录客户信息查询相应购物车信息
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/cart")
	public ModelAndView showCart(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Client client = (Client) session.getAttribute("client");
		if (null == client) {
			throw new NoClientException("用户未登录[滑稽]~");
		}

		List<OrderItem> orderItems = orderItemService.queryOrderItem(client);
		double price = orderItemService.querySumOfUnPackedOrderItem(client);

		mv.addObject("orderItems", orderItems);
		mv.addObject("sumOfOrderItem", price);
		mv.setViewName("cart");

		return mv;
	}

	/**
	 * 支付处理
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/payOrder", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String payOrder(HttpSession session) {
		Client client = (Client) session.getAttribute("client");

		String tip = "支付失败，请稍候重试！";

		int res = orderService.packOrder(client);
		if (res > 0) {
			tip = "支付成功(^∇^*)去首页发现更多~";
		}

		return tip;
	}

	@RequestMapping("/order")
	public ModelAndView showHistory(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Client client = (Client) session.getAttribute("client");
		if (null == client) {
			throw new NoClientException("用户未登录[滑稽]~");
		}

		List<Order> orders = orderService.queryOrdersByClient(client);

		mv.addObject("orders", orders);
		mv.setViewName("listOrders");

		return mv;
	}
}
