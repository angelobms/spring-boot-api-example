package br.com.bmsti.api.security.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmsti.api.responses.Response;
import br.com.bmsti.api.security.dto.JwtAuthenticationDTO;
import br.com.bmsti.api.security.dto.TokenDTO;
import br.com.bmsti.api.security.utils.JwtTokenUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Generate and return new JWT token.
	 * 
	 * @param jwtAuthenticationDTO
	 * @param result
	 * @return esponseEntity<Response<TokenDTO>>
	 * @throws AuthenticationException
	 */
	@PostMapping
	public ResponseEntity<Response<TokenDTO>> generateTokenJwt(@Valid @RequestBody JwtAuthenticationDTO jwtAuthenticationDTO,
			BindingResult result) throws AuthenticationException {
		Response<TokenDTO> response = new Response<>();

		if (result.hasErrors()) {
			log.error("Error validating posting: {}.", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		log.info("Generating token for email: {}.", jwtAuthenticationDTO.getEmail());
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				jwtAuthenticationDTO.getEmail(), jwtAuthenticationDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(jwtAuthenticationDTO.getEmail());
		String token = jwtTokenUtil.getToken(userDetails);
		response.setDate(new TokenDTO(token));
		
		return ResponseEntity.ok(response);
	}

	/**
	 * Generate new toke with new expiration date.
	 * 
	 * @param request
	 * @return ResponseEntity<Response<TokenDTO>>
	 */
	@PostMapping(value = "/refresh")
	public ResponseEntity<Response<TokenDTO>> generateRefreshTokenJwt(HttpServletRequest request) {
		log.info("Generating  regresh token JWT.");
		Response<TokenDTO> response = new Response<>();
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));
		
		if (token.isPresent() && token.get().startsWith(BEARER_PREFIX)) {
			token = Optional.of(token.get().substring(7));
		}
		
		if (!token.isPresent()) {
			response.getErrors().add("Token uninformed.");
		} else if (!jwtTokenUtil.tokenValid(token.get())){
			response.getErrors().add("Token invalid or expired.");
		}
		
		return ResponseEntity.ok(response);
	}
}
