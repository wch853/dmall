package com.dmall.dao;

import java.util.List;

import com.dmall.beans.purchase.Provider;

public interface ProviderDao {
	
	// 查询供应商信息
	List<Provider> selectProviders();
}
