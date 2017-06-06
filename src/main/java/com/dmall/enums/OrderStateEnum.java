package com.dmall.enums;

/**
 * 订单发货状态数据字典
 * 
 * @author wch
 *
 */
public enum OrderStateEnum {

	UNDELIVERED(1, "未发货"), 
	DELIVERED(2, "已发货");

	private int state;
	private String info;

	private OrderStateEnum(int state, String info) {
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
