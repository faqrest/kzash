package com.nixsolutions.dao.hibernateImpl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nixsolutions.entity.Role;
import com.nixsolutions.dao.DAOApi.RoleDAO;

@Repository
@Transactional
public class HibernateRoleDAO extends GeneralDAO<Role> implements RoleDAO {

	public HibernateRoleDAO() {
		super(Role.class);
	}

	@Override
	public Role getByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class)
				.add(Restrictions.eq("name", name));
		Role role = (Role) criteria.uniqueResult();
		return role;
	}

}
