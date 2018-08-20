package com.pinyougou.enums;


import lombok.Getter;

/**
 * @author: 
 * 描述: 异常枚举-实现 commonEnum接口
 * @date: 
 * @version: 
 */
@Getter
public enum ErrorEnum implements CommonEnum{
	//系统
	SUCCESS("0000","请求成功"),
	SECUTIRY_ERROR("0030","安全验证未通过"),
	UNKNOWN_ERROR("0001","系统异常"),
	IP_OPERATION_OFTEN("0002","ip操作过于频繁"),
	DECRYPT_ERROR("0028","解密异常"),
	SESSION_NULL_ERROR("0003","session为空"),
	NOT_LOGIN("0004","用户未登录"),
	TIMED_OUT("00041","连接超时"),
	//登录注册
	HASBEEN_REG("0005","该手机号已经注册"),
	IMAGE_CODE_GENERATE_FAIL("0006","图形验证码生成失败"),
	IMAGE_CODE_NOT_MATCH("0007","图形验证码不匹配"),
	AUTH_CODE_SEND_FAIL("0008","手机验证码发送失败"),
	PWD_ERROR("0006","账号或密码有误"),
	NO_REGISTER("00091","手机号未注册"),
	PWD_LENGTH("00061","密码不能少于6位大于12位"),
	AUTH_CODE_INVAILD("0009","手机验证码匹配失败"),
	AUTH_CODE_EXPIRE("0010","手机验证码过期"),
	PHONE_REGISTER_ERROR("0011","手机注册失败"),
	UPDATE_LAST_LOGIN_TIME("0012","修改最后登录时间失败"),
	PHONE_OFTEN("0013","手机操作过于频繁，需要输入图形验证码"),
	//数据库、redis
	DATA_OPERTION_ERROR("0014","数据操作异常"),
	NAME_REPEAT("0015","名字重复"),
	UPDATE_DATA_SAME("0016","更新-更新的数据与原数据相同"),
	SELECT_NOT_ALLOW("0017","不允许这样的查询"),
	UPDATE_NOT_ALLOW("0018","不允许这样修改"),
	EXIST_START_COUPONBAG("00181","该红包中有正在启用的卷包，不能启用"),
	DATA_NOT_EXIST("0019","数据不存在"),
	//参数
	PARAM_NULL("0020","参数为空"),
	PARAM_ERROR("0029","参数错误"),
	PARAM_RESOLVE_ERROR("0021","参数解析异常"),
	//用户
	USER_PHONE_INVALID("0031","该手机号用户已失效"),
	USER_NOT_EXIST("0022","用户不存在"),
	USER_FROZEN("0023","用户被冻结"),
	USER_BALANCE_QUERY_FAIL("0036","用户余额查询失败"),
	//投标授权
	USER_NOT_AUTO_CAST_AUTH("0033","用户没有进行一键投标授权"),
	USER_ALREADY_AUTO_CAST_AUTH("0034","用户已经进行一键投标授权"),
	AUTO_CAST_AUTH_CALLBACK_ERROR("0035","投标授权回调放失败"),
	AUTO_CAST_AUTH_QUERY_FAIL("0055","一键投标授权查询失败"),
	AUTO_CAST_AUTH_SINGLE_OVER("0056","投标金额超过单次一键投标授权金额"),
	AUTO_CAST_AUTH_TOTAL_OVER("0057","投标金额超过累计一键投标授权金额"),
	//券包-红包
	COUPON_BAG_NOT_EXIST("0024","券包不存在"),
	COUPON_NOT_EXIST("0025","红包不存在"),
	CUSTOMER_COUPON_NOT_EXIST("0026","用户-红包关联不存在"),
	COUPON_YET_USABLE("0027","该红包有用户仍然在使用"),
	COUPON_ZERO("0037","该红包已被领取完"),
	COUPON_BAG_ZERO("0038","该券包已被领取完"),
	COUPON_NOT_ENOUGH("0039","卷包剩余数量不足发送所有用户"),
	//自动投标
	AUTO_CAST_NOT_OPEN("0032","用户未开启自动投标"),
	//投标
	ARGUMENT_ERROR("1001","参数异常"),
	USER_STATUS_ERROR("1002","用户状态异常"),
	BALANCE_LESS("1003","余额不足，请充值"),
	BIDDING_STATUS_ERROR("1004","标的已满"),
	BIDDING_PWD_ERROR("1005","标的密码不正确"),
	NO_CONFORM_AUTO_CAST_LIMIT("1006","不符合自定义自动投标规则异常"),
	COUPON_ERROR("1007","投标金额小于优惠券起投金额"),
	BALANCE_LIMIT_ERROR("1008","标的余额过少时，需全部买入"),
	BALANCE_INSUFFICIENT_ERROR("1020","您所购买的标,因被抢购所剩金额已经不足以满足该次投标！"),
	API_INTERNAL_ERROR("1009","投标系统异常"),//该异常返回的消息不确定，是将银行返回的异常消息返回
	INTERNAL_ERROR("1010","内部异常"),
	BORROWER_CUSTOMER_SAME_ERROR("1011","借款人投资人不能相同"),
	NOT_NEW_USER("1012","老用户无法投资新手标"),
	REPEAT_CAST_BIDDING("1013","不能重复投标"),
	BIDDING_BALANCE_LESS("1014","标的余额不足"),
	BIDDING_MIN_ERR("1021","投资金额小于标的最低起投金额"),
	BIDDING_CAST_FAILD("1017","投标失败"),
	BIDDING_CAST_MONEY("1019","投标金额不符合规则"),
	BIDDING_CAST_FRESH_OVER("1036","该标投资金额超限"),
	//标的相关
	BIDDING_FULL_FAILD("1015","满标失败！"),
	BIDDING_REFUND_FAILD("1016","满标失败！"),
	BIDDING_BOND_TRANS("1018","债卷转让！"),
	
	//banner位相关异常
	BANNER_POSITION_STATUS_FAILD("1021","状态错误"),
	BANNER_POSITION_NAME_NULL_FAILD("1022","名称为空"),
	BANNER_POSITION_POSITION_NULL_FAILD("1023","位置为空"),
	BANNER_POSITION_SORT_NULL_FAILD("1024","排序为空"),
	BANNER_POSITION_APPIMAGEURL_NULL_FAILD("1025","AppImageURL为空"),
	BANNER_POSITION_PCIMAGEURL_NULL_FAILD("1026","pcImageURL为空"),
	BANNER_POSITION_IMAGENAME_NULL_FAILD("1027","图片名为空"),
	BANNER_POSITION_WINDOWS_FAILD("1029","已经有弹窗在启用中，不能再发布弹窗！"),
	
    ACCURATE_MARKETING_TITLE_NULL_FAILD("1030","营销活动标题为空"),
    ACCURATE_MARKETING_RECEIVE_OBJECT_NULL_FAILD("1031","营销活动接收对象为空"),
    ACCURATE_MARKETING_AWARD_NULL_FAILD("1032","营销活动奖品类型为空"),
    ACCURATE_MARKETING_START_TIME_NULL_FAILD("1033","营销活动生效时间为空"),
    ACCURATE_MARKETING_END_TIME_NULL_FAILD("1034","营销活动截至时间为空"),
    ACCURATE_MARKETING_OVER_END_TIME("1035","营销活动超过截至时间"),
    
	ESIGN_ERROR("1028","e签宝异常")
	
	
	;
	
	private String code;
	private String message;
	private ErrorEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
