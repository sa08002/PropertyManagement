package com.example.demo.service;

import com.example.demo.entity.Detail;

public interface DetailService {
	
	Detail confirm(int id);
	
	void update(Detail detail, int id);

}
