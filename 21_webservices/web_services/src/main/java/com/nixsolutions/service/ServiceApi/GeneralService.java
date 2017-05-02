package com.nixsolutions.service.ServiceApi;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.entity.User;

public interface GeneralService<E extends Serializable> {

	public void save(E obj) throws SQLException;

	public E getById(int id) throws SQLException;

	public void update(E obj);

	public void delete(int id) throws Exception;

	public List<E> getAll();

}
