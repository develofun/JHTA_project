package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbCsFAQCategoryVo;
import net.stylesolo.www.vo.TbCsFAQRnumVo;
import net.stylesolo.www.vo.TbCsFAQVo;

@Repository
public class Cs_FAQDao {
	@Resource private SqlSession sqlsession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.CsFAQMapper";
	public List<TbCsFAQVo> faq_list(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".faqlist",map);
	}
	public List<TbCsFAQVo> faq_hit(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".faqhits",map);
	}
	public int faq_count(HashMap<String, Object> map){
		return sqlsession.selectOne(NAMESPACE+".faqcount",map);
	}
	public TbCsFAQVo faq_detail(HashMap<String, Object> map){
		return sqlsession.selectOne(NAMESPACE+".faqdetail", map);
	}
	public int faq_hit_update(HashMap<String, Object> map){
		return sqlsession.update(NAMESPACE+".faq_hit_update", map);
	}
	public TbCsFAQRnumVo faq_get_rnum(HashMap<String, Object> map){
		return sqlsession.selectOne(NAMESPACE+".faq_get_rnum",map);
	}
	public List<TbCsFAQCategoryVo> get_faq_category(){
		return sqlsession.selectList(NAMESPACE+".get_faq_category");
	}
}
