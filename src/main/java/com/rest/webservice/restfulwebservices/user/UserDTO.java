package com.rest.webservice.restfulwebservices.user;

import java.util.Date;

public class UserDTO {

	private Long id;
	private String name;
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
