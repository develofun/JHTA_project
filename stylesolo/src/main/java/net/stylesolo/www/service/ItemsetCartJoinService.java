package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ItemsetCartJoinDao;
import net.stylesolo.www.dao.ShopCartJoinDao;
import net.stylesolo.www.vo.ItemsetCartJoinVo;
import net.stylesolo.www.vo.ItemsetOrderVo;
import net.stylesolo.www.vo.ShopCartJoinVo;

@Service
public class ItemsetCartJoinService {
	@Autowired private ItemsetCartJoinDao dao;

	public void setDao(ItemsetCartJoinDao dao) {
		this.dao = dao;
	}
	public List<ItemsetCartJoinVo> cartList(String id){
		return dao.cartList(id);
	}
	public int delete(HashMap<String, Object> map){
		return dao.delete(map);
	}
	public ItemsetOrderVo listUp(int code){
		return dao.listUp(code);
	}
	public List<ItemsetCartJoinVo> cartListUp(HashMap<String, Object> map){
		return dao.cartListUp(map);
	}
}
