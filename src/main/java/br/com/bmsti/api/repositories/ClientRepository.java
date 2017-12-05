package br.com.bmsti.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.bmsti.api.documents.Client;

public interface ClientRepository extends MongoRepository<Client, String>  {

	Client findByName(String name);
	
	@Query("{ 'age' : { $gt: ?0, $lt: 71 } }")
	List<Client> findByAgeBetween(int ageInit, int ageEnd);	
	
}
