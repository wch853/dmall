package com.dmall.service;

import com.dmall.beans.user.Admin;

public interface AdminService {
	
	// 验证管理员登录
	Admin checkAdmin(String username, String password);
}
