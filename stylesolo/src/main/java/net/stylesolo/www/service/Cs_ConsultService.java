package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.Cs_ConsultDao;
import net.stylesolo.www.vo.TbConsultCategoryVo;
import net.stylesolo.www.vo.TbCsConsultAnswerVo;
import net.stylesolo.www.vo.TbCsConsultImageVo;
import net.stylesolo.www.vo.TbCsConsultVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;

@Service
public class Cs_ConsultService {
	@Resource Cs_ConsultDao consult_dao;
	public TbMemberPrivacyVo get_member_privacy(String id){
		return consult_dao.get_member_privacy(id);
	}
	public List<TbConsultCategoryVo> get_consult_category(){
		return consult_dao.get_consult_category();
	}
	public int send_question(HashMap<String, Object> map){
		return consult_dao.send_question(map);
	}
	public int consult_image(TbCsConsultImageVo consult_imgVo){
		return consult_dao.consult_image(consult_imgVo);
	}
	public int get_new_consult_num(){
		return consult_dao.get_new_consult_num();
	}
	public List<TbCsConsultVo> get_consult_ing(HashMap<String, Object> map){
		return consult_dao.get_consult_ing(map);
	}
	public List<TbCsConsultVo> get_end_consult(HashMap<String, Object> map){
		return consult_dao.get_end_consult(map);
	}
	public TbCsConsultAnswerVo get_consult_answer(int cs_consult_num){
		return consult_dao.get_consult_answer(cs_consult_num);
	}
	public List<TbCsConsultImageVo> consult_image_detail(int cs_consult_num){
		return consult_dao.consult_image_detail(cs_consult_num);
	}
	public int consult_del (int cs_consult_num){
		return consult_dao.consult_del(cs_consult_num);
	}
	public int consult_img_del (int cs_consult_num){
		return consult_dao.consult_img_del(cs_consult_num);
	}
	public int consult_ing_count (String member_privacy_id){
		return consult_dao.consult_ing_count(member_privacy_id);
	}
	public int consult_end_count (String member_privacy_id){
		return consult_dao.consult_end_count(member_privacy_id);
	}
}
