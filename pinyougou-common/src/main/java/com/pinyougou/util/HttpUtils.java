package com.pinyougou.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.util.StringUtils;


@SuppressWarnings("deprecation")
public class HttpUtils {

	public static final String UTF8 = "utf-8";
	public static final String GBK = "gbk";
	public static final String GB2312 = "gb2312";
	public static final String ISO88591 = "ISO-8859-1";
	public static int READ_TIMEOUT = 30000;
	public static int CONNECT_TIMEOUT = 30000;
	
	public static HttpResponse doGet(String host, String path, String method, 
			Map<String, String> headers, 
			Map<String, String> querys)
            throws Exception {    	
    	HttpClient httpClient =  wrapClient(host);

    	HttpGet request = new HttpGet(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
        	request.addHeader(e.getKey(), e.getValue());
        }
        
        return httpClient.execute(request);
    }
	/**
	 * post请求数据
	 * 
	 * @param connectURL
	 * @param param
	 * @param charset
	 * @return
	 */
	public static String doPost(String connectURL, String param, String charset) {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOut = null;
		URL url = null;
		HttpURLConnection httpPost = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			url = new URL(connectURL);
			httpPost = (HttpURLConnection) url.openConnection();
			httpPost.setRequestMethod("POST");
			httpPost.setDoInput(true);
			httpPost.setDoOutput(true);
			httpPost.setUseCaches(false);
			httpPost.setConnectTimeout(CONNECT_TIMEOUT);
			httpPost.setReadTimeout(READ_TIMEOUT);
			httpPost.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpPost.connect();
			out = httpPost.getOutputStream();
			out.write(param.getBytes(charset));
			out.flush();
			in = httpPost.getInputStream();
			byteArrayOut = new ByteArrayOutputStream();
			byte[] buf = new byte[512];
			int l = 0;
			while ((l = in.read(buf)) != -1) {
				byteArrayOut.write(buf, 0, l);
			}
			bytes = byteArrayOut.toByteArray();
			return new String(bytes, charset);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(byteArrayOut);
			close(out);
			close(in);
			close(httpPost);
		}
		return null;
	}

	public static String doPostSSL(String connectURL, Map<String, String> params, String charset)
			throws MalformedURLException, IOException, UnsupportedEncodingException {
		_ignoreSSL();
		return doPost(connectURL, params, charset);
	}

	/**
	 * post请求数据
	 * 
	 * @param connectURL
	 * @param param
	 * @param charset
	 * @return
	 */
	public static String doPost(String connectURL, Map<String, String> params, String charset) {
		String param = "";
		if (params != null && !params.isEmpty()) {
			StringBuffer paramBuf = new StringBuffer();
			for (Iterator<String> it = params.keySet().iterator(); it.hasNext();) {
				String key = it.next();
				String value = params.get(key);
				paramBuf.append("&").append(key).append("=").append(value);
			}
			param = paramBuf.substring(1);
		}
		System.out.println("post url:" + connectURL);
		System.out.println("post data:" + param);
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOut = null;
		URL url = null;
		HttpURLConnection httpPost = null;
		OutputStream out = null;
		BufferedInputStream in = null;
		try {
			url = new URL(connectURL);
			httpPost = (HttpURLConnection) url.openConnection();
			httpPost.setRequestMethod("POST");
			httpPost.setDoInput(true);
			httpPost.setDoOutput(true);
			httpPost.setUseCaches(false);
			httpPost.setConnectTimeout(CONNECT_TIMEOUT);
			httpPost.setReadTimeout(READ_TIMEOUT);
			httpPost.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpPost.connect();
			out = httpPost.getOutputStream();
			out.write(param.getBytes(charset));
			out.flush();

			try {
				in = new BufferedInputStream(httpPost.getInputStream());
			} catch (IOException e) {
				in = new BufferedInputStream(httpPost.getErrorStream());
			}

			byteArrayOut = new ByteArrayOutputStream();
			byte[] buf = new byte[512];
			int l = 0;
			while ((l = in.read(buf)) != -1) {
				byteArrayOut.write(buf, 0, l);
			}
			bytes = byteArrayOut.toByteArray();
			return new String(bytes, charset);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(byteArrayOut);
			close(in);
			close(out);
			close(httpPost);
		}
		return null;
	}

	/**
	 * Get请求数据
	 * 
	 * @param connectURL
	 * @param param
	 * @param charset
	 * @return
	 */
	public static String doGet(String connectURL, String charset) {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOut = null;
		URL url = null;
		HttpURLConnection httpGet = null;
		InputStream in = null;
		try {
			url = new URL(connectURL);
			httpGet = (HttpURLConnection) url.openConnection();
			httpGet.setConnectTimeout(CONNECT_TIMEOUT);
			httpGet.setReadTimeout(READ_TIMEOUT);
			httpGet.connect();
			in = httpGet.getInputStream();
			byteArrayOut = new ByteArrayOutputStream();
			byte[] buf = new byte[512];
			int l = 0;
			while ((l = in.read(buf)) != -1) {
				byteArrayOut.write(buf, 0, l);
			}
			bytes = byteArrayOut.toByteArray();
			return bytes != null ? new String(bytes, charset) : null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(byteArrayOut);
			close(in);
			close(httpGet);
		}
		return null;
	}

	private static void close(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
				stream = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void close(HttpURLConnection httpConn) {
		if (httpConn != null) {
			httpConn.disconnect();
		}
	}

	private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
		@Override
		public boolean verify(String s, SSLSession sslsession) {
			return true;
		}
	};

	/**
	 * 忽略SSL
	 */
	private static void _ignoreSSL() {
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			// Install the all-trusting trust manager

			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
		} catch (KeyManagementException ex) {
			Logger.getLogger(HttpUtils.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(HttpUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
    	StringBuilder sbUrl = new StringBuilder();
    	sbUrl.append(host);
    	if (!StringUtils.isEmpty(path)) {
    		sbUrl.append(path);
        }
    	if (null != querys) {
    		StringBuilder sbQuery = new StringBuilder();
        	for (Map.Entry<String, String> query : querys.entrySet()) {
        		if (0 < sbQuery.length()) {
        			sbQuery.append("&");
        		}
        		if (StringUtils.isEmpty(query.getKey()) && !StringUtils.isEmpty(query.getValue())) {
        			sbQuery.append(query.getValue());
                }
        		if (!StringUtils.isEmpty(query.getKey())) {
        			sbQuery.append(query.getKey());
        			if (!StringUtils.isEmpty(query.getValue())) {
        				sbQuery.append("=");
        				sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
        			}        			
                }
        	}
        	if (0 < sbQuery.length()) {
        		sbUrl.append("?").append(sbQuery);
        	}
        }
    	
    	return sbUrl.toString();
    }
	private static HttpClient wrapClient(String host) {
		HttpClient httpClient = new DefaultHttpClient();
		if (host.startsWith("https://")) {
			sslClient(httpClient);
		}
		
		return httpClient;
	}
	
	private static void sslClient(HttpClient httpClient) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] xcs, String str) {
                	
                }
                public void checkServerTrusted(X509Certificate[] xcs, String str) {
                	
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = httpClient.getConnectionManager();
            SchemeRegistry registry = ccm.getSchemeRegistry();
            registry.register(new Scheme("https", 443, ssf));
        } catch (KeyManagementException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchAlgorithmException ex) {
        	throw new RuntimeException(ex);
        }
    }
	public static String INTRANET_IP = getIntranetIp(); // 内网IP
	public static String INTERNET_IP = getInternetIp(); // 外网IP

	/**
	 * 获得外网IP
	 * 
	 * @Description: TODO
	 * @author:  
	 * @date:  
	 * @version:  
	 * @return
	 * @return 外网IP
	 */
	public static String getInternetIp() {
		try {
			Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			Enumeration<InetAddress> addrs;
			while (networks.hasMoreElements()) {
				addrs = networks.nextElement().getInetAddresses();
				while (addrs.hasMoreElements()) {
					ip = addrs.nextElement();
					if (ip != null && ip instanceof Inet4Address && ip.isSiteLocalAddress()
							&& !ip.getHostAddress().equals(INTRANET_IP)) {
						return ip.getHostAddress();
					}
				}
			}
			// 如果没有外网IP，就返回内网IP
			return INTRANET_IP;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获得内网IP
	 * 
	 * @Description: TODO
	 * @author:  
	 * @date:  
	 * @version: 
	 * @return 内网IP
	 */
	private static String getIntranetIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}