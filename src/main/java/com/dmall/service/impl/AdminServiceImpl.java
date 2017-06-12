package com.dmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmall.beans.user.Admin;
import com.dmall.dao.AdminDao;
import com.dmall.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin checkAdmin(String username, String password) {
		return adminDao.selectAdmin(username, password);
	}

}
