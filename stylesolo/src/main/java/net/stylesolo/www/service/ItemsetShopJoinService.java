package net.stylesolo.www.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ItemsetShopJoinDao;
import net.stylesolo.www.vo.ItemsetShopJoinVo;

@Service
public class ItemsetShopJoinService {
	@Autowired private ItemsetShopJoinDao dao;

	public void setDao(ItemsetShopJoinDao dao) {
		this.dao = dao;
	}
	public List<ItemsetShopJoinVo> joinItemset(int code){
		return dao.joinItemset(code);
	}
}
