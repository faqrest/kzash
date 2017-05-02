package com.nixsolutions.service.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nixsolutions.dao.DAOApi.RoleDAO;
import com.nixsolutions.entity.Role;
import com.nixsolutions.service.ServiceApi.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends GeneralServiceImpl<Role> implements RoleService {

	private RoleDAO dao;
	
	@Autowired
	public RoleServiceImpl(RoleDAO dao) {
		super(dao);
		this.dao = dao;
	}

	@Override
	@Transactional
	public Role getByName(String name) {
		return dao.getByName(name);
	}

}
