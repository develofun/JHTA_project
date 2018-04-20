package net.stylesolo.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.stylesolo.www.service.ItemSetMainService;
import net.stylesolo.www.service.ShopCategoryService;
import net.stylesolo.www.service.ShopService;
import net.stylesolo.www.vo.ItemsetMainViewVo;
import net.stylesolo.www.vo.ShopCategoryVo;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ShopCategoryService service;
	
	@Autowired
	private ItemSetMainService setService;

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String goToShopPage(Model model) {
		
		
		int categoryStart=0;
		int categoryEnd=999999;
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("categoryStart", categoryStart);
		map.put("categoryEnd", categoryEnd);
		map.put("method", "best");
		map.put("startRow", 1);
		map.put("endRow", 5);
		List<ShopCategoryVo> bList=service.categoryView(map);
		map.put("endRow", 3);
		Random ran=new Random();
		String[] mtd={"new","lowPrice","highPrice"};
		map.put("method", mtd[ran.nextInt(3)]);
		List<ItemsetMainViewVo> setList=setService.getList(map);
		map.put("endRow", 4);
		map.put("method", "new");
		List<ShopCategoryVo> nList=service.categoryView(map);
		map.put("endRow", 3);
		map.put("method", "discountRate");
		List<ShopCategoryVo> dList=service.categoryView(map);
		model.addAttribute("bList", bList);
		model.addAttribute("setList", setList);
		model.addAttribute("nList", nList);
		model.addAttribute("dList", dList);
		return ".shopping.shop_main";
		
	}
	
	@RequestMapping("/shopping_payment")
	public String payment(){
		return ".shopping.order_step1";
	}
	
/*	@RequestMapping("/order_desc")
	public String order_desc(){
		return ".shopping.order_desc";
	}*/
}