package com.shuzheng.ssm.controller;

import javax.validation.Valid;

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
	
	@Autowired
	private BookServiceI<Book> bookService;
	
	@Autowired
	private UserServiceI<User> userService;
	
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
		return "redirect:/user/books/" + id;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{userid}/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable int userid, @PathVariable int id) {
		bookService.delete(id);
		return "redirect:/user/books/" + userid;
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
		return "redirect:/user/books/" + book.getUserid();
	}

}
