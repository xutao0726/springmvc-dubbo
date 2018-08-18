package com.jsw.mapper;

import java.util.List;

public interface BMapper<T> {
	
	T get(Integer id);
	
	T find(T t);
	
	T find(String id);
	T findById(String id);
	
	List<T> findList(T t);
	
	int save(T t);
	
	int delete(T t);
	
	int delete(String id);
	
	int count(T t);
	
	List<T> listAll();
	
	List<T> listAll(T t);

	List<T> list(T t);

    void update(T t);
    
	T getObj(T t);
	
	List<T> getListObj(T t);
	
	List<T> getPageList(T t);
	//
	int getCount(T t);
}
