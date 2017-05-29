package com.dmall.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dmall.beans.Client;
import com.dmall.beans.OrderItem;
import com.dmall.enums.PackStateEnum;
import com.dmall.exception.NoClientException;
import com.dmall.service.OrderItemService;
import com.dmall.service.ProductService;

/**
 * 与商品有关的控制器
 * @author wch
 *
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderItemService orderItemService;

	@RequestMapping("/product")
	public String product() {
		return "listAllProducts";
	}

	/**
	 * 查询商品目录 对于boostrap-table，返回的json必须包含total(总数)和rows(数据)
	 * 
	 * @param offset 偏移量
	 * @param limit  每页数量
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
		
		Integer clientId = client.getClientId();

		orderItemService.addOrderItem(clientId, productId, productQuantity);
		// $.ajax，不返回参数就无法使用success回调，待查
		return true;
	}

	/**
	 * 根据登录客户信息查询相应购物车信息
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
		
		Integer clientId = client.getClientId();

		List<OrderItem> orderItems = orderItemService.queryOrderItem(clientId);
		if (orderItems.size() > 0) {
			double price = orderItemService.querySumOfUnPackedOrderItem(clientId);
			mv.addObject("sumOfOrderItem", price);
		}
		
		mv.addObject("orderItems", orderItems);
		mv.setViewName("cart");

		return mv;
	}
	
	/**
	 * 处理未登录时用到客户信息的空指针异常
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
