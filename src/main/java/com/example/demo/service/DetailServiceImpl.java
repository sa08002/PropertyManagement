package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DetailDao;
import com.example.demo.entity.Detail;

@Service
public class DetailServiceImpl implements DetailService {
	
	private final DetailDao dao;
	
	@Autowired public DetailServiceImpl(DetailDao dao) {
		this.dao = dao;
	}

	@Override
	public Detail confirm(int id) {
		Detail detail = new Detail();
		detail = dao.confirmDetail(id);
		return detail;
	}

}
