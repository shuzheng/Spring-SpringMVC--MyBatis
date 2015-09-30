package com.shuzheng.ssm.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.UserServiceI;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserServiceI<User> userService;

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("")
	public String index() {
		return "redirect:/user/list";
	}
	
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		return "/user/list";
	}
	
	/**
	 * 新增get
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "/user/add";
	}
	
	/**
	 * 新增post
	 * @param user
	 * @param binding
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid User user, BindingResult binding) {
		if (binding.hasErrors()) {
			return "user/add";
		}
		userService.insert(user);
		return "redirect:/user/list";
	}
	
	/**
	 * 新增post2,返回自增主键值
	 * @param user
	 * @param binding
	 * @return
	 */
	@RequestMapping(value = "/add2", method = RequestMethod.POST)
	public String add2(@Valid User user, BindingResult binding) {
		if (binding.hasErrors()) {
			return "user/add";
		}
		userService.insertAutoKey(user);
		System.out.println(user.getId());
		return "redirect:/user/list";
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/user/list";
	}
	
	/**
	 * 修改get
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.get(id));
		return "/user/update";
	}
	
	/**
	 * 修改post
	 * @param id
	 * @param user
	 * @param binding
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable int id, @Valid User user, BindingResult binding, Model model) {
		if (binding.hasErrors()) {
			model.addAttribute("errors", binding.getAllErrors());
			return "user/update/" + id;
		}
		userService.update(user);
		return "redirect:/user/list";
	}
	
}
