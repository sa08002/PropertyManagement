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
	
//	登録処理
	@Override
	public void insertProperty(Property property) {
		jdbcTemplate.update("INSERT INTO property(property_name, address, tel1, email, detail1, created)"
				+ " VALUES(?, ?, ?, ?, ?, ?)",
				property.getPropertyName(), property.getAddress(), property.getTel1(), property.getEmail(), property.getDetail1(), property.getCreated());
	}

//	一覧取得
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

//	確認
	@Override
	public Property confirmProperty(int id) {
		String sql = "SELECT id, property_name, address, tel1, email, detail1, created FROM property WHERE id = ?";		
		Map<String, Object> oneProperty = jdbcTemplate.queryForMap(sql, id);
		Property property = new Property();
		property.setId((int)oneProperty.get("id"));
		property.setPropertyName((String)oneProperty.get("property_name"));
		property.setAddress((String)oneProperty.get("address"));
		property.setTel1((String)oneProperty.get("tel1"));
		property.setEmail((String)oneProperty.get("email"));
		property.setDetail1((String)oneProperty.get("detail1"));
		property.setCreated(((Timestamp)oneProperty.get("created")).toLocalDateTime());

		return property;
	}

//	編集処理
	@Override
	public void updateProperty(Property property) {
		jdbcTemplate.update("UPDATE property SET property_name = ?, address = ?, tel1 = ?, email = ?, detail1 = ? WHERE id = ?",
				property.getPropertyName(), property.getAddress(), property.getTel1(), property.getEmail(), property.getDetail1(), property.getId());
	}
//	削除処理
	@Override
	public void delete(int id) {
	    String sql = "DELETE FROM property WHERE id = ?";
	    jdbcTemplate.update(sql, id);
	}

}
