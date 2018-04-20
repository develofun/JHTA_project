package net.stylesolo.www.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ChartDao;

@Service
public class ChartService {
	@Resource ChartDao dao;
	
//	사이트 방문자 1 추가
	public int update_visitor(){
		return dao.update_visitor();
	}
	
//	사이트 접속자 1 추가
	public int update_login(){
		return dao.update_login();
	}
	
//	결제 정보 업데이트
	public int update_payment(int sales){
		return dao.update_payment(sales);
	}
}
