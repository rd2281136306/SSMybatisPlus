package com.pinyougou.config;

import java.io.Serializable;

/**
 * GeetestWeb配置文件 极验
 *
 */
public class GeetestConfig implements Serializable{

	private static final long serialVersionUID = 1L;

	// 填入自己的captcha_id和private_key
	private static final String geetest_id = "0ad3a44e7246b827d990920077a85164";
	private static final String geetest_key = "997af1d2a226f490b51963711c0cf620";
	private static final boolean newfailback = true;

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}

	public static final boolean isnewfailback() {
		return newfailback;
	}
}
