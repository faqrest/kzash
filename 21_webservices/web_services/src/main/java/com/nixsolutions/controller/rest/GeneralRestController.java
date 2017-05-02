package com.nixsolutions.controller.rest;

import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.nixsolutions.dto.AddressDTO;
import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.entity.User;

public interface GeneralRestController {
	
	Response getUser(String id) throws NumberFormatException, SQLException;

	Response deleteUser(String id) throws NumberFormatException, Exception;

	//Response saveUser(UserDTO user, AddressDTO addres) throws SQLException;

	Response saveUser(UserDTO user) throws SQLException;
}
