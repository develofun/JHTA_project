package net.stylesolo.www.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.stylesolo.www.common.SetBoardPage;

import net.stylesolo.www.service.TbGongguImgService;
import net.stylesolo.www.service.TbGongguInsertService;
import net.stylesolo.www.vo.TbGongguBestListVo;
import net.stylesolo.www.vo.TbGongguBuyVo;
import net.stylesolo.www.vo.TbGongguImgVo;
import net.stylesolo.www.vo.TbGongguInfoVo;
import net.stylesolo.www.vo.TbGongguInsertVo;
import net.stylesolo.www.vo.TbGongguListValueVo;
import net.stylesolo.www.vo.TbGongguReplyVo;
import net.stylesolo.www.vo.TbGongguUploadRequestVo;
import net.stylesolo.www.vo.TbMemberInfoGongguInfoVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;

@Controller
public class GongguController {
	@Autowired private TbGongguInsertService service;
	@Autowired private TbGongguImgService imgservice;
	
	//���������������� �̵��ÿ� ����Ʈ3������ �Բ� ����ϱ�
	@RequestMapping("/gonggu/{parameter}")
	public String ggmain(Model model, @PathVariable("parameter")String id) {
		if(id==null || id==""){
			model.addAttribute("why_are_you_here","�������� �޴��� �̿��Ͻ÷��� �α����� �ϼž� �մϴ�.");
			return ".member.member_login";
		}else{
		
			List<TbGongguBestListVo> bestlist=service.get_gonggu_best();
			
			int best1=bestlist.get(0).getGonggu_insert_num();
			int best2=bestlist.get(1).getGonggu_insert_num();
			int best3=bestlist.get(2).getGonggu_insert_num();
			
			TbGongguInfoVo best1_info=service.get_gonggu_best_info(best1);
			TbGongguInfoVo best2_info=service.get_gonggu_best_info(best2);
			TbGongguInfoVo best3_info=service.get_gonggu_best_info(best3);
			
			//����Ʈ3 �������� ���//
			Calendar c1 = Calendar.getInstance();//���ó�¥�ҷ�����
			long dday1=(best1_info.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
			long best1_day=dday1/(60*60*24);//(s->m->h->day �� ��ȯ)
			
			long dday2=(best2_info.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
			long best2_day=dday2/(60*60*24);//(s->m->h->day �� ��ȯ)
			
			long dday3=(best3_info.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
			long best3_day=dday3/(60*60*24);//(s->m->h->day �� ��ȯ)
			//////////////////////
			
			model.addAttribute("best1",best1_info);
			model.addAttribute("best1_day",best1_day);
			
			model.addAttribute("best2",best2_info);
			model.addAttribute("best2_day",best2_day);
			
			model.addAttribute("best3",best3_info);
			model.addAttribute("best3_day",best3_day);
			
			
			return ".gonggu.gonggu_main";
			
		}
	}
	
	
	@RequestMapping("/gonggu/gonggu_detail")//0407�����ؾ��Һκ�(�����)//
	public String ggdetail(Model model, int num){
		TbGongguInfoVo vo=service.gonggu_detail(num);//���������ϰ�
		List<TbGongguBuyVo> buyerlist=service.buyerlist(num);//�����ڸ���Ʈ
		int buyer_cnt=service.gonggu_buyer_cnt(num);//������ī��Ʈ
		int reply_cnt=service.gonggu_reply_cnt(num);//����ī��Ʈ

        Calendar c1 = Calendar.getInstance();//���ó�¥�ҷ�����
		long dday1=(vo.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
		long d_day=dday1/(60*60*24);//(s->m->h->day �� ��ȯ)
		
		model.addAttribute("vo",vo);
		model.addAttribute("d_day",d_day);
		model.addAttribute("buyerlist",buyerlist);
		model.addAttribute("buyer_cnt",buyer_cnt);
		model.addAttribute("reply_cnt",reply_cnt);
		return ".gonggu.gonggu_detail";
	}
	
	//���������������� ��� ajax(JSON�̿�)
	@RequestMapping("/gonggu_detail_replylist/{num}")
	@ResponseBody
	public String replylist(@PathVariable("num")int num){
		List<TbGongguReplyVo> replylist=service.gonggu_reply_list(num);
		JSONArray arr=new JSONArray();
		for(TbGongguReplyVo vo:replylist){
			JSONObject jj=new JSONObject();
			jj.put("num", vo.getGonggu_reply_num());
			jj.put("id", vo.getMember_privacy_id());
			jj.put("comment", vo.getGonggu_reply_comment());
			jj.put("date", vo.getGonggu_reply_date().toString());
			arr.add(jj);
		}
		return arr.toString();
	}
	
	@RequestMapping("/gonggu_detail_replyinsert")
	@ResponseBody
	public String replyinsert(int num,String comment,String id){
		System.out.println("�Ѿ��������"+num+","+comment+","+id);
		JSONObject json=new JSONObject();
		TbGongguReplyVo vo=new TbGongguReplyVo(0, comment, null, id, num);
		service.gonggu_reply_insert(vo);
		
		if(vo != null){
			json.put("insertOk", true);
		}else{
			json.put("insertOk", false);
		}
		return json.toString();
	}
	
	@RequestMapping("/gonggu/gonggu_join")
	public String ggjoin(){
		return ".gonggu.gonggu_join";
	}
	
		
	//����� �����ϴ� ��Ʈ�ѷ�(���+���� ����Ʈ����)0406
	@RequestMapping("/gonggu/gonggu_joinlist")
	public String ggjoinlist(@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageNum_buy",defaultValue="1")int pageNum_buy,String id,Model model){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		
		int totalRowCount=service.gonggu_info_cnt(map);//������ϸ���Ʈ����
		SetBoardPage pu=new SetBoardPage(pageNum, totalRowCount);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		int totalRowCount2=service.gonggu_buy_info_cnt(map);//�������Ÿ���Ʈ����
		SetBoardPage pu_buy=new SetBoardPage(pageNum_buy, totalRowCount2);
		map.put("startRow_buy", pu_buy.getStartRow());
		map.put("endRow_buy", pu_buy.getEndRow());
		
		List<TbGongguInfoVo> joinlist=service.joinlist(map);//������ϸ���Ʈ
		List<TbGongguInfoVo> buylist=service.buylist(map);//�������Ÿ���Ʈ
		
		model.addAttribute("joinlist",joinlist);
		model.addAttribute("pu",pu);
		model.addAttribute("buylist",buylist);
		model.addAttribute("pu_buy",pu_buy);
		
		return ".gonggu.gonggu_joinlist";
	}
	
	@RequestMapping("/gonggu/gonggu_buylist")
	public String ggbuylist(Model model,String id){
		return ".gonggu.gonggu_buylist";
	}
		
	@RequestMapping(value="/gonggu/insert",method=RequestMethod.POST)
	public String insert(TbGongguInsertVo vo, MultipartFile gonggu_img_name, HttpSession session){
		//������ ���ε��� ������� ������
		String path=session.getServletContext().getRealPath("/resources/upload");
		String orgfilename=gonggu_img_name.getOriginalFilename();//������ ���ϸ�
		//������ ���ϸ� �����(�ߺ����� �ʵ���)
		String savefilename=UUID.randomUUID() +"_"+ orgfilename;
		try{
			//���۵� ������ �о���� ���� ��Ʈ����ü
			InputStream is=gonggu_img_name.getInputStream();
			//���۵� ������ ������ ����(���)�ϱ� ���� ���Ͻ�Ʈ����ü����
			FileOutputStream fos=new FileOutputStream(path+"/"+savefilename);
			//���Ϻ����ϱ�
			FileCopyUtils.copy(is, fos);
			is.close();
			fos.close();
			System.out.println(path+"/"+savefilename+"[���Ͼ��ε强��!]");
			
			service.insert(vo);
			
			TbGongguImgVo imgvo=new TbGongguImgVo(0, orgfilename, savefilename, null, 0);
			
			imgservice.insert(imgvo);
			
			return ".gonggu.gonggu_main";
		}catch(IOException ie){
			System.out.println(ie.getMessage());
			return ".gonggu.gonggu_join";
		}
	}
	
	@RequestMapping(value="/gonggu/ordering",method=RequestMethod.POST)
	public ModelAndView ggordering(String member_privacy_id,int gonggu_insert_num,int gonggu_buy_getnum){
		TbMemberPrivacyVo userinfo=service.gonggu_ordering_user_info(member_privacy_id);//���������� �ҷ��ͼ� �����������̺� ���
		TbGongguInsertVo gongguinfo=service.gonggu_ordering_info(gonggu_insert_num);//�ش���������� �ҷ��ͼ� �������̺� �ش����� ���
		TbGongguImgVo gongguimg=service.gonggu_ordering_img_info(gonggu_insert_num);//�ش�����̹�������
		
		int gongguprice=Integer.parseInt(gongguinfo.getGonggu_insert_price());
		int price=gonggu_buy_getnum * gongguprice;//�Ѱ���=���Ű���*1���簡��
				
		String addr=userinfo.getMember_privacy_addr();
		String[] addr_array;

		addr_array = addr.split(",");
		
		ModelAndView mv=new ModelAndView(".gonggu.gonggu_ordering");
		mv.addObject("userinfo",userinfo);//�ش���� ������vo
		mv.addObject("gongguinfo",gongguinfo);//�ش����vo
		mv.addObject("buynum",gonggu_buy_getnum);//���ż���
		mv.addObject("price",price);//�Ѱ���
		mv.addObject("gongguimg",gongguimg);//�ش���� �̹���vo
		mv.addObject("addrNum", addr_array[0]);//�����ȣ
		mv.addObject("addr1", addr_array[1]);//�ּ�1
		mv.addObject("addr2", addr_array[2]);//�ּ�2(���ּ�)
				
		return mv;
	}
	
	
	@RequestMapping(value="/gonggu/buy",method=RequestMethod.POST)
	public ModelAndView ggbuy(TbGongguBuyVo vo){
		HashMap<String, Object> map=new HashMap<String, Object>();
				
		int usernum=vo.getGonggu_insert_num();//������Ϲ�ȣ �ҷ��ͼ� �ش� ���¹�ȣ,����� �ҷ��µ� ���â�� ����ϱ�
		TbMemberInfoGongguInfoVo membervo=service.gonggu_ordering_result(usernum);
				
		int n=service.gonggu_buy(vo);
		map.put("getnum", vo.getGonggu_buy_getnum());//���Լ���
		map.put("insertnum", vo.getGonggu_insert_num());//������Ϲ�ȣ(������Ʈ ���)
		
		int m=service.gonggu_buy_cntUpdate(map);
		
		ModelAndView mv=new ModelAndView(".gonggu.gonggu_buy_result");
		if(n>0){
			mv.addObject("result","success");
			mv.addObject("membervo",membervo);
		}else{
			mv.addObject("result","fail");
		}
		return mv;
	}
	
	
	//��üȸ����������Ʈ���//0407�����ؾ��Һκ�//
	@RequestMapping("/gonggu/gonggu_member_list")
	public String ggmemberlist(@RequestParam(value="pageNum",defaultValue="1")int pageNum,String keyword,Model model){
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
				
		int totalRowCount=service.get_member_list_count(map);//ȸ����������Ʈ����
		SetBoardPage pu=new SetBoardPage(pageNum, totalRowCount);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
				
		List<TbGongguListValueVo> memberlist=service.gonggu_member_list(map);
				
		
		//����Ʈ3 ����ϴ� ��ɵ�//
		List<TbGongguBestListVo> bestlist=service.get_gonggu_best();
		
		int best1=bestlist.get(0).getGonggu_insert_num();
		int best2=bestlist.get(1).getGonggu_insert_num();
		int best3=bestlist.get(2).getGonggu_insert_num();
		
		TbGongguInfoVo best1_info=service.get_gonggu_best_info(best1);
		TbGongguInfoVo best2_info=service.get_gonggu_best_info(best2);
		TbGongguInfoVo best3_info=service.get_gonggu_best_info(best3);
		///////////////////////
		
		//����Ʈ3 �������� ���//
		Calendar c1 = Calendar.getInstance();//���ó�¥�ҷ�����
		long dday1=(best1_info.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
		long best1_day=dday1/(60*60*24);//(s->m->h->day �� ��ȯ)
		
		long dday2=(best2_info.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
		long best2_day=dday2/(60*60*24);//(s->m->h->day �� ��ȯ)
		
		long dday3=(best3_info.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
		long best3_day=dday3/(60*60*24);//(s->m->h->day �� ��ȯ)
		//////////////////////
		
		model.addAttribute("memberlist",memberlist);
		model.addAttribute("pu",pu);
		model.addAttribute("keyword",keyword);
		
		model.addAttribute("best1",best1_info);
		model.addAttribute("best1_day",best1_day);
		
		model.addAttribute("best2",best2_info);
		model.addAttribute("best2_day",best2_day);
		
		model.addAttribute("best3",best3_info);
		model.addAttribute("best3_day",best3_day);
		
		return ".gonggu.gonggu_member_list";
	}
	
	//ī�װ����ý� �ش��������Ʈ���
	@RequestMapping("/gonggu_list_category")
	public String ggcategorylist(@RequestParam(value="pageNum",defaultValue="1")int pageNum,String keyword,String category,Model model){
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("category", category);
				
		int totalRowCount=service.get_member_list_category_count(map);//ȸ����������Ʈ����(ī�װ����� ����)
		SetBoardPage pu=new SetBoardPage(pageNum, totalRowCount);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<TbGongguListValueVo> memberlist=service.gonggu_member_list_category(map);
		System.out.println("�������Ʈ:"+memberlist);
		//����Ʈ3����ϴ±�ɺκ�//
		List<TbGongguBestListVo> bestlist=service.get_gonggu_best();
		System.out.println("����Ʈ����Ʈ:"+bestlist);
		int best1=bestlist.get(0).getGonggu_insert_num();
		int best2=bestlist.get(1).getGonggu_insert_num();
		int best3=bestlist.get(2).getGonggu_insert_num();
		
		TbGongguInfoVo best1_info=service.get_gonggu_best_info(best1);
		TbGongguInfoVo best2_info=service.get_gonggu_best_info(best2);
		TbGongguInfoVo best3_info=service.get_gonggu_best_info(best3);
		///////////////////////
		
		//����Ʈ3 �������� ���//
		Calendar c1 = Calendar.getInstance();//���ó�¥�ҷ�����
		long dday1=(best1_info.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
		long best1_day=dday1/(60*60*24);//(s->m->h->day �� ��ȯ)
		
		long dday2=(best2_info.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
		long best2_day=dday2/(60*60*24);//(s->m->h->day �� ��ȯ)
		
		long dday3=(best3_info.getGonggu_insert_closingdate().getTime() - c1.getTimeInMillis()) / 1000;//ms������ ��ȯ�� ���̰� ���(ms->s)
		long best3_day=dday3/(60*60*24);//(s->m->h->day �� ��ȯ)
		//////////////////////
		
		model.addAttribute("memberlist",memberlist);
		model.addAttribute("pu",pu);
		model.addAttribute("keyword",keyword);
		
		model.addAttribute("best1",best1_info);
		model.addAttribute("best1_day",best1_day);
		
		model.addAttribute("best2",best2_info);
		model.addAttribute("best2_day",best2_day);
		
		model.addAttribute("best3",best3_info);
		model.addAttribute("best3_day",best3_day);
		
		return ".gonggu.gonggu_member_list";
	}
	
	//�������ѽ�û�������̵�
	@RequestMapping("/gonggu/gonggu_upload_request")
	public String gonggu_upload_request(){
		return ".gonggu.gonggu_upload_request";
	}
	//�������ѽ�û�ϱ�
	@RequestMapping(value="/gonggu/gonggu_upload_request",method=RequestMethod.POST)
	public ModelAndView gonggu_upload_request_insert(TbGongguUploadRequestVo vo){
		int n=service.gonggu_upload_request(vo);
		ModelAndView mv=new ModelAndView(".main");
		return mv;
	}
	
}







