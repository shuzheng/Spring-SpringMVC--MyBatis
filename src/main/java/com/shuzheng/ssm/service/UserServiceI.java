package com.shuzheng.ssm.service;

import java.util.List;

import com.shuzheng.ssm.model.User;

public interface UserServiceI<T> {
	
	User get(int id);
	
	List<User> getAll();
	
	void insert(User user);
	
	void delete(int id);
	
	void update(User user);
	
}
