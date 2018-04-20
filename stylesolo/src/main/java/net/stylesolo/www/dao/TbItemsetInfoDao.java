package net.stylesolo.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbItemsetInfoVo;
@Repository
public class TbItemsetInfoDao {
	@Autowired private SqlSession sqlSession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.ItemSetMapper";
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<TbItemsetInfoVo> itemsetInfo(int code){
		return sqlSession.selectList(NAMESPACE+".itemsetInfo", code);
	}
}
