package br.com.bmsti.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/** 
* Entity <b>Company</b> represents the table <b>company</b> in database <b>point</b>. 
* A persistent object of this class represents a record in the table company.
* 
* @author Angelo Brandao - (angelobms@gmail.com)
* @version 1.0 
*/
@Entity
@Table(name = "company")
public class Company implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2567047597130796634L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 200, nullable = false)
	private String name;

	@Column(name = "CNPJ", unique = true, nullable = false)
	private String cnpj;

	@Column(name = "DATE_CREATED", nullable = false)
	private Date dateCreated;

	@Column(name = "DATE_UPDATED", nullable = false)
	private Date dateUpdated;

	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Employee> employees;

	public Company() {
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@PrePersist
	public void prePersist() {
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
		return "Company [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + "]";
	}

}
