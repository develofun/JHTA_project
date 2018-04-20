package net.stylesolo.www.vo;

public class TbEventImageVo {
	private int event_image_num;//이벤트이미지 번호
	private int event_num;//이벤트 번호
	private String event_image_name; //이벤트 이미지명
	public TbEventImageVo(){}
	public TbEventImageVo(int event_image_num, int event_num, String event_image_name) {
		super();
		this.event_image_num = event_image_num;
		this.event_num = event_num;
		this.event_image_name = event_image_name;
	}
	public int getEvent_image_num() {
		return event_image_num;
	}
	public void setEvent_image_num(int event_image_num) {
		this.event_image_num = event_image_num;
	}
	public int getEvent_num() {
		return event_num;
	}
	public void setEvent_num(int event_num) {
		this.event_num = event_num;
	}
	public String getEvent_image_name() {
		return event_image_name;
	}
	public void setEvent_image_name(String event_image_name) {
		this.event_image_name = event_image_name;
	}
}
