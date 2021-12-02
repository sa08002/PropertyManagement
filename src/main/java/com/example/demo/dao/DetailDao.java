package com.example.demo.dao;

import com.example.demo.entity.Detail;

public interface DetailDao {
	
//	投稿
	void insertDetail (Detail detail);
	
//	確認
	Detail confirmDetail(int id);
	
//	編集
	void updateDetail(Detail detail, int id);

}
