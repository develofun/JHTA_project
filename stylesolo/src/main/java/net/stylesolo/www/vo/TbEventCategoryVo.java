package net.stylesolo.www.vo;

public class TbEventCategoryVo {
	private int event_category_num;
	private int event_num;
	private String event_category_name;
	
	public TbEventCategoryVo(){}

	public TbEventCategoryVo(int event_category_num, int event_num, String event_category_name) {
		super();
		this.event_category_num = event_category_num;
		this.event_num = event_num;
		this.event_category_name = event_category_name;
	}

	public int getEvent_category_num() {
		return event_category_num;
	}

	public void setEvent_category_num(int event_category_num) {
		this.event_category_num = event_category_num;
	}

	public int getEvent_num() {
		return event_num;
	}

	public void setEvent_num(int event_num) {
		this.event_num = event_num;
	}

	public String getEvent_category_name() {
		return event_category_name;
	}

	public void setEvent_category_name(String event_category_name) {
		this.event_category_name = event_category_name;
	}
}
