package com.dmall.beans.purchase;

import java.util.Date;

/**
 * 采购订单实体类
 * 
 * @author wch
 *
 */
public class Purchase {

	private Integer purchaseId;
	private Provider provider;
	private Date createDate;
	private int purchaseState;

	public Purchase() {
		super();
	}

	public Purchase(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Purchase(Provider provider, int purchaseState) {
		this.provider = provider;
		this.purchaseState = purchaseState;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getPurchaseState() {
		return purchaseState;
	}

	public void setPurchaseState(int purchaseState) {
		this.purchaseState = purchaseState;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", provider=" + provider + ", createDate=" + createDate
				+ ", purchaseState=" + purchaseState + "]";
	}

}
