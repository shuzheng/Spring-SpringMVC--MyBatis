package com.shuzheng.ssm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private IUserService userService;

	@RequestMapping("/index")
	public @ResponseBody
	User index() throws Exception {
		User user = userService.geUserById(1);
		return user;
	}

}
