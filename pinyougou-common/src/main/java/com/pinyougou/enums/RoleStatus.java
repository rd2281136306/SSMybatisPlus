package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 用户状态
 * @date: 
 * @version: 
 */
public enum RoleStatus {
	
	VALID("有效"),INVALID("无效");
	
	public String title;

	private RoleStatus(String title) {
		this.title = title;
	}
	
	
}
