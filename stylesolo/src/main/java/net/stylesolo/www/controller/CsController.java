package net.stylesolo.www.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import net.stylesolo.www.common.SetBoardPage;
import net.stylesolo.www.service.CsNoticeService;
import net.stylesolo.www.service.Cs_ConsultService;
import net.stylesolo.www.service.Cs_FAQService;
import net.stylesolo.www.vo.TbConsultCategoryVo;
import net.stylesolo.www.vo.TbCsConsultAnswerVo;
import net.stylesolo.www.vo.TbCsConsultImageVo;
import net.stylesolo.www.vo.TbCsConsultVo;
import net.stylesolo.www.vo.TbCsFAQCategoryVo;
import net.stylesolo.www.vo.TbCsFAQVo;
import net.stylesolo.www.vo.TbCsNoticeVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;

@Controller
public class CsController {
	@Resource Cs_FAQService service_faq;
	@Resource Cs_ConsultService service_consult;
	@Resource CsNoticeService serviceCNS;
	@RequestMapping("/customerService")
	/*FAQ占쏙옙占쏙옙*/
	public String faqMain(Model model,HttpSession session){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("snum", 1);
		map.put("enum", 5);
		List<TbCsFAQVo> faq_list=service_faq.faq_list(map);
		List<TbCsFAQVo> faq_hits=service_faq.faq_hits(map);
		if(session!=null){
			String get_id=(String)session.getAttribute("id");
			if(get_id!=null&&get_id!=""){model.addAttribute("get_id", get_id);}
		}
		List<TbCsFAQCategoryVo>get_faq_category= service_faq.get_faq_category();
		model.addAttribute("get_faq_category",get_faq_category);
		model.addAttribute("faq_new", faq_list);
		model.addAttribute("faq_hits", faq_hits);
		return ".cs.cs_FAQ_Main";
	}
	/*1:1占쏙옙占쏙옙 占쏙옙占쏙옙*/
	@RequestMapping(value="/cs/cs_consult", method=RequestMethod.GET)
	public String consultMain(Model model,HttpSession session){
		String get_id=(String)session.getAttribute("id");
		if(get_id!=null&&get_id!=""){
			List<TbConsultCategoryVo> consult_category=service_consult.get_consult_category();
			TbMemberPrivacyVo member_info=service_consult.get_member_privacy(get_id);
			String id=member_info.getMember_privacy_id();
			String phone=member_info.getMember_privacy_phone();
			String p1=phone.substring(0, 3);String p2=phone.substring(3,7);String p3=phone.substring(7,11);
			String email=member_info.getMember_privacy_email();
			String[] email0=email.split("@");String email1=email0[0];String email2=email0[1];
			List<TbCsFAQCategoryVo>get_faq_category= service_faq.get_faq_category();
			model.addAttribute("get_faq_category",get_faq_category);
			model.addAttribute("consult_id", id);
			model.addAttribute("phone", phone);
			model.addAttribute("phone1", p1);
			model.addAttribute("phone2", p2);
			model.addAttribute("phone3", p3);
			model.addAttribute("email", email);
			model.addAttribute("email1", email1);
			model.addAttribute("email2", email2);
			model.addAttribute("consult_category", consult_category);
		}
		return ".cs.cs_Consult_Main";
	}
	/*1:1占쏙옙占쏙옙 占쏙옙占�*/
	@RequestMapping(value="/cs/cs_consult", method=RequestMethod.POST)
	public String consultResult(Model model,String consult_sort,String consult_id,String consult_phone_num,
			String consult_email,String consult_title,String consult_content, 
			MultipartHttpServletRequest multipartRequest,HttpSession session){
		int consult_category_num=0;
		HashMap<String, Object> map=new HashMap<String, Object>();
		List<TbConsultCategoryVo> consult_category_list=service_consult.get_consult_category();
		for(TbConsultCategoryVo consult_category:consult_category_list){
			if(consult_category.getConsult_category_name().equals(consult_sort)){
				consult_category_num=consult_category.getConsult_category_num();
			}
		}
		map.put("cs_consult_title", consult_title);
		map.put("cs_consult_content", consult_content);
		map.put("cs_consult_answercheck", "확占쏙옙 占쏙옙");
		map.put("member_privacy_id",consult_id);
		map.put("consult_category_num", consult_category_num);
		map.put("cs_consult_state", "처占쏙옙 占쏙옙");
		int send_qusetion=service_consult.send_question(map);
		if(send_qusetion>0){
			/*占쏙옙占쏙옙占쏙옙占쏙옙*/
			Iterator<String> images=multipartRequest.getFileNames();
			String consultPath=session.getServletContext().getRealPath("/resources/cs_consultimage/");
			SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMddhhmmss", Locale.KOREA );
			Date currentTime = new Date();
			String consult_time=formatter.format(currentTime);
			int cnt=1;
			while(images.hasNext()){
				String image_name=images.next();
				MultipartFile image=multipartRequest.getFile(image_name+"");
				String imgOrgname=image.getOriginalFilename();
				int imgchk1=imgOrgname.indexOf(".png");
				int imgchk2=imgOrgname.indexOf(".jpg");
				int imgchk3=imgOrgname.indexOf(".jpeg");
				image.getSize();
				if(image.getSize()!=0){
					String imgchk="";
					if(imgchk1>0){imgchk=imgOrgname.substring(imgchk1, imgchk1+4);
					}else if(imgchk2>0){imgchk=imgOrgname.substring(imgchk2, imgchk2+4);
					}else if(imgchk3>0){imgchk=imgOrgname.substring(imgchk3, imgchk3+4);}
					File consult_image = new File(consultPath+"consult_"+consult_time+"("+cnt+")"+imgchk);
					System.out.println("占쏙옙占쏙옙占쏙옙 占쏙옙占�: "+consultPath);
					System.out.println("占쏙옙占싹몌옙: "+"consult_"+consult_time+"("+cnt+")"+imgchk);
					if(!consult_image.exists()){
						try {
							consult_image.createNewFile();
						} catch (IOException ie) {
							System.out.println(ie.getMessage());
						}
					}
					try {
						image.transferTo(consult_image);
					}catch(IllegalStateException ile){
						System.out.println(ile.getMessage());
					} catch (IOException ie) {
						System.out.println(ie.getMessage());
					}
					int cs_consult_num=service_consult.get_new_consult_num();
					TbCsConsultImageVo consult_imgVo=new TbCsConsultImageVo(0,cs_consult_num,"consult_"+consult_time+"("+cnt+")"+imgchk);
					int consult_img_in=service_consult.consult_image(consult_imgVo);
					if(consult_img_in<=0){
						consult_image.delete();
					}
				}
				cnt++;
			}
		}else{
			System.out.println("error");
		}
		List<TbCsFAQCategoryVo>get_faq_category= service_faq.get_faq_category();
		model.addAttribute("get_faq_category",get_faq_category);
		return ".cs.cs_Consult_Result";
	}
	
