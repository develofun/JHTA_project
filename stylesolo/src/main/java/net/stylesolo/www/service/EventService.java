package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.EventDao;
import net.stylesolo.www.vo.TbCouponInfoVo;
import net.stylesolo.www.vo.TbEventCategoryVo;
import net.stylesolo.www.vo.TbEventDiscountVo;
import net.stylesolo.www.vo.TbEventItemVo;
import net.stylesolo.www.vo.TbEventListVo;
import net.stylesolo.www.vo.TbEvent_Coupon_InfoVo;
import net.stylesolo.www.vo.TbMyCouponInfoVo;

@Service
@EnableScheduling
public class EventService {
	@Resource EventDao event_dao;
	@Scheduled(cron="5 00 10 * * *")
	public void event_renew(){
		System.out.println("renew");
		List<TbEventListVo> chk_ing=event_dao.chk_event_sort_ing();
		if(!chk_ing.isEmpty()){
			for(int i=0;i<chk_ing.size();i++){
				int event_num_ing=chk_ing.get(i).getEvent_num();
				int event_category=chk_ing.get(i).getEvent_category_num();
				if(event_category==1){
					List<TbEventListVo>discount_event=event_dao.chk_discount_event(event_category);
					HashMap<String, Object> map_disc=new HashMap<String, Object>();
					if(!discount_event.isEmpty()){
						for(int j=0;j<discount_event.size();j++){
							int event_object_num=discount_event.get(j).getEvent_object_num();
							int event_discount_rate=discount_event.get(j).getEvent_discount_rate();
							List<TbEventDiscountVo> discount_items=event_dao.chk_discount_item(event_object_num);
							if(!discount_items.isEmpty()){
								int disc_rate=event_discount_rate/10;
								map_disc.put("event_discount_rate", event_discount_rate);
								map_disc.put("event_object_num", event_object_num);
								map_disc.put("disc_rate", disc_rate);
								event_dao.update_event_discountrate(map_disc);
							}
						}
					}
				}
				System.out.println(event_num_ing);
				System.out.println(chk_ing.get(i).getEvent_sort());
				event_dao.event_ing_update(event_num_ing);
				System.out.println(event_num_ing+": "+chk_ing.get(i).getEvent_sort());
			}
		}
		if(chk_ing.isEmpty()){
			System.out.println("해당사항 없음");
		}
		List<TbEventListVo> chk_end=event_dao.chk_event_sort_end();
		if(!chk_end.isEmpty()){
			for(int i=0;i<chk_end.size();i++){
				int event_num_end=chk_end.get(i).getEvent_num();
				int event_category=chk_end.get(i).getEvent_category_num();
				if(event_category==1){
					List<TbEventListVo>discount_event_end=event_dao.chk_end_discount_event(event_category);
					if(!discount_event_end.isEmpty()){
						for(int j=0;j<discount_event_end.size();j++){
							int event_object_num=discount_event_end.get(j).getEvent_object_num();
							event_dao.update_discount_end(event_object_num);
						}
					}
				}
				System.out.println(event_num_end);
				System.out.println(chk_end.get(i).getEvent_sort());
				event_dao.event_end_update(event_num_end);
				System.out.println(event_num_end+": "+chk_end.get(i).getEvent_sort());
			}
		}
		if(chk_end.isEmpty()){
			System.out.println("해당사항 없음");
		}
		 List<TbEvent_Coupon_InfoVo> chk_coupon_date=event_dao.event_coupon_chk_date();
		 List<TbEvent_Coupon_InfoVo> chk_coupon_count=event_dao.event_coupon_chk_count();
		 if(!chk_coupon_date.isEmpty()){
			 for (int i = 0; i < chk_coupon_date.size(); i++) {
				 int coupon_num_date=chk_coupon_date.get(i).getCoupon_num();
				 event_dao.del_event_coupon(coupon_num_date);
				 event_dao.del_coupon(coupon_num_date);
			 }
		 }else{System.out.println("해당사항 없음");}
		 if(!chk_coupon_count.isEmpty()){
			 for (int i = 0; i < chk_coupon_count.size(); i++) {
				int coupon_num_count=chk_coupon_count.get(i).getCoupon_num();
				event_dao.del_event_coupon(coupon_num_count);
				event_dao.del_coupon(coupon_num_count);
			}
		 }else{System.out.println("해당사항 없음");}
	}
	public List<TbEventListVo> get_event_list(HashMap<String, Object> map){
		return event_dao.get_event_list(map);
	}
	public int get_list_count(HashMap<String, Object> map){
		return event_dao.get_list_count(map);
	}
	public List<TbEventListVo> get_event_banner_list(int show_num){
		return event_dao.get_event_banner_list(show_num);
	}
	public TbEventListVo get_event_detail(HashMap<String, Object> map){
		return event_dao.get_event_detail(map);
	}
	public List<TbEventItemVo> get_event_item(HashMap<String, Object> map){
		return event_dao.get_event_item(map);
	}
	public int get_item_count(int event_object_num){
		return event_dao.get_item_count(event_object_num);
	}
	public int chk_detail_img(int show_num){
		return event_dao.chk_detail_img(show_num);
	}
	public TbEventCategoryVo get_event_categoryl(int get_num){
		return event_dao.get_event_categoryl(get_num);
	}
	public List<TbEventListVo> chk_event_sort_ing(){
		return event_dao.chk_event_sort_ing();
	}
	public List<TbEventListVo> chk_event_sort_end(){
		return event_dao.chk_event_sort_end();
	}
	public TbEvent_Coupon_InfoVo event_coupon_info(int event_num){
		return event_dao.event_coupon_info(event_num);
	}
	public TbCouponInfoVo get_coupon_event(int coupon_num){
		return event_dao.get_coupon_event(coupon_num);
	}
	public int get_event_coupon(HashMap<String, Object> map){
		return event_dao.get_event_coupon(map);
	}
	public int update_event_coupon_num(HashMap<String, Object> map){
		return event_dao.update_event_coupon_num(map);
	}
	public TbMyCouponInfoVo get_mycoupon_info(HashMap<String, Object> map){
		return event_dao.get_mycoupon_info(map);
	}
}
