package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 活动金类型
 * @date: 
 * @version: 
 */
public enum ActivityOfGoldType {
	
	REMIT("汇款"),RECYCLE("打款");
	
	public String title;

	private ActivityOfGoldType(String title) {
		this.title = title;
	}
}
