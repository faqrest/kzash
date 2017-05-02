package com.nixsolutions.dao.DAOApi;

import com.nixsolutions.entity.User;

public interface UserDAO extends GeneralDAOApi<User> {
	public User getByEmail(String email);

	User getByPhone(String phone);
}
