package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ShopCategoryVo;

@Repository
public class ShopCategoryDao {
	@Autowired private SqlSession session;
	private final String NAMESPACE="net.stylesolo.www.mybatis.CategoryMapper";
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public List<ShopCategoryVo> categoryView(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".categoryView", map);
	}
	public int itemCount(HashMap<String, Object> map){
		return session.selectOne(NAMESPACE+".cateItemCount", map);
	}
}
