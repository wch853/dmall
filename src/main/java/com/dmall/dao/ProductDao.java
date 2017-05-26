package com.dmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.Product;

public interface ProductDao {
	
	int getCount();
	
	List<Product> selectProduct(@Param("offset") int offset, @Param("limit") int limit);
	
	Product selectProductById(Integer productId);
}
