package com.pinyougou.exception;

/**
 * @author 
 * @version 
 */
public class DataParseException extends BaseException {

	private static final long serialVersionUID = 1L;
	public DataParseException() {
	}

	public DataParseException(Throwable ex) {
		super(ex);
	}

	public DataParseException(String message) {
		super(message);
	}

	public DataParseException(String message, Throwable ex) {
		super(message, ex);
	}

	

}
