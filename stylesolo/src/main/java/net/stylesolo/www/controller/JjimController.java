package net.stylesolo.www.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.stylesolo.www.common.SetBoardPage;
import net.stylesolo.www.service.TbShopJjimService;
import net.stylesolo.www.vo.TbItemsetCodeVo;
import net.stylesolo.www.vo.TbItemsetJjimVo;
import net.stylesolo.www.vo.TbShopJjimVo;

@Controller
public class JjimController {
	@Autowired private TbShopJjimService service;
	
	@RequestMapping("/jjim")
	public String jjim(){
		return ".shopping.shop_jjim_main";
	}
	
	@RequestMapping("/jjim_list")
	@ResponseBody
	public String jjim_list(HttpServletRequest req,@RequestParam(value="pageNum",defaultValue="1")int pageNum){
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		int totalCount=service.getCount(id);
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		SetBoardPage pu=new SetBoardPage(pageNum,totalCount);
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		map.put("id",id);
		List<TbShopJjimVo> list=service.jjim_list(map);
		
		JSONArray arr=new JSONArray();
		JSONObject re=new JSONObject();
		for(TbShopJjimVo vo:list){
			JSONObject jj=new JSONObject();
			jj.put("shop_jjim_num", vo.getShop_jjim_num());
			jj.put("member_privacy_id", vo.getMember_privacy_id());
			jj.put("shop_item_code", vo.getShop_item_code());
			jj.put("shop_item_name", vo.getShop_item_name());
			jj.put("shop_item_saleprice", vo.getShop_item_saleprice());
			jj.put("shop_item_mainimg_imgname", vo.getShop_item_mainimg_imgname());
			arr.add(jj);
		}
		re.put("list",arr);
		re.put("startPageNum", pu.getStartPageNum());
		re.put("endPageNum", pu.getEndPageNum());
		return re.toString();
	}
	
	@RequestMapping("/itemset_list")
	@ResponseBody
	public String itemset_list(HttpServletRequest req,int pageNum){
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		TbItemsetJjimVo vo1=new TbItemsetJjimVo();
		vo1.setMember_privacy_id(id);
		int totalCount=service.itemset_check(vo1);
		SetBoardPage pu=new SetBoardPage(pageNum,totalCount);
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("id", id);
		List<TbItemsetCodeVo> itemset_list=service.itemset_list(map);
		JSONArray arr=new JSONArray();
		JSONObject re=new JSONObject();
		for(TbItemsetCodeVo vo:itemset_list){
			JSONObject jj=new JSONObject();
			jj.put("item_code_num", vo.getItem_code_num());
			jj.put("itemset_code_category", vo.getItemset_code_category());
			jj.put("item_code_setname", vo.getItem_code_setname());
			jj.put("itemset_code_price", vo.getItemset_code_price());
			jj.put("itemset_code_mainimg", vo.getItemset_code_mainimg());
			arr.add(jj);
		}
		re.put("list", arr);
		re.put("startPageNum", pu.getStartPageNum());
		re.put("endPageNum", pu.getEndPageNum());
		return re.toString();
	}
	
	@RequestMapping("/jjim_del")
	@ResponseBody
	public String jjim_del(HttpServletRequest req){
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		HashMap<String, Object> map=new HashMap<String, Object>();
		String[] shop_item_code=(req.getParameter("shop_item_code")).split(",");
		
		map.put("id", id);
		int n=0;
		for(int i=0;i<shop_item_code.length;i++){
			int code=Integer.parseInt(shop_item_code[i]);
			map.put("shop_item_code", code);
			n=service.jjim_del(map);
		}
		if(n>0){
			return "success";
		}else{
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping("/itemset_jjim_del")
	public String itemset_del(HttpServletRequest req){
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		HashMap<String, Object> map=new HashMap<String, Object>();
		String[] item_code_num=(req.getParameter("item_code_num")).split(",");
		map.put("id", id);
		int n=0;
		for(int i=0;i<item_code_num.length;i++){
			int code_num=Integer.parseInt(item_code_num[i]);
			map.put("item_code_num", code_num);
			n=service.itemset_jjim_del(map);
		}
		if(n>0){
			return "success";
		}else{
			return "fail";
		}
	}
}
