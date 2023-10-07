package br.com.crudspringh2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crudspringh2.entities.User;
import br.com.crudspringh2.service.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping()
	public User createUser(@RequestBody User user) {
		service.saveUser(user);
		return user;
	}

	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		service.removeById(id);
	}
	
	@PutMapping(value = "/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

}
