package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbShopJjimDao;
import net.stylesolo.www.vo.TbItemsetCodeVo;
import net.stylesolo.www.vo.TbItemsetJjimVo;
import net.stylesolo.www.vo.TbShopJjimVo;

@Service
public class TbShopJjimService {
	@Autowired private TbShopJjimDao dao;
	
	public List<TbShopJjimVo> jjim_list(HashMap<String, Object> map){
		return dao.jjim_list(map);
	}
	public int getCount(String id){
		return dao.getCount(id);
	}
	public List<TbItemsetCodeVo> itemset_list(HashMap<String, Object> map){
		return dao.itemset_list(map);
	}
	public int itemset_check(TbItemsetJjimVo vo){
		return dao.itemset_check(vo);
	}
	public int jjim_del(HashMap<String, Object> map){
		return dao.jjim_del(map);
	}
	public int itemset_jjim_del(HashMap<String, Object> map){
		return dao.itemset_jjim_del(map);
	}
}
