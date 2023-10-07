package br.com.crudspringh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crudspringh2.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
