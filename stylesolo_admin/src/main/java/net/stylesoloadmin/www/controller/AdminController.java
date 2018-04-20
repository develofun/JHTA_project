package net.stylesoloadmin.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin_list",method=RequestMethod.GET)
	public String admin_list(){
		return ".admin.admin_list";
	}
	
	@RequestMapping("/admin_authority")
	public String admin_detail(){
		return ".admin.admin_detail";
	}
	
	@RequestMapping("/admin_log")
	public String admin_log(){
		return ".admin.admin_log";
	}
	
}
