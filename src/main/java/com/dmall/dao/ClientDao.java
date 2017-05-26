package com.dmall.dao;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.Client;

public interface ClientDao {
	
	// 验证用户登录
	Client checkUser(@Param("username") String username, @Param("password") String password);
}
