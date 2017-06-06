package com.dmall.enums;

/**
 * 订单项打包状态数据字典
 * 
 * @author wch
 *
 */
public enum OrderItemStateEnum {

	UNPACKED(1, "未打包"), PACKED(2, "已打包");

	private int state;
	private String info;

	public int getState() {
		return state;
	}

	public String getInfo() {
		return info;
	}

	private OrderItemStateEnum(int state, String info) {
		this.state = state;
		this.info = info;
	}

	/**
	 * 根据数据参数查询具体信息
	 * 
	 * @param state
	 * @return
	 */
	public OrderItemStateEnum getPackState(int state) {
		for (OrderItemStateEnum packStateEnum : values()) {
			if (packStateEnum.getState() == state) {
				return packStateEnum;
			}
		}
		return null;
	}

}
