package com.nixsolutions.dao.hibernateImpl;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nixsolutions.dao.DAOApi.GeneralDAOApi;

@Transactional
public abstract class GeneralDAO<T> implements GeneralDAOApi<T> {

	private Class<T> type;

	@Autowired
	SessionFactory sessionFactory;

	public GeneralDAO(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(type).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(int key) throws SQLException {
		return (T) sessionFactory.getCurrentSession().get(type, key);
	}

	@Override
	public void save(T entity) throws SQLException {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(int key) throws Exception {
		T entity = this.getById(key);
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}
}
