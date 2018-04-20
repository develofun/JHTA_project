package net.stylesolo.www.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ChartDao {
	@Resource SqlSession session;
	private static final String NAMESPACE="net.stylesolo.www.mybatis.ChartMapper";
	
//	사이트 방문자 1 추가
	public int update_visitor(){
		return session.update(NAMESPACE+".update_visitor");
	}
	
//	사이트 접속자 1 추가
	public int update_login(){
		return session.update(NAMESPACE+".update_login");
	}
	
//	결제 정보 업데이트
	public int update_payment(int sales){
		return session.update(NAMESPACE+".update_payment",sales);
	}
}
