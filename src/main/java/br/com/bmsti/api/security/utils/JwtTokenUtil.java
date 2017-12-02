package br.com.bmsti.api.security.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
	
	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_ROLE = "role";
	static final String CLAIM_KEY_CREATED = "created";
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	/**
	 * Get the username (email) contained in token JWT. 
	 * 
	 * @param token
	 * @return String
	 */
	public String getUsernameFromToken(String token) {
		String username;
		try{
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}
	
	/**
	 * Return the expiration date of token JWT.  
	 * 
	 * @param token
	 * @return Date
	 */
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}
	
	/**
	 * Create new token (refresh).
	 * 
	 * @param token
	 * @return String
	 */
	public String refreshToken(String token) {
		String refreshedToken;
		try {
			Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = generateToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}
	
	/**
	 * Verify and return if token JWT is valid.
	 * 
	 * @param token
	 * @return boolean
	 */
	public boolean tokenValid(String token) {
		return !expiredToken(token);
	}
	
	/**
	 * Return new token with base in user data.
	 * 
	 * @param userDetails
	 * @return String
	 */
	public String getToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_ROLE, userDetails.getUsername());
		userDetails.getAuthorities().forEach(authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
		claims.put(CLAIM_KEY_CREATED, new Date());
		
		return generateToken(claims);
	}
	
	/**
	 * Realize the parse token JWT for extract informations contained in his body.  
	 * 
	 * @param token
	 * @return Claims
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
	
	/**
	 * Return the expiration date with base in current date.
	 * 
	 * @return Date
	 */
	private Date genareteExpirationDate() {
		/*Date ts = null;
		DateFormat formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
		try {
			ts = (Date)formatter.parse(System.currentTimeMillis() + expiration + 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ts;*/		
		return new Date(System.currentTimeMillis() + expiration + 1000);
	}
	
	/**
	 * Verify if token JWT is expired.
	 * 
	 * @param token
	 * @return boolean
	 */
	public boolean expiredToken(String token) {
		Date expirationDate = this.getExpirationDateFromToken(token);
		if (expirationDate == null) {
			return false;
		}
		return expirationDate.before(new Date());
	}
	
	/**
	 * Generate new token JWT containing the data (claims) provided.
	 * 
	 * @param claims
	 * @return String
	 */
	private String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(genareteExpirationDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

}
