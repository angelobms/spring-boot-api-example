package br.com.bmsti.api.security.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class JwtAuthenticationDTO {
	
	@NotEmpty(message = "Email can not be empty.")
	@Email(message = "Email invalid.")
	private String email;
	
	@NotEmpty(message = "Password can not be empty.")
	private String password;
	
	public JwtAuthenticationDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
