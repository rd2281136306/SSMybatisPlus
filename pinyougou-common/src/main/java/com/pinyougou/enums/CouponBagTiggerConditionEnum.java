package com.pinyougou.enums;

import lombok.Getter;

/**
 * @author: 
 * 描述: 券包触发条件
 * @date: 
 * @version: 
 */
@Getter
public enum CouponBagTiggerConditionEnum {
	
	NULL(0,"无"),
	REGISTER(1,"注册"),
	REGISTEREFEE(2,"推荐人获注册红包"),
	AUTHCRADREFEE(3,"推荐人获绑卡红包"),
	COMPLETEDEPOSIT(4,"完成存管"),
	FIRSTINVEST(5,"首次投资"),
	REALNAMEREFEE(6,"推荐人获实名红包"),
	FIRSTINVESTREFEE(7,"推荐人获首投红包")
	
	;
	
	private Integer code;
	private String message;
	private CouponBagTiggerConditionEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
}
