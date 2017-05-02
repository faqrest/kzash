package com.nixsolutions.dao.DAOApi;

import com.nixsolutions.entity.Role;

public interface RoleDAO extends GeneralDAOApi<Role> {
	
	Role getByName(String name);
	
}
