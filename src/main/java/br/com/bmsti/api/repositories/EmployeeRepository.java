package br.com.bmsti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bmsti.api.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByName(String name);
	
	Employee findByCpf(String cpf);

}
