package com.shuzheng.ssm.mapper2;

import org.springframework.stereotype.Repository;

import com.shuzheng.ssm.mapper.UserMapper;
import com.shuzheng.ssm.model.User;

@Repository
public interface MyUserMapper {

	User getBooks(int id);
}
