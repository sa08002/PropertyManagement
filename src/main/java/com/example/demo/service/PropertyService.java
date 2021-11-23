package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Property;

public interface PropertyService {
	
//	登録処理
	void save(Property property);
	
//	一覧取得
	List<Property> getAll();
	
//	確認
	Property confirm(int id);

//	編集処理
	void update(Property property);
	
//	削除処理
	void delete(int id);
	

}
