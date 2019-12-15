package com.rest.webservice.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	private long usersCount = 3L;
	private static List<User> users = new ArrayList<User>();

	static {
		users.add(new User(1L, "Rama", new Date()));
		users.add(new User(2L, "Krishna", new Date()));
		users.add(new User(3L, "Pavan", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {

		if (null == user.getId()) {
			user.setId(++usersCount);
		}
		users.add(user);

		return user;
	}

	public User findUserById(long id) {

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteUserById(long id) {

		Iterator<User> iterator = users.iterator();
		
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (id == user.getId()) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
}
