package net.stylesolo.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbItemsetMdrecVo;

@Repository
public class TbItemsetMdrecDao {
	@Autowired private SqlSession sqlSession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.ItemSetMapper";
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<TbItemsetMdrecVo> getMdRec(){
		return sqlSession.selectList(NAMESPACE+".recMainMd");
	}
}
