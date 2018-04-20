package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ShopCartListVo;
import net.stylesolo.www.vo.ShopCartVo;
import net.stylesolo.www.vo.TbShopCartVo;

@Repository
public class TbShopCartDao {
	@Autowired private SqlSession sqlSession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.CartMapper";
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<TbShopCartVo> cart_list(String id){
		List<TbShopCartVo> list=sqlSession.selectList(NAMESPACE + ".cart_list", id);
		return list;
	}
	public List<ShopCartListVo> cart_listup(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".cart_listup", map);
	}
}