	/*占쏙옙占실놂옙占쏙옙*/
	@RequestMapping(value="/cs/cs_consult_list",method=RequestMethod.GET)
	public String cs_consult_list(
			Model model,HttpSession session,String consult_num,HttpServletResponse resp
			,@RequestParam(value="pageNum_ing",defaultValue="1")int pageNum_ing,
			@RequestParam(value="endPageNum_ing",defaultValue="1")int endPageNum_ing,
			@RequestParam(value="pageNum_end",defaultValue="1")int pageNum_end,
			@RequestParam(value="endPageNum_end",defaultValue="1")int endPageNum_end,
			@RequestParam(value="pagePre5_ing",defaultValue="0")int pagePre5_ing,
			@RequestParam(value="pageNext5_ing",defaultValue="0")int pageNext5_ing,
			@RequestParam(value="pagePre5_end",defaultValue="0")int pagePre5_end,
			@RequestParam(value="pageNext5_end",defaultValue="0")int pageNext5_end
			){
		HashMap<String, Object> map=new HashMap<String, Object>();
		if(session!=null){
			String get_id=(String)session.getAttribute("id");
			if(get_id!=null&&get_id!=""){model.addAttribute("get_id", get_id);}
			int total_count_ing=service_consult.consult_ing_count(get_id);
			SetBoardPage pu_consult_ing=new SetBoardPage(pagePre5_ing,total_count_ing);
			if(pagePre5_ing!=0){
				if(pagePre5_ing<=5){
					pageNum_ing=pagePre5_ing;
				}else{
					if(pagePre5_ing%5==0){pageNum_ing=((pagePre5_ing/5)-1)*5-4;}
					pageNum_ing=(pagePre5_ing/5)*5-4;
				}
			}
			if(pageNext5_ing!=0){
				if(pageNext5_ing+6 >=pu_consult_ing.getTotalPageCount()){
					pageNum_ing=pageNext5_ing;
				}else{
					pageNum_ing=(pageNext5_ing/5)*5+6;
					if(pageNext5_ing%5==0){pageNum_ing=(pageNext5_ing/5)*5+1;}
				}
			}
			SetBoardPage pu_ing=new SetBoardPage(pageNum_ing, total_count_ing);
			int total_count_end=service_consult.consult_end_count(get_id);
			SetBoardPage pu_consult_end=new SetBoardPage(pageNext5_end,total_count_ing);
			if(pagePre5_end!=0){
				if(pagePre5_end<=5){
					pageNum_end=pagePre5_end;
				}else{
					if(pagePre5_end%5==0){pageNum_end=((pagePre5_end/5)-1)*5-4;}
					pageNum_ing=(pagePre5_end/5)*5-4;
				}
			}
			if(pageNext5_end!=0){
				if(pageNext5_end+6>=pu_consult_end.getTotalPageCount()){
					pageNum_end=pageNext5_end;
				}else{
					pageNum_end=(pageNext5_end/5)*5+6;
					if(pageNext5_end>5&&pageNext5_end%5==0){pageNum_end=(pageNext5_end/5)*5+1;}
				}
			}
			SetBoardPage pu_end=new SetBoardPage(pageNum_end,total_count_end);
			
			map.put("member_privacy_id", get_id);
			map.put("snum_ing", pu_ing.getStartRow());
			map.put("enum_ing", pu_ing.getEndRow());
			map.put("snum_end", pu_end.getStartRow());
			map.put("enum_end", pu_end.getEndRow());
			List<TbCsConsultVo> get_consult_ing=service_consult.get_consult_ing(map);
			List<TbCsConsultVo> get_consult_end=service_consult.get_end_consult(map);
			model.addAttribute("pu_ing_startPage", pu_ing.getStartPageNum());
			model.addAttribute("pu_ing_endPage", pu_ing.getEndPageNum());
			model.addAttribute("pu_ing_pageNum", pu_ing.getPageNum());
			model.addAttribute("pu_ing_totalPage", pu_ing.getTotalPageCount());
			model.addAttribute("get_consult_ing", get_consult_ing);
			model.addAttribute("pu_end_startPage", pu_end.getStartPageNum());
			model.addAttribute("pu_end_endPage", pu_end.getEndPageNum());
			model.addAttribute("pu_end_pageNum", pu_end.getPageNum());
			model.addAttribute("pu_end_totalPage", pu_end.getTotalPageCount());
			model.addAttribute("get_consult_end", get_consult_end);
		}
		List<TbCsFAQCategoryVo>get_faq_category= service_faq.get_faq_category();
		model.addAttribute("get_faq_category",get_faq_category);
		return ".cs.cs_Consult_List";
	}
	/*占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙 占쏙옙 占썰변 占쏙옙占�*/
	@RequestMapping(value="/cs/cs_consult_list",method=RequestMethod.POST)
	@ResponseBody
	public String cs_get_consult_answer(
			Model model,String consult_num,String consult_num_del){
			//String html="";
			JSONObject js=new JSONObject();
			if(consult_num!=""&&consult_num!=null){
				int cs_consult_num=Integer.parseInt(consult_num);
				TbCsConsultAnswerVo get_consult_answer=service_consult.get_consult_answer(cs_consult_num);
				String consult_answer=get_consult_answer.getCs_consult_answer();			
				model.addAttribute("consult_answer", consult_answer);
				js.put("consult_answer", consult_answer);
				//html="${consult_answer }";
			}
			if(consult_num_del!=""&&consult_num_del!=null){
				System.out.println(consult_num_del);
				int cs_consult_num_del=Integer.parseInt(consult_num_del);
				List<TbCsConsultImageVo> del_img_list=service_consult.consult_image_detail(cs_consult_num_del);
				if(del_img_list.isEmpty()){
					service_consult.consult_del(cs_consult_num_del);
				}else{
					int consult_img_del=service_consult.consult_img_del(cs_consult_num_del);
					if(consult_img_del>0){
						String delfilePath="C:/FinalPro/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/stylesolo/resources/cs_consultimage/";	
						for(TbCsConsultImageVo vo:del_img_list){
							File delfile=new File(delfilePath+vo.getCs_consult_image_name());
							if(delfile.delete()){
								System.out.println("占쏙옙占싹삼옙占쏙옙");
							}
						}
						service_consult.consult_del(cs_consult_num_del);
					}
				}
			}
			return js.toString();
	}
	
