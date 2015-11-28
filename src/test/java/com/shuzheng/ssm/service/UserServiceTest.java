package com.shuzheng.ssm.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shuzheng.ssm.mapper.UserMapper;
import com.shuzheng.ssm.model.Book;
import com.shuzheng.ssm.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class UserServiceTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@Test
	public void getBooksTest() {
		User user = userMapper.getBooks(1);
		List<Book> books = user.getBooks();
		for (Book book : books) {
			System.out.println(user.getNickname() + ":" + book.getName());
		}
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
}
