package com.nixsolutions.dao.DAOApi;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAOApi<T> {
	
	List<T> getAll();

    T getById(int key) throws SQLException;

    void save(T entity) throws SQLException;

    void delete(int key) throws Exception;

    void update(T entity);
}
