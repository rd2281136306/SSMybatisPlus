package com.pinyougou.util.yfsms;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pinyougou.constant.Constants.CloudFengParam;
import com.pinyougou.util.DateUtils;
import com.pinyougou.util.MD5Utils;

/**
 * 云峰短信 @XmlAttribute是标签内属性 @XmlElement是子元素标签
 * 
 * @author:  
 * 描述: TODO
 * @date: 
 * @version: 
 */
@XmlRootElement(name = "xml")
public class CloudFengSms {
	@XmlElement
	public Head head;
	@XmlElement
	public Body body;
	public static String buildSign(String timestamp,String content,String phone,String missionNum){
		@SuppressWarnings({ "unchecked", "rawtypes" })
		TreeMap<String, Object> tm = new TreeMap();
    	tm.put("app_key", CloudFengParam.KEY);
    	tm.put("batch_num", "qiandaikj"+missionNum);
    	tm.put("content", content);
    	tm.put("dest_id",phone);
    	tm.put("mission_num", "100001");
    	tm.put("nonce_str", "qiandaikj");
    	tm.put("sms_type", "verify_code");
    	tm.put("time_stamp", timestamp);
    	String url = "";
    	Set<String> keys = tm.keySet();
        for (String key : keys){
             url+="&"+key+"="+tm.get(key);
        }
        url = url.substring(1)+"&app_secret="+CloudFengParam.SECRET;
        System.out.println(url);
        try {
			String sign = MD5Utils.encry(url);
			System.out.println(sign);
			return sign;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	/**云峰短信取消*/
	public static boolean sendSms(String content,String phone){
		/*String sendsms = CloudFengSms.buildSms(content,phone);
		String result = HttpClientUtils.sendPostXml(CloudFengParam.IP,sendsms);
		if(result.contains("<error_code>000000</error_code>")){
			return true;
		}
		return false;*/   
		return true;
	}
	
	public static String buildSms(String content, String phone) {
		PhoneOrder phoneOrder = new PhoneOrder();
		phoneOrder.phone=phone;
		phoneOrder.missionNum = "100001";
		String date = DateUtils.returnNormalDate(new Date());
		StringWriter result = null;
		CloudFengSms xl = new CloudFengSms();
		Head head = new Head();
		head.appKey = CloudFengParam.KEY;
		head.nonceStr = "qiandaikj";
		head.timeStamp =  date;
		head.sign = buildSign(date,content,phoneOrder.phone,phoneOrder.missionNum);
		xl.head = head;
		Body body = new Body();
		body.batchNum=CloudFengParam.DEFAULT_BATCHNUM;//
		body.smsType = "verify_code";
		body.dests.destList = Arrays.asList(phoneOrder);
		body.content = content;
		xl.body = body;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(CloudFengSms.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setListener(new MarshallerListener());
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			result = new StringWriter();
			jaxbMarshaller.marshal(xl, result);
			return result.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}finally {  
            if(result != null) {  
                try {  
                	result.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
                result = null;  
            }  
        }  
		return null;
	}
}

@XmlRootElement(name = "head")
class Head {
	@XmlElement(name = "app_key")
	public String appKey;
	@XmlElement(name = "time_stamp")
	public String timeStamp;
	@XmlElement(name = "nonce_str")
	public String nonceStr;
	@XmlElement(name = "sign")
	public String sign;
}

@XmlRootElement(name = "body")
class Body {
	@XmlElement(name = "dests")
	public PhoneOrders dests = new PhoneOrders();
	@XmlElement(name = "batch_num")
	public String batchNum;
	@XmlElement(name = "sms_type")
	public String smsType;
	@XmlElement(name = "content")
	public String content;
}

@XmlRootElement(name = "dests")
class PhoneOrders {
	@XmlElement(name = "dest")
	public List<PhoneOrder> destList;
}

@XmlRootElement(name = "dest")
class PhoneOrder {
	@XmlElement(name = "mission_num")
	public String missionNum;
	@XmlElement(name = "dest_id")
	public String phone;
	PhoneOrder(){}
	PhoneOrder(String missionNum,String phone){
		this.missionNum = missionNum;
		this.phone = phone;
	}
}

/**
 * jaxb空值监听器，如果为空，则设置默认值
 * @author: 
 * 描述: TODO
 * @date: 
 * @version: 
 */
class MarshallerListener extends Marshaller.Listener {
	public static final String BLANK_CHAR = "";
	@Override
	public void beforeMarshal(Object source) {
		super.beforeMarshal(source);
		Field[] fields = source.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			// 获取字段上注解<pre name="code" class="java">
			try {
				if (f.getType() == String.class && f.get(source) == null) {
					f.set(source, BLANK_CHAR);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}

