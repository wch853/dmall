package com.dmall.dao;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.user.Admin;

public interface AdminDao {
	
	// 根据用户名、密码查询用户
	Admin selectAdmin(@Param("username") String username, @Param("password") String password);
}
