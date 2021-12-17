package com.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Login {

	@Id
	@GeneratedValue
	private int loginId;
	
	private String username;


	@NotEmpty(message = "Please enter your password")
	private String password;
	
	private String role;
	
	@JsonIgnore
	private boolean isLoggedIn = false;
	
	@JsonIgnore
	@OneToOne(mappedBy="login")
	private Admin admin;
	


	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", isLoggedIn=" + isLoggedIn + ", admin=" + admin + "]";
	}
	
	
	
		
}

