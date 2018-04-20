package net.stylesolo.www.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.stylesolo.www.service.ChartService;
import net.stylesolo.www.service.TbMemberPrivacyService;
import net.stylesolo.www.vo.MemberChangePwdVo;
import net.stylesolo.www.vo.TbMemberOutVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;

@Controller
public class MemberController {
	@Autowired private TbMemberPrivacyService service;
	@Resource private ChartService chartService;
	/*
	  page type
	   - join
	   - find
	   - update
	   - login
	*/
	@RequestMapping(value = "/member/forms/{page}", method=RequestMethod.GET)
	public String goToTheFormPage(@PathVariable("page")String page, HttpSession session, Model model) {
		if(page.equals("update")) {
			model.addAttribute(
					"vo", 
					service.callMemberInformation((String)session.getAttribute("member_id"))
					);
		}
		return ".member.member_"+page;
	}
	
	/*
	moveFormPage �޼ҵ�� ����
	
	@RequestMapping("/member/member_join")
	public String memjoin(){
		return ".member.member_join";
	}
	
	@RequestMapping("/member/member_find")
	public String memFind(){
		return ".member.member_find";
	}

	@RequestMapping("/member/member_out")
	public String memout(){
		return ".members.member_out";
	}
	
	@RequestMapping("/member/member_update")
	public String memupdate(){
		return ".members.member_update";
	}
	
	@RequestMapping("/member/member_changepwd")
	public String memchangepwd(){
		return ".members.member_changepwd";
	}
	
	@RequestMapping("/member/member_login")
	public String memberlogin(){
		return ".member.member_login";
	}
	
	@RequestMapping("/member/member_checkpwd")
	public String memcheck(){
		return ".checkpwd";
	}
	
	*/

//	ȸ�� ������ ���� (����)
	@RequestMapping(value = "/member/save/{purpose}", method = RequestMethod.POST)
	public String storeMemberInformation (TbMemberPrivacyVo vo,
			@PathVariable("purpose")String purpose) {
		
		String result = (service.saveJoiningMemberData(vo)>0)?".main":"/member/form/join";

		//		ȸ�� ���� ��� �߰�(�̴��)
//		public void member_join_stat(){}
		
		return result;
	}
	
//	�α���
	@RequestMapping(value = "/member/login",method = RequestMethod.POST)
	public String login(TbMemberPrivacyVo mvo, HttpSession session, Model model) {
//		HashMap<String,Object> map=new HashMap<String,Object>();
//		map.put("id",id);
//		map.put("pwd",pwd);
//		HashMap<String,Object> map_memberout=new HashMap<String,Object>();
//		map_memberout.put("id", id);
		
		boolean result = service.isMember(mvo);//ȸ�����̺� ��ϵ� ȸ������ üũ
		
//		HashMap<String, Object> map2=service.memberout_prevent_login(map_memberout);//Ż�����̺� ��ϵ� ȸ��
		
		if(result) {
			/*�⼮ ����Ʈ 10�� ����(�̴��)*/
			boolean isPointAdd = service.member_point_add(mvo.getMember_privacy_id()) > 0;
			chartService.update_login();
			if(isPointAdd){
				System.out.println("����Ʈ ���� ����!");
			}else{
				System.out.println("����Ʈ ���� ����...");
			}
			
			/*session�� id�� ����Ǵ� �Ÿ� ȸ�� ��ȣ(�ڵ�)�� �����ؾ� ��*/
			session.setAttribute("id", mvo.getMember_privacy_id());
			return "redirect:/";
		}else{
			model.addAttribute("login_errMsg", "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return ".member.member_login";
		}
	}
	
	@RequestMapping(value = "/member/lookForAnAccount", method = RequestMethod.POST)
	@ResponseBody
	public String lookForAnAccount(TbMemberPrivacyVo mvo) {
		String result = service.lookForAnAccount(mvo);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", result);
		
		return jsonObject.toString();
	}
	/*
	@RequestMapping("/member/findId")
	@ResponseBody
	public String findId(String name,String phone,String birth){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("birth", birth);
		JSONObject json=new JSONObject();
		TbMemberPrivacyVo vo=service.member_findId(map);
		
		if(vo != null){
			json.put("idCheck", vo.getMember_privacy_id());
		}else{
			json.put("idCheck", false);
		}
		return json.toString();
	}
	
	@RequestMapping("/member/findPwd")
	@ResponseBody
	public String findPwd(String id,String email,String phone){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		map.put("email", email);
		map.put("phone", phone);
		JSONObject json=new JSONObject();
		TbMemberPrivacyVo vo=service.member_findPwd(map);
		
		if(vo != null){
			json.put("pwdCheck", vo.getMember_privacy_pwd());
		}else{
			json.put("pwdCheck", false);
		}
		return json.toString();
	}
	
	@RequestMapping("/member/find_pwd")
	@ResponseBody
	public HashMap<String, String> findPwd(String member_id,String member_email){
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("member_privacy_id",member_id);
		map.put("member_privacy_email",member_email);
		TbMemberPrivacyVo vo=service.pwdCheck(map);
		if(vo==null){
			map.put("resultMsg", "������ ã�� �� �����ϴ�.");
		}else{
			map.put("find_pwd", vo.getMember_privacy_pwd());
			FindMailSender fms=new FindMailSender();
			boolean mail_send_result=fms.FindPwdMailSender(member_email,vo.getMember_privacy_pwd());
		}
		return map;
	}
	
	@RequestMapping("/member/changepwd_new")
	public String go_newChangePwd(String id,Model model){
		model.addAttribute("id",id);
		return ".member.member_changepwd_new";
	}
	 */
	
	//�Ż󳻿� üũ �� ��й�ȣ ���� �������� ��Ʈ�ѷ�
	@RequestMapping("/member/new_change_password")
	public String new_change_password(String id,String new_password){
		HashMap<String, Object> map=new HashMap<String, Object>();
		System.out.println("���̵�,��й�ȣ:"+id+","+new_password);
		map.put("id", id);
		map.put("pwd", new_password);
		service.new_change_pwd(map);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/member/authentication/email", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, String> authenticateByEmail(String member_email) {
//		GmailAuth fms=new GmailAuth();
//		HashMap<String, String> map=fms.sendMail(member_email, "메일 내용");
//		GmailAuth.sendMail(member_email, "메일 내용");
//		System.out.println(map.get("code"));
//		return map;
		return null;
	}

	/* shopitemcontroller�� �̵�
	@RequestMapping("/member/member_main")
	public String memmain(){
		return ".member";
	}
	*/
	
	@RequestMapping("/idCheck/{id}")
	@ResponseBody
	public String idCheck(@PathVariable("id")String id){
		JSONObject json=new JSONObject();
		TbMemberPrivacyVo vo=service.idCheck(id);
		
		if(vo != null){
			json.put("idcheck", true);
		}else{
			json.put("idcheck", false);
		}
		return json.toString();
	}
	
	
	@RequestMapping(value="/checkMember", method = RequestMethod.POST)
	public String checkMember(String id,String pwd,HttpSession session){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("id",id);
		map.put("pwd",pwd);
		
		TbMemberPrivacyVo vo=service.checkMember(map);
		
		System.out.println("vo:"+vo);
		
		String addr=vo.getMember_privacy_addr();
		String[] addr_array;

		addr_array = addr.split(",");
		
		if(vo.equals("null")){
			return ".members.member_checkpwd";
		}else{
			session.setAttribute("id", id);
			session.setAttribute("vo", vo);
			session.setAttribute("addrNum", addr_array[0]);
			session.setAttribute("addr1", addr_array[1]);
			session.setAttribute("addr2", addr_array[2]);
			return ".members.member_update";
		}
	}
	
	@RequestMapping("/member/changePwd")
	public ModelAndView update(MemberChangePwdVo vo){
		int n=service.changepwd(vo);
		ModelAndView mv=new ModelAndView(".member");
		return mv;
	}
	
//	ȸ�� Ż��
	@RequestMapping(value="/member/drop", method=RequestMethod.POST)
	public ModelAndView memberout_insert(TbMemberOutVo vo,HttpSession session){
		int n=service.memberout_insert(vo);
		if(n>0){
			service.memberout_change_state(vo);
			ModelAndView mv=new ModelAndView(".main");
			session.invalidate();
			return mv;
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="/member/update",method=RequestMethod.POST)
	public ModelAndView member_update(TbMemberPrivacyVo vo,HttpSession session){
		int n=service.update(vo);
		if(n>0){
			ModelAndView mv=new ModelAndView(".member");
			return mv;
		}else{
			return null;
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
}

