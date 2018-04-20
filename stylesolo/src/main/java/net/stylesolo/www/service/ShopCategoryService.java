package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ShopCategoryDao;
import net.stylesolo.www.vo.ShopCategoryVo;

@Service
public class ShopCategoryService {
	@Autowired private ShopCategoryDao dao;

	public void setDao(ShopCategoryDao dao) {
		this.dao = dao;
	}
	public List<ShopCategoryVo> categoryView(HashMap<String, Object> map){
		return dao.categoryView(map);
	}
	public int itemCount(HashMap<String, Object> map){
		return dao.itemCount(map);
	}
}
