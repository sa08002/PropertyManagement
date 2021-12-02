package com.example.demo.entity;

public class Detail {
	
	private int property_id;
	private String detail1;
	private String detail2;
	private String detail3;
	private String detail4;
	private String detail5;
	
	public Detail() {}
	
	public Detail(int property_id, String detail1, String detail2, String detail3, String detail4, String detail5) {
		this.detail1 = detail1;
		this.detail1 = detail2;
		this.detail1 = detail3;
		this.detail1 = detail4;
		this.detail1 = detail5;
		
	}
	
	public int getProperty_id() {
		return property_id;
	}

	public void setProperty_id(int property_id) {
		this.property_id = property_id;
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
