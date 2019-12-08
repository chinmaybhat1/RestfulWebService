package com.rest.webservice.restfulwebservices.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserConverter {

	public UserDTO convert(User user) {

		UserDTO userDTO = new UserDTO();
		if (null != user && null != user.getId()) {
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setDateOfBirth(user.getDateOfBirth());
		}

		return userDTO;
	}

	public User convert(UserDTO userDTO) {

		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setDateOfBirth(userDTO.getDateOfBirth());

		return user;
	}

	public List<UserDTO> convert(List<User> users) {

		List<UserDTO> userDtos = new ArrayList<UserDTO>();

		users.forEach(user -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setDateOfBirth(user.getDateOfBirth());

			userDtos.add(userDTO);
		});

		return userDtos;
	}

}
