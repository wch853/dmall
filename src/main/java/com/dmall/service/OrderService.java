package com.dmall.service;

import com.dmall.beans.Client;

public interface OrderService {
	
	// 通过客户信息生成订单，包括计算订单总额和将订单id插入到各订单中
	int packOrder(Client client);
}
