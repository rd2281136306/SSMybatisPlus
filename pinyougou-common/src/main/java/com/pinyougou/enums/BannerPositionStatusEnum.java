package com.pinyougou.enums;

import lombok.Getter;

/**
 * 
 * 描述: banner位状态枚举类
 * @author: 
 * @date: 
 * @version: 
 */
@Getter
public enum BannerPositionStatusEnum {
	
	STOP(0,"停用"),
	START(1,"启用");
	
	private Integer code;
	private String message;
	
	private BannerPositionStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
		
}




