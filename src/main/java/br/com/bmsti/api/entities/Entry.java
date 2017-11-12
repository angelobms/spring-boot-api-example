package br.com.bmsti.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.com.bmsti.api.enums.TypeEnum;

@Entity
@Table(name = "entry")
public class Entry implements Serializable {

	private static final long serialVersionUID = -5498709644766897410L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DATE", nullable = false)
	private LocalDateTime date;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "DATE_CREATED", nullable = false)
	private LocalDate dateCreated;
	
	@Column(name = "DATE_UPDATED", nullable = false)
	private LocalDate dateUpdated;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	private TypeEnum type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;
	
	public Entry() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreted(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDate getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDate dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@PrePersist
	public void prePersit() {
		final LocalDate now = LocalDate.now();
		dateCreated = now;
		dateUpdated = now;
	}
	
	@PreUpdate
	public void preUpdate() {
		dateUpdated = LocalDate.now();
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", date=" + date + ", description=" + description + ", location=" + location
				+ ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + ", type=" + type + ", employee="
				+ employee + "]";
	}
	
}
