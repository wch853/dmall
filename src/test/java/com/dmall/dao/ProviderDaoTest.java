package com.dmall.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmall.beans.purchase.Provider;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ProviderDaoTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProviderDao dao;
	
	@Test
	public void testSelectProvider() {
		List<Provider> providers = dao.selectProviders();
		
		log.info(providers.toString());
	}
}
