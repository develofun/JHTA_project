package net.stylesolo.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ShopItemVo;

@Repository
public class TbShopCategoryDao {
	@Autowired private SqlSession sqlSession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.CategoryMapper";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<ShopItemVo> deco_new_list(){
		List<ShopItemVo> deco_new_list=sqlSession.selectList(NAMESPACE + ".deco_new_list");
		return deco_new_list;
	}
	public List<ShopItemVo> deco_best_list(){
		List<ShopItemVo> deco_best_list=sqlSession.selectList(NAMESPACE + ".deco_best_list");
		return deco_best_list;
	}
	public List<ShopItemVo> deco_all_list(){
		List<ShopItemVo> deco_all_list=sqlSession.selectList(NAMESPACE + ".deco_all_list");
		return deco_all_list;
	}
	
	public List<ShopItemVo> digital_new_list(){
		List<ShopItemVo> digital_new_list=sqlSession.selectList(NAMESPACE + ".digital_new_list");
		return digital_new_list;
	}
	public List<ShopItemVo> digital_best_list(){
		List<ShopItemVo> digital_best_list=sqlSession.selectList(NAMESPACE + ".digital_best_list");
		return digital_best_list;
	}
	public List<ShopItemVo> digital_all_list(){
		List<ShopItemVo> digital_all_list=sqlSession.selectList(NAMESPACE + ".digital_all_list");
		return digital_all_list;
	}
	
	public List<ShopItemVo> women_new_list(){
		List<ShopItemVo> women_new_list=sqlSession.selectList(NAMESPACE + ".women_new_list");
		return women_new_list;
	}
	public List<ShopItemVo> women_best_list(){
		List<ShopItemVo> women_best_list=sqlSession.selectList(NAMESPACE + ".women_best_list");
		return women_best_list;
	}
	public List<ShopItemVo> women_all_list(){
		List<ShopItemVo> women_all_list=sqlSession.selectList(NAMESPACE + ".women_all_list");
		return women_all_list;
	}
	
	public List<ShopItemVo> man_new_list(){
		List<ShopItemVo> man_new_list=sqlSession.selectList(NAMESPACE + ".man_new_list");
		return man_new_list;
	}
	public List<ShopItemVo> man_best_list(){
		List<ShopItemVo> man_best_list=sqlSession.selectList(NAMESPACE + ".man_best_list");
		return man_best_list;
	}
	public List<ShopItemVo> man_all_list(){
		List<ShopItemVo> man_all_list=sqlSession.selectList(NAMESPACE + ".man_all_list");
		return man_all_list;
	}
	
	public List<ShopItemVo> sports_new_list(){
		List<ShopItemVo> sports_new_list=sqlSession.selectList(NAMESPACE + ".sports_new_list");
		return sports_new_list;
	}
	public List<ShopItemVo> sports_best_list(){
		List<ShopItemVo> sports_best_list=sqlSession.selectList(NAMESPACE + ".sports_best_list");
		return sports_best_list;
	}
	public List<ShopItemVo> sports_all_list(){
		List<ShopItemVo> sports_all_list=sqlSession.selectList(NAMESPACE + ".sports_all_list");
		return sports_all_list;
	}
	
	public List<ShopItemVo> hobby_new_list(){
		List<ShopItemVo> hobby_new_list=sqlSession.selectList(NAMESPACE + ".hobby_new_list");
		return hobby_new_list;
	}
	public List<ShopItemVo> hobby_best_list(){
		List<ShopItemVo> hobby_best_list=sqlSession.selectList(NAMESPACE + ".hobby_best_list");
		return hobby_best_list;
	}
	public List<ShopItemVo> hobby_all_list(){
		List<ShopItemVo> hobby_all_list=sqlSession.selectList(NAMESPACE + ".hobby_all_list");
		return hobby_all_list;
	}
	
	public List<ShopItemVo> food_new_list(){
		List<ShopItemVo> food_new_list=sqlSession.selectList(NAMESPACE + ".food_new_list");
		return food_new_list;
	}
	public List<ShopItemVo> food_best_list(){
		List<ShopItemVo> food_best_list=sqlSession.selectList(NAMESPACE + ".food_best_list");
		return food_best_list;
	}
	public List<ShopItemVo> food_all_list(){
		List<ShopItemVo> food_all_list=sqlSession.selectList(NAMESPACE + ".food_all_list");
		return food_all_list;
	}
	
}
