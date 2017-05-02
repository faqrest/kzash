package com.nixsolutions.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.nixsolutions.dao.DAOApi.GenreDAO;
import com.nixsolutions.entity.Genre;

@Repository
public class HibernateGenreDao extends GeneralDAO<Genre> implements GenreDAO {

	public HibernateGenreDao() {
		super(Genre.class);
	}

}
