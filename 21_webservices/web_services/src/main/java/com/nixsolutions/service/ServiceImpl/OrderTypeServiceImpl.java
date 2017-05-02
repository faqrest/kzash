package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.OrderTypeDAO;
import com.nixsolutions.entity.OrderType;
import com.nixsolutions.service.ServiceApi.OrderTypeService;

@Service
@Transactional
public class OrderTypeServiceImpl extends GeneralServiceImpl<OrderType> implements OrderTypeService {

	private OrderTypeDAO dao;

	@Autowired
	public OrderTypeServiceImpl(OrderTypeDAO dao) {
		super(dao);
		this.dao = dao;
	}

}
