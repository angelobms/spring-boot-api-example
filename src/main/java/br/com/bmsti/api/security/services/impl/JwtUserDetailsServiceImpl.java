package br.com.bmsti.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.bmsti.api.security.JwtUserFactory;
import br.com.bmsti.api.security.entities.User;
import br.com.bmsti.api.security.services.UserService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> employee = userService.findByEmail(username);

		if (employee.isPresent()) {
			return JwtUserFactory.create(employee.get());
		}

		throw new UsernameNotFoundException("Email not found.");
	}

}
