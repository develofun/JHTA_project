package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbConsultCategoryVo;
import net.stylesolo.www.vo.TbCsConsultAnswerVo;
import net.stylesolo.www.vo.TbCsConsultImageVo;
import net.stylesolo.www.vo.TbCsConsultVo;
import net.stylesolo.www.vo.TbCsFAQRnumVo;
import net.stylesolo.www.vo.TbCsFAQVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;

@Repository
public class Cs_ConsultDao {
	@Resource private SqlSession sqlsession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.CsConsultMapper";
	public TbMemberPrivacyVo get_member_privacy(String id){
		return sqlsession.selectOne(NAMESPACE+".get_member_privacy", id);
	}
	public List<TbConsultCategoryVo> get_consult_category(){
		return sqlsession.selectList(NAMESPACE+".get_consult_category");
	}
	public int send_question(HashMap<String, Object> map){
		return sqlsession.insert(NAMESPACE+".send_question",map);
	}
	public int consult_image(TbCsConsultImageVo consult_imgVo){
		return sqlsession.insert(NAMESPACE+".consult_image", consult_imgVo);
	}
	public int get_new_consult_num(){
		return sqlsession.selectOne(NAMESPACE+".get_new_consult_num");
	}
	public List<TbCsConsultVo> get_consult_ing(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".get_ing_consult", map);
	}
	public List<TbCsConsultVo> get_end_consult(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".get_end_consult", map);
	}
	public TbCsConsultAnswerVo get_consult_answer(int cs_consult_num){
		return sqlsession.selectOne(NAMESPACE+".get_consult_answer",cs_consult_num);
	}
	public List<TbCsConsultImageVo> consult_image_detail(int cs_consult_num){
		return sqlsession.selectList(NAMESPACE+".consult_image_detail", cs_consult_num);
	}
	public int consult_del (int cs_consult_num){
		return sqlsession.delete(NAMESPACE+".consult_del",cs_consult_num);
	}
	public int consult_img_del (int cs_consult_num){
		return sqlsession.delete(NAMESPACE+".consult_img_del",cs_consult_num);
	}
	public int consult_ing_count (String member_privacy_id){
		return sqlsession.selectOne(NAMESPACE+".consult_ing_count", member_privacy_id);
	}
	public int consult_end_count (String member_privacy_id){
		return sqlsession.selectOne(NAMESPACE+".consult_end_count", member_privacy_id);
	}
}
