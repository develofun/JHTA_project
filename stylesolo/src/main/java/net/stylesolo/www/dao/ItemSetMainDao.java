package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.common.CommonConstants;
import net.stylesolo.www.vo.ItemsetMainViewVo;
import net.stylesolo.www.vo.TbItemsetImgVo;
import net.stylesolo.www.vo.TbItemsetPaymentProductVo;

@Repository
public class ItemSetMainDao {
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.MainPageMapper.";
	private final String NAMESPACE1="net.stylesolo.www.mybatis.ItemSetMapper.";

//	쇼핑 최신 목록
//	쇼핑 주요 카테고리별 베스트 
//	주요 이벤트
//	추천 베스트 리스트
//	공구 베스트 리스트
	public void callRecentRegisteredShoppingDataForMainPage() {
		sqlsession.selectList(NAMESPACE + "callRecentRegisteredShoppingData",
				CommonConstants.NUMBEROFBLOCKCONTENTOFMAINPAGE);
	}
	public void callShoppingDataByCategoryForMainPage() {
		sqlsession.selectList(NAMESPACE + "callShoppingDataByCategory",
				CommonConstants.NUMBEROFBLOCKCONTENTOFMAINPAGE);
	}
	public void callMajorEventDataForMainPage() {
		sqlsession.selectList(NAMESPACE + "callMajorEventData",
				CommonConstants.NUMBEROFBLOCKCONTENTOFMAINPAGE);
	}
	public void callMajorRecommendDataForMainPage() {
		sqlsession.selectList(NAMESPACE + "callMajorRecommendData",
				CommonConstants.NUMBEROFBLOCKCONTENTOFMAINPAGE);
	}
	public void callMajorGongguDataForMainPage() {
		sqlsession.selectList(NAMESPACE + "callMajorGongguData",
				CommonConstants.NUMBEROFBLOCKCONTENTOFMAINPAGE);
	}
		
	
	public List<ItemsetMainViewVo> getList(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE1+"itemSetView",map);
	}
	public int itemSetCount(HashMap<String, Object> map){
		return sqlsession.selectOne(NAMESPACE1+"itemSetCount", map);
	}
	public int paymentInsert(TbItemsetPaymentProductVo vo2){
		return sqlsession.insert(NAMESPACE1+"paymentInsert", vo2);
	}
	public int itemsetUpdate(HashMap<String, Object> map){
		return sqlsession.update(NAMESPACE1+"itemsetUpdate", map);
	}
	public List<TbItemsetImgVo> subImgList(int code){
		return sqlsession.selectList(NAMESPACE1+"subImgList",code);
	}
}
