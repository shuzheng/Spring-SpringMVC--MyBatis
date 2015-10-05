package com.shuzheng.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shuzheng.ssm.model.User;

@Repository
public interface UserMapper {

	User get(int id);
	
	List<User> getAll(Map<String,Object> parameter);
	
	void insert(User user);
	
	void insertAutoKey(User user);
	
	void delete(int id);
	
	void update(User user);

	
	User getBooks(int id);
}
