package com.wch.dmall.exception;

/**
 * 业务公共异常
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
