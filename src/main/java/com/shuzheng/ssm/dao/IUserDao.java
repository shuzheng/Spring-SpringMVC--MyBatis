package com.shuzheng.ssm.dao;

import org.springframework.stereotype.Repository;

import com.shuzheng.ssm.model.User;

@Repository
public interface IUserDao extends IBaseDao<User> {

	User getBooks(int id);
}
