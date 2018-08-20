package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 判断菜单是否属于管理操作菜单
 * @date: 
 * @version: 
 */
public enum MenuIsOperation {
	
	YES("是"),ISNOT("不是");
	
	public String title;
	
	private MenuIsOperation(String title){
		this.title = title;
	}
}
