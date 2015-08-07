package com.shuzheng.ssm.dao;

import java.util.List;

import com.shuzheng.ssm.model.User;

public interface IUserDao {

	public abstract void save(User user);

	public abstract void delete(User user);
	
	public abstract User update(User user);

	public abstract User findById(Integer id);

	public abstract List<User> findByUsername(String username);

	public abstract List<User> findAll();

}