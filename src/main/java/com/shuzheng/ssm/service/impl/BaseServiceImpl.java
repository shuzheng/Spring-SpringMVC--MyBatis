package com.shuzheng.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuzheng.ssm.dao.IBaseDao;
import com.shuzheng.ssm.service.IBaseService;

@Service
public class BaseServiceImpl<T> implements IBaseService<T> {

	@Autowired
	private IBaseDao<T> baseDao;
	
	@Override
	public T get(int id) {
		return baseDao.get(id);
	}

	@Override
	public long count(String condition) {
		return baseDao.count(condition);
	}

	@Override
	public List<T> getAll(Map<String,Object> parameters) {
		return baseDao.getAll(parameters);
	}

	@Override
	public void insert(T t) {
		baseDao.insert(t);
	}

	@Override
	public void insertAutoKey(T t) {
		baseDao.insertAutoKey(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

}
