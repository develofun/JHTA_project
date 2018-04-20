package net.stylesolo.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.MainPageDao;
import net.stylesolo.www.vo.ShopItemVo;
import net.stylesolo.www.vo.TbBannerVo;
import net.stylesolo.www.vo.TbGongguImgVo;

@Service
public class MainPageService {
	@Autowired
	private MainPageDao mainPageDao;
	
	public List<TbBannerVo> callBannerData(String menuCode) {
		return mainPageDao.callBannerData(menuCode);
	}
	
	public List<ShopItemVo> callShopLatestProducts() {
		return mainPageDao.callShopLatestProducts();
	}
	
	public List<TbGongguImgVo> callMajorGongguData() {
		return mainPageDao.callMajorGongguData();
	}
}
