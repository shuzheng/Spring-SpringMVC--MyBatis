package com.shuzheng.ssm.service;

import java.util.List;

import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.util.Page;

public interface UserServiceI<T> {
	
	User get(int id);
	
	List<User> getAll(Page page);
	
	void insert(User user);
	
	void insertAutoKey(User user);
	
	void delete(int id);
	
	void update(User user);

	
	User getBooks(int id);
}
