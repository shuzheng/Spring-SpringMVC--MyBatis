package com.shuzheng.ssm.service;

import com.shuzheng.ssm.model.Book;

public interface IBookService extends IBaseService<Book> {
	
	Book getUser(int id);
}
