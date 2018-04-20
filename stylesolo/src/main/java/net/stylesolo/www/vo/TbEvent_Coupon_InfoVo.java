package net.stylesolo.www.vo;

import java.sql.Date;

public class TbEvent_Coupon_InfoVo {
	public int event_num;
	public String event_title;
	public Date event_start;
	public Date event_end;
	public Date event_w_date;
	public String event_sort;
	public int event_category_num;
	public int event_coupon_code;
	public int event_coupon_num;
	public Date event_coupon_w_date;
	public int coupon_num;
	public TbEvent_Coupon_InfoVo() {}
	public TbEvent_Coupon_InfoVo(int event_num, String event_title, Date event_start, Date event_end, Date event_w_date,
			String event_sort, int event_category_num, int event_coupon_code, int event_coupon_num,
			Date event_coupon_w_date, int coupon_num) {
		super();
		this.event_num = event_num;
		this.event_title = event_title;
		this.event_start = event_start;
		this.event_end = event_end;
		this.event_w_date = event_w_date;
		this.event_sort = event_sort;
		this.event_category_num = event_category_num;
		this.event_coupon_code = event_coupon_code;
		this.event_coupon_num = event_coupon_num;
		this.event_coupon_w_date = event_coupon_w_date;
		this.coupon_num = coupon_num;
	}
	public int getEvent_num() {
		return event_num;
	}
	public void setEvent_num(int event_num) {
		this.event_num = event_num;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public Date getEvent_start() {
		return event_start;
	}
	public void setEvent_start(Date event_start) {
		this.event_start = event_start;
	}
	public Date getEvent_end() {
		return event_end;
	}
	public void setEvent_end(Date event_end) {
		this.event_end = event_end;
	}
	public Date getEvent_w_date() {
		return event_w_date;
	}
	public void setEvent_w_date(Date event_w_date) {
		this.event_w_date = event_w_date;
	}
	public String getEvent_sort() {
		return event_sort;
	}
	public void setEvent_sort(String event_sort) {
		this.event_sort = event_sort;
	}
	public int getEvent_category_num() {
		return event_category_num;
	}
	public void setEvent_category_num(int event_category_num) {
		this.event_category_num = event_category_num;
	}
	public int getEvent_coupon_code() {
		return event_coupon_code;
	}
	public void setEvent_coupon_code(int event_coupon_code) {
		this.event_coupon_code = event_coupon_code;
	}
	public int getEvent_coupon_num() {
		return event_coupon_num;
	}
	public void setEvent_coupon_num(int event_coupon_num) {
		this.event_coupon_num = event_coupon_num;
	}
	public Date getEvent_coupon_w_date() {
		return event_coupon_w_date;
	}
	public void setEvent_coupon_w_date(Date event_coupon_w_date) {
		this.event_coupon_w_date = event_coupon_w_date;
	}
	public int getCoupon_num() {
		return coupon_num;
	}
	public void setCoupon_num(int coupon_num) {
		this.coupon_num = coupon_num;
	}
}
