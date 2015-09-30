package com.shuzheng.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shuzheng.ssm.model.Book;

@Repository
public interface BookMapper {

	Book get(int id);
	
	List<Book> getAll();
	
	void insert(Book book);
	
	void insertAutoKey(Book book);
	
	void delete(int id);
	
	void update(Book book);
	
	
	Book getUser(int id);
}
