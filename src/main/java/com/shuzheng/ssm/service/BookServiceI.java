package com.shuzheng.ssm.service;

import java.util.List;

import com.shuzheng.ssm.model.Book;

public interface BookServiceI<T> {
	
	Book get(int id);
	
	List<Book> getAll();
	
	void insert(Book book);
	
	void insertAutoKey(Book book);
	
	void delete(int id);
	
	void update(Book book);
	
	
	Book getUser(int id);
}
