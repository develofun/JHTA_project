package net.stylesolo.www.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.services.appstream.model.Session;

import net.stylesolo.www.common.SetBoardPage;
import net.stylesolo.www.dao.TbMemberPrivacyDao;
import net.stylesolo.www.service.ChartService;
import net.stylesolo.www.service.ShopBoardService;
import net.stylesolo.www.service.ShopItemService;
import net.stylesolo.www.vo.ShopCancelListVo;
import net.stylesolo.www.vo.ShopCancelVo;
import net.stylesolo.www.vo.ShopCartListVo;
import net.stylesolo.www.vo.ShopCartVo;
import net.stylesolo.www.vo.ShopItemOptionVo;
import net.stylesolo.www.vo.ShopItemVo;
import net.stylesolo.www.vo.ShopOrderDescVo;
import net.stylesolo.www.vo.ShopQnaBoardVo;
import net.stylesolo.www.vo.ShopReviewBoardVo;
import net.stylesolo.www.vo.ShopReviewFileVo;
import net.stylesolo.www.vo.ShopSubImgVo;
import net.stylesolo.www.vo.TbCouponMyCouponVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;
import net.stylesolo.www.vo.TbMyCouponInfoVo;
import net.stylesolo.www.vo.TbShopDeliveryVo;
import net.stylesolo.www.vo.TbShopOrderListVo;
import net.stylesolo.www.vo.TbShopPaymentProductVo;
import net.stylesolo.www.vo.TbShopPaymentVo;
@Controller
public class ShopItemController {
	@Autowired private ShopItemService service;
	@Autowired private ShopBoardService boardService;
	@Resource private ChartService chartService;

	//��ǰ��������
	@RequestMapping("/shoplayout")
	public ModelAndView getInfo(int item_code,HttpServletResponse response){
		System.out.println("shoplayout��Ʈ�ѷ�");
		String code=String.valueOf(item_code);
		Cookie cookie=new Cookie(code,code);
		cookie.setMaxAge(24*60*60);
		cookie.setPath("/");
		response.addCookie(cookie);
	
		System.out.println("��Ű:"+cookie.getValue());
		
		ShopItemVo vo=service.getInfo(item_code);
		List<ShopSubImgVo> imglist=service.getSubImg(item_code);
		List<ShopItemOptionVo> option=service.getOption(item_code);
		int re_totalRowCount=boardService.rgetRowCount(item_code);
		SetBoardPage pu=new SetBoardPage(1, re_totalRowCount);
		
		ModelAndView mv=new ModelAndView(".item_desc");
		mv.addObject("vo", vo);
		mv.addObject("pu",pu);
		mv.addObject("list", imglist);
		mv.addObject("option", option);
		return mv;
	}
	
	//����Խ��� �Խñ� ��� ��������
	@RequestMapping("/review_load")
	@ResponseBody
	public String review_load(@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum,int item_code){
		int re_totalRowCount=boardService.rgetRowCount(item_code);
		System.out.println("review_load ��Ʈ�ѷ�:"+re_totalRowCount);
		
		//����¡ó�� ���� ���ϱ�
		SetBoardPage pu=new SetBoardPage(pageNum, re_totalRowCount);
		//����Խ��� 1~10���� ��������(ùȭ��)
		HashMap<String, Object> map=new HashMap<String, Object>();
		System.out.println("getStartRow:"+ pu.getStartRow());
		System.out.println("getEndRow:"+ pu.getEndRow());
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("item_code", item_code);
		List<ShopReviewBoardVo> viewList=boardService.viewList(map);
		
		//System.out.println(viewList);
		// \ 'shop_review_star:'�ڡڡڡڡ�', shop_review_code:0, member_privacy_id='test'}
		JSONArray arr=new JSONArray();
		for(ShopReviewBoardVo vo:viewList){		
			JSONObject jj=new JSONObject();
			jj.put("shop_review_num", vo.getShop_review_num());
			jj.put("shop_review_content", vo.getShop_review_content());
			jj.put("shop_review_w_date", vo.getShop_review_w_date().toString());
			jj.put("shop_review_star", vo.getShop_review_star());
			jj.put("shop_review_num", vo.getShop_review_num());
			jj.put("shop_item_code", vo.getShop_item_code());
			jj.put("member_privacy_id", vo.getMember_privacy_id());
			jj.put("shop_review_file_filename", vo.getShop_review_file_filename());
			jj.put("startPageNum", pu.getStartPageNum());
			jj.put("endPageNum", pu.getEndPageNum());
			arr.add(jj);
		}

		return arr.toString();
	}
	
