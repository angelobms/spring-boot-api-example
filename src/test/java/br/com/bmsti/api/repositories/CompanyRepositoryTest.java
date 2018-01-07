package br.com.bmsti.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bmsti.api.entities.Company;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompanyRepositoryTest {

	@Autowired
	private CompanyRepository companyRepository;

	private static final String CNPJ = "73693323000181";

	@Before
	public void setUp() throws Exception {
		Company company = new Company();
		company.setName("Company Example");
		company.setCnpj(CNPJ);
		this.companyRepository.save(company);
	}

	@After
	public void tearDown() {
		this.companyRepository.deleteAll();
	}

	@Test
	public void testFindByCnpj() {
		Company company = this.companyRepository.findByCnpj(CNPJ);

		assertEquals(CNPJ, company.getCnpj());
	}

}
