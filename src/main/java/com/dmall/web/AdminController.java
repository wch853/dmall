package com.dmall.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dmall.beans.project.Order;
import com.dmall.service.OrderService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/order")
	public ModelAndView deliverOrders() {
		ModelAndView mv = new ModelAndView();
		
		List<Order> orders = orderService.queryUndeliveredOrders();
		mv.addObject("orders", orders);
		mv.setViewName("deliverOrders");
		
		return mv;
	}
	
	@RequestMapping("/deliver/{orderId}")
	@ResponseBody
	public boolean deliverOrder(@PathVariable("orderId") Integer orderId) {
		return orderService.deliverOrder(orderId);
	}
}
