package net.stylesolo.www.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ItemSetMainDao;
import net.stylesolo.www.vo.ItemsetMainViewVo;
import net.stylesolo.www.vo.TbItemsetCodeVo;
import net.stylesolo.www.vo.TbItemsetPaymentProductVo;

@Service
public class ItemSetMainService {
	@Autowired 
	private ItemSetMainDao itemSetMainDao;
	
//	쇼핑 최신 목록
//	쇼핑 주요 카테고리별 베스트 
//	주요 이벤트
//	추천 베스트 리스트
//	공구 베스트 리스트
	public void callDataForMainPage() {
		itemSetMainDao.callRecentRegisteredShoppingDataForMainPage();
		itemSetMainDao.callShoppingDataByCategoryForMainPage();
		itemSetMainDao.callMajorEventDataForMainPage();
		itemSetMainDao.callMajorGongguDataForMainPage();
		itemSetMainDao.callMajorRecommendDataForMainPage();
	}
	

	public void setItemSetMainDao(ItemSetMainDao itemSetMainDao) {
		this.itemSetMainDao = itemSetMainDao;
	}
	public List<ItemsetMainViewVo> getList(HashMap<String, Object> map){
		return itemSetMainDao.getList(map);
	}
	public int itemSetCount(HashMap<String, Object> map){
		return itemSetMainDao.itemSetCount(map);
	}
	public int paymentInsert(TbItemsetPaymentProductVo vo2){
		return itemSetMainDao.paymentInsert(vo2);
	}
	public int itemsetUpdate(HashMap<String, Object> map){
		return itemSetMainDao.itemsetUpdate(map);
	}
}
