package com.dmall.enums;

/**
 * 采购订单状态数据字典
 * 
 * @author wch
 *
 */
public enum PurchaseStateEnum {

	UNRECEIVED(1, "未收货"), 
	RECEIVED(2, "已收货");

	private int state;
	private String info;

	private PurchaseStateEnum(int state, String info) {
		this.state = state;
		this.info = info;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
