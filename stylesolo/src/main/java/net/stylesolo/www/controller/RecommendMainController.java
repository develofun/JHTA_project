package net.stylesolo.www.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.stylesolo.www.common.SetBoardPage;
import net.stylesolo.www.service.ItemSetMainService;
import net.stylesolo.www.service.ItemsetCartJoinService;
import net.stylesolo.www.service.ItemsetShopJoinService;
import net.stylesolo.www.service.ShopItemService;
import net.stylesolo.www.service.TbItemsetCartService;
import net.stylesolo.www.service.TbItemsetCodeService;
import net.stylesolo.www.service.TbItemsetImgService;
import net.stylesolo.www.service.TbItemsetInfoService;
import net.stylesolo.www.service.TbItemsetJjimService;
import net.stylesolo.www.service.TbItemsetMdrecService;
import net.stylesolo.www.vo.ItemsetCartJoinVo;
import net.stylesolo.www.vo.ItemsetMainViewVo;
import net.stylesolo.www.vo.ItemsetOrderVo;
import net.stylesolo.www.vo.ItemsetShopJoinVo;
import net.stylesolo.www.vo.TbItemsetCartVo;
import net.stylesolo.www.vo.TbItemsetCodeVo;
import net.stylesolo.www.vo.TbItemsetImgVo;
import net.stylesolo.www.vo.TbItemsetInfoVo;
import net.stylesolo.www.vo.TbItemsetJjimVo;
import net.stylesolo.www.vo.TbItemsetPaymentProductVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;
import net.stylesolo.www.vo.TbShopDeliveryVo;
import net.stylesolo.www.vo.TbShopPaymentProductVo;
import net.stylesolo.www.vo.TbShopPaymentVo;

@Controller//��õ������ ùȭ��
public class RecommendMainController {//ī�װ��� �ֱ� ������Ʈ������ 1~5����ǰ���� ����ش�.
	@Autowired private ItemSetMainService service;
	@Autowired private TbItemsetCodeService serviceC;
	@Autowired private TbItemsetCartService cartService;
	@Autowired private TbItemsetImgService imgService;
	@Autowired private TbItemsetJjimService jjimService;
	@Autowired private TbItemsetMdrecService serviceM;
	@Autowired private ItemsetShopJoinService serviceJ;
	@Autowired private ShopItemService itemService;
	@Autowired private ItemsetCartJoinService icService;
	
