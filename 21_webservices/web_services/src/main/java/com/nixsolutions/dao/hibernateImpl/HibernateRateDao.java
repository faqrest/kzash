package com.nixsolutions.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.Rate;
import com.nixsolutions.dao.DAOApi.RateDAO;

@Repository
public class HibernateRateDao extends GeneralDAO<Rate> implements RateDAO {

	public HibernateRateDao() {
		super(Rate.class);
	}

}
