package com.shuzheng.ssm.dao;

import org.springframework.stereotype.Repository;

import com.shuzheng.ssm.model.Book;

@Repository
public interface IBookDao extends IBaseDao<Book> {
	
	Book getUser(int id);
}
