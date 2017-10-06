package com.dmall.exception;

/**
 * 用户未登录异常
 * 
 * @author wch
 *
 */
public class NoClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoClientException(String message) {
		super(message);
	}

}