	// ����Խ��� ������ ��������
	@RequestMapping("/re_desc")
	@ResponseBody
	public ShopReviewBoardVo re_desc(int num){
		System.out.println("re_desc��Ʈ�ѷ�");
		ShopReviewBoardVo vo=boardService.re_desc(num);
		return vo;
	}

	
	//�������� ���� �Խñ� ��� ��������
	@RequestMapping("/pagingList")
	@ResponseBody
	public String pagingList(@RequestParam(value="board",required=true)String board,@RequestParam(value="pageNum",required=true)int pageNum,
					@RequestParam(value="item_code",required=true)int item_code,@RequestParam(value="keyword",required=false,defaultValue="")String keyword){
		
		System.out.println("pagingList ��Ʈ�ѷ� ����-----------------");
		
		JSONObject json=new JSONObject();
		if(board.equals("review")){ //����Խ��ǿ��� ����¡ ��û�� �־��� ���
			HashMap<String, Object> map=new HashMap<String, Object>();
	//		map.put("table", "tb_shop_review");
			map.put("keyword", null);
			map.put("item_code", item_code);
			//��ü �� ��
			int re_totalRowCount=boardService.rgetRowCount(item_code);
			//����¡ó�� ���� ���ϱ�
			SetBoardPage pu=new SetBoardPage(pageNum, re_totalRowCount);
			
			map.put("startRow", pu.getStartRow());
			map.put("endRow", pu.getEndRow());
			System.out.println("StartPageNum"+pu.getStartPageNum());
			List<ShopReviewBoardVo> rlist=boardService.pagingList(map);
			json.put("board", "review");
			json.put("keyword", keyword);
			json.put("pu", pu);
			json.put("list", rlist);
		}else if(board.equals("qna")){
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("keyword", keyword);
			map.put("item_code", item_code);
			
			int q_totalRowCount=boardService.getRowCount(map);
			SetBoardPage pu=new SetBoardPage(pageNum, q_totalRowCount);
			map.put("startRow", pu.getStartRow());
			map.put("endRow", pu.getEndRow());
			List<ShopReviewBoardVo> qlist=boardService.pagingList(map);
			json.put("board", "qna");
			json.put("keyword", keyword);
			json.put("pu", pu);
			json.put("list", qlist);
		}
		return json.toString();
	}
	
	//Q&A �Խñ� ��� ��������
	@RequestMapping("/qna_load")
	@ResponseBody
	public String qna_load(@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum,int item_code,
			@RequestParam(value="keyword",required=false,defaultValue="")String keyword){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("item_code", item_code);
		map.put("keyword", keyword);
		int q_totalRowCount=boardService.qgetRowCount(map);
		System.out.println("q_totalRowCount:"+q_totalRowCount);
		System.out.println("qna��Ʈ�ѷ�����");
		//����¡ó�� ���� ���ϱ�
		SetBoardPage pu=new SetBoardPage(pageNum, q_totalRowCount);
		//����Խ��� 1~10���� ��������(ùȭ��)
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<ShopQnaBoardVo> qnaList=boardService.qnaList(map);
		
		JSONArray arr=new JSONArray();
		for(ShopQnaBoardVo vo:qnaList){
			JSONObject jj=new JSONObject();
			jj.put("shop_qna_num", vo.getSHOP_QNA_NUM());
			jj.put("shop_qna_title", vo.getSHOP_QNA_TITLE());
			jj.put("shop_qna_content", vo.getSHOP_QNA_CONTENT());
			jj.put("shop_qna_w_date", vo.getSHOP_QNA_W_DATE().toString());
			jj.put("shop_qna_hit", vo.getSHOP_QNA_HIT());
			jj.put("shop_item_code", item_code);
			jj.put("member_privacy_id", vo.getMEMBER_PRIVACY_ID());
			jj.put("shop_qna_comm_content", vo.getShop_qna_comm_content());
			jj.put("shop_qna_comm_w_date", vo.getShop_qna_comm_w_date());
			jj.put("startPageNum", pu.getStartPageNum());
			jj.put("endPageNum", pu.getEndPageNum());
			System.out.println("jj:"+jj);
			arr.add(jj);
		}

		return arr.toString();
	}
	
