package com.example.demo.app.property;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class PropertyForm {
	
	@NotNull
	private String propertyName;
	@Max(10)
	private String postalCode;
	@NotNull
	private String address;
	@NotNull
	@Max(15)
	private String tel1;
	private String tel12;
	@Max(15)
	private String fax;
	@Email(message = "Invalid E-mail Format")
	private String email;
	@NotNull
	private String salesOffice;
	private String detail1;
	private String detail2;
	
	public PropertyForm() {
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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

	public String getTel12() {
		return tel12;
	}

	public void setTel12(String tel12) {
		this.tel12 = tel12;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalesOffice() {
		return salesOffice;
	}

	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
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
	
}
