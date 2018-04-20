package net.stylesolo.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbGongguImgDao;
import net.stylesolo.www.vo.TbGongguImgVo;

@Service
public class TbGongguImgService {
	@Autowired private TbGongguImgDao dao;
	
	public int insert(TbGongguImgVo vo){
		return dao.insert(vo);
	}
}
