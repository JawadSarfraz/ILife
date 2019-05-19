package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean {
	private static final long serialVersionUID = 3973801993975443027L;
	
	private String email;
	private String password;
	
	
	public String getEmail	() {
		return email;
	}
	public void setEmail(String name) {
		this.email = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
