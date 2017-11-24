package br.com.bmsti.api.dtos;

import java.math.BigDecimal;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private BigDecimal hourValue;
    private Float amountHoursWorkedDay;
    private Float amountHoursLunch;    

    public EmployeeDTO() {		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getHourValue() {
		return hourValue;
	}

	public void setHourValue(BigDecimal hourValue) {
		this.hourValue = hourValue;
	}

	public Float getAmountHoursWorkedDay() {
		return amountHoursWorkedDay;
	}

	public void setAmountHoursWorkedDay(Float amountHoursWorkedDay) {
		this.amountHoursWorkedDay = amountHoursWorkedDay;
	}

	public Float getAmountHoursLunch() {
		return amountHoursLunch;
	}

	public void setAmountHoursLunch(Float amountHoursLunch) {
		this.amountHoursLunch = amountHoursLunch;
	}

    @Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", hourValue=" + hourValue + ", amountHoursWorkedDay=" + amountHoursWorkedDay + ", amountHoursLunch="
				+ amountHoursLunch + "]";
	}

}