package com.pinyougou.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

import com.pinyougou.constant.CommonParam;
 
   
@SuppressWarnings("deprecation")
public class HttpClientUtils {  
    private static PoolingHttpClientConnectionManager connectionManager = null;  
    private static HttpClientBuilder httpBulder = null;  
    private static RequestConfig requestConfig = null;  
    private static int MAXCONNECTION = 200;  
    private static int DEFAULTMAXCONNECTION = 100;  
    /*"http://111.203.228.5:58001"  http://192.168.2.161:8080*/;  // 富民银行IP 后期修改
    public static HttpUriRequest getRequestMethod(Map<String, String> map, String url, String method) {  
        List<NameValuePair> params = new ArrayList<NameValuePair>();  
        Set<Map.Entry<String, String>> entrySet = map.entrySet();  
        for (Map.Entry<String, String> e : entrySet) {  
            String name = e.getKey();  
            String value = String.valueOf(e.getValue());  
            NameValuePair pair = new BasicNameValuePair(name, value);  
            params.add(pair);  
        }  
        HttpUriRequest reqMethod = null; 
        // 只处理POST请求
        reqMethod = RequestBuilder.post().setUri(CommonParam.BankParam.IP+CommonParam.BankParam.SERVICE_PREIX+url) 
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build(); 
        
        return reqMethod;  
    }
    public static CloseableHttpClient getConnection() {  
        CloseableHttpClient httpClient = httpBulder.build();  
        httpClient = httpBulder.build();  
        return httpClient;  
    }  
    static {  
        //设置http的状态参数  
        requestConfig = RequestConfig.custom()  
                .setSocketTimeout(5000)  
                .setConnectTimeout(5000)  
                .setConnectionRequestTimeout(5000) 
                .build();  
        HttpHost target = new HttpHost(CommonParam.BankParam.IP, CommonParam.BankParam.PORT);
        connectionManager = new PoolingHttpClientConnectionManager();  
        connectionManager.setMaxTotal(MAXCONNECTION);  
        connectionManager.setDefaultMaxPerRoute(DEFAULTMAXCONNECTION);  
        connectionManager.setMaxPerRoute(new HttpRoute(target), MAXCONNECTION);  //为富民设置最大连接个数
        httpBulder = HttpClients.custom();  
        httpBulder.setConnectionManager(connectionManager);  
    }
    
    
    /**   
     * 发送xml请求到server端   
     * @param url xml请求数据地址   
     * @param xmlString 发送的xml数据流   
     * @return null发送失败，否则返回响应内容   
     */      
    public static String sendPostXml(String target,String xmlString){      
        //创建httpclient工具对象     
    	String responseResult="";
    	 try {
			@SuppressWarnings("resource")
			HttpClient httpclient = new DefaultHttpClient(); 
			 HttpPost httppost = new HttpPost(target); 
			 StringEntity myEntity = new StringEntity(xmlString, "UTF-8"); 
			 httppost.addHeader("Content-Type", "text/xml"); 
			 httppost.setEntity(myEntity); 
			 HttpResponse response = httpclient.execute(httppost); 
			 HttpEntity resEntity = response.getEntity(); 
			 InputStreamReader reader = new InputStreamReader(resEntity.getContent(), "UTF-8"); 
			 char[] buff = new char[1024]; 
			 int length = 0; 
			 
			 while ((length = reader.read(buff)) != -1) { 
				responseResult+=new String(buff, 0, length);
			 } 
			 httpclient.getConnectionManager().shutdown();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        return responseResult;
    }     
}  