package br.com.bmsti.api.security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.bmsti.api.security.entities.User;
import br.com.bmsti.api.security.enums.RoleEnum;

public class JwtUserFactory {

	public JwtUserFactory() {
	}

	/**
	 * Convert and generate a JwtUser with base in the employee data. 
	 * 
	 * @param user
	 * @return {@link JwtUser}
	 */
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getRole()));
	}

	/**
	 * Convert the role of user for the format used by Spring Security.
	 * 
	 * @param role
	 * @return {@link List} List<{@link GrantedAuthority}>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(RoleEnum role) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.toString()));
		return authorities;
	}

}
