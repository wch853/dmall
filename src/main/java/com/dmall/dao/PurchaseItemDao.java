package com.dmall.dao;

import com.dmall.beans.purchase.PurchaseItem;

public interface PurchaseItemDao {

	// 插入采购订单项
	int insertPurchaseItem(PurchaseItem purchaseItem);
}
