package model;

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
@Table(name = "Location")

public class Location {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	
	private int id;
	
	@Column ( name = "city")
	private String city;
	
	@Column (name = "sector")
	private String sector;

	@Column (name = "country")
	private String country;

	@OneToMany(mappedBy = "location")
    private Set<NgoLocation> userServices = new HashSet<NgoLocation>();	

	@OneToMany(mappedBy = "location")
    private Set<EventLocation> eventLocation = new HashSet<EventLocation>();	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Set<NgoLocation> getUserServices() {
		return userServices;
	}
	public void setUserServices(Set<NgoLocation> userServices) {
		this.userServices = userServices;
	}
	public Set<EventLocation> getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(Set<EventLocation> eventLocation) {
		this.eventLocation = eventLocation;
	}
	
}
