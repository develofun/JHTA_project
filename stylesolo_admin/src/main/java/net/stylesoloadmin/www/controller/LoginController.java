package net.stylesoloadmin.www.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.stylesoloadmin.www.service.AdminMemberService;
import net.stylesoloadmin.www.vo.AdminMemberVo;

@Controller
public class LoginController {
	@Resource AdminMemberService service;
	
	/* 가입 신청 페이지 이동 */
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String admin_join_page(){
		return ".login.admin_join";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String admin_join_action(AdminMemberVo vo){
		System.out.println(vo);
		return ".main";
	}
	
	@RequestMapping(value="/admin_find_account",method=RequestMethod.GET)
	public String admin_find_page(){
		return ".login.find_account";
	}
	
	@RequestMapping(value="/admin_login",method=RequestMethod.GET)
	public String admin_login_page(){
		return ".main";
	}
}
