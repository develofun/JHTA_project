package net.stylesolo.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbItemsetInfoDao;
import net.stylesolo.www.vo.TbItemsetInfoVo;
@Service
public class TbItemsetInfoService {
	@Autowired private TbItemsetInfoDao tbItemsetInfoDao;

	public void setTbItemsetInfoDao(TbItemsetInfoDao tbItemsetInfoDao) {
		this.tbItemsetInfoDao = tbItemsetInfoDao;
	}
	public List<TbItemsetInfoVo> itemsetInfo(int code){
		return tbItemsetInfoDao.itemsetInfo(code);
	}
}
