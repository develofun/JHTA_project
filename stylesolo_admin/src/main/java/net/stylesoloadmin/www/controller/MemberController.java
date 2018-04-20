package net.stylesoloadmin.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/member_list")
	public String member_list(){
		return ".member.member_list";
	}
	
	@RequestMapping("/member_detail")
	public String member_detail(){
		return ".member.member_detail";
	}
	
	@RequestMapping("/member_level_point")
	public String member_level_point(){
		return ".member.member_level_point";
	}
	
	@RequestMapping("/member_drop_list")
	public String member_drop_list(){
		return ".member.member_drop_list";
	}
}
