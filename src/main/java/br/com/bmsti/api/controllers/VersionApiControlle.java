package br.com.bmsti.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VersionApiControlle {
	
	/**
	 * Version API for URL, define version 'v1'  
	 * 
	 * @param name
	 * @return ResponseEntity<<Response<String>>
	 */
	@GetMapping(value = "/v1/hello/{name}")
	public ResponseEntity<String> helloNameV1(@PathVariable("name") String name) {
		return ResponseEntity.ok(String.format("API v1: Hello %s! ", name));
	}
	
	/**
	 * Version API for URL, define version 'v2'  
	 * 
	 * @param name
	 * @return ResponseEntity<<Response<String>>
	 */
	@GetMapping(value = "/v2/hello/{name}")
	public ResponseEntity<String> helloNameV2(@PathVariable("name") String name) {
		return ResponseEntity.ok(String.format("API v2: Hello %s! ", name));
	}
	
	/**
	 * Version API for Header 'X-API-Version', define version 'v1'  
	 * 
	 * @param name
	 * @return ResponseEntity<<Response<String>>
	 */
	@GetMapping(value = "/hello/{name}", headers = "X-API-Version=v1")
	public ResponseEntity<String> helloHeaderNameV1(@PathVariable("name") String name) {
		return ResponseEntity.ok(String.format("API Header v1: Hello %s! ", name));
	}
	
	/**
	 * Version API for Header 'X-API-Version', define version 'v2'  
	 * 
	 * @param name
	 * @return ResponseEntity<<Response<String>>
	 */
	@GetMapping(value = "/hello/{name}", headers = "X-API-Version=v2")
	public ResponseEntity<String> helloHeaderNameV2(@PathVariable("name") String name) {
		return ResponseEntity.ok(String.format("API Header v2: Hello %s! ", name)); 
	}

}
