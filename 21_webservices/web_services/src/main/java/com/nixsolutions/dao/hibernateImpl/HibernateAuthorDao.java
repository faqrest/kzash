package com.nixsolutions.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.Author;
import com.nixsolutions.dao.DAOApi.AuthorDAO;

@Repository
public class HibernateAuthorDao extends GeneralDAO<Author> implements AuthorDAO {

	public HibernateAuthorDao() {
		super(Author.class);
	}

}
