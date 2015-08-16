package com.shuzheng.ssm.service;

import com.shuzheng.ssm.model.User;

public interface IUserService<T> extends IBaseService<T> {
	
	User geUserById(int id) throws Exception;
	
}
