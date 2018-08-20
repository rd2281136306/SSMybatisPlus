package com.pinyougou.enums;

import lombok.Getter;
/**
 * 
 * @author: 
 * 描述: 消息通知表type，类型： 0：短信 1：邮件
 * @date: 
 * @version: 
 */
@Getter
public enum MessageInformLogTypeEnum {
	
	SMS(0,"短信"),
	MAIL(1,"邮件");
	
	private Integer code;
	private String message;
	private MessageInformLogTypeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
