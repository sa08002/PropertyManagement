package com.example.demo.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		jdbcTemplate.update("INSERT INTO property(property_id, property_name, address, tel1, email, created)"
				+ " VALUES(?, ?, ?, ?, ?, ?)",
				property.getPropertyId(), property.getPropertyName(), property.getAddress(), property.getTel1(), property.getEmail(), property.getCreated());
	}

//	一覧取得
	@Override
	public List<Property> getAll() {
		String sql = "SELECT id, property_id, property_name, address, tel1, email, created FROM property";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Property> list = new ArrayList<Property>();
		for(Map<String, Object> result : resultList) {
			Property property = new Property();
			property.setId((int)result.get("id"));
			property.setPropertyId((int)result.get("property_id"));
			property.setPropertyName((String)result.get("property_name"));
			property.setAddress((String)result.get("address"));
			property.setTel1((String)result.get("tel1"));
			property.setEmail((String)result.get("email"));
			property.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			list.add(property);
		}
		return list;
	}

//	確認
	@Override
	public Property confirmProperty(int id) {
		String sql = "SELECT id, property_id, property_name, address, tel1, email, created FROM property WHERE id = ?";		
		Map<String, Object> oneProperty = jdbcTemplate.queryForMap(sql, id);
		Property property = new Property();
		property.setId((int)oneProperty.get("id"));
		property.setPropertyId((int)oneProperty.get("property_id"));
		property.setPropertyName((String)oneProperty.get("property_name"));
		property.setAddress((String)oneProperty.get("address"));
		property.setTel1((String)oneProperty.get("tel1"));
		property.setEmail((String)oneProperty.get("email"));
		property.setCreated(((Timestamp)oneProperty.get("created")).toLocalDateTime());

		return property;
	}

//	編集処理
	@Override
	public void updateProperty(Property property) {
		jdbcTemplate.update("UPDATE property SET property_id = ?, property_name = ?, address = ?, tel1 = ?, email = ? WHERE id = ?",
				property.getPropertyId(), property.getPropertyName(), property.getAddress(), property.getTel1(), property.getEmail(), property.getId());
	}
//	削除処理
	@Override
	public void delete(int id) {
	    String sql = "DELETE FROM property WHERE id = ?";
	    jdbcTemplate.update(sql, id);
	}

//	今年の物件Noの取得
	@Override
	public int generationId() {
		
//		現在登録されている最新の物件Noの取得
		String sql = "SELECT MAX(property_id) FROM property ";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		String propertyIdMax = String.valueOf((Integer)map.get("MAX(PROPERTY_ID)"));
		String propertyYear = propertyIdMax.substring(0, 4);
		
//		現在の年を取得
		Date date = new Date();
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		String currentYear = getYearFormat.format(date);		
		
//		同年に物件がない場合、「西暦 + 0001」のIDを返却
		if (!propertyYear.equals(currentYear)) {
			String stringNewYearId = currentYear + "0001";
			int intNewYearId = Integer.parseInt(stringNewYearId);
			return intNewYearId;
		}
		
//		同年に物件がある場合、「存在するID + 1」を返却
		int intNextId = Integer.parseInt(propertyIdMax) + 1;
		return intNextId;
	}

}
