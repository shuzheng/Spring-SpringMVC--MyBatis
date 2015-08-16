package com.shuzheng.ssm.dao;

import tk.mybatis.mapper.common.Mapper;

import com.shuzheng.ssm.model.User;

public interface UserMapper extends Mapper<User> {

	User geUserById(int id);
	
}