	public void setIcService(ItemsetCartJoinService icService) {
		this.icService = icService;
	}
	public void setServiceC(TbItemsetCodeService serviceC) {
		this.serviceC = serviceC;
	}
	public void setService(ItemSetMainService service) {
		this.service = service;
	}
	@RequestMapping("/recommend")
	public String recMain(String category,
			String search,@RequestParam(value="method",defaultValue="new")String method,Model mv){
		HashMap<String, Object> map=new HashMap<String, Object>();
		int startRow=1;
		int endRow=4;
		map.put("search", search);
		map.put("method", method);
		map.put("endRow", endRow);
		map.put("startRow", startRow);
		String [] clist={"codi","inte"};
		for(int i=0;i<clist.length;i++){
			map.put("category", clist[i]);
			String clisti="clist"+String.valueOf(i+1);
			System.out.println(clisti);
			mv.addAttribute(clisti, service.getList(map));
		}
		mv.addAttribute("mdRec", serviceM.getMdRec());
		return ".recommend.recommendMain";
	}
	@RequestMapping("itemsetDetail")
	public String itemsetDetail(Model mv,int codeNum,
			@RequestParam(value="msg",required=false)String msg){
		TbItemsetCodeVo cvo=serviceC.itemsetDetail(codeNum);
		List<ItemsetShopJoinVo> list=serviceJ.joinItemset(codeNum);
		List<TbItemsetImgVo> imgList=imgService.subImgList(codeNum);
		mv.addAttribute("imgList", imgList);
		mv.addAttribute("list", list);
		mv.addAttribute("cvo", cvo);
		if(msg!=null)mv.addAttribute("msg", msg);
		return ".recommend.detailPage";
	}
	@RequestMapping("recommendPage")
	public String catePage(String search,@RequestParam(value="method",defaultValue="new")String method,String category,Model mv,@RequestParam(value="pageNum",defaultValue="1")int pageNum){
		if(search!=null&&search.equals(""))search=null;
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("category", category);
		map.put("search", search);
		map.put("method", method);
		int totalRowCount=service.itemSetCount(map);
		SetBoardPage pu=new SetBoardPage(pageNum, totalRowCount);//�� �������� 16�� �� ���̱�, 15���� ����¡ó��
		map.put("rowBlockCount", pu.getRowBlockCount());//�������� ������ �� ����
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<ItemsetMainViewVo> list=service.getList(map);
		map.put("startRow",  1);
		map.put("endRow",  3);
		map.put("method", "new");
		List<ItemsetMainViewVo> nList=service.getList(map);
		mv.addAttribute("map", map);
		mv.addAttribute("pu", pu);
		mv.addAttribute("setList", list);
		mv.addAttribute("nList",nList);
		return ".recommend.recommendCate";
	}
	@RequestMapping("/setItemBasket")
	public String insertCart(int codeNum,int price,int qty,HttpServletRequest req){
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null)return ".member.member_login";
		TbItemsetCartVo vo=new TbItemsetCartVo(0, id, qty, price, codeNum);
		int result=cartService.insert(vo);
		String msg=null;
		if(result>0){
			msg="basketSuccess";
		}else{
			msg="basketFail";
		}
		return "redirect:/itemsetDetail?codeNum="+codeNum+"&msg="+msg;
	}
	@RequestMapping("/setItemInterest")
	public String interestCart(int codeNum,HttpServletRequest req){
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null)return ".member.member_login";
		TbItemsetJjimVo vo=new TbItemsetJjimVo(0, id, codeNum);
		String msg=null;
		if(jjimService.itemset_check(vo)>0){
			msg="already";
			return "redirect:/itemsetDetail?codeNum="+codeNum+"&msg="+msg;
		}
		int result=jjimService.insert(vo);
		
		if(result>0){
			msg="jjimSuccess";
		}else{
			msg="jjimFail";
		}
		return "redirect:/itemsetDetail?codeNum="+codeNum+"&msg="+msg;
	}
	@RequestMapping("/orderPageMove")
	public String orderPageMove(@RequestParam(value="codeNum",required=true)int[] codeNum, 
			@RequestParam(value="setQty",required=true) int[] setQty,HttpSession sesion,Model mv){
		String id=(String)sesion.getAttribute("id");
		if(id==null)return ".member.member_login";
		TbMemberPrivacyVo minfo=itemService.getMember_info(id);
		int couponQty=itemService.mycouponQty(id);
		ArrayList<ItemsetOrderVo> list=new ArrayList<ItemsetOrderVo>();
		for(int i=0;i<codeNum.length;i++){
			ItemsetOrderVo vo=icService.listUp(codeNum[i]);
			TbItemsetCodeVo cvo=serviceC.itemsetDetail(codeNum[i]);
			vo.setItemset_cart_price(cvo.getItemset_code_price());
			vo.setItemset_cart_order_qty(setQty[i]);
			list.add(vo);
		}
		mv.addAttribute("list",list);
		mv.addAttribute("minfo", minfo);
		mv.addAttribute("couponQty",couponQty);
		
		return ".shop.set_order_step";
	}
	//���� �����ϱ�
		@RequestMapping("/setPayment.do")
		public ModelAndView payment(HttpServletRequest req){
			ModelAndView mv=new ModelAndView();
			String[] item_code=req.getParameterValues("item_code");
			String[] point=req.getParameterValues("point");
			String[] saleprice=req.getParameterValues("saleprice");
			String[] order_qty=req.getParameterValues("order_qty");
			String[] total=req.getParameterValues("total");
			String[] option_num=req.getParameterValues("option_num");
		//	int total_=Integer.parseInt(req.getParameter("total_"));
			String usep=req.getParameter("usepoint"); //����� ����Ʈ
			int usepoint=0;
			if(usep!=null && usep!=""){
				usepoint=Integer.parseInt(usep);
			}
			int coupon=Integer.parseInt(req.getParameter("coupon")); //����
		//	int sum=Integer.parseInt(req.getParameter("sum"))+3000;
			String name=req.getParameter("name");
			String tel=req.getParameter("tel");
			String addr=req.getParameter("addr");
			String msg=req.getParameter("msg");
			int pay_method=Integer.parseInt(req.getParameter("pay_method"));
			HttpSession session=req.getSession();
			String id=(String)session.getAttribute("id");
			int orderNum=itemService.orderNum();
			int sum=0;
			for(int i=0;i<total.length;i++){
				sum+=Integer.parseInt(total[i]);
			}
			System.out.println("sum:"+sum);
			int coupon_amount=0;
			if(coupon!=0){
				coupon_amount=itemService.getCpAmount(coupon); //�����ݾװ�������
			}
			TbShopPaymentVo vo1=new TbShopPaymentVo(
					orderNum+1, //�ֹ���ȣ
					pay_method, //��������
					coupon_amount, //�������ݾ�
					usepoint, //����� ����Ʈ
					sum, //�� ��ǰ�ݾ�
					(sum-coupon_amount-usepoint+3000), //�� �����ݾ�
					null, // �ֹ���¥
					id //ȸ�����̵�
					);
			itemService.addPayment(vo1);
			
			HashMap<String, Object> map=new HashMap<String, Object>();
			for(int i=0;i<item_code.length;i++){
				System.out.println(orderNum+1);
				System.out.println(Integer.valueOf(order_qty[i]));
				System.out.println(Integer.valueOf(total[i]));
				System.out.println(Integer.valueOf(item_code[i]));
				TbItemsetPaymentProductVo vo2=new TbItemsetPaymentProductVo(
						0,
						orderNum+1,
						Integer.valueOf(order_qty[i]),
						Integer.valueOf(total[i]),
						Integer.valueOf(item_code[i])
						);
				service.paymentInsert(vo2);
				map.put("qty", vo2.getItemset_payment_product_qty());
				map.put("itemCode", vo2.getItemset_code_num());
				service.itemsetUpdate(map);
			}
			int p=0;
			for(int i=0;i<point.length;i++){
				p=p+(Integer.parseInt(point[i]));
			}
			map.put("id", id);
			map.put("usepoint", p);
			map.put("reason", "��������");
			itemService.updatePoint(map);
			if(usepoint>0){
				map.put("id", id);
				map.put("usepoint", -usepoint);
				map.put("reason", "���ΰ���");
				itemService.updatePoint(map);
			}
			if(coupon!=0){
				itemService.useCoupon(coupon);
			}
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Date currentTime=new Date();
			String today=sdf.format(currentTime)+"0000";
			System.out.println(today);
			
			TbShopDeliveryVo vo3=new TbShopDeliveryVo(
					today,
					"�ֹ��Ϸ�",
					"�����",
					name,
					0,
					addr,
					tel,
					msg,
					3000,
					orderNum+1
				);
			itemService.insertDelivery(vo3);
			mv.setViewName("redirect:/orderList");
			return mv;
		}
}
