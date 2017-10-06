package com.dmall.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmall.beans.user.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class AdminDaoTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminDao dao;
	
	@Test
	public void testSelectAdmin() {
		String username = "wch85";
		String password = "123456";
		
		Admin admin = dao.selectAdmin(username, password);
		
		log.info((null == admin) + "");
	}
}
