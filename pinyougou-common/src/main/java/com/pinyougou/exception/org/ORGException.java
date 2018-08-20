package com.pinyougou.exception.org;

import com.pinyougou.enums.CommonEnum;

import lombok.Getter;
@Getter
public class ORGException extends RuntimeException{
	private static final long serialVersionUID = 7722047927480348731L;
	protected String code;
	public ORGException(CommonEnum commonEnum){
		super(commonEnum.getMessage());
		this.code = commonEnum.getCode();
	}
	
	public ORGException(String code, String message){
		super(message);
		this.code = code;
	}
	public ORGException(){}
}
