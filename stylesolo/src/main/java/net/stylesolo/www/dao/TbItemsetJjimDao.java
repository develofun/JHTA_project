package net.stylesolo.www.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbItemsetJjimVo;

@Repository
public class TbItemsetJjimDao {
	@Autowired private SqlSession sqlSession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.ItemSetMapper";
	private final String NAMESPACE1="net.stylesolo.www.mybatis.ShopJjimMapper";
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int insert(TbItemsetJjimVo vo){
		return sqlSession.insert(NAMESPACE+".itemsetInterest", vo);
	}
	public int delete(int[] num){
		return sqlSession.delete(NAMESPACE+".itemsetInterestDelete",num);
	}
	public int itemset_check(TbItemsetJjimVo vo){
		return sqlSession.selectOne(NAMESPACE1+".itemset_check", vo);
	}
}
