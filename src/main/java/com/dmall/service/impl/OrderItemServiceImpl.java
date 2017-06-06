package com.dmall.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmall.beans.project.OrderItem;
import com.dmall.beans.repository.Product;
import com.dmall.beans.user.Client;
import com.dmall.dao.OrderItemDao;
import com.dmall.enums.OrderItemStateEnum;
import com.dmall.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderItemDao dao;
	
	/**
	 * 增加订单项（加入购物车）
	 */
	@Override
	public int addOrderItem(Client client, Integer productId, int productQuantity) {
		Product product = new Product(productId);
		OrderItem orderItem = new OrderItem(client, product, productQuantity);
		return dao.insertOrderItem(orderItem);
	}

	/**
	 * 查询订单项（购物车页展示）
	 */
	@Override
	public List<OrderItem> queryOrderItem(Client client) {
		
		// 查询的是未打包，即未生成为订单的订单项
		int packState = OrderItemStateEnum.UNPACKED.getState();
		OrderItem orderItem = new OrderItem(client, packState);
		List<OrderItem> orderItems = dao.selectOrderItem(orderItem);
		
		if (orderItems.size() == 0) {
			return null;
		}
		
		// 将订单项中的以分为单位的价格转化为以元为单位并计算各订单项价格
		Iterator<OrderItem> it = orderItems.iterator();
		while (it.hasNext()) {
			OrderItem oItem = it.next();
			int price = oItem.getProduct().getProductPrice();
			int quantity = oItem.getProductQuantity();
			
			// 商品单价，元为单位
			oItem.getProduct().setDoublePrice(price / 100.0);
			
			// 将当前购物车中各订单项的小计金额写入数据库
			// 每次查询购物车时将订单项价格写入，防止价格变更，更符合实际
			oItem.setOrderItemPrice(price * quantity);
			dao.updateOrderItemPrice(oItem);
			
			// 订单项小计，分为单位
			oItem.setDoublePrice(oItem.getOrderItemPrice() / 100.0);
		}
		
		return orderItems;
	}

	/**
	 * 查询购物车中所有商品总额
	 */
	@Override
	public double querySumOfUnPackedOrderItem(Client client) {
		// 查询的是未打包，即未生成为订单的订单项
		int packState = OrderItemStateEnum.UNPACKED.getState();
		OrderItem orderItem = new OrderItem(client, packState);
		
		int sum = 0;
		try {
			// 当查询不到符合条件的订单项会返回null值，BindingException
			sum = dao.selectSumOfUnPackedOrderItem(orderItem);
		} catch (BindingException e) {
			log.error("Exception : 没有符合条件的订单");
		}
		
		double price = sum / 100.0;
		return price;
	}

}
