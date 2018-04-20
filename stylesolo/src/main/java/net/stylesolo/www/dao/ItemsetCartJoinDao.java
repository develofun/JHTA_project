package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ItemsetCartJoinVo;
import net.stylesolo.www.vo.ItemsetOrderVo;

@Repository
public class ItemsetCartJoinDao {
	@Autowired private SqlSession session;
	private final String NAMESPACE="net.stylesolo.www.mybatis.CartMapper";
	private final String NAMESPACE1="net.stylesolo.www.mybatis.ItemSetMapper";
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public List<ItemsetCartJoinVo> cartList(String id){
		return session.selectList(NAMESPACE+".cart_list_set", id);
	}
	public int delete(HashMap<String, Object> map){
		return session.delete(NAMESPACE+".cartDelete_set", map);
	}
	public ItemsetOrderVo listUp(int code){
		return session.selectOne(NAMESPACE1+".itemsetOrder", code);
	}
	public List<ItemsetCartJoinVo> cartListUp(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".cart_listup_set", map);
	}
}
