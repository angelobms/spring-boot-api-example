package br.com.bmsti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bmsti.api.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

	
}
