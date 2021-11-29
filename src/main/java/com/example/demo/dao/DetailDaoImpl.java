package com.example.demo.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Detail;

@Repository
public class DetailDaoImpl implements DetailDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DetailDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Detail confirmDetail(int id) {
		String sql = "SELECT detail1, detail2, detail3, detail4, detail5 FROM detail WHERE property_id = ?";		
		Map<String, Object> oneDetail = jdbcTemplate.queryForMap(sql, id);
		Detail detail = new Detail();
		detail.setDetail1((String)oneDetail.get("detail1"));
		detail.setDetail2((String)oneDetail.get("detail2"));
		detail.setDetail3((String)oneDetail.get("detail3"));
		detail.setDetail4((String)oneDetail.get("detail4"));
		detail.setDetail5((String)oneDetail.get("detail5"));
		
		return detail;
	}

	@Override
	public void updateDetail(Detail detail, int id) {
		jdbcTemplate.update("UPDATE detail SET detail1 = ?, detail2 = ?, detail3 = ?, detail4 = ?,  detail5 = ? WHERE property_id = ?",
				detail.getDetail1(), detail.getDetail2(), detail.getDetail3(), detail.getDetail4(), detail.getDetail5(), id);
		
	}

}
