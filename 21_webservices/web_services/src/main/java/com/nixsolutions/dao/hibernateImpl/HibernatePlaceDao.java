package com.nixsolutions.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.Place;
import com.nixsolutions.dao.DAOApi.PlaceDAO;

@Repository
public class HibernatePlaceDao extends GeneralDAO<Place> implements PlaceDAO {

	public HibernatePlaceDao() {
		super(Place.class);
	}

}
