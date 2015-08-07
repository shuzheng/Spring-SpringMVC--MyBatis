package com.shuzheng.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shuzheng.ssm.service.impl.UserServiceImpl;

//告诉DispatcherServlet相关的容器， 这是一个Controller， 管理好这个bean哦
@Controller
// 类级别的RequestMapping，告诉DispatcherServlet由这个类负责处理以跟URL。
// HandlerMapping依靠这个标签来工作
@RequestMapping("/hello")
public class HelloController {

	private static Log log = LogFactory.getLog(HelloController.class);

	private UserServiceImpl userService;

	public void setUserServiceImpl(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/index")
	public String index() {
		// 视图渲染，/WEB-INF/jsp/hello/world.jsp
		return "hello/world";
	}
	
	// 方法级别的RequestMapping， 限制并缩小了URL路径匹配，同类级别的标签协同工作，最终确定拦截到的URL由那个方法处理
	@RequestMapping("/world")
	public String world() {
		// 视图渲染，/WEB-INF/jsp/hello/world.jsp
		return "hello/world";
	}
/*
	// 本方法将处理 /courses/view?courseId=123 形式的URL
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {

		log.debug("In viewCourse, courseId = {}", courseId);
		Course course = courseService.getCoursebyId(courseId);
		model.addAttribute(course);
		return "course_overview";
	}

	// 本方法将处理 /courses/view2/123 形式的URL
	@RequestMapping("/view2/{courseId}")
	public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {

		log.debug("In viewCourse2, courseId = {}", courseId);
		Course course = courseService.getCoursebyId(courseId);
		model.put("course", course);
		return "course_overview";
	}

	// 本方法将处理 /courses/view3?courseId=123 形式的URL
	@RequestMapping("/view3")
	public String viewCourse3(HttpServletRequest request) {

		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		Course course = courseService.getCoursebyId(courseId);
		request.setAttribute("course", course);

		return "course_overview";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
	public String createCourse() {
		return "course_admin/edit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String doSave(@ModelAttribute Course course) {

		log.debug("Info of Course:");
		log.debug(ReflectionToStringBuilder.toString(course));

		// 在此进行业务操作，比如数据库持久化
		course.setCourseId(123);
		return "redirect:view2/" + course.getCourseId();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String showUploadPage(@RequestParam(value = "multi", required = false) Boolean multi) {
		if (multi != null && multi) {
			return "course_admin/multifile";
		}
		return "course_admin/file";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {

		if (!file.isEmpty()) {
			log.debug("Process file: {}", file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("c:\\temp\\imooc\\", System.currentTimeMillis() + file.getOriginalFilename()));
		}

		return "success";
	}

	@RequestMapping(value = "/doUpload2", method = RequestMethod.POST)
	public String doUploadFile2(MultipartHttpServletRequest multiRequest) throws IOException {

		Iterator<String> filesNames = multiRequest.getFileNames();
		while (filesNames.hasNext()) {
			String fileName = filesNames.next();
			MultipartFile file = multiRequest.getFile(fileName);
			if (!file.isEmpty()) {
				log.debug("Process file: {}", file.getOriginalFilename());
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File("c:\\temp\\imooc\\", System.currentTimeMillis() + file.getOriginalFilename()));
			}

		}

		return "success";
	}

	@RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	Course getCourseInJson(@PathVariable Integer courseId) {
		return courseService.getCoursebyId(courseId);
	}

	@RequestMapping(value = "/jsontype/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<Course> getCourseInJson2(@PathVariable Integer courseId) {
		Course course = courseService.getCoursebyId(courseId);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	*/
}