	@RequestMapping("/insert_qna.do")
	@ResponseBody
	public String insert_qna(int item_code,String title,String qna_content,HttpSession session){
		String id=(String)session.getAttribute("id");
		HashMap<String, Object> map=new HashMap<String, Object>();
		ShopQnaBoardVo vo=new ShopQnaBoardVo(0, title, qna_content, null, 0, item_code, id);
		int n=boardService.insert_qna(vo);
		String result="";
		if(n>0){
			result="success";
		}else{
			result="fail";
		}
		return result;
	}
	
	@RequestMapping("/qna_hit")
	@ResponseBody
	public String qna_hit(int num){
		int n=boardService.addHit(num);
		String result="";
		if(n>0){
			result="success";
		}else{
			result="fail";
		}
		return result;
	}
	
	//�ɼǿ� ���� ��� ���� �������� ++ �������� �ɼǹ�ȣ �迭�� ��Ƽ� �迭�� ������
	@RequestMapping("/getQty")
	@ResponseBody
	public String getQty(int option){
		int qty=service.getQty(option);
		System.out.println("��Ʈ�ѷ� getQty:"+qty);
	
		JSONObject json=new JSONObject();
		json.put("qty", qty);
		return json.toString();
	}
	
	// �� �߰��ϱ�
	@RequestMapping("/addJjim.do")
	@ResponseBody
	public String addJjim(int code,HttpSession session){
	//	System.out.println("�� code:"+code);
		JSONObject json=new JSONObject();
		String id=(String)session.getAttribute("id");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		map.put("code", code);
		
		int have=service.searchJjim(map);
		if(have>0){
			json.put("result", "fail");
		}else{
			int n=service.addJjim(map);
			if(n>0){
				json.put("result", "success");
			}else{
				json.put("result", "error");
			}
		}
	
		return json.toString();
	}
	
