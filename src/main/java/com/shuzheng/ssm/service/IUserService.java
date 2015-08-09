package com.shuzheng.ssm.service;

import com.shuzheng.ssm.model.User;

public interface IUserService {
	
	User geUserById(int id) throws Exception;
	
}
