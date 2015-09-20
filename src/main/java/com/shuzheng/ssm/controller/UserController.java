package com.shuzheng.ssm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService<User> userService;

	
	@RequestMapping("/list")
	public String list(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "/user/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "/user/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid User user, BindingResult binding, Model model) {
		if (binding.hasErrors()) {
			return "user/add";
		}
		
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		
		return "redirect:/user/list";
	}
	
	@RequestMapping("/index")
	public @ResponseBody User index() {
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
