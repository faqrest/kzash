package com.nixsolutions.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.PublishingHouse;
import com.nixsolutions.dao.DAOApi.PublishingHouseDAO;

@Repository
public class HibernatePublishingHouseDao extends GeneralDAO<PublishingHouse> implements PublishingHouseDAO {

	public HibernatePublishingHouseDao() {
		super(PublishingHouse.class);
	}

}
