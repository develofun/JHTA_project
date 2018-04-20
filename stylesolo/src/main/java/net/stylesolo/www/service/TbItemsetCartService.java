package net.stylesolo.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbItemsetCartDao;
import net.stylesolo.www.vo.TbItemsetCartVo;

@Service
public class TbItemsetCartService {
	@Autowired private TbItemsetCartDao dao;

	public void setDao(TbItemsetCartDao dao) {
		this.dao = dao;
	}
	public int insert(TbItemsetCartVo vo){
		return dao.insert(vo);
	}
	public int delete(int[] num){
		return dao.delete(num);
	}
}
