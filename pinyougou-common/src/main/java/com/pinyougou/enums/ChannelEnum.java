package com.pinyougou.enums;

import lombok.Getter;

/**
 * @author: 
 * 描述: 设备通道-银行接口
 * @date: 
 * @version: 
 */
@Getter
public enum ChannelEnum {
	
	PC("00","PC端"),
	MOBILE("01","手机端"),
	PAD("02","PAD端"),
	OTHER("03","其它"),
	
	;
	
	private String code;
	private String message;
	private ChannelEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
