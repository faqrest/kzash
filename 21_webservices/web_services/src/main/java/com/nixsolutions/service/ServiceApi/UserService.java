package com.nixsolutions.service.ServiceApi;

import java.sql.SQLException;

import com.nixsolutions.dto.AddressDTO;
import com.nixsolutions.dto.RoleDTO;
import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.entity.User;

public interface UserService extends GeneralService<User> {
	public User getByEmail(String email);
	
	Integer createUser(UserDTO userDTO, AddressDTO address) throws SQLException;

	User update(UserDTO userDTO, RoleDTO roleDto) throws SQLException;

	UserDTO getUserDtoById(int id) throws SQLException;

	public Integer createUser(UserDTO user) throws SQLException;
}
