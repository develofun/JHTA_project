package net.stylesolo.www.controller;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.stylesolo.www.common.CommonConstants;
import net.stylesolo.www.service.ChartService;
import net.stylesolo.www.service.MainPageService;
import net.stylesolo.www.vo.ShopItemVo;
import net.stylesolo.www.vo.TbBannerVo;
import net.stylesolo.www.vo.TbGongguImgVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainPageController {
	@Autowired
	private MainPageService mainPageService;
	@Autowired
	private ChartService chartService;
	
	/*
	@Autowired private ShopCategoryService shopService;
	@Autowired private ItemSetMainService itemSetService;
	@Autowired private TbGongguInsertService gongguService;
	*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToMainPage(Model model) {		
//		������ ���� �����غ��� ���?
		
//		ī�װ� ����Ʈ
//		���� ��� 2��
//		��õ ��� 8~12��
//		��ǰ �ֽ� ����Ʈ 6~9��
/////////////////////////////////////		
		
//		��� �ҷ�����
//		�̺�Ʈ ���
		List<TbBannerVo> bannerData =
				mainPageService.callBannerData(CommonConstants.MAINMENUCODE);
		
//		���� �Ѹ�
		List<TbGongguImgVo> majorGongguData = 
				mainPageService.callMajorGongguData();
		
//		���� �ֵ� (���� ���� ǰ��)
//		���� �ֽ� ��� ��ǰ
		List<ShopItemVo> shopLatestProducts =
				mainPageService.callShopLatestProducts();
		
		model.addAttribute("mainBanner", bannerData);
		model.addAttribute("majorGongguData", majorGongguData);
		model.addAttribute("shopLatestProducts", shopLatestProducts);
		
//		return "change/index";
		return ".main";
		
		
		/*
		int categoryStart=0;
		int categoryEnd=999999;
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("categoryStart", categoryStart);
		map.put("categoryEnd", categoryEnd);
		map.put("method", "best");
		map.put("startRow", 1);
		map.put("endRow", 5);
		List<ShopCategoryVo> bList=shopService.categoryView(map);
		map.put("endRow", 3);
		Random ran=new Random();
		String[] mtd={"new","lowPrice","highPrice"};
		map.put("method", mtd[ran.nextInt(3)]);
		List<ItemsetMainViewVo> setList=itemSetService.getList(map);
		map.put("endRow", 4);
		map.put("method", "new");
		List<ShopCategoryVo> nList=shopService.categoryView(map);
		map.put("endRow", 3);
		map.put("method", "discountRate");
		List<ShopCategoryVo> dList=shopService.categoryView(map);
		model.addAttribute("bList", bList);
		model.addAttribute("setList", setList);
		model.addAttribute("nList", nList);
		model.addAttribute("dList", dList);
		//��������Ʈ��ǰ ������//
		List<TbGongguBestListVo> bestlist=gongguService.get_gonggu_best();
		
		int[] bestArr=new int[3];
		for(int i=0;i<bestlist.size();i++){
			bestArr[i]=bestlist.get(i).getGonggu_insert_num();
			model.addAttribute("best"+(i+1),gongguService.get_gonggu_best_info(bestArr[i]));
		}
		////////////////////
		*/
		
	}
	
//	�湮�� �߰�(�̴��)
	@RequestMapping("/ip_save_session")
	@ResponseBody
	public String saveTheIpSession(HttpServletRequest request){
		HttpSession session=request.getSession();
		try{
			InetAddress addr=InetAddress.getLocalHost();
			session.setAttribute("ip", addr.getHostAddress());
			int n=chartService.update_visitor();
			System.out.println(n);
			return addr.getHostAddress();
		}catch(UnknownHostException uhe){
			System.out.println(uhe.getMessage());
			return "0";
		}
	}
	
}
