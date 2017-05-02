package com.nixsolutions.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.nixsolutions.dao.DAOApi.LanguageDAO;
import com.nixsolutions.entity.Language;

@Repository
public class HibernateLanguageDao extends GeneralDAO<Language> implements LanguageDAO {

	public HibernateLanguageDao() {
		super(Language.class);
	}

}
