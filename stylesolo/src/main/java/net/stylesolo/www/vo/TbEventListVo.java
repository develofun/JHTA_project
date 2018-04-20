package net.stylesolo.www.vo;

import java.sql.Date;

public class TbEventListVo {
	private int event_num;
	private String event_title;
	private String event_content;
	private Date event_start;
	private Date event_end;
	private Date event_w_date;
	private String event_sort;
	private int event_category_num;
	private int event_object_num;//이벤트 할 중분류 번호
	private int event_discount_rate;
	private String event_image_name;
	public TbEventListVo(){}
	public TbEventListVo(int event_num, String event_title, String event_content, Date event_start, Date event_end,
			Date event_w_date, String event_sort, int event_category_num, int event_object_num, int event_discount_rate,
			String event_image_name) {
		super();
		this.event_num = event_num;
		this.event_title = event_title;
		this.event_content = event_content;
		this.event_start = event_start;
		this.event_end = event_end;
		this.event_w_date = event_w_date;
		this.event_sort = event_sort;
		this.event_category_num = event_category_num;
		this.event_object_num = event_object_num;
		this.event_discount_rate = event_discount_rate;
		this.event_image_name = event_image_name;
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
	public String getEvent_content() {
		return event_content;
	}
	public void setEvent_content(String event_content) {
		this.event_content = event_content;
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
	public String getEvent_image_name() {
		return event_image_name;
	}
	public void setEvent_image_name(String event_image_name) {
		this.event_image_name = event_image_name;
	}
	public int getEvent_object_num() {
		return event_object_num;
	}
	public void setEvent_object_num(int event_object_num) {
		this.event_object_num = event_object_num;
	}
	public int getEvent_discount_rate() {
		return event_discount_rate;
	}
	public void setEvent_discount_rate(int event_discount_rate) {
		this.event_discount_rate = event_discount_rate;
	}
}
