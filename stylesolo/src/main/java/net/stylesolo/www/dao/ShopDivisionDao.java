package net.stylesolo.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ShopDivisionVo;

@Repository
public class ShopDivisionDao {
	@Autowired private SqlSession session;
	private final String NAMESPACE="net.stylesolo.www.mybatis.CategoryMapper";
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public List<ShopDivisionVo> getDivision(int categoryNum){
		System.out.println("categoryNum"+categoryNum);
		return session.selectList(NAMESPACE+".sectionList", categoryNum);
	}
	public List<ShopDivisionVo> allDivision(){
		return session.selectList(NAMESPACE+".allList");
	}
}
