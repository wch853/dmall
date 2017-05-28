package com.dmall.enums;

/**
 * 订单项打包状态数据字典
 * 
 * @author wch
 *
 */
public enum PackStateEnum {

	UNPACKED(1, "未打包"), PACKED(2, "已打包");

	private int state;
	private String info;
	
	public int getState() {
		return state;
	}

	public String getInfo() {
		return info;
	}

	private PackStateEnum(int state, String info) {
		this.state = state;
		this.info = info;
	}
	
	public PackStateEnum getPackState(int index) {
		for (PackStateEnum packStateEnum : values()) {
			if (packStateEnum.getState() == index) {
				return packStateEnum;
			}
		}
		return null;
	}

}
