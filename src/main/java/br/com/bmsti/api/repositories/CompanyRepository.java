package br.com.bmsti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bmsti.api.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
 
	@Transactional(readOnly = true)
	Company findByName(String name);
	
	@Transactional(readOnly = true)
	Company findByCnpj(String cnpj);
	
}
