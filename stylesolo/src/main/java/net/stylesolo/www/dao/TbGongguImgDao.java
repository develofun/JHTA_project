package net.stylesolo.www.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbGongguImgVo;

@Repository
public class TbGongguImgDao {
	@Autowired private SqlSession sqlSession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.GongguImgMapper";
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(TbGongguImgVo vo){
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}
}
