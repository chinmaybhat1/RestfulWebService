package com.rest.webservice.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservice.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public UserDTO getUserById(@PathVariable long id) {

		UserDTO user = userService.getUserById(id);

		if (null == user) {
			throw new UserNotFoundException("Unable to find user with id " + id);
		}
		
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody UserDTO user) {

		UserDTO userDTO = userService.createUser(user);

		URI loction = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userDTO.getId())
				.toUri();

		return ResponseEntity.created(loction).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable long id) {

		UserDTO user = userService.deleteUserById(id);

		if (null == user) {
			throw new UserNotFoundException("Unable to find user with id " + id);
		}
	}

}
