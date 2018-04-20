package net.stylesolo.www.vo;

public class TbGongguListValueVo {
	private int gonggu_insert_num;
	private String gonggu_insert_title;
	private String gonggu_insert_content;
	private String gonggu_img_sname;
	private int gonggu_insert_maxnum;
	private long day;
	
	public TbGongguListValueVo() {}

	public TbGongguListValueVo(int gonggu_insert_num, String gonggu_insert_title, String gonggu_insert_content,
			String gonggu_img_sname, int gonggu_insert_maxnum, long day) {
		super();
		this.gonggu_insert_num = gonggu_insert_num;
		this.gonggu_insert_title = gonggu_insert_title;
		this.gonggu_insert_content = gonggu_insert_content;
		this.gonggu_img_sname = gonggu_img_sname;
		this.gonggu_insert_maxnum = gonggu_insert_maxnum;
		this.day = day;
	}

	public int getGonggu_insert_num() {
		return gonggu_insert_num;
	}

	public void setGonggu_insert_num(int gonggu_insert_num) {
		this.gonggu_insert_num = gonggu_insert_num;
	}

	public String getGonggu_insert_title() {
		return gonggu_insert_title;
	}

	public void setGonggu_insert_title(String gonggu_insert_title) {
		this.gonggu_insert_title = gonggu_insert_title;
	}

	public String getGonggu_insert_content() {
		return gonggu_insert_content;
	}

	public void setGonggu_insert_content(String gonggu_insert_content) {
		this.gonggu_insert_content = gonggu_insert_content;
	}

	public String getGonggu_img_sname() {
		return gonggu_img_sname;
	}

	public void setGonggu_img_sname(String gonggu_img_sname) {
		this.gonggu_img_sname = gonggu_img_sname;
	}

	public int getGonggu_insert_maxnum() {
		return gonggu_insert_maxnum;
	}

	public void setGonggu_insert_maxnum(int gonggu_insert_maxnum) {
		this.gonggu_insert_maxnum = gonggu_insert_maxnum;
	}

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
		this.day = day;
	}

	
	
	
}
