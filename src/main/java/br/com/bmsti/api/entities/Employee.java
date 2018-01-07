package br.com.bmsti.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.bmsti.api.enums.ProfileEnum;

/**
 * Entity <b>Employee</b> represents the table <b>employee</b> in database
 * <b>point</b>. A persistent object of this class represents a record in the
 * table employee.
 * 
 * @author Angelo Brandao - (angelobms@gmail.com)
 * @version 1.0
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2338544294966134486L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "CPF", unique = true, nullable = false)
	private String cpf;

	@Column(name = "HOUR_VALUE")
	private BigDecimal hourValue;

	@Column(name = "AMOUNT_HOURS_WORKED_DAY")
	private Float amountHoursWorkedDay;

	@Column(name = "AMOUNT_HOURS_LUNCH")
	private Float amountHoursLunch;

	@Enumerated(EnumType.STRING)
	@Column(name = "PROFILE", nullable = false)
	private ProfileEnum profile;

	@Column(name = "DATE_CREATED", nullable = false)
	private Date dateCreated;

	@Column(name = "DATE_UPDATED", nullable = false)
	private Date dateUpdated;

	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Entry> entries;

	public Employee() {
		super();
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

	@Transient
	public Optional<BigDecimal> getHourValueOpt() {
		return Optional.ofNullable(hourValue);
	}

	public Float getAmountHoursWorkedDay() {
		return amountHoursWorkedDay;
	}

	public void setAmountHoursWorkedDay(Float amountHoursWorkedDay) {
		this.amountHoursWorkedDay = amountHoursWorkedDay;
	}

	@Transient
	public Optional<Float> getAmountHoursWorkedDayOpt() {
		return Optional.ofNullable(amountHoursWorkedDay);
	}

	public Float getAmountHoursLunch() {
		return amountHoursLunch;
	}

	public void setAmountHoursLunch(Float amountHoursLunch) {
		this.amountHoursLunch = amountHoursLunch;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	@Transient
	public Optional<Float> getAmountHoursLunchOpt() {
		return Optional.ofNullable(amountHoursLunch);
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	@PrePersist
	public void prePersit() {
		final Date now = new Date();
		dateCreated = now;
		dateUpdated = now;
	}

	@PreUpdate
	public void preUpdate() {
		dateUpdated = new Date();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", hourValue=" + hourValue + ", amountHoursWorkedDay=" + amountHoursWorkedDay + ", amountHoursLunch="
				+ amountHoursLunch + ", profile=" + profile + ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + ", company=" + company + "]";
	}

}
