package com.shuzheng.ssm.service;

import com.shuzheng.ssm.model.User;

public interface UserServiceI extends BaseServiceI<User> {
	
	User getBooks(int id);
}
