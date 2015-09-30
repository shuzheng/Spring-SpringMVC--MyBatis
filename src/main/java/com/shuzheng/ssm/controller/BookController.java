package com.shuzheng.ssm.controller;

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

import com.shuzheng.ssm.model.Book;
import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.BookServiceI;
import com.shuzheng.ssm.service.UserServiceI;

@Controller
@RequestMapping("/book")
public class BookController {
	
	private static Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private BookServiceI<Book> bookService;
	
	@Autowired
	private UserServiceI<User> userService;

	/**
	 * 书籍列表
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public String list(@PathVariable int id, Model model) {
		log.debug(id);
		User user = userService.getBooks(id);
		model.addAttribute("user", user);
		return "/book/list";
	}
	
	/**
	 * 新增get
	 * @return
	 */
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String add(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.get(id));
		return "/book/add";
	}
	
	/**
	 * 新增post
	 * @param book
	 * @param binding
	 * @return
	 */
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public String add(@PathVariable int id, @Valid Book book, BindingResult binding) {
		if (binding.hasErrors()) {
			return "book/add/" + id;
		}
		book.setUserid(id);
		bookService.insert(book);
		return "redirect:/book/list/" + id;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{userid}/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable int userid, @PathVariable int id) {
		bookService.delete(id);
		return "redirect:/book/list/" + userid;
	}
	
	/**
	 * 修改get
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("book", bookService.getUser(id));
		return "/book/update";
	}
	
	/**
	 * 修改post
	 * @param id
	 * @param book
	 * @param binding
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable int id, @Valid Book book, BindingResult binding, Model model) {
		if (binding.hasErrors()) {
			model.addAttribute("errors", binding.getAllErrors());
			return "book/update/" + id;
		}
		bookService.update(book);
		return "redirect:/book/list/" + book.getUserid();
	}

}
