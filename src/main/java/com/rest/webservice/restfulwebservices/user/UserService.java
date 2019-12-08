package com.rest.webservice.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserConverter userConverter;

	public List<UserDTO> getAllUsers() {

		List<User> users = userDAO.findAll();

		return userConverter.convert(users);
	}

	public UserDTO getUserById(long id) {

		User user = userDAO.findUserById(id);

		return userConverter.convert(user);
	}

	public UserDTO createUser(UserDTO userDTO) {
		
		User user = userConverter.convert(userDTO);
		
		User createdUser = userDAO.save(user);
		
		return userConverter.convert(createdUser);
	}

}
