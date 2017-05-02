package com.nixsolutions.dao.hibernateImpl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.User;
import com.nixsolutions.dao.DAOApi.UserDAO;

@Repository
public class HibernateUserDao extends GeneralDAO<User> implements UserDAO {

	public HibernateUserDao() {
		super(User.class);
	}

	@Override
	public User getByEmail(String email) {
		Query queue = sessionFactory.getCurrentSession().createQuery("from user where eMail=:e");
        queue.setParameter("e", email);
        return (User) queue.uniqueResult();
	}
	
	@Override
	public User getByPhone(String phone) {
		Query queue = sessionFactory.getCurrentSession().createQuery("from user where phone=:e");
        queue.setParameter("e", phone);
        return (User) queue.uniqueResult();
	}

}
