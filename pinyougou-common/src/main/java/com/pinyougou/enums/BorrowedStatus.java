package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 借款状态
 * @date: 
 * @version: 
 */
public enum BorrowedStatus {

	IN_THE_BORROWING("借款中"),BORROWING_SUCCESSFUL("借款成功"),UNDONE("借款撤销"),BORROWING_FAILURE("借款失败");
	
	public String title;

	private BorrowedStatus(String title) {
		this.title = title;
	}
	
	
}
