package net.stylesolo.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbShopCategoryDao;
import net.stylesolo.www.vo.ShopItemVo;

@Service
public class TbShopCategoryService {
	@Autowired private TbShopCategoryDao categoryDao;
	
	public List<ShopItemVo> deco_new_list(){
		return categoryDao.deco_new_list();
	}
	public List<ShopItemVo> deco_best_list(){
		return categoryDao.deco_best_list();
	}
	public List<ShopItemVo> deco_all_list(){
		return categoryDao.deco_all_list();
	}
	
	public List<ShopItemVo> digital_new_list(){
		return categoryDao.digital_new_list();
	}
	public List<ShopItemVo> digital_best_list(){
		return categoryDao.digital_best_list();
	}
	public List<ShopItemVo> digital_all_list(){
		return categoryDao.digital_all_list();
	}
	
	public List<ShopItemVo> women_new_list(){
		return categoryDao.women_new_list();
	}
	public List<ShopItemVo> women_best_list(){
		return categoryDao.women_best_list();
	}
	public List<ShopItemVo> women_all_list(){
		return categoryDao.women_all_list();
	}
	
	public List<ShopItemVo> man_new_list(){
		return categoryDao.man_new_list();
	}
	public List<ShopItemVo> man_best_list(){
		return categoryDao.man_best_list();
	}
	public List<ShopItemVo> man_all_list(){
		return categoryDao.man_all_list();
	}
	
	public List<ShopItemVo> sports_new_list(){
		return categoryDao.sports_new_list();
	}
	public List<ShopItemVo> sports_best_list(){
		return categoryDao.sports_best_list();
	}
	public List<ShopItemVo> sports_all_list(){
		return categoryDao.sports_all_list();
	}
	
	public List<ShopItemVo> hobby_new_list(){
		return categoryDao.hobby_new_list();
	}
	public List<ShopItemVo> hobby_best_list(){
		return categoryDao.hobby_best_list();
	}
	public List<ShopItemVo> hobby_all_list(){
		return categoryDao.hobby_all_list();
	}
	
	public List<ShopItemVo> food_new_list(){
		return categoryDao.food_new_list();
	}
	public List<ShopItemVo> food_best_list(){
		return categoryDao.food_best_list();
	}
	public List<ShopItemVo> food_all_list(){
		return categoryDao.food_all_list();
	}
}
