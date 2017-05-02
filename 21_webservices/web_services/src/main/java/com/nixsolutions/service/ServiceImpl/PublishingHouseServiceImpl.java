package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.PublishingHouseDAO;
import com.nixsolutions.entity.PublishingHouse;
import com.nixsolutions.service.ServiceApi.PublishingHouseService;

@Service
@Transactional
public class PublishingHouseServiceImpl extends GeneralServiceImpl<PublishingHouse> implements PublishingHouseService {

	private PublishingHouseDAO dao;
	
	@Autowired
	public PublishingHouseServiceImpl(PublishingHouseDAO dao) {
		super(dao);
		this.dao = dao;
	}

}
