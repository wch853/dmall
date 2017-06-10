package com.dmall.dao;

import java.util.List;

import com.dmall.beans.purchase.PurchaseItem;

public interface PurchaseItemDao {

	// 插入采购订单项
	int insertPurchaseItem(PurchaseItem purchaseItem);
	
	// 根据采购订单查询采购订单项
	List<PurchaseItem> selectPurchaseItem(PurchaseItem purchaseItem);
}
