package net.stylesolo.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.common.CommonConstants;
import net.stylesolo.www.vo.ShopItemVo;
import net.stylesolo.www.vo.TbBannerVo;
import net.stylesolo.www.vo.TbGongguImgVo;

/*
 * 메인 페이지에 필요한 데이터 연동 모델 객체
*/

@Repository
public class MainPageDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "net.stylesolo.www.mybatis.MainPageMapper.";
	
	public List<TbBannerVo> callBannerData(String menuCode) {
		return sqlSession.selectList(NAMESPACE + "callBannerData", menuCode);
	}
	
	public List<ShopItemVo> callShopLatestProducts() {
		return sqlSession.selectList(NAMESPACE + "callShopLatestProducts",
				CommonConstants.NUMBEROFBLOCKCONTENTOFMAINPAGE);
	}
	
	public List<TbGongguImgVo> callMajorGongguData() {
		return sqlSession.selectList(NAMESPACE + "callMajorGongguData",
				CommonConstants.NUMBEROFROLLINGCONTENTOFMAINPAGE);
	}
	
}
