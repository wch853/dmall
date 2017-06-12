package com.dmall.beans.purchase;

import com.dmall.beans.repository.Product;

/**
 * 订单项实体类
 * 
 * @author wch
 *
 */
public class PurchaseItem {

	private Integer purchaseItemId;
	private Purchase purchase;
	private Product product;
	private int purchaseNum;
	private int receiveNum;

	public PurchaseItem() {
		super();
	}

	public PurchaseItem(Purchase purchase, Product product, int purchaseNum) {
		this.purchase = purchase;
		this.product = product;
		this.purchaseNum = purchaseNum;
	}

	public PurchaseItem(Purchase purchase) {
		this.purchase = purchase;
	}

	public Integer getPurchaseItemId() {
		return purchaseItemId;
	}

	public void setPurchaseItemId(Integer purchaseItemId) {
		this.purchaseItemId = purchaseItemId;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public int getReceiveNum() {
		return receiveNum;
	}

	public void setReceiveNum(int receiveNum) {
		this.receiveNum = receiveNum;
	}

	@Override
	public String toString() {
		return "PurchaseItem [purchaseItemId=" + purchaseItemId + ", purchase=" + purchase + ", product=" + product
				+ ", purchaseNum=" + purchaseNum + ", receiveNum=" + receiveNum + "]";
	}

}
