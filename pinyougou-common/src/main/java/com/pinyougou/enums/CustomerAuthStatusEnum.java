package com.pinyougou.enums;

import lombok.Getter;

/**
 * @author: 
 * 描述: 认证状态
 * @date: 
 * @version: 
 */
@Getter
public enum CustomerAuthStatusEnum {
	
	ALL_UNAUTH(0,"全未认证"),
	REAL_NAME_AUTH(1,"实名认证"),
	REAL_NAME_PWD_BANK(2,"实名、绑卡认证")
	;
	
	private Integer code;
	private String message;
	CustomerAuthStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	

}
