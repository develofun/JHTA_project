package net.stylesolo.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbItemsetCodeDao;
import net.stylesolo.www.vo.TbItemsetCodeVo;
@Service
public class TbItemsetCodeService {
	@Autowired private TbItemsetCodeDao tbItemsetCodeDao;

	public void setTbItemsetCodeDao(TbItemsetCodeDao tbItemsetCodeDao) {
		this.tbItemsetCodeDao = tbItemsetCodeDao;
	}
	public TbItemsetCodeVo itemsetDetail(int code){
		return tbItemsetCodeDao.itemsetDetail(code);
	}
	

}
