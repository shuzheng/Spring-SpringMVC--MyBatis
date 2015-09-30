package com.shuzheng.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuzheng.ssm.mapper.BookMapper;
import com.shuzheng.ssm.model.Book;

@Service
public class BookServiceImpl<T> implements BookServiceI<T> {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public Book get(int id) {
		return bookMapper.get(id);
	}

	@Override
	public List<Book> getAll() {
		return bookMapper.getAll();
	}

	@Override
	public void insert(Book book) {
		bookMapper.insert(book);
	}

	@Override
	public void insertAutoKey(Book book) {
		bookMapper.insertAutoKey(book);
	}

	@Override
	public void delete(int id) {
		bookMapper.delete(id);
	}

	@Override
	public void update(Book book) {
		bookMapper.update(book);
	}


	@Override
	public Book getUser(int id) {
		return bookMapper.getUser(id);
	}
	
}
