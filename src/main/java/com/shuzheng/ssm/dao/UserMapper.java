package com.shuzheng.ssm.dao;

import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;

import com.shuzheng.ssm.model.User;

@Repository
public interface UserMapper extends Mapper<User> {

	User geUserById(int id);
	
}
