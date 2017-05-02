package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.OrdersDAO;
import com.nixsolutions.entity.Orders;
import com.nixsolutions.service.ServiceApi.OrdersService;

@Service
@Transactional
public class OrdersServiceImpl extends GeneralServiceImpl<Orders> implements OrdersService {

	private OrdersDAO dao;

	@Autowired
	public OrdersServiceImpl(OrdersDAO dao) {
		super(dao);
		this.dao = dao;
	}

}