	//��ٱ��Ϸ� �̵�
	@RequestMapping("/goCart.do")
	public ModelAndView goCart(HttpSession session){
		
		String id=(String)session.getAttribute("id");
		System.out.println("���̵�:"+id);
		List<ShopItemVo> normal_list=service.goCart(id);
	
		ModelAndView mv=new ModelAndView(".shop.shop_cart_main");
		mv.addObject("list", normal_list);
		return mv;
	}
	
	
	//��ٱ��� ���̺� �߰��ϱ�
	   @RequestMapping("/addCart.do")
	   @ResponseBody
	   public String addCart(HttpServletRequest request){
	      HttpSession session=request.getSession();
	      String id=(String)session.getAttribute("id");
	      //http://localhost:9091/addCart?code=110004&code=110004&option=7&option=9&qty=1&qty=2&price=19900 
	      JSONObject json=new JSONObject();

	      String[] str_option=request.getParameterValues("option");
	      String[] str_code=request.getParameterValues("code");
	      String[] str_qty=request.getParameterValues("qty");
	      int price=Integer.parseInt(request.getParameter("price"));
	      ShopCartVo vo;
	      int n=0;
	      if(str_option!=null){ //�ɼ��� ������
	         for(int i=0;i<str_option.length;i++){
	            vo=new ShopCartVo(0,id,Integer.parseInt(str_code[i]),Integer.parseInt(str_option[i]),Integer.parseInt(str_qty[i]),price);
	            int d_c=service.cartSearch(vo);
	            if(d_c>0){ //���� ��ǰ�� ������,
	            	n+=service.cartUpdate(vo);
	            }else{//���� ��ǰ�� ������
	            	n+=service.addCart(vo);
	            }
	         }
	      }else{ //�ɼ��� ������
	         for(int i=0;i<str_code.length;i++){
	         vo=new ShopCartVo(0,id,Integer.parseInt(str_code[i]),Integer.parseInt(str_qty[i]),price);
	         int d_c=service.cartSearch(vo);
	            if(d_c>0){ //���� ��ǰ�� ������,
	            	n+=service.cartUpdate(vo);
	            }else{//���� ��ǰ�� ������
	            	n+=service.addCart(vo);
	            }
	         }
	      }
	      if(n>0){
	         json.put("result", "success");
	      }else{
	         json.put("result", "fail");
	      }
	   

	      return json.toString();
	   }
	   
	
	@RequestMapping("/goCartPage.do")
	public ModelAndView goCartPage(HttpServletRequest request){
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		List<ShopCartListVo> list=service.cartList(id);  //id ������ �����ϱ�
	//	List<ShopItemsetCartVo> setList=service.setCart("test"); //id ������ �����ϱ�
		ModelAndView mv=new ModelAndView(".shop.shop_cart_main");
		mv.addObject("list", list);
	//	mv.addObject("setList", setList);
	//	mv.addObject("id", id);
		
		return mv; 
	}
	
	@RequestMapping("/delCart.do")
	@ResponseBody
	public String delCart(int num){
		int n=service.delCart(num);
		JSONObject json=new JSONObject();
		if(n>0){
			json.put("result", "success");
		}else{
			json.put("result", "fail");
		}
		return json.toString();
	}
	
	//��ٱ��� ����Ʈ ������
	@RequestMapping("/cartList.do")
	@ResponseBody
	public String cartList(HttpSession session){
		System.out.println("cartList����");
		String id=(String)session.getAttribute("id");
		List<ShopCartListVo> list=service.cartList(id);
		JSONObject json=new JSONObject();
		json.put("list", list);
		System.out.println("list:"+list);
		return json.toString();
	}
	
	// �ٷα��� �������̵�
	   //http://localhost:9091/order?code=110004&option=7&qty=2&code=110004&option=8&qty=1
	   @RequestMapping("/order.do")
	   public ModelAndView orderPage(@RequestParam(value="code",required=true)int[] code,@RequestParam(value="option",required=false,defaultValue="0")int[] option, 
	         @RequestParam(value="qty",required=true) int[] qty,HttpSession sesion){
	      System.out.println("order����");
	      String id=(String)sesion.getAttribute("id");
	      
	      ArrayList<ShopCartListVo> list=new ArrayList<ShopCartListVo>();
	      ArrayList<ShopItemVo> list1=new ArrayList<ShopItemVo>();
	   
	      //����Ʈ ������
	      TbMemberPrivacyVo minfo=service.getMember_info(id);
	      int couponQty=service.mycouponQty(id);
	      
	      
	      //��ǰ ������ ��������
	      
	      ModelAndView mv=new ModelAndView(".shop.order_step1");
	      if(option[0]!=0){ //�ɼ��� ������
	         for(int i=0;i<option.length;i++){
	            HashMap<String, Integer> map=new HashMap<String, Integer>();
	            map.put("item_code",code[i]);
	            map.put("option", option[i]);
	            ShopCartListVo vo=service.directOrder(map);
	            vo.setShop_cart_order_qty(qty[i]);
	            vo.setItem_options_num(option[i]);
	            list.add(vo);
	         }
	         System.out.println(list);
	         mv.addObject("list", list);
	         mv.addObject("options", "have");
	      }else{ //�ɼ��� ������
	         for(int i=0;i<code.length;i++){
	        	 System.out.println("�ٷα���:"+code[i]);
	            ShopCartListVo info=service.dOrder(code[i]);
	            info.setShop_cart_order_qty(qty[i]);
	            list.add(info);
	         }
	         mv.addObject("list", list);
	         mv.addObject("options", null);
	      }
	      mv.addObject("minfo", minfo);
	      mv.addObject("couponQty", couponQty);
	   //   mv.addObject("clist", clist);
	      System.out.println("�ɼ�:"+mv.getModel());
	      return mv;
	   }   
	
