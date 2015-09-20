package com.shuzheng.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuzheng.ssm.mapper.UserMapper;
import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;

@Service
public class UserServiceImpl<T> extends BaseService<T> implements IUserService<T> {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User geUserById(int id) {
		return userMapper.geUserById(id);
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

}
