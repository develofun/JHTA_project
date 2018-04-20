package net.stylesolo.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TbItemsetImgDao {
	@Autowired private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	private final String NAMESPACE="net.stylesolo.www.mybatis.ItemSetMapper";
	public List<String> itemsetSubImg(int code){
		return sqlSession.selectList(NAMESPACE+".itemsetSubImg", code);
	}
}
