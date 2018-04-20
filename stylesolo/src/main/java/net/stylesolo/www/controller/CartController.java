package net.stylesolo.www.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.stylesolo.www.service.ItemsetCartJoinService;
import net.stylesolo.www.service.ShopCartJoinService;
import net.stylesolo.www.service.ShopItemService;
import net.stylesolo.www.service.TbShopCartService;
import net.stylesolo.www.vo.ItemsetCartJoinVo;
import net.stylesolo.www.vo.ShopCartJoinVo;
import net.stylesolo.www.vo.ShopCartListVo;
import net.stylesolo.www.vo.ShopCartVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;
import net.stylesolo.www.vo.TbShopCartVo;

@Controller
public class CartController {
	@Autowired private ShopItemService shopService;
	@Autowired private ShopCartJoinService service;
	@Autowired private ItemsetCartJoinService setService;
	@Autowired private TbShopCartService itemPaymentService;
	public void setService(ShopCartJoinService service) {
		this.service = service;
	}
	public void setSetService(ItemsetCartJoinService setService) {
		this.setService = setService;
	}
	
	public void setItemPaymentService(TbShopCartService itemPaymentService) {
		this.itemPaymentService = itemPaymentService;
	}
	@RequestMapping(value="/cart",method=RequestMethod.GET)
	public ModelAndView cartForm(HttpServletRequest req){
		//���̵� �� �޾ƿ���
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");		
		//mybatis�� ������ �ۼ�(��ٱ��Ͽ� �ҷ��� ������/��Ʈ��ǰ ������)	
		//dao,service ���ļ� �ҷ��� �� �� �ܿ� �����ϱ�
		//1.īƮ ����Ʈ���� ������ ��ǰ�ڵ带 ���� �̹��� ���̺��� ��ȸ�ؼ� �����ͼ� ����
		//2.cart_list ���۸� �����ؼ� ���̺� ���� �� �̹����� �Բ� ��ȸ�ϱ�
		List<ShopCartJoinVo> list=service.cartList(id);
		List<ItemsetCartJoinVo> listSet=setService.cartList(id);
		ModelAndView mv=new ModelAndView(".shop.shop_cart_main");
		mv.addObject("list",list);
		mv.addObject("listSet", listSet);
		return mv;
	}
	@RequestMapping(value="/cartDelete")
	public String cartDelete(int[] checkItem){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("checkItem", checkItem);
		int result=service.delete(map);
		return "redirect:/cart";
	}
	@RequestMapping(value="/setCartDelete")
	public String setCartDelete(int[] checkset){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("checkItem", checkset);
		int result=setService.delete(map);
		return "redirect:/cart";
	}
	@RequestMapping("/cartPayment")
	public String cartPayment(HttpServletRequest req,int[] checkItem,Model mv){
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("checkItem", checkItem);
		List<ShopCartListVo> list=itemPaymentService.cart_listup(map);
		TbMemberPrivacyVo minfo=shopService.getMember_info(id);
		int couponQty=shopService.mycouponQty(id);
		mv.addAttribute("list", list);
		mv.addAttribute("minfo", minfo);
		mv.addAttribute("couponQty", couponQty);
		return ".shop.order_step1";
	}
	@RequestMapping("/setCartPayment")
	public String setCartPayment(HttpServletRequest req,int[] checkset,Model mv){
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("checkItem", checkset);
		List<ItemsetCartJoinVo> list=setService.cartListUp(map);
		TbMemberPrivacyVo minfo=shopService.getMember_info(id);
		int couponQty=shopService.mycouponQty(id);
		mv.addAttribute("list", list);
		mv.addAttribute("minfo", minfo);
		mv.addAttribute("couponQty", couponQty);
		return ".shop.set_order_step";
	}
}
