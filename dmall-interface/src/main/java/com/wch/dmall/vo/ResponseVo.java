package com.wch.dmall.vo;

import com.wch.dmall.enums.ResponseEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 统一响应对象
 *
 * @param <T>
 */
@Getter
@Setter
public class ResponseVo<T> implements Serializable {

    /**
     * 接口调用成功标志
     */
    private boolean success;

    /**
     * 接口调用状态码
     */
    private int code;

    /**
     * 接口调用消息提示
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    private ResponseVo(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseVo setResponse(boolean success, int code, String msg, T data) {
        return new ResponseVo<>(success, code, msg, data);
    }

    public static <T> ResponseVo setResponse(ResponseEnum responseEnum, T data) {
        return setResponse(responseEnum.getSuccess(), responseEnum.getCode(), responseEnum.getMsg(), data);
    }

    public static <T> ResponseVo setResponse(ResponseEnum responseEnum) {
        return setResponse(responseEnum.getSuccess(), responseEnum.getCode(), responseEnum.getMsg(), null);
    }
}
