package com.learn.survey.dao;

import java.util.List;

public interface BaseDao<T> {
	
	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void updateEntity(T t);
	public void deleteEntity(T t);
	public void batchEntityByHQL(String hql,Object ...objects);
	
	public T loadEntity(Integer id);
	public T getEntity(Integer id);
	public List<T> getEntityByHQL(String hql,Object...objects);

}
