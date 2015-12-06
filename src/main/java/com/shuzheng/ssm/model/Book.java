package com.shuzheng.ssm.model;


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