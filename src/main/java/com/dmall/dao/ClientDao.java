package com.dmall.dao;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.user.Client;

public interface ClientDao {
	
	// 验证用户登录
	Client selectClient(@Param("username") String username, @Param("password") String password);
	
	// 用户注册
	int insertClient(Client client);
}
