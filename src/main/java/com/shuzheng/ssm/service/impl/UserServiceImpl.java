package com.shuzheng.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuzheng.ssm.dao.UserMapper;
import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	private UserMapper userDao;

	@Autowired
	public void setUserDao(UserMapper userDao) {
		this.userDao = userDao;
	}

	@Override
	public User geUserById(int id) throws Exception {
		return userDao.geUserById(id);
	}

}
