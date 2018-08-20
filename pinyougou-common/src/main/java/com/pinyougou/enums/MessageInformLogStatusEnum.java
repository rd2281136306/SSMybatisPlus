package com.pinyougou.enums;

import lombok.Getter;
/**
 * 
 * @author: 
 * 描述: 消息状态
 * @date: 
 * @version: 
 */
@Getter
public enum MessageInformLogStatusEnum {
	NOT_SEND(0,"未发送"),
	SUCCESS(1,"发送完成"),
	FAIL(2,"发送失败");
	
	private Integer code;
	private String message;
	private MessageInformLogStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
