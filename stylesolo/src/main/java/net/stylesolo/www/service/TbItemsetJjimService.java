package net.stylesolo.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbItemsetJjimDao;
import net.stylesolo.www.vo.TbItemsetJjimVo;

@Service
public class TbItemsetJjimService {
	@Autowired private TbItemsetJjimDao dao;

	public void setDao(TbItemsetJjimDao dao) {
		this.dao = dao;
	}
	public int insert(TbItemsetJjimVo vo){
		return dao.insert(vo);
	}
	public int delete(int[] num){
		return dao.delete(num);
	}
	public int itemset_check(TbItemsetJjimVo vo){
		return dao.itemset_check(vo);
	}
}
