package net.stylesolo.www.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbItemsetCartVo;

@Repository
public class TbItemsetCartDao {
	@Autowired private SqlSession sqlSession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.ItemSetMapper";
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int insert(TbItemsetCartVo vo){
		return sqlSession.insert(NAMESPACE+".itemsetBasket", vo);
	}
	public int delete(int[] num){
		return sqlSession.delete(NAMESPACE+"itemsetBasketDelete",num);
	}
}
