package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 用户状态
 * @date: 
 * @version: 
 */
public enum UserStatus {
	
	VALID("有效"),INVALID("无效"),FREEZE("冻结");
	
	public String title;

	private UserStatus(String title) {
		this.title = title;
	}
	
	
}
