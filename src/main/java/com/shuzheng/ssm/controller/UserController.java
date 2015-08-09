package com.shuzheng.ssm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Log log = LogFactory.getLog(UserController.class);

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/index")
	public @ResponseBody
	User index() throws Exception {
		IUserService s = userService;
		User user = s.geUserById(1);
		return user;
	}

}
