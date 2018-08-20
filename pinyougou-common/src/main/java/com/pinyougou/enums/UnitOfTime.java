package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 时间单位
 * @date: 
 * @version: 
 */
public enum UnitOfTime {
	
	MONTH("月"),DAY("天");
	
	public String title;

	private UnitOfTime(String title) {
		this.title = title;
	}

}
