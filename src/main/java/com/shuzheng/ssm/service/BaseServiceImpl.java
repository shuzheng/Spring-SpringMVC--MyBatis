package com.shuzheng.ssm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuzheng.ssm.mapper.BaseMapper;

@Service
public class BaseServiceImpl<T> implements BaseServiceI<T> {

	@Autowired
	private BaseMapper<T> baseMapper;
	
	@Override
	public T get(int id) {
		return baseMapper.get(id);
	}

	@Override
	public long count(String condition) {
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
