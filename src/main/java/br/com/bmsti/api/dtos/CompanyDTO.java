package br.com.bmsti.api.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

public class CompanyDTO {

	private Long id;
	
	@NotEmpty(message = "Name can not be empty.")
	@Length(min = 5, max = 200, message = "Name must contain between 5 and 200 characters.")
	private String name;
	
	@NotEmpty(message = "CNPJ can not be empty.")
	@CNPJ(message = "CNPJ invalid.")
	private String cnpj;

	public CompanyDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", name=" + name + ", cnpj=" + cnpj + "]";
	}

}
