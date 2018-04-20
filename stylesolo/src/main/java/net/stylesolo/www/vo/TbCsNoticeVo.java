package net.stylesolo.www.vo;

import java.sql.Date;

public class TbCsNoticeVo {
	private int cs_notice_num;//공지사항번호
	private String cs_notice_category;//카테고리	
	private String cs_notice_title;//제목
	private String cs_notice_content;//내용
	private int cs_notice_hit;//조회수
	private Date cs_notice_w_date;//작성일
	//생성자
	public TbCsNoticeVo(){}
	public TbCsNoticeVo(int cs_notice_num, String cs_notice_category, String cs_notice_title, String cs_notice_content,
			int cs_notice_hit, Date cs_notice_w_date) {
		super();
		this.cs_notice_num = cs_notice_num;
		this.cs_notice_category = cs_notice_category;
		this.cs_notice_title = cs_notice_title;
		this.cs_notice_content = cs_notice_content;
		this.cs_notice_hit = cs_notice_hit;
		this.cs_notice_w_date = cs_notice_w_date;
	}
	//GETTER&SETTER
	public int getCs_notice_num() {
		return cs_notice_num;
	}
	public void setCs_notice_num(int cs_notice_num) {
		this.cs_notice_num = cs_notice_num;
	}
	public String getCs_notice_category() {
		return cs_notice_category;
	}
	public void setCs_notice_category(String cs_notice_category) {
		this.cs_notice_category = cs_notice_category;
	}
	public String getCs_notice_title() {
		return cs_notice_title;
	}
	public void setCs_notice_title(String cs_notice_title) {
		this.cs_notice_title = cs_notice_title;
	}
	public String getCs_notice_content() {
		return cs_notice_content;
	}
	public void setCs_notice_content(String cs_notice_content) {
		this.cs_notice_content = cs_notice_content;
	}
	public int getCs_notice_hit() {
		return cs_notice_hit;
	}
	public void setCs_notice_hit(int cs_notice_hit) {
		this.cs_notice_hit = cs_notice_hit;
	}
	public Date getCs_notice_w_date() {
		return cs_notice_w_date;
	}
	public void setCs_notice_w_date(Date cs_notice_w_date) {
		this.cs_notice_w_date = cs_notice_w_date;
	}
}
