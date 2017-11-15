package br.com.bmsti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bmsti.api.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
 
	Company findByName(String name);
	
	Company findByCnpj(String cnpj);
	
}
