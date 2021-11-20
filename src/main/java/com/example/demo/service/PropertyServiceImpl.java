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

//	登録処理
	@Override
	public void save(Property property) {
		dao.insertProperty(property);
	}
	
//	一覧取得
	@Override
	public List<Property> getAll() {
		return dao.getAll();
	}
	
//	確認
	@Override
	public Property comfirm(int id) {
		Property property = new Property();
		property = dao.comfirmProperty(id);
		return property;
	}
	
//	編集処理
	@Override
	public void update(Property property) {
		dao.updateProperty(property);
	}

//	削除処理
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

}
