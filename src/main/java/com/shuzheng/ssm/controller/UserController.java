package com.shuzheng.ssm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/index")
	public @ResponseBody User index() throws Exception {
		User user = userService.geUserById(1);
		
		User u;
		for (int i = 1; i <= 100; i ++) {
			u = new User();
			u.setCtime(System.currentTimeMillis());
			u.setNickname("用户" + i);
			u.setPassword("123456");
			u.setSex(1);
			u.setUsername("username" + i);
			userService.save(u);
			u = null;
		}
		
		return user;
	}

}
