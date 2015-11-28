package com.shuzheng.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.shuzheng.ssm.mapper.BaseMapper;
import com.shuzheng.ssm.service.IBaseService;

@Service
public class BaseServiceImpl<T> implements IBaseService<T> {

	@Autowired
	private BaseMapper<T> baseMapper;
	
	@Override
	public T get(int id) {
		return baseMapper.get(id);
	}

	@Override
	public long count(String condition) {
		Assert.hasText(condition, "查询条件不能为空！");
		return baseMapper.count(condition);
	}

	@Override
	public List<T> getAll(Map<String,Object> parameters) {
		return baseMapper.getAll(parameters);
	}

	@Override
	public void insert(T t) {
		baseMapper.insert(t);
	}

	@Override
	public void insertAutoKey(T t) {
		baseMapper.insertAutoKey(t);
	}

	@Override
	public void delete(int id) {
		baseMapper.delete(id);
	}

	@Override
	public void update(T t) {
		baseMapper.update(t);
	}

}
