package com.nixsolutions.service.ServiceApi;

import com.nixsolutions.entity.Role;

public interface RoleService extends GeneralService<Role> {
	
	public Role getByName(String name);
	
}
