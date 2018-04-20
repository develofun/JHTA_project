package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ShopItemDao;
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

@Service
public class ShopItemService {
	@Autowired private ShopItemDao dao;
	public ShopItemVo getInfo(int item_code){
		return dao.getInfo(item_code);
	}
	public List<ShopSubImgVo> getSubImg(int item_code){
		return dao.getSubImg(item_code);
	}
	public List<ShopItemOptionVo> getOption(int item_code){
		return dao.getOption(item_code);
	}
	public int getQty(int option){
		return dao.getQty(option);
	}
	public int addJjim(HashMap<String, Object> map){
		System.out.println("¼­ºñ½º:"+map.get("code"));
		return dao.addJjim(map);
	}
	public List<ShopItemVo> goCart(String id){
		return dao.goCart(id);
	}
	public List<TbItemsetCartVo> goCartSet(String id){
		return dao.goCartSet(id);
	}
	 
	public int addCart(ShopCartVo vo){
	 
		return dao.addCart(vo);
	}
	public List<ShopItemVo> categoryList(HashMap<String, Object> map){
		return dao.categoryList(map);
	}
	
/*	public List<ShopCartListVo> goCartPage(String id){
		return dao.goCartPage(id);
	}*/
	
	public List<ShopItemsetCartVo> setCart(String id){
		return dao.setCart(id);
	}
	
	public int delCart(int num){
		return dao.delCart(num);
	}
	public List<ShopCartListVo> cartList(String id){
		return dao.cartList(id);
	}
	
	public int searchJjim(HashMap<String, Object> map){
		return dao.searchJjim(map);
	}
	
	public ShopCartListVo directOrder(HashMap<String, Integer> map){
		return dao.directOrder(map);
	}
	
	public ShopCartListVo dOrder(int code){
		return dao.dOrder(code);
	}
	public TbMemberPrivacyVo getMember_info(String id){
		return dao.getMember_info(id);
	}
	public List<TbCouponMyCouponVo> getMyCoupon(String id){
		return dao.getMyCoupon(id);
	}
	public int mycouponQty(String id){
		return dao.mycouponQty(id);
	}
	public List<TbCouponMyCouponVo> getUsablecp(String id){
		return dao.getUsablecp(id);
	}
	public TbCouponMyCouponVo getCouponInfo(int value){
		return dao.getCouponInfo(value);
	}
	public String sideBar(int code){
		return dao.sideBar(code);
	}
	public int orderNum(){
		return dao.orderNum();
	}
	public int addPayment(TbShopPaymentVo vo){
		return dao.addPayment(vo);
	}
	public int addPayPd(TbShopPaymentProductVo vo){
		return dao.addPayPd(vo);
	}
	public int getCpAmount(int coupon){
		return dao.getCpAmount(coupon);
	}
	public int item_sub(HashMap<String, Object> map){
		return dao.item_sub(map);
	}
	public int option_sub(HashMap<String, Object> map){
		return dao.option_sub(map);
	}
	public int updatePoint(HashMap<String, Object> map){
		return dao.updatePoint(map);
	}
	public int useCoupon(int coupon){
		return dao.useCoupon(coupon);
	}
	public int insertDelivery(TbShopDeliveryVo vo){
		return dao.insertDelivery(vo);
	}
	public List<TbShopOrderListVo> orderList(HashMap<String, Object> map){
		return dao.orderList(map);
	}
	public List<ShopOrderDescVo> order_desc(int order_num){
	    return dao.order_desc(order_num);
	}
	public List<TbShopOrderListVo> search_list(HashMap<String, Object> map){
		return dao.search_list(map);
	}
	public int order_count(HashMap<String, Object> map){
		return dao.order_count(map);
	}
	public int cancel_apply(ShopCancelVo vo){
		return dao.cancel_apply(vo);
	}
	public int del_history(HashMap<String, Object> map){
		return dao.del_history(map);
	}
	public List<ShopCancelListVo> cancelList(String id){
		return dao.cancelList(id);
	}
	public int cancel_chk(int payment_num){
		return dao.cancel_chk(payment_num);
	}
	public int getCancelPage(String id){
		return dao.getCancelPage(id);
	}
	public int deleteCart(HashMap<String, Object> map){
		return dao.deleteCart(map);
	}
	public int cartSearch(ShopCartVo vo){
		return dao.cartSearch(vo);
	}
	public int cartUpdate(ShopCartVo vo){
		return dao.cartUpdate(vo);
	}
	public int order_totalprice(String id){
		return dao.order_totalprice(id);
	}
	public int order_totalcount(String id){
		return dao.order_totalcount(id);
	}
	public int review_count(String id){
		return dao.review_count(id);
	}
}
	

