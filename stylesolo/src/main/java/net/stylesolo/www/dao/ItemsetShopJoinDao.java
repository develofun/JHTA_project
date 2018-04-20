package net.stylesolo.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ItemsetShopJoinVo;

@Repository
public class ItemsetShopJoinDao {
	@Autowired private SqlSession session;
	private final String NAMESPACE="net.stylesolo.www.mybatis.ItemSetMapper";
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<ItemsetShopJoinVo> joinItemset(int code){
		return session.selectList(NAMESPACE+".itemSetJoinList", code);
	}
}
