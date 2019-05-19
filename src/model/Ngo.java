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
@Table(name = "ngo")
public class Ngo {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")

	private int id;

	@Column (name = "name")
	private String name;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "phonenumber")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "ngo")
    private Set<NgoLocation> userServices = new HashSet<NgoLocation>();
	
	public Set<NgoLocation> getUserServices() {
		return userServices;
	}
	public void setUserServices(Set<NgoLocation> userServices) {
		this.userServices = userServices;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
