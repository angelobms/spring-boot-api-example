package br.com.bmsti.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import br.com.bmsti.api.documents.Client;
import br.com.bmsti.api.repositories.ClientRepository;
import br.com.bmsti.api.security.entities.User;
import br.com.bmsti.api.security.enums.RoleEnum;
import br.com.bmsti.api.security.repositories.UserRepository;
import br.com.bmsti.api.utils.PasswordUtils;

@EnableCaching
@SpringBootApplication
public class SpringBootApiExampleApplication {	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiExampleApplication.class, args);
		System.out.println("Spring Boot API Example");
	}

	@Autowired
	private UserRepository userReposirory;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			/*User user = new User();
			user.setEmail("user@test.com.br");
			user.setRole(RoleEnum.ROLE_USER);
			user.setPassword(PasswordUtils.generateBCrypt("123456"));
			this.userReposirory.save(user);
			
			User admin = new User();
			admin.setEmail("admin@test.com.br");
			admin.setRole(RoleEnum.ROLE_ADMIN);
			admin.setPassword(PasswordUtils.generateBCrypt("123456"));
			this.userReposirory.save(admin);*/
			
			clientRepository.deleteAll();
			
			clientRepository.save(new Client("Angelo", 21));
			clientRepository.save(new Client("Renato", 34));
			clientRepository.save(new Client("Marcela", 19));
			clientRepository.save(new Client("Roberta", 39));
			
			System.out.println("List all with the findAll():");
			System.out.println("---------------------------");
			clientRepository.findAll();
			System.out.println();
			
			System.out.println("Find a single clinet with the findByname('Angelo'):");
			System.out.println("---------------------------");
			clientRepository.findByName("Angelo");
			System.out.println();
			
			System.out.println("Clints with age between 18 and 35:");
			System.out.println("---------------------------");
			clientRepository.findByAgeBetween(18, 35);
			System.out.println();
			
		};
	}
}
