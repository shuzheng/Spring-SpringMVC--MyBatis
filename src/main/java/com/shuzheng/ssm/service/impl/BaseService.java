package com.shuzheng.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

import com.github.pagehelper.PageHelper;
import com.shuzheng.ssm.service.IBaseService;

@Service
public class BaseService<T> implements IBaseService<T> {

	@Autowired
	protected Mapper<T> mapper;

	@Override
	public int save(T entity) {
		return mapper.insert(entity);
	}

	@Override
	public int delete(T entity) {
		return mapper.deleteByPrimaryKey(entity);
	}

	@Override
	public List<T> selectPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		// Spring4支持泛型注入
		return mapper.select(null);
	}

}