	/*占싱울옙홰占�*/
	@RequestMapping("/cs/cs_info")
	public String info(Model model,HttpSession session){
		if(session!=null){
			String get_id=(String)session.getAttribute("id");
			if(get_id!=null&&get_id!=""){model.addAttribute("get_id", get_id);}
		}
		System.out.println("faqinfo");
		List<TbCsFAQCategoryVo>get_faq_category= service_faq.get_faq_category();
		model.addAttribute("get_faq_category",get_faq_category);
		return ".cs.cs_Info";
	}
	/*FAQ 占쏙옙占쏙옙트*/
	@RequestMapping(value="/cs/cs_list", method=RequestMethod.GET)
	public String faq_list(@RequestParam(value="pageNum",defaultValue="1")int pageNum,
		@RequestParam(value="endPageNum",defaultValue="1")int endPageNum,
		@RequestParam(value="pagePre",defaultValue="0")int pagePre,
		@RequestParam(value="pageNext",defaultValue="0")int pageNext,
		@RequestParam(value="pagePre10",defaultValue="0")int pagePre10,
		@RequestParam(value="pageNext10",defaultValue="0")int pageNext10,
		String search,String category,String faq_num,String rnum,Model model,HttpSession session){
		HashMap<String, Object> map=new HashMap<String, Object>();
		if(pagePre!=0||pageNext!=0){
			if(pagePre!=0){
				if(pagePre<=0){pageNum=1;}else if(pagePre!=0){pageNum=pagePre;}
			}else{
				pageNum=pageNext;
			}
		}
		if(pagePre10!=0||pageNext10!=0){
			if(pagePre10!=0){
				if(pagePre10>=1&&pagePre10<10){
					pageNum=pagePre10;
				}else {pageNum=(pagePre10/10*10)-9;}
			}else{
				pageNum=(pageNext10/10*10)+11;
			}
		}
		int faq_count=service_faq.faq_count(map);
		int totalRowCount=faq_count;
		if(pageNext10!=0){if((faq_count/10)+1<pageNum){pageNum=pageNext10;}}
		if(pageNext!=0){if((faq_count/10)+1<pageNum){pageNum=pageNext-1;}}
		SetBoardPage pu=new SetBoardPage(pageNum, totalRowCount);
		map.put("snum", pu.getStartRow());
		map.put("enum", pu.getEndRow());
		List<TbCsFAQVo> faq_list=service_faq.faq_list(map);
		if(faq_num!=null&&faq_num!=""){
			map.put("faq_num", faq_num);
			TbCsFAQVo faq_detail=service_faq.faq_detail(map);
			int faq_hit=faq_detail.getCs_faq_hit()+1;
			map.put("faq_hit", faq_hit);
			service_faq.faq_hit_update(map);
			model.addAttribute("faq_num",faq_num);
		}
		if(search!=null&&search!=""){
			map.put("search", search);
			faq_count=service_faq.faq_count(map);
			totalRowCount=faq_count;
			if(pageNext10!=0){if((faq_count/10)+1<pageNum){pageNum=pageNext10;}}
			if(pageNext!=0){if((faq_count/10)+1<pageNum){pageNum=pageNext-1;}}
			pu=new SetBoardPage(pageNum, totalRowCount);
			map.put("snum", pu.getStartRow());
			map.put("enum", pu.getEndRow());
			faq_list=service_faq.faq_list(map);
		}else if(category!=null&&category!=""){
			map.put("category", category);
			if(faq_num!=null&&faq_num!=""){
				map.put("faq_num", faq_num);
				int get_rnum=service_faq.faq_get_rnum(map).getRnum();
				pageNum=get_rnum/10 + 1;
				if(get_rnum%10==0)pageNum=get_rnum/10;
			}
			faq_count=service_faq.faq_count(map);
			totalRowCount=faq_count;
			if(pageNext10!=0){if((faq_count/10)+1<pageNum){pageNum=pageNext10;}}
			if(pageNext!=0){if((faq_count/10)+1<pageNum){pageNum=pageNext-1;}}
			pu=new SetBoardPage(pageNum, totalRowCount);
			map.put("snum", pu.getStartRow());
			map.put("enum", pu.getEndRow());
			faq_list=service_faq.faq_list(map);
		}
		if(session!=null){
			String get_id=(String)session.getAttribute("id");
			if(get_id!=null&&get_id!=""){model.addAttribute("get_id", get_id);}
		}
		List<TbCsFAQCategoryVo>get_faq_category= service_faq.get_faq_category();
		model.addAttribute("get_faq_category",get_faq_category);
		model.addAttribute("faq_list", faq_list);
		model.addAttribute("pu",pu);
		model.addAttribute("faq_count", faq_count);
		model.addAttribute("category", category);
		model.addAttribute("search", search);
		return ".cs.cs_FAQ_List";
	}
	
