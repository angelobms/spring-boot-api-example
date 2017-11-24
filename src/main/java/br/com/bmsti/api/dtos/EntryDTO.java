package br.com.bmsti.api.dtos;

import java.util.Date;

public class EntryDTO {

    private Long id;
    private Date date;
    private String description;
    private String location;

    public EntryDTO() {		
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
    
    @Override
    public String toString() {
        return "Entry [id=" + id + ", date=" + date + ", description=" + description + ", location=" + location
        + ", dateCreated=" + "]";
    }


}