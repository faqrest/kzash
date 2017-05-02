package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.RateDAO;
import com.nixsolutions.entity.Rate;
import com.nixsolutions.service.ServiceApi.RateService;

@Service
@Transactional
public class RateServiceImpl extends GeneralServiceImpl<Rate> implements RateService {

	private RateDAO dao;

	@Autowired
	public RateServiceImpl(RateDAO dao) {
		super(dao);
		this.dao = dao;
	}

}
