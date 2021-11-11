package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		String sql = "SELECT id, property_name, address, tel1, email, detail1, created FROM property";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Property> list = new ArrayList<Property>();
		for(Map<String, Object> result : resultList) {
			Property property = new Property();
			property.setId((int)result.get("id"));
			property.setPropertyName((String)result.get("property_name"));
			property.setAddress((String)result.get("address"));
			property.setTel1((String)result.get("tel1"));
			property.setEmail((String)result.get("email"));
			property.setDetail1((String)result.get("detail1"));			
			property.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			list.add(property);
		}
		return list;
	}

}
