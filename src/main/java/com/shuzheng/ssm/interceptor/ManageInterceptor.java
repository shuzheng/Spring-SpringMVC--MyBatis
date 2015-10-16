package com.shuzheng.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 后台过滤器
 * @author shuzheng
 * @date 2015-10-07
 */
public class ManageInterceptor implements HandlerInterceptor {

	private static Log log = LogFactory.getLog(ManageInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info(">>> manage:preHandle");
		String url = request.getServletPath();
		log.info(">>> url:" + url);
		if (request.getSession().getAttribute("ADMIN") != null) {
			return true;
		}
		// 页面参数
		String query = request.getQueryString();
		if (query != null) {
			url += "?" + query;
		}
		log.info(">>> urls:" + url);
		log.info(handler.getClass());  
	    HandlerMethod handlerMethod = (HandlerMethod) handler;  
	    log.info(handlerMethod.getMethod());
		//response.sendRedirect("/manage/login?backurl=" + URLEncoder.encode(url, "UTF-8"));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.info(">>> manage:postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info(">>> manage:afterCompletion");
	}

}
