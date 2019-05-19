package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Event")

public class Event{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column (name = "name")
	private String name;

	@OneToMany(mappedBy = "event")
    private Set<EventLocation> userServicesEvent = new HashSet<EventLocation>();
	
	//big disastor kay waqt sb ngo ko info
	@Column (name = "type")
	private String type;
	
	@Column (name = "description")
	private String description;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public Set<EventLocation> getUserServicesEvent() {
		return userServicesEvent;
	}
	public void setUserServicesEvent(Set<EventLocation> userServicesEvent) {
		this.userServicesEvent = userServicesEvent;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
