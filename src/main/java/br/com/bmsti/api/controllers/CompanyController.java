package br.com.bmsti.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@GetMapping(value = "/{name}")
	public String getName(@PathVariable String name) {
		return "Nome company: " + name;
	}
	
}
