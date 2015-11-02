package com.shuzheng.ssm.mapper;

import org.springframework.stereotype.Repository;

import com.shuzheng.ssm.model.User;

@Repository
public interface UserMapper extends BaseMapper<User> {

	User getBooks(int id);
}