	// ����insert
	@RequestMapping("/review_insert.do")
	@ResponseBody
	public String review_insert(MultipartHttpServletRequest request){
		System.out.println("��������Ʈ�ѷ�");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String content=request.getParameter("re_content");
		String star=request.getParameter("star");
		int item_code=Integer.parseInt(request.getParameter("item_code"));
		MultipartFile mfile=request.getFile("file1");	
		String filename=mfile.getOriginalFilename();
		System.out.println("filename:"+filename);
		if(filename!=null && filename!=""){
			try{
				ShopReviewBoardVo vo=new ShopReviewBoardVo(0, content, null, star, item_code, id);
				int n=boardService.insert_review(vo);
				int num=vo.getInsertNum();
				System.out.println("insertnum:"+num);
				String path=request.getSession().getServletContext().getRealPath("/resources/item_img/");
			//	String filename=mfile.getOriginalFilename();
				String savefilename=UUID.randomUUID()+"_"+filename;
				//���۵� ������ �о���� ���� ��Ʈ����ü
				InputStream is=mfile.getInputStream();
				//������ ������ ������ ����(���)�ϱ� ���� ���Ͻ�Ʈ����ü ����
				FileOutputStream fos=new FileOutputStream(path+"/"+savefilename);
				//���Ϻ����ϱ�
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				System.out.println(path+savefilename+"[���Ͼ��ε强��!!]");
				
				ShopReviewFileVo fvo=new ShopReviewFileVo(0,savefilename,num);
				int m=boardService.reviewFileUp(fvo);
				
				
				if(n>0){
					return "success";
				}else{
					return "fail";
				}
			}catch(IOException ie){
				System.out.println(ie.getMessage());
				return "fail";
			}
		}else{
			ShopReviewBoardVo vo=new ShopReviewBoardVo(0, content, null, star, item_code, id);
			int n=boardService.insert_review(vo);
			
			if(n>0){
				return "success";
			}else{
				return "fail";
			}
		}
	}
	
	//�α��� ȸ�� ���� ��������
	@RequestMapping("/getMember_info")
	@ResponseBody
	public String getMember_info(HttpSession session){
		System.out.println("����Ʈ�ѷ��ž��u�e��������������������������");
		String id=(String)session.getAttribute("id"); //���̵� ��������
		TbMemberPrivacyVo vo=service.getMember_info(id);
		JSONObject json=new JSONObject();
		json.put("member_privacy_name", vo.getMember_privacy_name());
		json.put("member_privacy_addr", vo.getMember_privacy_addr());
		json.put("member_privacy_phone", vo.getMember_privacy_phone());
		return json.toString();
	}
	
