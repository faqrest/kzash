package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.GenreDAO;
import com.nixsolutions.entity.Genre;
import com.nixsolutions.service.ServiceApi.GenreService;

@Service
@Transactional
public class GenreServiceImpl extends GeneralServiceImpl<Genre> implements GenreService {

	private GenreDAO dao;
	
	@Autowired
	public GenreServiceImpl(GenreDAO dao) {
		super(dao);
		this.dao = dao;
	}

}
