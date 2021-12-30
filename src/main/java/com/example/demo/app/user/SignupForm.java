package com.example.demo.app.user;

import javax.validation.constraints.NotNull;

public class SignupForm {
	
	@NotNull
    private String employee;
	@NotNull
    private String username;
	@NotNull
	private String password;
    
	
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
}