	//��������Ʈ ��������
	@RequestMapping("myCoupon")
	@ResponseBody
	public String myCoupon(String id){
		System.out.println("��������Ʈ ��Ʈ�ѷ� ����");
		List<TbCouponMyCouponVo> list=service.getMyCoupon(id);
		
		java.sql.Date today=new java.sql.Date(System.currentTimeMillis());
		SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
		String ff=fm.format(today);
		java.sql.Date tt=java.sql.Date.valueOf(ff);
		System.out.println("Tt:"+tt);
		
		System.out.println("���ó�¥"+today);
		JSONArray arr=new JSONArray();
		for(TbCouponMyCouponVo vo:list){
		
			JSONObject json=new JSONObject();
			json.put("coupon_mycoupon_num", vo.getCoupon_mycoupon_num());
			json.put("coupon_mycoupon_qty", vo.getCoupon_mycoupon_qty());
			json.put("coupon_num", vo.getCoupon_num());
			json.put("member_privacy_id", vo.getMember_privacy_id());
			json.put("coupon_startDate", vo.getCoupon_startDate().toString());
			json.put("coupon_endDate", vo.getCoupon_endDate().toString());
			json.put("coupon_subject", vo.getCoupon_subject());
			json.put("coupon_discount", vo.getCoupon_discount());
			json.put("coupon_value", vo.getCoupon_value());
			json.put("coupon_validity", vo.getCoupon_validity());
			json.put("now", ff);
			arr.add(json);		
			System.out.println(json.toString());
		}
		return arr.toString();
	}
	//��밡�� ������� �޾ƿ���
	@RequestMapping("/usable_cp")
	@ResponseBody
	public String usable_cp(HttpSession session){
		String id=(String)session.getAttribute("id");
		List<TbCouponMyCouponVo> list=service.getUsablecp(id);
		JSONArray arr=new JSONArray();
		for(TbCouponMyCouponVo vo:list){
			JSONObject json=new JSONObject();
			json.put("coupon_mycoupon_num", vo.getCoupon_mycoupon_num());
			json.put("coupon_mycoupon_qty", vo.getCoupon_mycoupon_qty());
			json.put("coupon_num", vo.getCoupon_num());
			json.put("member_privacy_id", vo.getMember_privacy_id());
			json.put("coupon_startDate", vo.getCoupon_startDate().toString());
			json.put("coupon_endDate", vo.getCoupon_endDate().toString());
			json.put("coupon_subject", vo.getCoupon_subject());
			json.put("coupon_discount", vo.getCoupon_discount());
			json.put("coupon_value", vo.getCoupon_value());
			json.put("coupon_validity", vo.getCoupon_validity());
			arr.add(json);
		}	
		return arr.toString();
	}
	//������ ���� ���� ��������
	@RequestMapping("/getCouponInfo")
	@ResponseBody
	public String getCouponInfo(int value){
		System.out.println("��Ʈ�ѷ�������������������������������");
		TbCouponMyCouponVo vo=service.getCouponInfo(value);
		JSONObject json=new JSONObject();
		json.put("coupon_mycoupon_num", vo.getCoupon_mycoupon_num());
		json.put("coupon_mycoupon_qty", vo.getCoupon_mycoupon_qty());
		json.put("coupon_num", vo.getCoupon_num());
		json.put("member_privacy_id", vo.getMember_privacy_id());
		json.put("coupon_startDate", vo.getCoupon_startDate().toString());
		json.put("coupon_endDate", vo.getCoupon_endDate().toString());
		json.put("coupon_subject", vo.getCoupon_subject());
		json.put("coupon_discount", vo.getCoupon_discount());
		json.put("coupon_value", vo.getCoupon_value());
		json.put("coupon_validity", vo.getCoupon_validity());
		return json.toString();
	}
	
	//���� �����ϱ�
	@RequestMapping("/payment.do")
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
		int orderNum=service.orderNum();
		int sum=0;
		for(int i=0;i<total.length;i++){
			sum+=Integer.parseInt(total[i]);
		}
		System.out.println("sum:"+sum);
		int coupon_amount=0;
		if(coupon!=0){
			coupon_amount=service.getCpAmount(coupon); //�����ݾװ�������
		}
		
