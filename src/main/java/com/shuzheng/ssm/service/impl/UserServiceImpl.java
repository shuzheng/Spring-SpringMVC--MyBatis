package com.shuzheng.ssm.service.impl;

import org.springframework.stereotype.Service;

import com.shuzheng.ssm.dao.IUserDao;
import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	@Override
	public User geUserById(int id) throws Exception {
		return userDao.geUserById(id);
	}

}
