package net.stylesolo.www.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ShopCategoryImgVo;

@Repository
public class ShopCategoryImgDao {
	@Autowired private SqlSession session;
	private final String NAMESPACE="net.stylesolo.www.mybatis.CategoryMapper";
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public ShopCategoryImgVo cateImg(int categoryCode){
		return session.selectOne(NAMESPACE+".categoryImg", categoryCode);
	}
}
