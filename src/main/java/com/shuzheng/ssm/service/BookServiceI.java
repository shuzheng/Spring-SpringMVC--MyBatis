package com.shuzheng.ssm.service;

import com.shuzheng.ssm.model.Book;

public interface BookServiceI extends BaseServiceI<Book> {
	
	Book getUser(int id);
}
