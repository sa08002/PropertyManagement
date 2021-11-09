package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Property;




@Repository
public class PropertyDaoImpl implements PropertyDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PropertyDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertProperty(Property property) {
		jdbcTemplate.update("INSERT INTO property(property_name, address, tel1, email, detail1, created)"
				+ " VALUES(?, ?, ?, ?, ?, ?)",
				property.getPropertyName(), property.getAddress(), property.getTel1(), property.getEmail(), property.getDetail1(), property.getCreated());
	}

	@Override
	public int updateProperty(Property property) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public List<Property> getAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
