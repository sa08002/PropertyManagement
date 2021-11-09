package com.example.demo.entity;

import java.time.LocalDateTime;

public class Property {
	
	private int id;
	private String propertyName;
	private String address;
	private String tel1;
	private String email;
	private String detail1;
	private LocalDateTime created;
	
	public Property() {}
	
	public Property(int id, String propertyName,  String address, 
			String tel1, String email, 
			String detail1, LocalDateTime created) {
		super();
		this.id = id;
		this.propertyName = propertyName;
		this.address = address;
		this.tel1 = tel1;
		this.email = email;
		this.detail1 = detail1;
		this.created = created;
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

	public String getDetail1() {
		return detail1;
	}

	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

}