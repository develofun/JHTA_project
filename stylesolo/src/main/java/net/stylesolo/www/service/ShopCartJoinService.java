package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ShopCartJoinDao;
import net.stylesolo.www.vo.ShopCartJoinVo;

@Service
public class ShopCartJoinService {
	@Autowired private ShopCartJoinDao dao;

	public void setDao(ShopCartJoinDao dao) {
		this.dao = dao;
	}
	public List<ShopCartJoinVo> cartList(String id){
		return dao.cartList(id);
	}
	public int delete(HashMap<String, Object> map){
		return dao.delete(map);
	}
}
