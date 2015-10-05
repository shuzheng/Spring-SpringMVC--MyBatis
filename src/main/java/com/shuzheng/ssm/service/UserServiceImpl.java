package com.shuzheng.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuzheng.ssm.mapper.UserMapper;
import com.shuzheng.ssm.model.User;
import com.shuzheng.ssm.util.Page;

@Service
public class UserServiceImpl<T> implements UserServiceI<T> {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User get(int id) {
		return userMapper.get(id);
	}

	@Override
	public List<User> getAll(Page page) {
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("pageBean", page);
		parameter.put("user", new User());
		return userMapper.getAll(parameter);
	}

	@Override
	public void insert(User user) {
		user.setCtime(System.currentTimeMillis());
		userMapper.insert(user);
	}

	@Override
	public void insertAutoKey(User user) {
		user.setCtime(System.currentTimeMillis());
		userMapper.insertAutoKey(user);
	}

	@Override
	public void delete(int id) {
		userMapper.delete(id);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}


	@Override
	public User getBooks(int id) {
		return userMapper.getBooks(id);
	}
	
}
