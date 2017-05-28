package com.dmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.Product;

public interface ProductDao {
	
	// 获取商品总数
	int getCount();
	
	// 通过offset、limit和search关键字查询商品
	List<Product> selectProduct(@Param("offset") int offset, 
								@Param("limit") int limit, 
								@Param("search") String search);
	
}
