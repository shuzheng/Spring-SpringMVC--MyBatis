package com.shuzheng.ssm.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * 后台控制器
 * @author shuzheng
 * @date 2015-10-07
 */
@Controller
@RequestMapping("/manage")
public class ManageController {

	private static Log log = LogFactory.getLog(ManageController.class);
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("ADMIN") == null) {
			return "redirect:/manage/login";
		}
		return "/manage/index";
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		if (session.getAttribute("ADMIN") != null) {
			return "redirect:/manage";
		}
		return "/manage/login";
	}
	
	/**
	 * 处理登录
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		if (username == null || !username.equals("admin")) {
			session.setAttribute("result", "帐号不存在！");
			return "redirect:/manage/login";
		}
		if (password == null || !password.equals("123123")) {
			session.setAttribute("result", "密码错误！");
			return "redirect:/manage/login";
		}
		session.setAttribute("ADMIN", "admin");
		return "redirect:/manage";
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("ADMIN") != null) {
			session.removeAttribute("ADMIN");
		}
		return "redirect:/manage";
	}
	
}
