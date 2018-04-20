package net.stylesolo.www.vo;

import java.sql.Date;

public class TbGongguImgVo extends TbGongguInsertVo{
	private int gonggu_img_num;
	private String gonggu_img_name;
	private String gonggu_img_sname;
	private Date gonggu_img_date;
	private int gonggu_insert_num;
	
	public TbGongguImgVo() {}
	
	public TbGongguImgVo(int gonggu_img_num, String gonggu_img_name, String gonggu_img_sname, Date gonggu_img_date,
			int gonggu_insert_num) {
		super();
		this.gonggu_img_num = gonggu_img_num;
		this.gonggu_img_name = gonggu_img_name;
		this.gonggu_img_sname = gonggu_img_sname;
		this.gonggu_img_date = gonggu_img_date;
		this.gonggu_insert_num = gonggu_insert_num;
	}

	public int getGonggu_img_num() {
		return gonggu_img_num;
	}

	public String getGonggu_img_name() {
		return gonggu_img_name;
	}

	public String getGonggu_img_sname() {
		return gonggu_img_sname;
	}

	public Date getGonggu_img_date() {
		return gonggu_img_date;
	}

	public int getGonggu_insert_num() {
		return gonggu_insert_num;
	}

	public void setGonggu_img_num(int gonggu_img_num) {
		this.gonggu_img_num = gonggu_img_num;
	}

	public void setGonggu_img_name(String gonggu_img_name) {
		this.gonggu_img_name = gonggu_img_name;
	}

	public void setGonggu_img_sname(String gonggu_img_sname) {
		this.gonggu_img_sname = gonggu_img_sname;
	}

	public void setGonggu_img_date(Date gonggu_img_date) {
		this.gonggu_img_date = gonggu_img_date;
	}

	public void setGonggu_insert_num(int gonggu_insert_num) {
		this.gonggu_insert_num = gonggu_insert_num;
	}
	
}
