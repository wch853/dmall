package com.dmall.service;

import com.dmall.beans.Client;

public interface ClientService {
	
	// 验证用户登录
	Client checkUser(String username, String password);
	
	// 用户注册
	Client registerClient(String username, String password);
}
