package com.pinyougou.enums;
/**
 * @author: 
 * 描述: 债权转让的状态
 * @date: 
 * @version: 
 */
public enum BondTransferStatus {

	/*1：等待转让；2：成功转让；3：过期转让*/
	WAIT(2), SUCCESS(1),OVERDUE(3);

	private int value;

	private BondTransferStatus(int value) {
	        this.value = value;
	    }

	public int getValue() {
		return value;
	}

	public boolean isRest() {
		return false;
	}

}
