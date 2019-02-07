package com.wch.dmall.enums;

import lombok.Getter;

/**
 * 响应枚举
 */
@Getter
public enum ResponseEnum {

    SUCCESS(true, 2000, "成功"),

    FAIL(false, 5000, "失败"),

    SERVER_INTERNAL_ERROR(false, 5001, "服务器内部错误"),

    INVALID_PARAM(false, 5002, "参数错误"),

    FORBIDDEN(false, 5003, "无权限");

    /**
     * 接口调用成功标志
     */
    private Boolean success;

    /**
     * 接口调用状态码
     */
    private int code;

    /**
     * 接口调用消息提示
     */
    private String msg;

    ResponseEnum(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
}
