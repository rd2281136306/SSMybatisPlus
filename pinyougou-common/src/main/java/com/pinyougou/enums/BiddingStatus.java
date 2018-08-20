package com.pinyougou.enums;

/**
 * @author: 
 * 描述: 标状态
 * @date: 
 * @version: 
 */
public enum BiddingStatus {
	AUTO_CASTING("自动投标进行中",1),
	WAITING_CHECK("待初审标",2),
	CASTING("投标中",3),
	DEPRECATED("废弃",4),
	WAITING_AGAIN_CHECK("待复审",5),
	SUCCESSFUL("成功",6),
	WAIT_BORROWER_CONFIRM("等待借款人确认",7),
	WAIT_CASTING("等待后台发标",8);
	
	public String info;
	public Integer code;
	private BiddingStatus(String info,Integer code) {
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
