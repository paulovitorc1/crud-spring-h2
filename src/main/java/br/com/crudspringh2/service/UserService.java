package br.com.crudspringh2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.crudspringh2.entities.User;
import br.com.crudspringh2.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public void removeById(Long id) {
		repository.deleteById(id);
	}

	public User saveUser(@RequestBody User user) {
		return repository.save(user);
	}

	public User updateUser(Long id, User user) {
		User existingUser = repository.findById(id).orElse(null);

		if (existingUser == null) {
			return null;
		}

		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhone(user.getPhone());
		existingUser.setPassword(user.getPassword());

		repository.save(existingUser);
		
		return existingUser;
	}

}
