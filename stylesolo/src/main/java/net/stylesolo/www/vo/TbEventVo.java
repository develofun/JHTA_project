package net.stylesolo.www.vo;

import java.sql.Date;

public class TbEventVo {
	private int event_num;//이벤트번호
	private String event_title;//이벤트제목
	private String event_content;//이벤트 내용
	private Date event_start;//이벤트 시작일
	private Date event_end;//이벤트 종료일
	private Date event_w_date;//이벤트 공지일
	private String event_sort;//이벤트 분류
	private int event_category_num;//이벤트 카테고리 번호
	private int event_object_num;//이벤트 할 중분류 번호
	public TbEventVo(){}

	public TbEventVo(int event_num, String event_title, String event_content, Date event_start, Date event_end,
			Date event_w_date, String event_sort, int event_category_num, int event_object_num) {
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

	public int getEvent_object_num() {
		return event_object_num;
	}

	public void setEvent_object_num(int event_object_num) {
		this.event_object_num = event_object_num;
	}
}
