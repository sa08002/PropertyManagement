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
	private String detail1;
	private String detail2;
	private String detail3;
	private String detail4;
	private String detail5;
	

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
	
	
	public String getDetail1() {
		return detail1;
	}

	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}

	public String getDetail2() {
		return detail2;
	}

	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}

	public String getDetail3() {
		return detail3;
	}

	public void setDetail3(String detail3) {
		this.detail3 = detail3;
	}

	public String getDetail4() {
		return detail4;
	}

	public void setDetail4(String detail4) {
		this.detail4 = detail4;
	}

	public String getDetail5() {
		return detail5;
	}

	public void setDetail5(String detail5) {
		this.detail5 = detail5;
	}
	
}
