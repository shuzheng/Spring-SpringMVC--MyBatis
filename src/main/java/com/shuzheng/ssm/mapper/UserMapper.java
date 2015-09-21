package com.shuzheng.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shuzheng.ssm.model.User;

@Repository
public interface UserMapper {

	User geUserById(int id);
	
	List<User> findAll();
}