		System.out.println("update_payment:"+(sum-coupon_amount-usepoint+3000));
		
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
		service.addPayment(vo1);
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		for(int i=0;i<item_code.length;i++){
			TbShopPaymentProductVo vo2=new TbShopPaymentProductVo(
					0,
					Integer.valueOf(order_qty[i]),
					Integer.valueOf(total[i]),
					orderNum+1,
					Integer.valueOf(item_code[i]),
					Integer.valueOf(option_num[i])
					);
			service.addPayPd(vo2);
			if((option_num[i].equals('0'))){ //������ -�ϱ� (�ɼ��� ���� ��)
				map.put("item_code", Integer.valueOf(item_code[i]));
				map.put("order_qty", Integer.valueOf(order_qty[i]));
				service.item_sub(map);
			}else{ //�ɼ��� ������ -�ϱ�
				map.put("item_code", Integer.valueOf(item_code[i]));
				map.put("order_qty", Integer.valueOf(order_qty[i]));
				map.put("option_num", Integer.valueOf(option_num[i]));
				service.option_sub(map);
			}
			service.deleteCart(map);
		}
		int p=0;
		for(int i=0;i<point.length;i++){
			p=p+(Integer.parseInt(point[i]));
		}
		map.put("id", id);
		map.put("usepoint", p);
		map.put("reason", "��������");
		service.updatePoint(map);
		if(usepoint>0){
			map.put("id", id);
			map.put("usepoint", -usepoint);
			map.put("reason", "���ΰ���");
			service.updatePoint(map);
		}
		if(coupon!=0){
			service.useCoupon(coupon);
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
		
		chartService.update_payment(sum-coupon_amount-usepoint+3000);
		
		service.insertDelivery(vo3);
		mv.setViewName("redirect:/orderList");
		return mv;
	}
	
	//�ֹ���� ����Ʈ
	@RequestMapping("/orderList")
	public ModelAndView orderList(HttpServletRequest req,@RequestParam(value="pageNum",defaultValue="1")int pageNum){
		HttpSession session=req.getSession(); 
		String id=(String)session.getAttribute("id");
		String start_date=req.getParameter("start_date");
		String end_date=req.getParameter("end_date");
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		map.put("id", id);
		java.sql.Date s_date;
		java.sql.Date e_date;
		if(start_date!=null && start_date!=""){
			s_date=java.sql.Date.valueOf(start_date);
			e_date=java.sql.Date.valueOf(end_date);
			System.out.println("e_date:" + e_date);
			System.out.println("s:"+s_date.toString());
			System.out.println("d:"+e_date.toString());
			map.put("start_date", s_date.toString());
			map.put("end_date", e_date.toString());
		}else{
			s_date=null;
			e_date=null;
			map.put("start_date", null);
			map.put("end_date", null);
		}
	//	System.out.println("start_date:" + start_date);
	//	System.out.println("end_date:" + end_date);
		
		int totalCount=service.order_count(map);
		SetBoardPage pu=new SetBoardPage(pageNum,totalCount);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<TbShopOrderListVo> list=service.orderList(map);
		ModelAndView mv=new ModelAndView(".shop.order_list");
		mv.addObject("list",list);
		mv.addObject("pu",pu);
		mv.addObject("start_date", s_date);
		mv.addObject("end_date", e_date);
		
		return mv;
	}
	
	//�ֹ��󼼺��� �Ķ����=�ֹ���ȣ
	@RequestMapping("/order_desc")
	public ModelAndView order_desc(int order_num){
      ModelAndView mv=new ModelAndView(".shop.order_desc");
      List<ShopOrderDescVo> list= service.order_desc(order_num);
  	  mv.addObject("list", list);
  	  return mv;   
	}
	
	/*
	 * �־���� �ǹ̰� ���µ�?
	
	@RequestMapping("/re_login")
	   public String re_login(){
	      return ".member.member_login";
	   }
	*/
	
	//��¥�� �˻�
	@RequestMapping("/search_list.do")
	public ModelAndView searchList(HttpServletRequest req){
		String start_date=req.getParameter("start_date");
		String end_date=req.getParameter("end_date");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		
		System.out.println("start_date :" + start_date);
		
		java.sql.Date s_date=java.sql.Date.valueOf(start_date);
		java.sql.Date e_date=java.sql.Date.valueOf(end_date);
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		map.put("start_date", s_date);
		map.put("end_date", e_date);
		List<TbShopOrderListVo> list=service.search_list(map);
		ModelAndView mv=new ModelAndView(".shop.order_list");
		mv.addObject("list",list);
		System.out.println("list :" + list);
		return mv;
	}
	
