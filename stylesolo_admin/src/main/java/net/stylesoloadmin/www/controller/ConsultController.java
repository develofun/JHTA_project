package net.stylesoloadmin.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsultController {
	
	@RequestMapping("/consult_list")
	public String consult_list(){
		return ".consult.consult_list";
	}
	
	@RequestMapping("/consult_detail")
	public String consult_detail(){
		return ".consult.consult_detail";
	}
	
	@RequestMapping("/consult_template")
	public String consult_template(){
		return ".consult.consult_template";
	}
	
	@RequestMapping("/consult_category")
	public String consult_category(){
		return ".consult.consult_category";
	}
}
