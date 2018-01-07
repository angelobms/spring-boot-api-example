package br.com.bmsti.api.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bmsti.api.entities.Company;
import br.com.bmsti.api.entities.Employee;
import br.com.bmsti.api.enums.ProfileEnum;
import br.com.bmsti.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	private static final String CNPJ = "73693323000181";
	private static final String EMAIL = "email@email.com.br";
	private static final String CPF = "78117364549";

	@Before
	public void setUp() throws Exception {
		Company company = this.companyRepository.save(getCompany());
		this.employeeRepository.save(getEmployee(company));
	}

	@After
	public void tearDown() {
		this.employeeRepository.deleteAll();
	}
	
	@Test
	public void testFindEmployeeByEmail() {
		Employee employee = this.employeeRepository.findByEmail(EMAIL);
		
		assertEquals(EMAIL, employee.getEmail());
	}
	
	@Test
	public void testFindEmployeeByCpf() {
		Employee employee = this.employeeRepository.findByCpf(CPF);
		
		assertEquals(CPF, employee.getCpf());
	}
	
	@Test
	public void testFindEmplyeeByCpfAndEmail() {
		Employee employee = this.employeeRepository.findByCpfOrEmail(CPF, EMAIL);
		
		assertNotNull(employee);
	}
	
	@Test
	public void testFindEmployeeByCpfOrEmailForEmailInvalid() {
		Employee employee = this.employeeRepository.findByCpfOrEmail(CPF, "email@invalid.com");
		
		assertNotNull(employee);
	}	

	private Employee getEmployee(Company company) {
		Employee employee = new Employee();
		employee.setName("Employee Example");
		employee.setProfile(ProfileEnum.ROLE_USER);
		employee.setPassword(PasswordUtils.generateBCrypt("123456"));
		employee.setCpf(CPF);
		employee.setEmail(EMAIL);
		employee.setCompany(company);
		return employee;
	}

	private Company getCompany() {
		Company company = new Company();
		company.setName("Company Example");
		company.setCnpj(CNPJ);
		return company;
	}

}
