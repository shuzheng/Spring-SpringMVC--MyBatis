package com.shuzheng.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseMapper<T> {

	// 根据id获取一条记录
	T get(int id);

	// 根据条件获取数量
	long count(String condition);
	
	// 根据map参数查询多条记录
	List<T> getAll(Map<String,Object> parameters);
	
	// 插入一条数据
	void insert(T t);
	
	// 插入一条数据并返回id
	void insertAutoKey(T t);
	
	// 根据id删除一条数据
	void delete(int id);
	
	// 更新一条数据
	void update(T t);
	
}
