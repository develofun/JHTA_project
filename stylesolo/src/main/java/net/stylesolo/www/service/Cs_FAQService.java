package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.Cs_FAQDao;
import net.stylesolo.www.vo.TbCsFAQCategoryVo;
import net.stylesolo.www.vo.TbCsFAQRnumVo;
import net.stylesolo.www.vo.TbCsFAQVo;

@Service
public class Cs_FAQService {
	@Resource Cs_FAQDao faq_dao;
	
	public List<TbCsFAQVo> faq_list(HashMap<String, Object> map){
		return faq_dao.faq_list(map);
	}
	public List<TbCsFAQVo> faq_hits(HashMap<String, Object> map){
		return faq_dao.faq_hit(map);
	}
	public int faq_count(HashMap<String, Object> map){
		return faq_dao.faq_count(map);
	}
	public TbCsFAQVo faq_detail(HashMap<String, Object> map){
		return faq_dao.faq_detail(map);
	}
	public int faq_hit_update(HashMap<String, Object> map){
		return faq_dao.faq_hit_update(map);
	}
	public TbCsFAQRnumVo faq_get_rnum(HashMap<String, Object> map){
		return faq_dao.faq_get_rnum(map);
	}
	public List<TbCsFAQCategoryVo> get_faq_category(){
		return faq_dao.get_faq_category();
	}
}
