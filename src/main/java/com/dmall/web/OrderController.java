package com.dmall.web;

/**
 * 有关订单的控制
 * 
 * @author wch
 * 
 */
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dmall.beans.Client;
import com.dmall.beans.Order;
import com.dmall.exception.NoClientException;
import com.dmall.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/order")
	public ModelAndView showHistory(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Client client = (Client) session.getAttribute("client");
		if (null == client) {
			throw new NoClientException("用户未登录[滑稽]~");
		}

		List<Order> orders = orderService.queryOrders(client);

		mv.addObject("orders", orders);
		mv.setViewName("listOrders");

		return mv;
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
}
