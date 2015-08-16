package com.shuzheng.ssm.service;

import java.util.List;


public interface IBaseService<T> {
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	int save(T entity);
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	int delete(T entity);
	
	/**
	 * 单表分页查询
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<T> selectPage(int pageNum, int pageSize);
	
}
