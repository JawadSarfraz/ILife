package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NgoLocation")

public class NgoLocation {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	//@Column (name ="ngoid")
	@ManyToOne
    @JoinColumn(name = "ngoid")
    private Ngo ngo;
	
	@ManyToOne
    @JoinColumn(name = "locationid")
    private Location location;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ngo getNgo() {
		return ngo;
	}
	public void setNgo(Ngo ngo) {
		this.ngo = ngo;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
}
