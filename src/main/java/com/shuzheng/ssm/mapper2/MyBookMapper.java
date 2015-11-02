package com.shuzheng.ssm.mapper2;

import org.springframework.stereotype.Repository;

import com.shuzheng.ssm.mapper.BaseMapper;
import com.shuzheng.ssm.mapper.BookMapper;
import com.shuzheng.ssm.model.Book;

@Repository
public interface MyBookMapper {
	
	Book getUser(int id);
}
