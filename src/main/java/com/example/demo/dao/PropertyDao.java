package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Property;

public interface PropertyDao {
	
	void insertProperty(Property property);
	
	int updateProperty(Property property);
	
	List<Property> getAll();


}
