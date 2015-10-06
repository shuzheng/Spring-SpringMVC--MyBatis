package com.shuzheng.ssm.service;

import com.shuzheng.ssm.model.User;

public interface IUserService extends IBaseService<User> {
	
	User getBooks(int id);
}
