package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

	private UserDaoService userDao;

	@Autowired
	public UserResource(UserDaoService userDao) {
		this.userDao = userDao;
	}

	@GetMapping
	public List<User> retrieveAllUsers() {
		return userDao.findAll();
	}
	@GetMapping("/{id}")
	public User retrieveUser(@PathVariable int id) {
		return userDao.findOne(id);
	}

}
