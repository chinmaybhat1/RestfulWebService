package com.rest.webservice.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserDTO {

	private Long id;
	@Size(min = 2, message="Name should have atleast 2 characters.")
	private String name;
	@Past
	private Date dateOfBirth;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String name, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
