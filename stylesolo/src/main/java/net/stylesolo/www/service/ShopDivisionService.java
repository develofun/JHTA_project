package net.stylesolo.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ShopDivisionDao;
import net.stylesolo.www.vo.ShopDivisionVo;
import net.stylesolo.www.vo.ShopSectionVo;

@Service
public class ShopDivisionService {
	@Autowired private ShopDivisionDao dao;

	public void setDao(ShopDivisionDao dao) {
		this.dao = dao;
	}
	public List<ShopDivisionVo> getDivision(int categoryNum){
		return dao.getDivision(categoryNum);
	}
	public List<ShopDivisionVo> allDivision(){
		return dao.allDivision();
	}
}
