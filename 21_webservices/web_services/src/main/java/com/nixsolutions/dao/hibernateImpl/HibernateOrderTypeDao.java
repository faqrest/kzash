package com.nixsolutions.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.OrderType;
import com.nixsolutions.dao.DAOApi.OrderTypeDAO;

@Repository
public class HibernateOrderTypeDao extends GeneralDAO<OrderType> implements OrderTypeDAO {

	public HibernateOrderTypeDao() {
		super(OrderType.class);
	}

}
