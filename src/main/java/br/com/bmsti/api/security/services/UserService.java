package br.com.bmsti.api.security.services;

import java.util.Optional;

import br.com.bmsti.api.security.entities.User;

public interface UserService {

	/**
	 * Find e return a user by email.
	 * 
	 * @param email
	 * @return Optional<User>
	 */
	Optional<User> findByEmail(String email);
	
}
