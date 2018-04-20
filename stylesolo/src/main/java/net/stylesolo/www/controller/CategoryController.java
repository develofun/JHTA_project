package net.stylesolo.www.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.stylesolo.www.common.SetBoardPage;
import net.stylesolo.www.service.ShopCategoryImgService;
import net.stylesolo.www.service.ShopCategoryService;
import net.stylesolo.www.service.ShopDivisionService;

import net.stylesolo.www.vo.ShopCategoryImgVo;
import net.stylesolo.www.vo.ShopCategoryVo;
import net.stylesolo.www.vo.ShopDivisionVo;
import net.stylesolo.www.vo.ShopItemVo;


@Controller
public class CategoryController {
	@Autowired private ShopCategoryService service;
	@Autowired private ShopDivisionService divisionService;
	@Autowired private ShopCategoryImgService cateImgService;
	public void setService(ShopCategoryService service) {
		this.service = service;
	}
	public void setDivisionService(ShopDivisionService divisionService) {
		this.divisionService = divisionService;
	}
	public void setCateImgService(ShopCategoryImgService cateImgService) {
		this.cateImgService = cateImgService;
	}
	@RequestMapping("/category")
	public String categoryView(Model mv,int code,@RequestParam(value="method",defaultValue="new")String method,
			@RequestParam(value="search",required=false)String search,@RequestParam(value="pageNum",defaultValue="1")int pageNum){
		HashMap<String, Object> map=new HashMap<String, Object>();
		System.out.println(method);
		int categoryCode=code;
		int categoryStart=0;
		int categoryEnd=0;
		String moveTarget=null;
		if(search!=null&&search=="")search=null;
		mv.addAttribute("search", search);
		mv.addAttribute("method", method);
		if(categoryCode<10){
			moveTarget=".shopping.shop_category_main";
			List<ShopDivisionVo> cList=divisionService.getDivision(categoryCode);
			ShopCategoryImgVo categoryImg=cateImgService.cateImg(categoryCode);
			mv.addAttribute("cList", cList);
			mv.addAttribute("categoryImg", categoryImg);
			categoryStart=categoryCode*100000;
			categoryEnd=categoryStart+99999;
		}else if(categoryCode<100){
			categoryStart=categoryCode*10000;
			categoryEnd=categoryStart+9999;
			int c=code/10;
			List<ShopDivisionVo> cList=divisionService.getDivision(c);
			ShopCategoryImgVo categoryImg=cateImgService.cateImg(c);
			mv.addAttribute("cList", cList);
			mv.addAttribute("categoryImg", categoryImg);
			moveTarget=".shopping.shop_category_division";
		}else{
			moveTarget=".shopping.shop_category_division";
			categoryStart=categoryCode*1000;
			categoryEnd=categoryStart+999;
			int c=code/100;
			List<ShopDivisionVo> cList=divisionService.getDivision(c);
			ShopCategoryImgVo categoryImg=cateImgService.cateImg(c);
			mv.addAttribute("categoryImg", categoryImg);
			mv.addAttribute("cList", cList);
		}
		map.put("search", search);
		map.put("categoryStart", categoryStart);
		map.put("categoryEnd", categoryEnd);
		map.put("method", method);
		SetBoardPage pu=new SetBoardPage(pageNum, service.itemCount(map));
		int startRow=pu.getStartRow();
		int endRow=pu.getEndRow();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		System.out.println("map:"+map);
		List<ShopCategoryVo> iList= service.categoryView(map);
		List<ShopCategoryVo> bList=null;
		List<ShopCategoryVo> nList=null;
		if(categoryCode>0){
			map.put("startRow", 1);
			map.put("endRow", 4);
			map.put("method", "best");
			bList=service.categoryView(map);
			map.put("method", "new");
			nList=service.categoryView(map);
		}
		mv.addAttribute("nList", nList);
		mv.addAttribute("bList", bList);
		mv.addAttribute("iList", iList);
		mv.addAttribute("categoryCode", categoryCode);
		mv.addAttribute("pu",pu);
		return moveTarget;
	}
	@RequestMapping(value="/categoryList",method=RequestMethod.GET)//�˻����� ���� ������ ó���ϴ� �޼ҵ�
	public String listView(Model mv,int code,@RequestParam(value="method",defaultValue="new")String method,
			@RequestParam(value="pageNum",defaultValue="1")int pageNum){
	/*	HashMap<String, Object> map=new HashMap<String, Object>();
		List<String> banner=null;//��� ����Ʈ �ҷ�����(db���� code�� ��ȸ��)
		//����Ʈ,�Ż�ǰ ������ 4���� �������� ���� ������,���� ����
		map.put("startRow", 1);
		map.put("endRow", 4);
		map.put("method", "new");//�Ż�ǰ ������ ��ȸ
		int min=0;
		int max=0;
		if((code/10)<1){
			min=code*100000;
			max=(code*100000)+99999;
		}else if((code/10>0) && (code/10)<10){
			min=code*10000;
			max=(code*10000)+9999;
		}else if((code/10)>9 && (code/10)<10){
			min=code*1000;
			max=(code*1000)+999;
		}
		map.put("min",min);
		map.put("max",max);
		System.out.println("min:" +min);
		System.out.println("max:" +max);
		List<ShopItemVo> nList=service.new_list(map);//�Ż�ǰ ������ 4�� nList�� ���
		map.put("method", "best");
		List<ShopItemVo> bList=service.best_list();//����Ʈ ��ǰ 4�� bList�� ���
		PageUtil pu=new PageUtil(pageNum, 0, 20, 10);//0�� totalPageCount������.
		map.put("startRow", pu.getStartRow());//��ü ����Ʈ ����� �������ȣ
		map.put("endRow", pu.getEndRow());//��ü ����Ʈ ����� �����ȣ
		map.put("method", method);//���Ĺ��
		List<ShopItemVo> iList=service.deco_all_list(map);//��ü ������ ����Ʈ iList�� ���
		mv.addAttribute("nList", nList);
		mv.addAttribute("bList", bList);
		mv.addAttribute("iList", iList);
		mv.addAttribute("banner", banner);
		mv.addAttribute("map", map);
		mv.addAttribute("pu", pu);
		return ".shopping.shop_category_main";*/
		return null;
	}
	/*@RequestMapping(value="/category",method=RequestMethod.POST)//���ʰ˻� & ����� �˻��� ���� �ʾ��� �� ���� �޼ҵ�
	public String deco(Model mv,int code,@RequestParam(value="method",defaultValue="new")String method,
			String search,@RequestParam(value="pageNum",defaultValue="1")int pageNum){
		if(search!=null&&search=="")search=null;
		HashMap<String, Object> map=new HashMap<String, Object>();
		PageUtil pu=new PageUtil(pageNum, 0, 20, 15);//0�� totalPageCount������.
		map.put("StartRow", pu.getStartRow());//��ü ����Ʈ ����� �������ȣ
		map.put("endRow", pu.getEndRow());//��ü ����Ʈ ����� �����ȣ
		map.put("method", method);//���Ĺ��
		ArrayList<String> searchList=new ArrayList<String>();//�˻��� ��� ���� ArrayList
		if(search!=null)searchList.add(search);//�˻�� null�� �ƴҰ�� ArrayList�� ����
		int searchListSize=searchList.size();
		map.put("search", search);//�˻���
		List<ShopItemVo> iList=null;//��ü ������ ����Ʈ iList�� ���
		mv.addAttribute("iList", iList);
		mv.addAttribute("map", map);
		mv.addAttribute("pu", pu);
		return ".shopping.shop_category_search";
	}
	*/
	@RequestMapping("/innerSearch")
	public String inSearch(Model mv,int code,@RequestParam(value="method",defaultValue="new")String method,
			String search,@RequestParam(value="pageNum",defaultValue="1")int pageNum,
			ArrayList<String> searchList){//��� �� �˻� ���� ����Ǵ� �޼ҵ�
		HashMap<String, Object> map=new HashMap<String, Object>();
		SetBoardPage pu=new SetBoardPage(pageNum, 0);//0�� totalPageCount������.
		map.put("StartRow", pu.getStartRow());//��ü ����Ʈ ����� �������ȣ
		map.put("endRow", pu.getEndRow());//��ü ����Ʈ ����� �����ȣ
		map.put("method", method);//���Ĺ��
		if(search!=null)searchList.add(search);//�˻�� null�� �ƴҰ�� ArrayList�� ����
		map.put("searchList", searchList);//�˻��� ���
		List<ShopItemVo> iList=null;//��ü ������ ����Ʈ iList�� ���
		mv.addAttribute("iList", iList);
		mv.addAttribute("map", map);
		mv.addAttribute("pu", pu);
		return ".shopping.shop_category_search";
	}
	@RequestMapping("/mainSearch")
	public String mainSearch(Model mv,String search,
			@RequestParam(value="method",defaultValue="new")String method,
			@RequestParam(value="pageNum",defaultValue="1")int pageNum){
		List<ShopDivisionVo> cList=divisionService.allDivision();
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("search", search);
		map.put("method", method);
		map.put("categoryStart", null);
		SetBoardPage pu=new SetBoardPage(pageNum, service.itemCount(map));
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<ShopCategoryVo> iList= service.categoryView(map);
		mv.addAttribute("cList",cList);
		mv.addAttribute("pu", pu);
		mv.addAttribute("map", map);
		mv.addAttribute("iList", iList);
		return ".shopping.mainSearch";
	}
}