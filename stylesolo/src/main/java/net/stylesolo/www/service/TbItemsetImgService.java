package net.stylesolo.www.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ItemSetMainDao;
import net.stylesolo.www.dao.TbItemsetImgDao;
import net.stylesolo.www.vo.TbItemsetImgVo;
import net.stylesolo.www.vo.TbItemsetInfoVo;

@Service
public class TbItemsetImgService {
	@Autowired private TbItemsetImgDao tbItemsetImgDao;
	@Autowired private ItemSetMainDao dao;
	
	public void setDao(ItemSetMainDao dao) {
		this.dao = dao;
	}
	public void setTbItemsetImgDao(TbItemsetImgDao tbItemsetImgDao) {
		this.tbItemsetImgDao = tbItemsetImgDao;
	}
	public List<String> itemsetSubImg(int code){
		return tbItemsetImgDao.itemsetSubImg(code);
	}
	public List<TbItemsetImgVo> subImgList(int code){
		return dao.subImgList(code);
	}
}
