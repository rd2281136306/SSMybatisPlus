package com.pinyougou.enums;

import lombok.Getter;

/*
 * 信息认证部分错误列表
 */
@Getter
public enum AuthEnum {
	SUCCESS("0000","验证通过"),
	ALREADY_BIDDING("0001","用户已经绑定成功"),
	CODE_EXPIRED("0002","验证码10分钟有效期已过，请重发验证码！"),
	ONLY_ONE("0003","一位用户只能绑定一张银行卡"),
	REALNAME("0004","请先实名认证"),
	FACTOR_MISMATCH("0005","手机号或银行卡要素不匹配"),
	NUMBER_NOT_SUPPORTED("0006","该银行卡号暂不支持！");
	
	
	private String code;
	private String message;
	private AuthEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
