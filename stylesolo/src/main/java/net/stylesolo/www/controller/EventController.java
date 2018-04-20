package net.stylesolo.www.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.stylesolo.www.common.SetBoardPage;
import net.stylesolo.www.service.EventService;
import net.stylesolo.www.vo.TbCouponInfoVo;
import net.stylesolo.www.vo.TbEventCategoryVo;
import net.stylesolo.www.vo.TbEventItemVo;
import net.stylesolo.www.vo.TbEventListVo;
import net.stylesolo.www.vo.TbEvent_Coupon_InfoVo;
import net.stylesolo.www.vo.TbMyCouponInfoVo;

@Controller
public class EventController {
	@Resource EventService service_event;
	@RequestMapping("/event")
	public String eventMain(Model model,
			@RequestParam(value="event_sort",defaultValue="������")String event_sort,
			@RequestParam(value="pageNum",defaultValue="1")int pageNum,
			@RequestParam(value="endPageNum",defaultValue="1")int endPageNum,
			@RequestParam(value="pagePre5",defaultValue="0")int pagePre5,
			@RequestParam(value="pageNext5",defaultValue="0")int pageNext5){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("event_sort", event_sort);
		final String path="/resources/event_image/";
		int pageCount=service_event.get_list_count(map);
		SetBoardPage paging5=new SetBoardPage(endPageNum, pageCount);
		if(pagePre5!=0){
			if(pagePre5<=5){
				pageNum=pagePre5;
			}else{
				if(pagePre5%5==0){pageNum=((pagePre5/6)-1)*6-4;}
				pageNum=(pagePre5/6)*6-4;
			}
		}
		if(pageNext5!=0){
			if(pageNext5+6 >=paging5.getTotalPageCount()){
				pageNum=pageNext5;
			}else{
				pageNum=(pageNext5/6)*6+7;
				if(pageNext5%6==0){pageNum=(pageNext5/6)*6+1;}
			}
		}
		SetBoardPage pu=new SetBoardPage(pageNum, pageCount);
		map.put("srnum", pu.getStartRow());
		map.put("ernum", pu.getEndRow());
		List<TbEventListVo> banner_list=service_event.get_event_banner_list(3);
		List<TbEventListVo> head_list=service_event.get_event_banner_list(2);
		List<TbEventListVo> content_list=service_event.get_event_list(map);
		String event_sort_list="";
		if(!content_list.isEmpty()){
			event_sort_list=content_list.get(0).getEvent_sort();
			event_sort_list=content_list.get(0).getEvent_sort();
		}
		String headevent1=head_list.get(0).getEvent_image_name();
		int head_num1=head_list.get(0).getEvent_num();
		String headevent2=head_list.get(1).getEvent_image_name();
		int head_num2=head_list.get(1).getEvent_num();
		model.addAttribute("headevent1",headevent1);
		model.addAttribute("headevent2", headevent2);
		model.addAttribute("head_num1", head_num1);
		model.addAttribute("head_num2", head_num2);
		model.addAttribute("event_path", path);
		model.addAttribute("banner_list", banner_list);
		model.addAttribute("head_list", head_list);
		model.addAttribute("content_list", content_list);
		model.addAttribute("event_sort", event_sort_list);
		model.addAttribute("pu", pu);
		model.addAttribute("pageNum", pu.getPageNum());
		return ".event.eventMain";
	}
	@RequestMapping("/event/event_detail")
	public String eventDetail(Model model,String get_event_num,
		@RequestParam(value="pageNum",defaultValue="1")int pageNum,
		HttpSession session){
		HashMap<String, Object> map=new HashMap<String, Object>();
		String get_id=(String)session.getAttribute("id");
		model.addAttribute("get_id", get_id);
		int get_num=Integer.parseInt(get_event_num);
		int cnt_detail=service_event.chk_detail_img(get_num);
		map.put("event_num", get_num);
		map.put("cnt_detail",cnt_detail);
		TbEventListVo detail=service_event.get_event_detail(map);
		int getcategory_num=detail.getEvent_category_num();
		TbEventCategoryVo event_category=service_event.get_event_categoryl(getcategory_num);
		String category_name=event_category.getEvent_category_name();
		String path="/resources/event_image/";
		String itempath="/resources/item_img/";
		if(category_name.equals("����")){
			int item_object_num=detail.getEvent_object_num();
			int get_item_count=service_event.get_item_count(item_object_num);
			SetBoardPage item_pu=new SetBoardPage(pageNum, get_item_count);
			map.put("event_object_num", item_object_num);
			map.put("srnum", item_pu.getStartRow());
			map.put("ernum", item_pu.getEndRow());
			List<TbEventItemVo>event_item=service_event.get_event_item(map);
			if(category_name.equals("����")){
				int event_rate=detail.getEvent_discount_rate();
				model.addAttribute("event_rate", event_rate);
			}
			model.addAttribute("get_event_num", get_event_num);
			model.addAttribute("event_item", event_item);
			model.addAttribute("item_pu", item_pu);
			model.addAttribute("detail", detail);
			model.addAttribute("itempath", itempath);
			model.addAttribute("path", path);
			return ".event.eventPage1";
		}else if(category_name.equals("����")){
			TbEvent_Coupon_InfoVo event_coupon=service_event.event_coupon_info(get_num);
			if(event_coupon!=null){
				int coupon_num=event_coupon.getCoupon_num();
				int event_coupon_count=event_coupon.getEvent_coupon_num();
				if(get_id!=null){
					map.put("get_id", get_id);
					map.put("coupon_num", coupon_num);
					TbMyCouponInfoVo mycoupon_info=service_event.get_mycoupon_info(map);
					if(mycoupon_info!=null){
						int chk_get_coupon=mycoupon_info.getCoupon_mycoupon_qty();
						model.addAttribute("chk_get_coupon", chk_get_coupon);
					}
				}
				model.addAttribute("event_coupon_count", event_coupon_count);
				model.addAttribute("get_num", get_num);
				model.addAttribute("coupon_num", coupon_num);
			}
			model.addAttribute("detail", detail);
			model.addAttribute("path", path);
			return ".event.eventPage2";
		}else{
			return ".event.eventPageMain";
		}
	}
	@RequestMapping("/event/event_cupon_result")
	public String get_event_cupon(Model model,HttpSession session,
			@RequestParam(value="get_num",defaultValue="0")int get_num,
			@RequestParam(value="coupon_num",defaultValue="0")int coupon_num){
		HashMap<String, Object> map=new HashMap<String, Object>();
		String get_id=(String)session.getAttribute("id");
		model.addAttribute("get_id", get_id);
		TbCouponInfoVo coupon_event=service_event.get_coupon_event(coupon_num);
		TbEvent_Coupon_InfoVo event_coupon=service_event.event_coupon_info(get_num);
		if(coupon_event!=null&&get_id!=null){
			int coupon_validity=coupon_event.getCoupon_validity();
			map.put("coupon_num", coupon_num);
			map.put("get_id", get_id);
			map.put("coupon_validity",coupon_validity);
			service_event.get_event_coupon(map);
			if(event_coupon!=null){
				int event_coupon_num=event_coupon.getEvent_coupon_num();
				map.put("event_coupon_num", event_coupon_num);
				service_event.update_event_coupon_num(map);
			}
		}
		return ".event.eventResult";
	}
}
