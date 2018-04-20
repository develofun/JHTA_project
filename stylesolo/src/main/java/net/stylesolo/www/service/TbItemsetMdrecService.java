package net.stylesolo.www.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbItemsetMdrecDao;
import net.stylesolo.www.vo.TbItemsetMdrecVo;

@Service
public class TbItemsetMdrecService {
	@Autowired private TbItemsetMdrecDao tbItemsetMdrecDao;
	
	public void setTbItemsetMdrecDao(TbItemsetMdrecDao tbItemsetMdrecDao) {
		this.tbItemsetMdrecDao = tbItemsetMdrecDao;
	}

	public List<TbItemsetMdrecVo> getMdRec(){
		return tbItemsetMdrecDao.getMdRec();
	}
}
