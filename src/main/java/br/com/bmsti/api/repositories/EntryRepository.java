package br.com.bmsti.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.bmsti.api.entities.Entry;

@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "EntryRepository.findByEmployeeId",
			query = "SELECT e FROM Entry e WHERE e.employee.id = :employeeId")
})
public interface EntryRepository extends JpaRepository<Entry, Long> {

	List<Entry> findByEmployeeId(@Param("employeeId") Long employeeId);
	
	Page<Entry> findByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);
	
}
