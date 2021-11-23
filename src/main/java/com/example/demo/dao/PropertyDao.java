package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Property;

public interface PropertyDao {
	
//	登録処理
	void insertProperty(Property property);
	
//	一覧取得
	List<Property> getAll();
	
//	確認
	Property confirmProperty(int id);
	
//	編集処理
	void updateProperty(Property property);
	
//	削除処理
	void delete(int id);


}
