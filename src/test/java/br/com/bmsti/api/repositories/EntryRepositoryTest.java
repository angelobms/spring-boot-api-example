package br.com.bmsti.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bmsti.api.entities.Company;
import br.com.bmsti.api.entities.Employee;
import br.com.bmsti.api.entities.Entry;
import br.com.bmsti.api.enums.ProfileEnum;
import br.com.bmsti.api.enums.TypeEnum;
import br.com.bmsti.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EntryRepositoryTest {
	
	private static final String CNPJ = "86126902000194";
	private static final String EMAIL = "email@email.com.br";
	private static final String CPF = "05991943591";
	
	@Autowired
	private EntryRepository entryRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	private Long employeeId;
	
	@Before
	public void setUp() throws Exception {
		
		Company company = this.companyRepository.save(getCompany());		
		
		Employee employee = this.employeeRepository.save(getEmployee(company));
		this.employeeId = employee.getId();
		
		this.entryRepository.save(getEntry(employee));
		this.entryRepository.save(getEntry(employee));
	}
	
	@After
	public void tearDown() {
		this.entryRepository.deleteAll();
	}
	
	@Test
	public void testFindEntryByEmployeeId() {
		List<Entry> entries = this.entryRepository.findByEmployeeId(employeeId);
		
		assertEquals(2, entries.size());
	}
	
	@Test
	public void testFindEntryByEmployeeIdPaginad() {
		PageRequest page = new PageRequest(0, 10);
		Page<Entry> entries = this.entryRepository.findByEmployeeId(employeeId, page);
		
		assertEquals(2, entries.getTotalElements());
	}
	
	private Entry getEntry(Employee employee) {
		Entry entry = new Entry();
		entry.setDate(new Date());
		entry.setType(TypeEnum.LUNCH_START);
		entry.setEmployee(employee);
		return entry;
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
