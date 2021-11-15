package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Property;

public interface PropertyDao {
	
	void insertProperty(Property property);
	
	Property comfirmProperty(int id);
	
	int updateProperty(Property property);
	
	List<Property> getAll();
	
	void delete(int id);


}
