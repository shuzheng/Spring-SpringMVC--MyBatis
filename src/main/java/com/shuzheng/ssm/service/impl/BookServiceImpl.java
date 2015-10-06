package com.shuzheng.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuzheng.ssm.dao.IBookDao;
import com.shuzheng.ssm.model.Book;
import com.shuzheng.ssm.service.IBookService;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book> implements IBookService {

	@Autowired
	private IBookDao bookDao;

	@Override
	public Book getUser(int id) {
		return bookDao.getUser(id);
	}
	
}
