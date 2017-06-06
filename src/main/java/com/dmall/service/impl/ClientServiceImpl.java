package com.dmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmall.beans.user.Client;
import com.dmall.dao.ClientDao;
import com.dmall.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao dao;
	
	@Override
	public Client checkUser(String username, String password) {
		return dao.checkUser(username, password);
	}

	@Override
	public Client registerClient(String username, String password) {
		
		Client client = new Client(username, password);
		int res = dao.insertClient(client);
		
		return res > 0 ? client : null;
	}

}
