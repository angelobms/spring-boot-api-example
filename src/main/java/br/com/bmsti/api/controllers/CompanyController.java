package br.com.bmsti.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmsti.api.dtos.CompanyDTO;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@GetMapping(value = "/{name}")
	public String getName(@PathVariable String name) {
		return "Nome company: " + name;
	}
	
	@PostMapping
	public ResponseEntity<CompanyDTO> create(@RequestBody CompanyDTO companyDTO) {
		companyDTO.setId(1L);
		return ResponseEntity.ok(companyDTO);
	}
	
}
