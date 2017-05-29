package com.dmall.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmall.beans.Client;
import com.dmall.service.ClientService;

/**
 * 有关用户的控制
 * 
 * @author wch
 *
 */
@Controller
public class ClientController {

	@Autowired
	private ClientService service;

	@RequestMapping("/login")
	@ResponseBody
	public Object checkLogin(HttpSession session, String username, String password) {

		Client client = service.checkUser(username, password);

		// client为空，即登录失败
		if (null == client) {
			return false;
		} else {
			session.setAttribute("client", client);
			return true;
		}
	}
}
