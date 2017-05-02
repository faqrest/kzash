package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.AuthorDAO;
import com.nixsolutions.entity.Author;
import com.nixsolutions.service.ServiceApi.AuthorService;

@Service
@Transactional
public class AuthorServiceImpl extends GeneralServiceImpl<Author> implements AuthorService {

	private AuthorDAO dao;
	
	@Autowired
	public AuthorServiceImpl(AuthorDAO dao) {
		super(dao);
		this.dao = dao;
	}

}