	//����������� �̵�
	@RequestMapping("order_cancel")
	public ModelAndView orderCancel(int order_num){
		ModelAndView mv=new ModelAndView(".shop.order_cancel");
		List<ShopOrderDescVo> list= service.order_desc(order_num);
		mv.addObject("list", list);
		mv.addObject("order_num",order_num);
	  	return mv;
	}
	
	@RequestMapping("cancel_apply")
	public ModelAndView cancel_apply(HttpServletRequest req){
		//int cancel_num, String reason, String cancel_history, Date cancel_applydate,
		//String member_privacy_id, int shop_payment_item_num
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
	
		int order_num=Integer.parseInt(req.getParameter("order_num"));
		String[] cancel_num=req.getParameterValues("cancel_chk");//üũ�� �͸� 2��
		String[] reason=req.getParameterValues("reason"); //3��
		int size=reason.length;
		for(int j=0;j<size;j++){
			if(reason[j].equals("0")){
				for(int k=j;k<size-1;k++){
					reason[k]=reason[k+1];
				}
			size--;
			break;
			}
		}
		
		System.out.println("cancel_num:" + cancel_num[0]);
		HashMap<String, Object> map=new HashMap<String, Object>();
		for(int i=0;i<cancel_num.length;i++){
			int n=service.cancel_chk(Integer.valueOf(cancel_num[i])); //��ҿ�û �ߺ����� �˻�
			if(n<1){
				ShopCancelVo vo=new ShopCancelVo(
						0,
						reason[i],
						"��ҿ�û",
						null,
						id,
						Integer.valueOf(cancel_num[i])
					);
				service.cancel_apply(vo);
			}
		}
		map.put("order_num", order_num);
		map.put("shop_order_history", "��ҽ�û");
		service.del_history(map);
		mv.setViewName("redirect:/orderList");
		return mv;
	}
	
	@RequestMapping("/cancelList.do")
	public ModelAndView cancelList(HttpServletRequest request,@RequestParam(value="pageNum",defaultValue="1")int pageNum){
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		List<ShopCancelListVo> list=service.cancelList(id);
		int totalpage=service.getCancelPage(id);
		SetBoardPage pu=new SetBoardPage(pageNum, totalpage);
		ModelAndView mv=new ModelAndView(".shop.cancel_list");
		mv.addObject("list", list);
		mv.addObject("pu", pu);
		return mv;
	}
	
	

	@RequestMapping("/member/myOrder")
	public String memmain(HttpServletRequest request, Model model){
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		map.put("start_date", null);
		map.put("end_date", null);
		int totalCount=service.order_count(map);
		SetBoardPage pu=new SetBoardPage(1,totalCount);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<TbShopOrderListVo> list=service.orderList(map);
		System.out.println(list);
		int order_totalprice=service.order_totalprice(id);
		System.out.println(order_totalprice);
		int order_totalcount=service.order_totalcount(id);
		int review_count=service.review_count(id);
		
	//	System.out.println(order_totalprice+"."+order_totalcount+"."+review_count);
		model.addAttribute("list",list);
		model.addAttribute("order_totalprice", order_totalprice);
		model.addAttribute("order_totalcount", order_totalcount);
		model.addAttribute("review_count", review_count);
		request.setAttribute("order_totalprice", order_totalprice);
		return ".member";
	}
	
	@RequestMapping("/couponList")
	public ModelAndView couponList(HttpSession session){
		String id=(String)session.getAttribute("id");
		List<TbCouponMyCouponVo> list=service.getMyCoupon(id);	
		ModelAndView mv=new ModelAndView(".members.couponList");
		mv.addObject("list", list);

		return mv;
	}
}
