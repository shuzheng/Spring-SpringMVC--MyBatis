package com.shuzheng.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuzheng.ssm.dao.UserMapper;
import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;

@Service
public class UserServiceImpl<T> extends BaseService<T> implements IUserService<T> {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User geUserById(int id) throws Exception {

		return userMapper.geUserById(id);
	}

}
