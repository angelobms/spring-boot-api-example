package br.com.bmsti.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SpringBootApiExampleApplicationTests {
	
	@Value("${pagination_qtd_per_page}")
	private int qtdPerPage;	

	@Test
	public void contextLoads() {
		assertEquals(50, qtdPerPage);	
	}	
	
}
