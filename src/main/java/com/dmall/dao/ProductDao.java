package com.dmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.repository.Product;

public interface ProductDao {
	
	// 获取商品总数
	int getCount();
	
	// 通过offset、limit和search关键字查询商品
	List<Product> selectProduct(@Param("offset") int offset, 
								@Param("limit") int limit, 
								@Param("search") String search);
	
	// 发货时减库存
	int updateDownStorage(@Param("productId") Integer productId, 
					  @Param("productQuantity") int productQuantity);
	
	// 入库时增库存
	int updateUpStorage(@Param("productId") Integer productId, 
						@Param("receiveNum") int receiveNum);
}
