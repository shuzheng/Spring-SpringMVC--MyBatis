package com.shuzheng.ssm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static Log log = LogFactory.getLog(IndexController.class);

	@RequestMapping
	public String index() {
		return "hello/world";
	}

}
