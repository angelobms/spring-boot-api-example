package br.com.bmsti.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	/**
	 * Generate a hash using the BCrypt.
	 * 
	 * @param password
	 * @return String
	 */
	public static String generateBCrypt(String password) {
		if (password ==  null) {
			return password;
		}
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(password);
	}
	
	/**
	 * Verify if password is valid.
	 * 
	 * @param password
	 * @param passwordEncoded
	 * @return boolean
	 */
	public static boolean validatePassword(String password, String passwordEncoded) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.matches(password, passwordEncoded);
	}
	
}
