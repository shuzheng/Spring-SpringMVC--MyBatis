package com.shuzheng.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuzheng.ssm.mapper.BookMapper;
import com.shuzheng.ssm.model.Book;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookServiceI {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public Book getUser(int id) {
		return bookMapper.getUser(id);
	}
	
}
