package com.example.demo.app.property;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class PropertyForm {
	
	private int id;
	@NotNull
	private String propertyName;
	@NotNull
	private String address;
	@NotNull
	private String tel1;
	@Email(message = "Invalid E-mail Format")
	private String email;
	
	public PropertyForm() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
