package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ShopCancelListVo;
import net.stylesolo.www.vo.ShopCancelVo;
import net.stylesolo.www.vo.ShopCartListVo;
import net.stylesolo.www.vo.ShopCartVo;
import net.stylesolo.www.vo.ShopItemOptionVo;
import net.stylesolo.www.vo.ShopItemVo;
import net.stylesolo.www.vo.ShopItemsetCartVo;
import net.stylesolo.www.vo.ShopOrderDescVo;
import net.stylesolo.www.vo.ShopSubImgVo;
import net.stylesolo.www.vo.TbCouponMyCouponVo;
import net.stylesolo.www.vo.TbItemsetCartVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;
import net.stylesolo.www.vo.TbShopDeliveryVo;
import net.stylesolo.www.vo.TbShopOrderListVo;
import net.stylesolo.www.vo.TbShopPaymentProductVo;
import net.stylesolo.www.vo.TbShopPaymentVo;

@Repository
public class ShopItemDao {
	@Autowired private SqlSession session;
	private final String NAMESPACE="net.stylesolo.www.mybatis.ShopItemMapper";
	public ShopItemVo getInfo(int item_code){
		return session.selectOne(NAMESPACE+".getInfo", item_code);
	}
	public List<ShopSubImgVo> getSubImg(int item_code){
		return session.selectList(NAMESPACE+".getSubImg", item_code);
	}
	public List<ShopItemOptionVo> getOption(int item_code){
		return session.selectList(NAMESPACE+".getOption", item_code);
	}
	public int getQty(int option){
		return session.selectOne(NAMESPACE+".getQty", option);
	}
	public int addJjim(HashMap<String, Object> map){
		System.out.println("dao:"+map.get("code") +",id:"+map.get("id"));
		return session.insert(NAMESPACE+".addJjim", map);
	}
	public List<ShopItemVo> goCart(String id){
		return session.selectList(NAMESPACE+".goCart", id);
	}
	public List<TbItemsetCartVo> goCartSet(String id){
		return session.selectList(NAMESPACE+".goCartSet", id);
	}
	public int addCart(ShopCartVo vo){
		return session.insert(NAMESPACE+".addCart",vo);
	}
	public List<ShopItemVo> categoryList(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".CategoryList", map);
	}
	public List<ShopCartListVo> goCartPage(String id){
		return session.selectList(NAMESPACE+".goCartPage", id);
	}
	public List<ShopItemsetCartVo> setCart(String id){
		return session.selectList(NAMESPACE+".goCartSet", id);
	}
	public int delCart(int num){
		return session.delete(NAMESPACE+".delCart",num);
	}
	public List<ShopCartListVo> cartList(String id){
		return session.selectList(NAMESPACE+".cartList", id);
	}
	public int searchJjim(HashMap<String, Object> map){
		return session.selectOne(NAMESPACE+".searchJjim", map);
	}
	
	public ShopCartListVo directOrder(HashMap<String, Integer> map){
		return session.selectOne(NAMESPACE+".directOrder", map);
	}
	public ShopCartListVo dOrder(int code){
		return session.selectOne(NAMESPACE+".dOrder", code);
	}
	public TbMemberPrivacyVo getMember_info(String id){
		return session.selectOne(NAMESPACE+".getMember_info", id);
	}
	public List<TbCouponMyCouponVo> getMyCoupon(String id){
		return session.selectList(NAMESPACE+".getMyCoupon", id);
	}
	public int mycouponQty(String id){
		return session.selectOne(NAMESPACE+".mycouponQty", id);
	}
	public List<TbCouponMyCouponVo> getUsablecp(String id){
		return session.selectList(NAMESPACE+".getUsablecp", id);
	}
	public TbCouponMyCouponVo getCouponInfo(int value){
		return session.selectOne(NAMESPACE+".getCouponInfo",value);
	}
	public String sideBar(int code){
		return session.selectOne(NAMESPACE+".sideBar", code);
	}
	public int orderNum(){
		return session.selectOne(NAMESPACE+".orderNum");
	}
	public int addPayment(TbShopPaymentVo vo){
		return session.insert(NAMESPACE+".addPayment", vo);
	}
	public int addPayPd(TbShopPaymentProductVo vo){
		return session.insert(NAMESPACE+".addPayPd", vo);
	}
	public int getCpAmount(int coupon){
		return session.selectOne(NAMESPACE+".getCpAmount",coupon);
	}
	public int item_sub(HashMap<String, Object> map){
		return session.update(NAMESPACE+".item_sub",map);
	}
	public int option_sub(HashMap<String, Object> map){
		return session.update(NAMESPACE+".option_sub",map);
	}
	public int updatePoint(HashMap<String, Object> map){
		return session.insert(NAMESPACE+".updatePoint", map);
	}
	public int useCoupon(int coupon){
		return session.update(NAMESPACE+".useCoupon", coupon);
	}
	public int insertDelivery(TbShopDeliveryVo vo){
		return session.insert(NAMESPACE+".insertDelivery", vo);
	}
	public List<TbShopOrderListVo> orderList(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".orderList", map);
	}
	public List<ShopOrderDescVo> order_desc(int order_num){
	    return session.selectList(NAMESPACE+".order_desc", order_num);
	}
	public List<TbShopOrderListVo> search_list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".search_list", map);
	}
	public int order_count(HashMap<String, Object> map){
		return session.selectOne(NAMESPACE+".order_count", map);
	}
	public int cancel_apply(ShopCancelVo vo){
		return session.insert(NAMESPACE+".cancel_apply", vo);
	}
	public int del_history(HashMap<String, Object> map){
		return session.update(NAMESPACE+".del_history", map);
	}
	public List<ShopCancelListVo> cancelList(String id){
		return session.selectList(NAMESPACE+".cancelList",id);
	}
	public int cancel_chk(int payment_num){
		return session.selectOne(NAMESPACE+".cancel_chk",payment_num);
	}
	public int getCancelPage(String id){
		return session.selectOne(NAMESPACE+".getCancelPage",id);
	}
	public int deleteCart(HashMap<String, Object> map){
		return session.delete(NAMESPACE+".deleteCart",map);
	}
	public int cartSearch(ShopCartVo vo){
		return session.selectOne(NAMESPACE+".cartSearch",vo);
	}
	public int cartUpdate(ShopCartVo vo){
		return session.update(NAMESPACE+".cartUpdate",vo);
	}
	public int order_totalprice(String id){
		return session.selectOne(NAMESPACE+".order_totalprice",id);
	}
	public int order_totalcount(String id){
		return session.selectOne(NAMESPACE+".order_totalcount",id);
	}
	public int review_count(String id){
		return session.selectOne(NAMESPACE+".review_count", id);
	}
}

