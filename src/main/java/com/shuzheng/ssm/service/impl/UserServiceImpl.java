package com.shuzheng.ssm.service.impl;

import java.util.List;

import com.shuzheng.ssm.dao.IUserDao;
import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	public IUserDao geUserDao() {
		return userDao;
	}

	public void seUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void addUser(User user) throws Exception {
		userDao.save(user);
	}

	public void updateUser(User user) throws Exception {
		userDao.update(user);
	}
	
	public void deleteUser(int id) throws Exception {
		userDao.delete(geUserById(id));
	}

	public User geUserById(int id) throws Exception {
		return userDao.findById(id);
	}

	public List<User> geUserList() throws Exception {
		return userDao.findAll();
	}
	
	public User geUserByUsername(String username) throws Exception {
		List<User> list = userDao.findByUsername(username);
		return list==null || list.size() == 0 ? null : (User)list.get(0);
	}

}
