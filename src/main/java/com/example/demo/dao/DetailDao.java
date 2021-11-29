package com.example.demo.dao;

import com.example.demo.entity.Detail;

public interface DetailDao {
	
	Detail confirmDetail(int id);
	
	void updateDetail(Detail detail, int id);

}
