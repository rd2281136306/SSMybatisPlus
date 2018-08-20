package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 菜单状态
 * @date: 
 * @version: 
 */
public enum MenuStatus {
	
	VALID("有效"),INVALID("无效");
	
	public String title;

	private MenuStatus(String title) {
		this.title = title;
	}
	
	
}
