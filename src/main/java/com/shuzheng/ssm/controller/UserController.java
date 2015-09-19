package com.shuzheng.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService<User> userService;

	@RequestMapping("/index")
	public @ResponseBody User index() throws Exception {
		User user = userService.geUserById(1);
		return user;
//		User u;
//		for (int i = 1; i <= 100; i ++) {
//			u = new User();
//			u.setCtime(System.currentTimeMillis());
//			u.setNickname("用户" + i);
//			u.setPassword("123456");
//			u.setSex(1);
//			u.setUsername("username" + i);
//			
//			userService.save(u);
//		}
//		
//		return user;
	}

}
