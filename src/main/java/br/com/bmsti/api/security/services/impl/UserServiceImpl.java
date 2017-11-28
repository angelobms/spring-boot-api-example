package br.com.bmsti.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bmsti.api.security.entities.User;
import br.com.bmsti.api.security.repositories.UserRepository;
import br.com.bmsti.api.security.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> findByEmail(String email) {		
		return Optional.ofNullable(this.userRepository.findByEmail(email));
	}

}