	/*cs_notice*/
	@RequestMapping(value="/cs/cs_notice", method=RequestMethod.GET)
	public String noticelist(
			//RequestParam
			@RequestParam(value="pageNum",defaultValue="1")int pageNum,
			@RequestParam(value="endPageNum",defaultValue="1")int endPageNum,
			@RequestParam(value="pagePre",defaultValue="0")int pagePre,
			@RequestParam(value="pageNext",defaultValue="0")int pageNext,
			@RequestParam(value="pagePre10",defaultValue="0")int pagePre10,
			@RequestParam(value="pageNext10",defaultValue="0")int pageNext10,
			String search,String category,String cs_notice_num,String rnum,Model model,HttpSession session){
			if(session!=null){
				String get_id=(String)session.getAttribute("id");
				if(get_id!=null&&get_id!=""){model.addAttribute("get_id", get_id);}
			}
			HashMap<String, Object> map=new HashMap<String, Object>();
			//paging
			//pre next
			if(pagePre!=0 || pageNext!=0){
				System.out.println(pagePre+","+pageNext);
				if(pagePre<=0){pageNum=1;}else if(pagePre!=0){pageNum=pagePre;}
				if(pageNext>endPageNum){pageNum=pageNext-1;}else if(pageNext!=0){pageNum=pageNext;}
				System.out.println(pageNum);
			}
			//10page
			if(pagePre10!=0 || pageNext10!=0){
				System.out.println(pagePre + "," + pageNext);
				if(pagePre10>=1){pageNum=1;}else if(pagePre10!=0){pageNum=pagePre10/10*10;}
				if(pageNext10>endPageNum){pageNum=pageNext-1;}else if(pageNext10!=0){pageNum=pageNext10/10*10;}
				System.out.println(pageNum);				
			}
			//total
			int csNoticeCount=serviceCNS.csNoticeCount(map);
			int totalRowCount=csNoticeCount;
			System.out.println(pageNum);
			SetBoardPage pu=new SetBoardPage(pageNum, totalRowCount);
			map.put("startnum", pu.getStartRow());
			map.put("endnum", pu.getEndRow());	
			List<TbCsNoticeVo> CsNoticeList=serviceCNS.CsNoticeList(map);
			
			//search
			if(search!=null&&search!=""){
				map.put("search", search);
				csNoticeCount=serviceCNS.csNoticeCount(map);
				totalRowCount=csNoticeCount;
				if(pageNext10!=0){if((csNoticeCount/10)+1<pageNum){pageNum=pageNext10;}}
				if(pageNext!=0){if((csNoticeCount/10)+1<pageNum){pageNum=pageNext-1;}}
				pu=new SetBoardPage(pageNum, totalRowCount);
				map.put("startnum", pu.getStartRow());
				map.put("endnum", pu.getEndRow());
				CsNoticeList=serviceCNS.CsNoticeList(map);
			}else if(category!=null&&category!=""){
				map.put("category", category);
				if(cs_notice_num!=null&&cs_notice_num!=""){
					map.put("cs_notice_num", cs_notice_num);
					int get_rnum=serviceCNS.csn_get_rnum(map).getRnum();
					pageNum=get_rnum/10 + 1;
					if(get_rnum%10==0)pageNum=get_rnum/10;
				}
				csNoticeCount=serviceCNS.csNoticeCount(map);
				totalRowCount=csNoticeCount;
				if(pageNext10!=0){if((csNoticeCount/10)+1<pageNum){pageNum=pageNext10;}}
				if(pageNext!=0){if((csNoticeCount/10)+1<pageNum){pageNum=pageNext-1;}}
				pu=new SetBoardPage(pageNum, totalRowCount);
				map.put("startnum", pu.getStartRow());
				map.put("endnum", pu.getEndRow());
				CsNoticeList=serviceCNS.CsNoticeList(map);
			}
			model.addAttribute("CsNoticeList",CsNoticeList);//list
			model.addAttribute("pu",pu);//paging
			model.addAttribute("csNoticeCount",csNoticeCount);//content count
			model.addAttribute("category", category);//category
			model.addAttribute("search", search);//search
			return ".cs.cs_Notice";
	}
			/*notice_detail*/
	
			@RequestMapping(value="/cs/notice_detail",method=RequestMethod.GET)
			public String csNoticeDetail(
					int num, Model model){
				System.out.println("csNoticeDetail1");
				//detail_info
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("num", num);
				System.out.println("csNoticeDetail2");
				TbCsNoticeVo vo=serviceCNS.csNoticeDetail(map);
				//hit
				serviceCNS.NoticeHitUpdate(num);
				
				model.addAttribute("vo",vo);
				System.out.println("csNoticeDetail3");
				return ".cs.cs_Notice_Detail";
			
	}
}
