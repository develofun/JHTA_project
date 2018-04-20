package net.stylesolo.www.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ChartDao;

@Service
public class ChartService {
	@Resource ChartDao dao;
	
//	����Ʈ �湮�� 1 �߰�
	public int update_visitor(){
		return dao.update_visitor();
	}
	
//	����Ʈ ������ 1 �߰�
	public int update_login(){
		return dao.update_login();
	}
	
//	���� ���� ������Ʈ
	public int update_payment(int sales){
		return dao.update_payment(sales);
	}
}
