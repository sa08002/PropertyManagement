package com.example.demo.service;

import com.example.demo.entity.Detail;

public interface DetailService {
	
//	登録処理
	void save(Detail detail);
	
//	確認
	Detail confirm(int id);
	
//	編集
	void update(Detail detail, int id);

}
