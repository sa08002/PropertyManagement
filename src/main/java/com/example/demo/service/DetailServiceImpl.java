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

//	投稿
	@Override
	public void save(Detail detail) {	
		dao.insertDetail(detail);
	}
	
//	確認
	@Override
	public Detail confirm(int id) {
		Detail detail = new Detail();
		detail = dao.confirmDetail(id);
		return detail;
	}

//	編集
	@Override
	public void update(Detail detail, int id) {
		dao.updateDetail(detail, id);
	}


}
