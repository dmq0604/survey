package com.learn.survey.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.survey.dao.BaseDao;

@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Override
	public void saveEntity(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void updateEntity(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void deleteEntity(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	@Override
	public void batchEntityByHQL(String hql, Object... objects) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
	}

	@Override
	public T loadEntity(Integer id) {
		return (T) sessionFactory.getCurrentSession().load(clazz, id);
	}

	@Override
	public T getEntity(Integer id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> getEntityByHQL(String hql, Object... objects) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}

}
