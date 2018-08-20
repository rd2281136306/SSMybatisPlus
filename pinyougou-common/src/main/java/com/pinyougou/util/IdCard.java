package com.pinyougou.util;

import lombok.Data;

@Data
public class IdCard {

	public IdCard() {
		// TODO Auto-generated constructor stub
	}

	// 身份证号码  
    private String idCard;  
      
    // 出生日期  
    private String born;  
      
    // 性别  
    private String sex;  
      
    // 所在地区  
    private String att;  
}
