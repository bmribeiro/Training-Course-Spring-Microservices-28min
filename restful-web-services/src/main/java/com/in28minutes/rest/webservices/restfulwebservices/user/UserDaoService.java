package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	// JPA / Hibernate > Database
	// UserDaoService > Static List

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;

	static {
		users.add(new User(usersCount++, "Bruno", LocalDate.now().minusYears(39)));
		users.add(new User(usersCount++, "Miguel", LocalDate.now().minusYears(34)));
		users.add(new User(usersCount++, "Ribeiro", LocalDate.now().minusYears(29)));
	}

	public List<User> findAll() {
		return users;
	}

	// public List<User> findAll()

	// public User save(User user)
	public User save(User user) {
		user.setId(usersCount++);
		users.add(user);
		return user;
	}


	// public User findOne(int id)
	public User findOne(int id) {
		java.util.function.Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

}
