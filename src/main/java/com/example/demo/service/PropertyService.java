package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Property;

public interface PropertyService {
	
	void save(Property property);

//	void update(Property property);
	
	List<Property> getAll();

}
