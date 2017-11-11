package br.com.bmsti.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApiExampleApplication {

	@Value("${pagination_qtd_per_page}")
	private int qtdPerPage;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiExampleApplication.class, args);
		System.out.println("Spring Boot API Example");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Amount of elements per page = " + this.qtdPerPage);
		};
		
	}
	
}
