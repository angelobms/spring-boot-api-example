package br.com.bmsti.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	
	private static final Logger log = LoggerFactory.getLogger(CompanyService.class);
	
	public void testService() {
		System.out.println("Executing company service...");
	}
	
	@Cacheable("companyCache")
	public String companyCache() {
		log.info("Executing the service...");
		return "Service company cacheable.";		
	}

}
