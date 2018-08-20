package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 用户状态
 * @date: 
 * @version: 
 */
public enum PermissionStatus {
	
	VALID("有效"),INVALID("无效");
	
	public String title;

	private PermissionStatus(String title) {
		this.title = title;
	}
	
	
}
