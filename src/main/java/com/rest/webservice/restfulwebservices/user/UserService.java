package com.rest.webservice.restfulwebservices.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserConverter userConverter;

	public List<UserDTO> getAllUsers() {

		log.info("Retrieving all user details.");

		List<User> users = userDAO.findAll();

		log.info("Retrieved " + users.size() + " users record.");

		return userConverter.convert(users);
	}

	public UserDTO getUserById(long id) {

		log.info("Retrieving user details for id " + id);
		
		User user = userDAO.findUserById(id);
		if (null == user) {
			log.error("Unable to retrieve user details for id " + id);
			return null;
		}
		log.info("Retrieved user details successfully.");

		return userConverter.convert(user);
	}

	public UserDTO deleteUserById(long id) {

		log.info("Deleting user record " + id);
		
		User user = userDAO.deleteUserById(id);
		if (null == user) {
			log.error("Unable to delete user detail for id " + id);
			return null;
		} else {
			log.debug("Deleted " + user.getName() + "'s user detail successfully.");
			return userConverter.convert(user);
		}
	}

	public UserDTO createUser(UserDTO userDTO) {

		log.info("Creating user details.");

		User user = userConverter.convert(userDTO);

		User createdUser = userDAO.save(user);

		if (null == createdUser) {
			log.error("Unable to create user " + userDTO.getName());
			return null;
		}

		log.debug("Successfully created user " + userDTO.getName());

		return userConverter.convert(createdUser);
	}

}
