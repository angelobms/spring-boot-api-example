package br.com.bmsti.api.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.bmsti.api.enums.TypeEnum;

/** 
* Entity <b>Entry</b> represents the table <b>entry</b> in database <b>point</b>. 
* A persistent object of this class represents a record in the table entry.
* 
* @author Angelo Brandao - (angelobms@gmail.com)
* @version 1.0 
*/
@Entity
@Table(name = "entry")
public class Entry implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5498709644766897410L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE", nullable = false)
	private Date date;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "DATE_CREATED", nullable = false)
	private Date dateCreated;
	
	@Column(name = "DATE_UPDATED", nullable = false)
	private Date dateUpdated;
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreted(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
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
		return "Entry [id=" + id + ", date=" + date + ", description=" + description + ", location=" + location
				+ ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + ", type=" + type + ", employee="
				+ employee + "]";
	}
	
}
