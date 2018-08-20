package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 借款返款类型
 * @date: 
 * @version: 
 */
public enum BorrowedRefundWay {
	
	MONTH_EXPIRE_RETURN("月到期返款");
	
	public String title;

	private BorrowedRefundWay(String title) {
		this.title = title;
	}
	
}
