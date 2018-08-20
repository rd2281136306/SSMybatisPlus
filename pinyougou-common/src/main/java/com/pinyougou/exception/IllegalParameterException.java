package com.pinyougou.exception;

/**
 * 
 * @author: 
 * 描述: TODO
 * @date: 
 * @version: 
 */
public class IllegalParameterException extends BaseException {
	
	private static final long serialVersionUID = 1L;
	public IllegalParameterException() {
	}

	public IllegalParameterException(Throwable ex) {
		super(ex);
	}

	public IllegalParameterException(String message) {
		super(message);
	}

	public IllegalParameterException(String message, Throwable ex) {
		super(message, ex);
	}

	
}
