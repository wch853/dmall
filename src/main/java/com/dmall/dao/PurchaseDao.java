package com.dmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dmall.beans.purchase.Purchase;

public interface PurchaseDao {
	
	// 插入采购订单
	int insertPurchase(Purchase purchase);
	
	// 根据采购订单状态查询采购订单
	List<Purchase> selectPurchase(@Param("purchaseState") int purchaseState);
}
