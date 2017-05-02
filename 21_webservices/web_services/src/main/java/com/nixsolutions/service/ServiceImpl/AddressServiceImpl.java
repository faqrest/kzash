package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.AddressDAO;
import com.nixsolutions.entity.Address;
import com.nixsolutions.service.ServiceApi.AddressService;

@Service
@Transactional
public class AddressServiceImpl extends GeneralServiceImpl<Address> implements AddressService {
	
	private AddressDAO dao;

	@Autowired
	public AddressServiceImpl(AddressDAO dao) {
		super(dao);
		this.dao = dao;
	}

}
