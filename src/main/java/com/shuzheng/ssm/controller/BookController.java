package com.shuzheng.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.shuzheng.ssm.model.Book;
import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.BookServiceI;
import com.shuzheng.ssm.service.UserServiceI;
import com.shuzheng.ssm.util.Paginator;

@Controller
@RequestMapping("/book")
public class BookController {
	
	private static Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private BookServiceI bookService;
	
	/**
	 * 书籍列表
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public String list(@PathVariable int id,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int rows,
			HttpServletRequest request) {
		// 查询参数
		String clumns = " * ";
		String condition = " userid=" + id;
		String order = " id asc ";
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("clumns", clumns);
		parameters.put("condition", condition);
		parameters.put("order", order);
		// 创建分页对象
		long total = bookService.count(condition);
		Paginator paginator = new Paginator();
		paginator.setTotal(total);
		paginator.setPage(page);
		paginator.setRows(rows);
		paginator.setParam("page");
		paginator.setUrl(request.getRequestURI());
		paginator.setQuery(request.getQueryString());
		// 调用有分页功能的方法
		parameters.put("paginator", paginator);
		List<Book> books = bookService.getAll(parameters);
		// 返回数据
		request.setAttribute("id", id);
		request.setAttribute("books", books);
		request.setAttribute("paginator", paginator);
		// 一对多
//		User user = userService.getBooks(id);
//		model.addAttribute("user", user);
		return "/book/list";
	}
	
	/**
	 * 新增get
	 * @return
	 */
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String add(@PathVariable int id, Model model) {
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
		// 一对一，可返回user信息
		//model.addAttribute("book", bookService.getUser(id));
		model.addAttribute("book", bookService.get(id));
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
