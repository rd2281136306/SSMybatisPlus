package com.pinyougou.enums;

import lombok.Getter;

@Getter
public enum AccurateMarketingEnum {
	
	ALL_CUSTOMER(0,"所有用户"),
	REGISTER_NO_AUTH(1,"已注册未认证"),
	AUTH_NO_INVEST(2,"已认证未投资"),
	NO_INVEST_OLD_CUSTOMER(3,"当前未投资老用户"),
	MAN(4,"男"),
	WOMAN(5,"女"),
	TOTAL_CAPTIAL(6,"资产总额"),
	BALANCE(7,"可用余额"),
	REFUND_ALL_MONEY(8,"待收总额");
	
	private Integer code;
	private String message;
	
	private AccurateMarketingEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}


