package net.stylesolo.www.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ChartDao {
	@Resource SqlSession session;
	private static final String NAMESPACE="net.stylesolo.www.mybatis.ChartMapper";
	
//	����Ʈ �湮�� 1 �߰�
	public int update_visitor(){
		return session.update(NAMESPACE+".update_visitor");
	}
	
//	����Ʈ ������ 1 �߰�
	public int update_login(){
		return session.update(NAMESPACE+".update_login");
	}
	
//	���� ���� ������Ʈ
	public int update_payment(int sales){
		return session.update(NAMESPACE+".update_payment",sales);
	}
}
