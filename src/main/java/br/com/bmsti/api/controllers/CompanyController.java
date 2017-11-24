package br.com.bmsti.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmsti.api.dtos.CompanyDTO;
import br.com.bmsti.api.responses.Response;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@GetMapping(value = "/{name}")
	public String getName(@PathVariable String name) {
		return "Nome company: " + name;
	}
	
	@PostMapping
	public ResponseEntity<Response<CompanyDTO>> create(@Valid @RequestBody CompanyDTO companyDTO, BindingResult result) {		
		Response<CompanyDTO> response = new Response<CompanyDTO>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setDate(companyDTO);		
		companyDTO.setId(1L);
		
		return ResponseEntity.ok(response);
	}
	
}
