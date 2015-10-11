package com.shuzheng.ssm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 全局控制器
 * @author shuzheng
 * @date 2015-10-11
 */
@Controller
public class ApplicationController {

	private static Log log = LogFactory.getLog(ApplicationController.class);
	
	@RequestMapping("/error")
	public String error() {
		return "/error";
	}
	
}
