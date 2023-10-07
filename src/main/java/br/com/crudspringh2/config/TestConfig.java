package br.com.crudspringh2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.crudspringh2.entities.User;
import br.com.crudspringh2.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	public void run(String... args) throws Exception {
		User user1 = new User(null, "Paulo", "paulo@gmail.com", 12391823, 123123);
		User user2 = new User(null, "Cesar", "cesar@gmail.com", 11111111, 1000000);

		userRepository.saveAll(Arrays.asList(user1, user2));
	}

}
