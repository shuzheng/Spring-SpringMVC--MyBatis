package com.shuzheng.ssm.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shuzheng.ssm.model.User;

public class UserDaoImpl implements com.shuzheng.ssm.dao.IUserDao {

	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		log.debug("user save");
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		log.debug("user delete");
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		log.debug("user update");
		return null;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		log.debug("user findById {}", id);
		return null;
	}

	@Override
	public List<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		log.debug("user findByUsername {}", username);
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		log.debug("user findAll");
		return null;
	}

}