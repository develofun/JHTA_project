package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbCouponInfoVo;
import net.stylesolo.www.vo.TbEventCategoryVo;
import net.stylesolo.www.vo.TbEventDiscountVo;
import net.stylesolo.www.vo.TbEventItemVo;
import net.stylesolo.www.vo.TbEventListVo;
import net.stylesolo.www.vo.TbEvent_Coupon_InfoVo;
import net.stylesolo.www.vo.TbMyCouponInfoVo;
@Repository
public class EventDao {
	@Resource private SqlSession sqlsession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.EventMapper";
	public List<TbEventListVo> get_event_list(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".get_event_list", map);
	}
	public int get_list_count(HashMap<String, Object> map){
		return sqlsession.selectOne(NAMESPACE+".get_list_count",map);
	}
	public List<TbEventListVo> get_event_banner_list(int show_num){
		return sqlsession.selectList(NAMESPACE+".get_event_banner_list", show_num);
	}
	public TbEventListVo get_event_detail(HashMap<String, Object> map){
		return sqlsession.selectOne(NAMESPACE+".get_event_detail", map);
	}
	public List<TbEventItemVo> get_event_item(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".get_event_item", map);
	}
	public int get_item_count(int event_object_num){
		return sqlsession.selectOne(NAMESPACE+".get_item_count", event_object_num);
	}
	public int chk_detail_img(int show_num){
		return sqlsession.selectOne(NAMESPACE+".chk_detail_img", show_num);
	}
	public TbEventCategoryVo get_event_categoryl(int get_num){
		return sqlsession.selectOne(NAMESPACE+".get_event_category", get_num);
	}
	public List<TbEventListVo> chk_event_sort_ing(){
		return sqlsession.selectList(NAMESPACE+".chk_event_sort_ing");
	}
	public List<TbEventListVo> chk_event_sort_end(){
		return sqlsession.selectList(NAMESPACE+".chk_event_sort_end");
	}
	public int event_ing_update(int event_num){
		return sqlsession.update(NAMESPACE+".event_ing_update", event_num);
	}
	public int event_end_update(int event_num){
		return sqlsession.update(NAMESPACE+".event_end_update", event_num);
	}
	public TbEvent_Coupon_InfoVo event_coupon_info(int event_num){
		return sqlsession.selectOne(NAMESPACE+".event_coupon_info", event_num);
	}
	public TbCouponInfoVo get_coupon_event(int coupon_num){
		return sqlsession.selectOne(NAMESPACE+".get_coupon_event", coupon_num);
	}
	public int get_event_coupon(HashMap<String, Object> map){
		return sqlsession.update(NAMESPACE+".get_event_coupon", map);
	}
	public int update_event_coupon_num(HashMap<String, Object> map){
		return sqlsession.update(NAMESPACE+".update_event_coupon_num", map);
	}
	public TbMyCouponInfoVo get_mycoupon_info(HashMap<String, Object> map){
		return sqlsession.selectOne(NAMESPACE+".get_mycoupon_info", map);
	}
	public List<TbEvent_Coupon_InfoVo> event_coupon_chk_date(){
		return sqlsession.selectList(NAMESPACE+".event_coupon_chk_date");
	}
	public List<TbEvent_Coupon_InfoVo> event_coupon_chk_count(){
		return sqlsession.selectList(NAMESPACE+".event_coupon_chk_count");
	}
	public int del_event_coupon(int coupon_num){
		return sqlsession.delete(NAMESPACE+".del_event_coupon", coupon_num);
	}
	public int del_coupon(int coupon_num){
		return sqlsession.delete(NAMESPACE+".del_coupon", coupon_num);
	}
	public List<TbEventListVo> chk_discount_event(int event_category_num){
		return sqlsession.selectList(NAMESPACE+".chk_discount_event", event_category_num);
	}
	public List<TbEventDiscountVo> chk_discount_item(int event_object_num){
		return sqlsession.selectList(NAMESPACE+".chk_discount_item", event_object_num);
	}
	public int update_event_discountrate(HashMap<String, Object> map){
		return sqlsession.update(NAMESPACE+".update_event_discountrate", map);
	}
	public List<TbEventListVo> chk_end_discount_event(int event_category_num){
		return sqlsession.selectList(NAMESPACE+".chk_end_discount_event", event_category_num);
	}
	public int update_discount_end(int event_object_num){
		return sqlsession.update(NAMESPACE+".update_discount_end", event_object_num);
	}
}
