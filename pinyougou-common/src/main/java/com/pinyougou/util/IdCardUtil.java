package com.pinyougou.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.alibaba.fastjson.JSON;

public class IdCardUtil {

	public IdCardUtil() {
		// TODO Auto-generated constructor stub
	}

	public static IdCard getIdCardInfo(String cardNo) {
		URL url = null;
		IdCard idCard = new IdCard();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			url = new URL("http://api.k780.com:88/?app=idcard.get&idcard=" + cardNo
					+ "&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=xml");

			System.out.println(url);

			Document doc = builder.parse(url.openStream());
			NodeList node = doc.getElementsByTagName("result");

			for (int i = 0; i < node.getLength(); i++) {
				String idcard = "";
				String born = "";
				String sex = "";
				String att = "";
				if (doc.getElementsByTagName("idcard").item(i).getFirstChild() != null) {
					idcard = doc.getElementsByTagName("idcard").item(i).getFirstChild().getNodeValue();
				}
				if (doc.getElementsByTagName("born").item(i).getFirstChild() != null) {
					born = doc.getElementsByTagName("born").item(i).getFirstChild().getNodeValue();
				}
				if (doc.getElementsByTagName("sex").item(i).getFirstChild() != null) {
					sex = doc.getElementsByTagName("sex").item(i).getFirstChild().getNodeValue();
				}
				if (doc.getElementsByTagName("att").item(i).getFirstChild() != null) {
					att = doc.getElementsByTagName("att").item(i).getFirstChild().getNodeValue();
				}
				idCard.setIdCard(idcard);
				idCard.setBorn(born);
				idCard.setSex(sex);
				idCard.setAtt(att);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return idCard;
	}

	public static String getIdCardDetail(String cardNo) throws UnsupportedEncodingException {
		// 获取身份证信息
		IdCard idcard = getIdCardInfo(cardNo);

		// 存储文本信息
		StringBuffer news = new StringBuffer();

		if (idcard != null) {
			news.append("所属地区:" + idcard.getAtt()).append("\n");
			news.append("出生日期:" + idcard.getBorn()).append("\n");
			news.append("性别:" + idcard.getSex()).append("\n");
		}

		if (news.length() == 0) {
			news.append("身份证号码").append(cardNo).append("不存在,请重新输入!");
		}

		return news.toString();
	}
	
	public static int getSex(String code) {
		int sex = 0;
		if (code.length() == 18) {
			if (Integer.parseInt(code.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
				sex = 0;
			} else {
				sex = 1;
			}
		} else if (code.length() == 15) {
			String usex = code.substring(14, 15);// 用户的性别
			if (Integer.parseInt(usex) % 2 == 0) {
				sex = 0;
			} else {
				sex = 1;
			}
		}
		return sex;
	}
	
	public static int IdNOToAge(String IdNO) {
		int leh = IdNO.length();
		String dates = "";
		if (leh == 18) {
			// int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
			dates = IdNO.substring(6, 10);
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String year = df.format(new Date());
			int u = Integer.parseInt(year) - Integer.parseInt(dates);
			return u;
		} else {
			dates = IdNO.substring(6, 8);
			return Integer.parseInt(dates);
		}

	}
	
	public static Date getBirthdayByIdCard(String idcard) {
		String idCardNumber = idcard.trim();
		int idCardLength = idCardNumber.length();
		String birthday = null;
		if (idCardLength == 18) {
			birthday = idcard.substring(6, 10) + "-" + idcard.substring(10, 12) + "-" + idcard.substring(12, 14);
		}

		if (idCardLength == 15) {
			birthday = "19" + idCardNumber.substring(6, 10) + "-" + idCardNumber.substring(8, 10) + "-"
					+ idCardNumber.substring(10, 12);
		}
		Date birthdate = null;
		try {
			birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();

		}
		return birthdate;
	}

	public static void main(String[] args) {
			System.out.print(JSON.toJSONString(getIdCardInfo("341004199411110411")));
	}
}
