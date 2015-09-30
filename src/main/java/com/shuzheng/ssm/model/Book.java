package com.shuzheng.ssm.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * 书籍
 * 
 * @author shuzheng
 * 
 */
public class Book {

	private Integer id;
	private Integer userid;
	@NotEmpty(message = "书籍名称不能为空")
	@Size(min = 6, max = 20, message = "书籍名称必须在6~20位之间")
	private String name;

	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}