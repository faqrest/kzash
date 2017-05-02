package com.nixsolutions.service.ServiceImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.dao.DAOApi.AddressDAO;
import com.nixsolutions.dao.DAOApi.RoleDAO;
import com.nixsolutions.dao.DAOApi.UserDAO;
import com.nixsolutions.dto.AddressDTO;
import com.nixsolutions.dto.RoleDTO;
import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.entity.Address;
import com.nixsolutions.entity.Role;
import com.nixsolutions.entity.User;
import com.nixsolutions.service.ServiceApi.AddressService;
import com.nixsolutions.service.ServiceApi.UserService;

@Service
@Transactional
public class UserServiceImpl extends GeneralServiceImpl<User> implements UserService {

	private UserDAO userDao;
	private AddressDAO addressDao;
	private RoleDAO roleDao;

	@Autowired
	public UserServiceImpl(UserDAO userDao, RoleDAO roleDao, AddressDAO addressDao) {
		super(userDao);
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.addressDao = addressDao;
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer createUser(UserDTO userDTO, AddressDTO addressDTO) throws SQLException {

		if (userDao.getByEmail(userDTO.geteMail()) != null) {
			throw new ServiceException("User with email '" + userDTO.geteMail() + "' already exists!");
		}
		if (userDTO.getPhone() != null && userDao.getByPhone(userDTO.getPhone()) != null) {
			throw new ServiceException("User with phone '" + userDTO.getPhone() + "' already exists!");
		}
		if (userDTO.getPhone().isEmpty()) {
			userDTO.setPhone(null);
		}

		Role role = roleDao.getByName("user");
		Address address = new Address(0, addressDTO.getRegion(), addressDTO.getCity(), addressDTO.getStreet(),
				addressDTO.getBuilding(), addressDTO.getFlat(), addressDTO.getPostalCode());

		addressDao.save(address);

		User user = new User(1, userDTO.getFirstName(), userDTO.getLastName(), role, userDTO.getReputation(),
				userDTO.getPassword(), userDTO.geteMail(), userDTO.getPhone(), address, userDTO.isDocument());

		userDao.save(user);
		return user.getUserId();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer createUser(UserDTO userDTO) throws SQLException {

		if (userDao.getByEmail(userDTO.geteMail()) != null) {
			throw new ServiceException("User with email '" + userDTO.geteMail() + "' already exists!");
		}
		if (userDTO.getPhone() != null && userDao.getByPhone(userDTO.getPhone()) != null) {
			throw new ServiceException("User with phone '" + userDTO.getPhone() + "' already exists!");
		}
		if (userDTO.getPhone().isEmpty()) {
			userDTO.setPhone(null);
		}

		Role role = roleDao.getByName("user");
		
		Address address = addressDao.getById(1);

		User user = new User(1, userDTO.getFirstName(), userDTO.getLastName(), role, userDTO.getReputation(),
				userDTO.getPassword(), userDTO.geteMail(), userDTO.getPhone(), address, true);

		userDao.save(user);
		return user.getUserId();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public User update(UserDTO userDTO, RoleDTO roleDto) throws SQLException {

		User persistentUser = userDao.getById(userDTO.getUserId());
		Role role = roleDao.getByName(roleDto.getName());
		persistentUser.setFirstName(userDTO.getFirstName());
		persistentUser.setLastName(userDTO.getLastName());
		persistentUser.seteMail(userDTO.geteMail());
		persistentUser.setPassword(userDTO.getPassword());
		persistentUser.setRole(role);
		persistentUser.setPhone(userDTO.getPhone());
		persistentUser.setReputation(userDTO.getReputation());
		userDao.update(persistentUser);
		return persistentUser;
	}
	
	@Override
	public UserDTO getUserDtoById(int id) throws SQLException {
		        User user = userDao.getById(id);

		        UserDTO userDto = new UserDTO();
		        userDto.setUserId(user.getUserId());
		        userDto.setFirstName(user.getFirstName());
		        userDto.setLastName(user.getLastName());
		        userDto.setPhone(user.getPhone());
		        userDto.seteMail(user.geteMail());
		        userDto.setPassword(user.getPassword());
		        userDto.setRole(user.getRole());
		        userDto.setDocument(user.isDocument());
		        userDto.setAddress(user.getAddress());
		        userDto.setReputation(user.getReputation());
		
		        return userDto;
		    }
}
