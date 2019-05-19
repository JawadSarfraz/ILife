	package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "eventlocation")

public class EventLocation {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	   @Column(name = "id")

	private int id;
	
	@ManyToOne
    @JoinColumn(name = "eventid")
	@Cascade({CascadeType.DELETE})
    private Event event;
		
	@ManyToOne
    @JoinColumn(name = "locationid")
	@Cascade({CascadeType.DELETE})
    private Location location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

}
