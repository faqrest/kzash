package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.LanguageDAO;
import com.nixsolutions.entity.Language;
import com.nixsolutions.service.ServiceApi.LanguageService;

@Service
@Transactional
public class LanguageServiceImpl extends GeneralServiceImpl<Language> implements LanguageService {

	private LanguageDAO dao;

	@Autowired
	public LanguageServiceImpl(LanguageDAO dao) {
		super(dao);
		this.dao = dao;
	}

}
