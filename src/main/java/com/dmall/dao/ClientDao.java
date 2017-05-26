package com.dmall.dao;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.Client;

public interface ClientDao {
	
	Client checkUser(@Param("username") String username, @Param("password") String password);
}
