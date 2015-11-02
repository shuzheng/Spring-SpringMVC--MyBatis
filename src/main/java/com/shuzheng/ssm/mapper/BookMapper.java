package com.shuzheng.ssm.mapper;

import org.springframework.stereotype.Repository;

import com.shuzheng.ssm.model.Book;

@Repository
public interface BookMapper extends BaseMapper<Book> {
	
	Book getUser(int id);
}
