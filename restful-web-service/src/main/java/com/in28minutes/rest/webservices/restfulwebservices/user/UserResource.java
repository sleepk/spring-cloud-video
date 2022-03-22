package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserResource {

	private UserDaoService services;

	@Autowired
	public UserResource(UserDaoService userDao) {
		this.services = userDao;
	}

	@GetMapping
	public List<User> retrieveAllUsers() {
		return services.findAll();
	}
	@GetMapping("/{id}")
	public User retrieveUser(@PathVariable int id) {
		return services.findOne(id);
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		 User savedUser = services.save(user);
		ServletUriComponentsBuilder.fromCurrentContextPath()
			.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return;
		
	}

}
