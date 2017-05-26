package com.dmall.enums;

/**
 * 登录情况数据字典
 * @author wch
 *
 */
public enum LoginEnum {

	FAIL(0, "fail"),

	SUCCESS(1, "success");

	private int state;
	private String info;

	LoginEnum(int state, String info) {
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

	public static LoginEnum getEnum(int index) {
		for (LoginEnum loginEnum : values()) {
			if (loginEnum.getState() == index) {
				return loginEnum;
			}
		}

		return null;
	}
}
