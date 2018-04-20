package net.stylesoloadmin.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShopController {
	
	@RequestMapping(value="/shop_category",method=RequestMethod.GET)
	public String shop_category(){
		return ".shop.shop_category";
	}
	
	@RequestMapping("/shop_item")
	public String shop_item(){
		return ".shop.shop_item";
	}
	
	@RequestMapping("/shop_order_delivery")
	public String shop_order_delivery(){
		return ".shop.shop_order_delivery";
	}

	@RequestMapping("/shop_payment")
	public String shop_payment(){
		return ".shop.shop_payment";
	}
}
