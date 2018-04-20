package net.stylesolo.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ShopCategoryImgDao;
import net.stylesolo.www.vo.ShopCategoryImgVo;
@Service
public class ShopCategoryImgService {
	@Autowired private ShopCategoryImgDao dao;
	public void setDao(ShopCategoryImgDao dao) {
		this.dao = dao;
	}
	public ShopCategoryImgVo cateImg(int categoryCode){
		return dao.cateImg(categoryCode);
	}
}
