package br.com.bmsti.api.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

public class CompanyDTO {

	private Long id;
	
	@NotEmpty(message = "Razão social não pode ser vazia.")
	@Length(min = 5, max = 200, message = "Razão social deve conter entre 5 a 200 caracteres.")
	private String name;
	
	@NotEmpty(message = "CNPJ não pode ser vazio.")
	@CNPJ(message = "CNPJ inválido.")
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
