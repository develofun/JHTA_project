package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ShopCartJoinVo;

@Repository
public class ShopCartJoinDao {
	@Autowired private SqlSession session;
	private final String NAMESPACE="net.stylesolo.www.mybatis.CartMapper";
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public List<ShopCartJoinVo> cartList(String id){
		return session.selectList(NAMESPACE+".cart_list", id);
	}
	public int delete(HashMap<String, Object> map){
		return session.delete(NAMESPACE+".cartDelete", map);
	}
}
