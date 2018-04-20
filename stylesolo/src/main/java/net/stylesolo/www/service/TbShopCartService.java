package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbShopCartDao;
import net.stylesolo.www.vo.ShopCartListVo;
import net.stylesolo.www.vo.ShopCartVo;
import net.stylesolo.www.vo.TbShopCartVo;

@Service
public class TbShopCartService {
	@Autowired private TbShopCartDao tbShopCartDao;
	
	public void setTbShopCartDao(TbShopCartDao tbShopCartDao) {
		this.tbShopCartDao = tbShopCartDao;
	}
	
	public List<TbShopCartVo> cart_list(String id){
		return tbShopCartDao.cart_list(id);
	}
	public List<ShopCartListVo> cart_listup(HashMap<String, Object> map){
		return tbShopCartDao.cart_listup(map);
	}
}
