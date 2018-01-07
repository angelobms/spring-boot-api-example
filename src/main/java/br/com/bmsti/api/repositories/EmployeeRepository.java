package br.com.bmsti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bmsti.api.entities.Employee;

@Transactional(readOnly = true)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByName(String name);
	
	Employee findByCpf(String cpf);
	
	Employee findByEmail(String email );
	
	Employee findByCpfOrEmail(String cpf, String email);

}
