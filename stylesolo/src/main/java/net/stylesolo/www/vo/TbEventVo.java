package net.stylesolo.www.vo;

import java.sql.Date;

public class TbEventVo {
	private int event_num;//�̺�Ʈ��ȣ
	private String event_title;//�̺�Ʈ����
	private String event_content;//�̺�Ʈ ����
	private Date event_start;//�̺�Ʈ ������
	private Date event_end;//�̺�Ʈ ������
	private Date event_w_date;//�̺�Ʈ ������
	private String event_sort;//�̺�Ʈ �з�
	private int event_category_num;//�̺�Ʈ ī�װ� ��ȣ
	private int event_object_num;//�̺�Ʈ �� �ߺз� ��ȣ
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
