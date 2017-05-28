package com.dmall.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dmall.beans.Client;
import com.dmall.beans.OrderItem;
import com.dmall.enums.PackStateEnum;
import com.dmall.service.OrderItemService;

@Controller
public class CartController {
	
	@Autowired
	private OrderItemService service;
	
	@RequestMapping("/cart")
	public ModelAndView showCart(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Client client = (Client) session.getAttribute("client");
		Integer clientId = client.getClientId();
		int packState = PackStateEnum.UNPACKED.getState();
		
		List<OrderItem> orderItems = service.queryOrderItem(clientId, packState);
		mv.addObject("orderItems", orderItems);
		mv.setViewName("cart");
		
		return mv;
	}
}
