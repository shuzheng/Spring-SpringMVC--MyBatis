package com.shuzheng.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "backurl", required = false) String backurl, HttpSession session) throws UnsupportedEncodingException {
		Map<String, String> json = new HashMap<String, String>(); 
		if (username == null || !username.equals("admin")) {
			json.put("result", "failed");
			json.put("data", "该账号不存在！");
			return json;
		}
		if (password == null || !password.equals("123123")) {
			json.put("result", "failed");
			json.put("data", "密码错误！");
			return json;
		}
		session.setAttribute("ADMIN", "admin");
		json.put("result", "success");
		json.put("data", URLDecoder.decode(backurl, "UTF-8"));
		return json;
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
