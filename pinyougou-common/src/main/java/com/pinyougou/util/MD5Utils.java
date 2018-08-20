package com.pinyougou.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Base64Utils;

import com.pinyougou.constant.CommonParam;


/**
 * @author: 
 * 描述: MD5加密工具类
 * @date: 
 * @version:
 */
public class MD5Utils {
	 static Logger logger = Logger.getLogger(MD5Utils.class);
	 
	 private static final String[] strDigits = { "0", "1", "2", "3", "4", "5",
	            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	 
	/**
	 * @Description: md5加密
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @return: String
	 */
	public static String encryptPwd(String pwd, String salt)
			 {
		String assemblyPwd = salt + pwd + salt;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
		}
		return Base64Utils.encodeToString(md5.digest(assemblyPwd.getBytes()));
	}

	/**
	 * @Description: 验证密码
	 * @author:
	 * @date: 
	 * @version: 
	 * @param pwd
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @return: boolean
	 */
	public static boolean validatePwd(String pwd, String salt, String loginPwd)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String assemblyPwd = salt + loginPwd + salt;
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		if (!pwd.equals(Base64Utils.encodeToString(md5.digest(assemblyPwd.getBytes())))) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(encry("adminadmin1498184354000"));
		System.out.println(encryptPwd("adminadmin", "11223311"));
	}
	  // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }
    /**
     * MD5加密
     * @param strObj
     * @return
     * @throws Exception
     */
    public static String encry(String str) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        return byteToString(md.digest(str.getBytes()));
    }
     public static String sign(String content, String charset) throws Exception {
        String signData = content + CommonParam.BankParam.SEC_KEY;
        try {
            String sign = DigestUtils.md5Hex(signData.getBytes(charset));
            logger.info("MD5签名[content=" + content + "; charset = " + charset + "]结果：" + sign);
            return sign;
        } catch (UnsupportedEncodingException e) {
            logger.error("MD5签名[content=" + content + "; charset = " + charset + "]时发生异常！", e);
            throw new Exception(e);
        }
    }
}
