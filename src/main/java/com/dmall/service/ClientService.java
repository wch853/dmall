package com.dmall.service;

import com.dmall.beans.Client;

public interface ClientService {
	
	Client checkUser(String username, String password);
}
