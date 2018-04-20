package net.stylesolo.www.vo;

import java.sql.Date;

public class TbGongguInsertVo {
	private int gonggu_insert_num;
	private String gonggu_insert_title;
	private String gonggu_insert_content;
	private String gonggu_insert_category;
	private String gonggu_insert_price;
	private int gonggu_insert_minnum;
	private int gonggu_insert_maxnum;
	private Date gonggu_insert_openingdate;
	private Date gonggu_insert_closingdate;
	private String gonggu_insert_bankname;
	private String gonggu_insert_account;
	private Date gonggu_insert_date;
	private String member_privacy_id;
	private String gonggu_insert_recommend;
	
	public TbGongguInsertVo() {}

	public TbGongguInsertVo(int gonggu_insert_num, String gonggu_insert_title, String gonggu_insert_content,
			String gonggu_insert_category, String gonggu_insert_price, int gonggu_insert_minnum,
			int gonggu_insert_maxnum, Date gonggu_insert_openingdate, Date gonggu_insert_closingdate,
			String gonggu_insert_bankname, String gonggu_insert_account, Date gonggu_insert_date,
			String member_privacy_id, String gonggu_insert_recommend) {
		super();
		this.gonggu_insert_num = gonggu_insert_num;
		this.gonggu_insert_title = gonggu_insert_title;
		this.gonggu_insert_content = gonggu_insert_content;
		this.gonggu_insert_category = gonggu_insert_category;
		this.gonggu_insert_price = gonggu_insert_price;
		this.gonggu_insert_minnum = gonggu_insert_minnum;
		this.gonggu_insert_maxnum = gonggu_insert_maxnum;
		this.gonggu_insert_openingdate = gonggu_insert_openingdate;
		this.gonggu_insert_closingdate = gonggu_insert_closingdate;
		this.gonggu_insert_bankname = gonggu_insert_bankname;
		this.gonggu_insert_account = gonggu_insert_account;
		this.gonggu_insert_date = gonggu_insert_date;
		this.member_privacy_id = member_privacy_id;
		this.gonggu_insert_recommend = gonggu_insert_recommend;
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

	public String getGonggu_insert_category() {
		return gonggu_insert_category;
	}

	public void setGonggu_insert_category(String gonggu_insert_category) {
		this.gonggu_insert_category = gonggu_insert_category;
	}

	public String getGonggu_insert_price() {
		return gonggu_insert_price;
	}

	public void setGonggu_insert_price(String gonggu_insert_price) {
		this.gonggu_insert_price = gonggu_insert_price;
	}

	public int getGonggu_insert_minnum() {
		return gonggu_insert_minnum;
	}

	public void setGonggu_insert_minnum(int gonggu_insert_minnum) {
		this.gonggu_insert_minnum = gonggu_insert_minnum;
	}

	public int getGonggu_insert_maxnum() {
		return gonggu_insert_maxnum;
	}

	public void setGonggu_insert_maxnum(int gonggu_insert_maxnum) {
		this.gonggu_insert_maxnum = gonggu_insert_maxnum;
	}

	public Date getGonggu_insert_openingdate() {
		return gonggu_insert_openingdate;
	}

	public void setGonggu_insert_openingdate(Date gonggu_insert_openingdate) {
		this.gonggu_insert_openingdate = gonggu_insert_openingdate;
	}

	public Date getGonggu_insert_closingdate() {
		return gonggu_insert_closingdate;
	}

	public void setGonggu_insert_closingdate(Date gonggu_insert_closingdate) {
		this.gonggu_insert_closingdate = gonggu_insert_closingdate;
	}

	public String getGonggu_insert_bankname() {
		return gonggu_insert_bankname;
	}

	public void setGonggu_insert_bankname(String gonggu_insert_bankname) {
		this.gonggu_insert_bankname = gonggu_insert_bankname;
	}

	public String getGonggu_insert_account() {
		return gonggu_insert_account;
	}

	public void setGonggu_insert_account(String gonggu_insert_account) {
		this.gonggu_insert_account = gonggu_insert_account;
	}

	public Date getGonggu_insert_date() {
		return gonggu_insert_date;
	}

	public void setGonggu_insert_date(Date gonggu_insert_date) {
		this.gonggu_insert_date = gonggu_insert_date;
	}

	public String getMember_privacy_id() {
		return member_privacy_id;
	}

	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}

	public String getGonggu_insert_recommend() {
		return gonggu_insert_recommend;
	}

	public void setGonggu_insert_recommend(String gonggu_insert_recommend) {
		this.gonggu_insert_recommend = gonggu_insert_recommend;
	}
}
