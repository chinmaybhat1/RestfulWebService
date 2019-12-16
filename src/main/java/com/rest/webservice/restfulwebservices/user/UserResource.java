package com.rest.webservice.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
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
	public Resource<UserDTO> getUserById(@PathVariable long id) {

		UserDTO user = userService.getUserById(id);

		if (null == user) {
			throw new UserNotFoundException("Unable to find user with id " + id);
		}
		
		Resource<UserDTO> resource = new Resource<UserDTO>(user);
		ControllerLinkBuilder linkedTo = linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkedTo.withRel("all-users"));
		
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO user) {

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
