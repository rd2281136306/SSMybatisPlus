package com.pinyougou.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;

import net.minidev.json.JSONObject;

public class Jwt {
    private static final byte[] SECRET="f774a3ed0822uo2@@~eb51cl!4".getBytes();
    private static final JWSHeader header=new JWSHeader(JWSAlgorithm.HS256, JOSEObjectType.JWT, null, null, null, null, null, null, null, null, null, null, null);
    
	/**
	 * 生成token
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param payload
	 * @return
	 * @return: String
	 */
	public static String createToken(Map<String, Object> payload) {
		String tokenString=null;
		// 创建一个 JWS object
		JWSObject jwsObject = new JWSObject(header, new Payload(new JSONObject(payload)));
		try {
			// 将jwsObject 进行HMAC签名
			jwsObject.sign(new MACSigner(SECRET));
			tokenString=jwsObject.serialize();
		} catch (JOSEException e) {
			System.err.println("签名失败:" + e.getMessage());
			e.printStackTrace();
		}
		return tokenString;
	}
    
    
    
    /**
     * 校验token
     * @Description: TODO
     * @author: 
     * @date: 
     * @version: 
     * @param token
     * @return
     * @return: Map<String,Object>
     */
	public static Map<String, Object> validToken(String token) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			JWSObject jwsObject = JWSObject.parse(token);
			Payload payload = jwsObject.getPayload();
			JWSVerifier verifier = new MACVerifier(SECRET);
			if (jwsObject.verify(verifier)) {
				JSONObject jsonOBj = payload.toJSONObject();
				// token校验成功（此时没有校验是否过期）
				resultMap.put("state", TokenState.VALID.toString());
				// 若payload包含ext字段，则校验是否过期
				if (jsonOBj.containsKey("ext")) {
					long extTime = Long.valueOf(jsonOBj.get("ext").toString());
					long curTime = new Date().getTime();
					// 过期了
					if (curTime > extTime) {
						resultMap.clear();
						resultMap.put("state", TokenState.EXPIRED.toString());
					}
				}
				resultMap.put("data", jsonOBj);

			} else {
				resultMap.put("state", TokenState.INVALID.toString());
			}
		} catch (Exception e) {
			resultMap.clear();
			resultMap.put("state", TokenState.INVALID.toString());
		}
		return resultMap;
	}	
}


