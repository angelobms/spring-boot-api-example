package br.com.bmsti.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.bmsti.api.entities.Company;
import br.com.bmsti.api.repositories.CompanyRepository;
import br.com.bmsti.api.services.CompanyService;
import br.com.bmsti.api.utils.PasswordUtils;

@SpringBootApplication
public class SpringBootApiExampleApplication {

	@Autowired
	private CompanyService companyService;
	
	//private CompanyRepository companyRepository;
	
	@Value("${pagination_qtd_per_page}")
	private int qtdPerPage;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiExampleApplication.class, args);
		System.out.println("Spring Boot API Example");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			/*System.out.println("Amount of elements per page = " + this.qtdPerPage);
			
			String passwordEncoded = PasswordUtils.generateBCrypt("123456");
			System.out.println("Password encoded: " + passwordEncoded);
			
			passwordEncoded = PasswordUtils.generateBCrypt("123456");
			System.out.println("Password encoded again: " + passwordEncoded);
			
			System.out.println("Password valid: " + PasswordUtils.validatePassword("123456", passwordEncoded));
			
			Company company = new Company();
			company.setName("BMSTI");
			company.setCnpj("32659847000187");
			
			this.companyRepository.save(company);
			
			List<Company> companies = companyRepository.findAll();
			companies.forEach(System.out::println);
			
			Company companyDB = companyRepository.findOne(1L);
			System.out.println("Compony per ID: " + companyDB);
			
			companyDB.setName("BMSTI WEB");
			this.companyRepository.save(companyDB);
					
			Company companyCNPJ = companyRepository.findByCnpj("32659847000187");
			System.out.println("Company per CNPJ: " + companyCNPJ);
			
			this.companyRepository.delete(1L);
			companies = companyRepository.findAll();
			System.out.println("Companies: " + companies.size());*/
			
			this.companyService.testService();
			
		};
	}
}
