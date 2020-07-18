package dev.alexmaramaldo.authenticator.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.alexmaramaldo.authenticator.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
}