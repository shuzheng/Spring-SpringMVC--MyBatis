package com.shuzheng.ssm.interceptor;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	    HandlerMethod method = (HandlerMethod) handler;  
	    log.info(method.getMethod());
	    // 权限校验
		if (request.getSession().getAttribute("ADMIN") == null) {
			// 未登录状态
			if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
				//ajax访问
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=UTF-8");
				OutputStream out = response.getOutputStream();
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
				//返回json格式的提示
				pw.println("{\"result\":\"failed\",\"data\":\"您未登录,请先登录！\"}");
				pw.flush();
				pw.close();
			} else {
				// 直接访问
				String contextPath = request.getContextPath();
				String url = request.getServletPath();
				String query = request.getQueryString();
				if (query != null) {
					url += "?" + query;
				}
				response.sendRedirect(contextPath + "/manage/login?backurl=" + URLEncoder.encode(url, "UTF-8"));
			}
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}
