package net.stylesolo.www.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.stylesolo.www.service.ShopItemService;

@Controller
public class ShopItemViewController {
	@Autowired private ShopItemService service;

	public void setService(ShopItemService service) {
		this.service = service;
	}
	@RequestMapping("categoryView")
	public String bigList(Model mv,int section){
		int categoryStart=0;
		int categoryEnd=0;
		if(section<10){
			categoryStart=section*100000;
			categoryEnd=categoryStart+99999;
			//대분류 불러오는 쿼리 집어넣기
		}else if(section<100){
			categoryStart=section*10000;
			categoryEnd=categoryStart+9999;
		}else{
			categoryStart=section*1000;
			categoryEnd=categoryStart+999;
		}
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("categoryStart", categoryStart);
		map.put("categoryEnd", categoryEnd);
		mv.addAttribute("categoryList",service.categoryList(map));
		return "";
	}
}
