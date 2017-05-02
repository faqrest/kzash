package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.PlaceDAO;
import com.nixsolutions.entity.Place;
import com.nixsolutions.service.ServiceApi.PlaceService;

@Service
@Transactional
public class PlaceServiceImpl extends GeneralServiceImpl<Place> implements PlaceService {

	private PlaceDAO dao;
	
	@Autowired
	public PlaceServiceImpl(PlaceDAO dao) {
		super(dao);
		this.dao = dao;
	}

}
