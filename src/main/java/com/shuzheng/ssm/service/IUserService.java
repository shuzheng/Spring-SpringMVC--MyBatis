package com.shuzheng.ssm.service;

import java.util.List;

import com.shuzheng.ssm.model.User;

public interface IUserService<T> {
	
	User geUserById(int id);
	
	List<User> findAll();
	
}
