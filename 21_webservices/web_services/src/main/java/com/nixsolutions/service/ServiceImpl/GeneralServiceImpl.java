package com.nixsolutions.service.ServiceImpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.GeneralDAOApi;
import com.nixsolutions.service.ServiceApi.GeneralService;

@Service
@Transactional
public class GeneralServiceImpl<E extends Serializable> implements GeneralService<E> {

	private GeneralDAOApi<E> dao;
	
	public GeneralServiceImpl() {}

	public GeneralServiceImpl(GeneralDAOApi<E> dao) {
		this.dao = dao;
	}

	@Override
	public void save(E obj) throws SQLException {
		dao.save(obj);
	}

	@Override
	public E getById(int id) throws SQLException {
		return dao.getById(id);
	}

	@Override
	public void update(E obj) {
		dao.update(obj);

	}

	@Override
	public void delete(int id) throws Exception {
		dao.delete(id);
	}

	@Override
	public List<E> getAll() {

		return dao.getAll();
	}

}
