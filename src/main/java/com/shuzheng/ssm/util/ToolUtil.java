package com.shuzheng.ssm.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * 常用方法封装类
 * 
 * @author shuzheng
 * @version 2014/04/14
 *
 */
public class ToolUtil {

	/**
	 * 获取ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("Cdn-Src-Ip"); // 网宿cdn的真实ip，蓝讯的是HTTP_CLIENT_IP
		if (ip == null || ip.length() == 0 || " unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (ip == null || ip.length() == 0 || " unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP"); // 获取代理ip
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP"); // 获取代理ip
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr(); // 获取真实ip
		}
		return ip;
	}
	
	/**
	 * 获取请求参数列表
	 * @param request
	 * @return
	 */
	public static String getParams(HttpServletRequest request) {
		String params = "";
		Map map = request.getParameterMap();
		Set keSet = map.entrySet();
		for(Iterator itr = keSet.iterator();itr.hasNext();) {
			Map.Entry me = (Map.Entry) itr.next();
			Object ok = me.getKey();
			Object ov = me.getValue();
			String[] value = new String[1];
			if (ov instanceof String[]) {
				value = (String[])ov;
			} else {
				value[0] = ov.toString();
			}
			for(int k = 0; k < value.length; k ++) {
				if (ok.equals("content")) {
					continue;
				}
				if (params.equals("")) {
					params = ok + "=" + value[k];
				} else {
					params += "&" + ok + "=" + value[k];
				}
			}
		}
		return params;
	}
	
	/**
	 * 将url请求规范成REST风格的url：/manage/type/update/5 ==> /manage/type/update
	 * @param url
	 * @return
	 */
	public static String getREST(String url) {
		String[] urls = url.split("/");
		if (urls.length > 3) {
			try {
				url = url.substring(0, url.indexOf(urls[3]) + urls[3].length());
			} catch (Exception e) { }
		}
		if (url.endsWith("/")) {
			url = url.substring(0, url.length()-1);
		}
		if (url.split("/").length == 3) {
			url += "/index";
		}
		return url;
	}

	/**
	 * 是否包含敏感词
	 * 
	 * @param words
	 * @param content
	 * @return
	 */
	public static boolean checkWord(String[] words, String content) {
		boolean flag = false;
		for (String word : words) {
			if (content.indexOf(word) >= 0) {
				flag = true;
			}
		}
		return flag;
	}
}
