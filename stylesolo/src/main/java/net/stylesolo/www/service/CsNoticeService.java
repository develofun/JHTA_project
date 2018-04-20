package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.CsNoticeDao;
import net.stylesolo.www.vo.TbCsNRnumVo;
import net.stylesolo.www.vo.TbCsNoticeVo;

@Service
public class CsNoticeService {
		@Autowired
		private CsNoticeDao csNoticeDao;
		
		public void setCsNoticeDao(CsNoticeDao csNoticeDao){
			this.csNoticeDao = csNoticeDao;
		}
		public List<TbCsNoticeVo> CsNoticeList(HashMap<String, Object> map){
			return csNoticeDao.CsNoticeList(map);
		}
		public List<TbCsNoticeVo> CsNoticehits(HashMap<String, Object> map){
			return csNoticeDao.CsNoticehits(map);
		}
		public int csNoticeCount(HashMap<String, Object> map){
			return csNoticeDao.csNoticeCount(map);
		}
		public TbCsNoticeVo csNoticeDetail(HashMap<String, Object> map){
			return csNoticeDao.csNoticeDetail(map);
		}
		public int NoticeHitUpdate(int num){
			return csNoticeDao.NoticeHitUpdate(num);
		}
		public TbCsNRnumVo csn_get_rnum(HashMap<String, Object> map){
			return csNoticeDao.csn_get_rnum(map);
		}
		
}
