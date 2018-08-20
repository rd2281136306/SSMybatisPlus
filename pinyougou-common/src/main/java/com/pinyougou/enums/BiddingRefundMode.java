package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 标的还款方式
 * @date: 
 * @version: 
 */
public enum BiddingRefundMode {
	
	NULL("没有还款方式",0),
	FUN1("月还息到期还本",1),
	FUN2("到期本息",2),
	FUN3("等额本息",3);
	
	public String info;
	public Integer code;
	
	private BiddingRefundMode(String info,Integer code) {
		this.info = info;
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
