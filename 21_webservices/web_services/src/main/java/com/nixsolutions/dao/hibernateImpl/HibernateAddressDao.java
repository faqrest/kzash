package com.nixsolutions.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.Address;
import com.nixsolutions.dao.DAOApi.AddressDAO;

@Repository
public class HibernateAddressDao extends GeneralDAO<Address> implements AddressDAO {

	public HibernateAddressDao() {
		super(Address.class);
	}

}
