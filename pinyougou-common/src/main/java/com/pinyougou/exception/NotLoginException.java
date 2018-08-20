package com.pinyougou.exception;

public class NotLoginException extends BaseException{
	
	private static final long serialVersionUID = 4713897493L;

	public NotLoginException(){
		super.setMsg("未登录异常！");
	}
}
