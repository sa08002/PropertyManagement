package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PropertyDao;
import com.example.demo.entity.Property;

@Service
public class PropertyServiceImpl implements PropertyService {
	
	private final PropertyDao dao;
	
	@Autowired public PropertyServiceImpl(PropertyDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Property property) {
		dao.insertProperty(property);
	}
	
	@Override
	public List<Property> getAll() {
		return dao.getAll();
	}

}
