package br.com.bmsti.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.bmsti.api.security.entities.User;
import br.com.bmsti.api.security.enums.RoleEnum;
import br.com.bmsti.api.security.repositories.UserRepository;
import br.com.bmsti.api.utils.PasswordUtils;

@SpringBootApplication
public class SpringBootApiExampleApplication {	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiExampleApplication.class, args);
		System.out.println("Spring Boot API Example");
	}

	@Autowired
	private UserRepository userReposirory;
	
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
			
		};
	}
}
