package com.pinyougou.enums;

import lombok.Getter;

/**
 * 
 * 描述: banner位的位置枚举类
 * @author: 
 * @date: 
 * @version: 
 */
@Getter
public enum BannerPositionEnum {

	PC_HOME(0,"pc首页"),
	APP_HOME(1,"app首页");
	
	private Integer code;
	private String message;
	
	private BannerPositionEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}



