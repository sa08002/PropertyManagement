package com.example.demo.entity;

public class User {
	
	private int id;
	private String employee;
    private String username;
	private String password;
	private String authority;
	
	public User() {}
	
	public User(int id, String employee,  String username, String password, String authority) {
		this.id = id;
		this.employee = employee;
		this.username = username;
		this.password = password;
		this.authority = authority;
	}
	
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
