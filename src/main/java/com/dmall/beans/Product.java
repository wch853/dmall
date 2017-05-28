package com.dmall.beans;

/**
 * 商品实体类
 * 
 * @author wch
 *
 */
public class Product {

	private Integer productId;
	private String productName;
	// 商品价格，以分为单位
	private int productPrice;
	// 以元为单位
	private double doublePrice;

	public double getDoublePrice() {
		return doublePrice;
	}

	public void setDoublePrice(double doublePrice) {
		this.doublePrice = doublePrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", doublePrice=" + doublePrice + "]";
	}

}
