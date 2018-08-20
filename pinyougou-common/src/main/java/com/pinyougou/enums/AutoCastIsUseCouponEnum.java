package com.pinyougou.enums;

import lombok.Getter;

/**
 * @author: 
 * 描述: 用户自动投标是否使用红包
 * @date: 
 * @version: 
 */
@Getter
public enum AutoCastIsUseCouponEnum {
	
	NOT_USE(0,"不使用"),
	USE(1,"使用");
	
	private Integer code;
	private String message;
	private AutoCastIsUseCouponEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	
}
