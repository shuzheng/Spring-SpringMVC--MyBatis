package com.shuzheng.ssm.service;

import java.util.List;

import com.shuzheng.ssm.model.User;

public interface IUserService {
	
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	void deleteUser(int id) throws Exception;
	User geUserById(int id) throws Exception;
	List<User> geUserList() throws Exception;
	User geUserByUsername(String username) throws Exception;
	
}
