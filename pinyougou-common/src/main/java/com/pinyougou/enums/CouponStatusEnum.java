package com.pinyougou.enums;

import lombok.Getter;

/**
 * @author: 
 * 描述: 红包状态枚举
 * @date: 
 * @version: 
 */
@Getter
public enum CouponStatusEnum {
	
	NOT_SETTING(0,"未设置"),
	START(1,"启用"),
	STOP(2,"停用");
	
	
	private Integer code;
	private String message;
	private CouponStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
}
