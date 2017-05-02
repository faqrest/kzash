package com.nixsolutions.dao.hibernateImpl;

import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.Orders;
import com.nixsolutions.dao.DAOApi.OrdersDAO;

@Repository
public class HibernateOrdersDao extends GeneralDAO<Orders> implements OrdersDAO {

	public HibernateOrdersDao() {
		super(Orders.class);
	}

}
