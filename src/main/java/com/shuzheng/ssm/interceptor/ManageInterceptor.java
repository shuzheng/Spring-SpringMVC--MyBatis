package com.shuzheng.ssm.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 后台过滤器
 * @author shuzheng
 * @date 2015-10-07
 */
public class ManageInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println(">>> manage:preHandle");
		String url = request.getServletPath();
		System.out.println(">>> url:" + url);
		if (request.getSession().getAttribute("ADMIN") != null) {
			return true;
		}
		// 页面参数
		String query = request.getQueryString();
		if (query != null) {
			url += "?" + query;
		}
		System.out.println(">>> urls:" + url);
		response.sendRedirect("/manage/login?backurl=" + URLEncoder.encode(url, "UTF-8"));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println(">>> manage:postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println(">>> manage:afterCompletion");
	}

}
