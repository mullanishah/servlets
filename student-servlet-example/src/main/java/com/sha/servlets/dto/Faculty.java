package com.sha.servlets.dto;

public class Faculty {
	
	private String name;
	private String username;
	private String password;
	private String email;
	private String designation;
	private boolean adminRole;
	
	public Faculty(String name, String username, String password, String email, String designation, boolean adminRole) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.designation = designation;
		this.adminRole = adminRole;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public boolean hasAdminRole() {
		return adminRole;
	}
	
	public void setAdminRole(boolean adminRole) {
		this.adminRole = adminRole;
	}
	
	@Override
	public String toString() {
		return "Admin [name=" + name + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", designation=" + designation + ", adminRole=" + adminRole + "]";
	}
	
}
