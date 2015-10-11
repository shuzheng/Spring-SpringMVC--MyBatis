package com.shuzheng.ssm.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;
import com.shuzheng.ssm.util.DateUtil;
import com.shuzheng.ssm.util.Paginator;

@Controller
@RequestMapping("/user")
public class UserController extends ApplicationController {
	
	private static Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private IUserService userService;

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
	 * @param page
	 * @param rows
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int rows,
			HttpServletRequest request) {
		// 查询参数
		String clumns = " * ";
		String condition = " id>0 ";
		String order = " id asc ";
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("clumns", clumns);
		parameters.put("condition", condition);
		parameters.put("order", order);
		// 创建分页对象
		long total = userService.count(condition);
		Paginator paginator = new Paginator();
		paginator.setTotal(total);
		paginator.setPage(page);
		paginator.setRows(rows);
		paginator.setParam("page");
		paginator.setUrl(request.getRequestURI());
		paginator.setQuery(request.getQueryString());
		// 调用有分页功能的方法
		parameters.put("paginator", paginator);
		List<User> users = userService.getAll(parameters);
		// 返回数据
		request.setAttribute("users", users);
		request.setAttribute("paginator", paginator);
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
		user.setCtime(System.currentTimeMillis());
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
		user.setCtime(System.currentTimeMillis());
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
	
	/**
	 * 上传文件
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Object upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
		// 返回结果
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断上传文件类型
		String contentType = file.getContentType().toLowerCase();
		if ((!contentType.equals("image/jpeg")) && 
				(!contentType.equals("image/pjpeg")) && 
				(!contentType.equals("image/png")) && 
				(!contentType.equals("image/x-png")) && 
				(!contentType.equals("image/bmp")) && 
				(!contentType.equals("image/gif"))) {
			map.put("result", "failed");
			map.put("data", "不支持该类型的文件！");
			return map;
		}
		// 创建图片目录
		String basePath = request.getSession().getServletContext().getRealPath("/attached");
		String fileName = file.getOriginalFilename();
		String savePath = basePath + "/images/" + DateUtil.getNow("yyyyMMdd");
		File targetFile = new File(savePath, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存图片
		file.transferTo(targetFile);
		map.put("result", "success");
		map.put("data", targetFile.getAbsoluteFile());
		return map;
	}
	
}
