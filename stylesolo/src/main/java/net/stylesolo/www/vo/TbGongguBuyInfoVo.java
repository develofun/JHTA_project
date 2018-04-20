package net.stylesolo.www.vo;

import java.sql.Date;
/*
 * Tb_Gonggu_Insert
 * Tb_Gonggu_Img
 * Tb_Gonggu_Buy
 * 3개 테이블 통합한 Vo
 */
public class TbGongguBuyInfoVo {
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
	
	private int gonggu_img_num;
	private String gonggu_img_name;
	private String gonggu_img_sname;
	private Date gonggu_img_date;
	
	private int gonggu_buy_num;
	private int gonggu_buy_price;
	private int gonggu_buy_getnum;
	private Date gonggu_buy_date;
	
	public TbGongguBuyInfoVo() {}

	public TbGongguBuyInfoVo(int gonggu_insert_num, String gonggu_insert_title, String gonggu_insert_content,
			String gonggu_insert_category, String gonggu_insert_price, int gonggu_insert_minnum,
			int gonggu_insert_maxnum, Date gonggu_insert_openingdate, Date gonggu_insert_closingdate,
			String gonggu_insert_bankname, String gonggu_insert_account, Date gonggu_insert_date,
			String member_privacy_id, String gonggu_insert_recommend, int gonggu_img_num, String gonggu_img_name,
			String gonggu_img_sname, Date gonggu_img_date, int gonggu_buy_num, int gonggu_buy_price,
			int gonggu_buy_getnum, Date gonggu_buy_date) {
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
		this.gonggu_img_num = gonggu_img_num;
		this.gonggu_img_name = gonggu_img_name;
		this.gonggu_img_sname = gonggu_img_sname;
		this.gonggu_img_date = gonggu_img_date;
		this.gonggu_buy_num = gonggu_buy_num;
		this.gonggu_buy_price = gonggu_buy_price;
		this.gonggu_buy_getnum = gonggu_buy_getnum;
		this.gonggu_buy_date = gonggu_buy_date;
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

	public int getGonggu_img_num() {
		return gonggu_img_num;
	}

	public void setGonggu_img_num(int gonggu_img_num) {
		this.gonggu_img_num = gonggu_img_num;
	}

	public String getGonggu_img_name() {
		return gonggu_img_name;
	}

	public void setGonggu_img_name(String gonggu_img_name) {
		this.gonggu_img_name = gonggu_img_name;
	}

	public String getGonggu_img_sname() {
		return gonggu_img_sname;
	}

	public void setGonggu_img_sname(String gonggu_img_sname) {
		this.gonggu_img_sname = gonggu_img_sname;
	}

	public Date getGonggu_img_date() {
		return gonggu_img_date;
	}

	public void setGonggu_img_date(Date gonggu_img_date) {
		this.gonggu_img_date = gonggu_img_date;
	}

	public int getGonggu_buy_num() {
		return gonggu_buy_num;
	}

	public void setGonggu_buy_num(int gonggu_buy_num) {
		this.gonggu_buy_num = gonggu_buy_num;
	}

	public int getGonggu_buy_price() {
		return gonggu_buy_price;
	}

	public void setGonggu_buy_price(int gonggu_buy_price) {
		this.gonggu_buy_price = gonggu_buy_price;
	}

	public int getGonggu_buy_getnum() {
		return gonggu_buy_getnum;
	}

	public void setGonggu_buy_getnum(int gonggu_buy_getnum) {
		this.gonggu_buy_getnum = gonggu_buy_getnum;
	}

	public Date getGonggu_buy_date() {
		return gonggu_buy_date;
	}

	public void setGonggu_buy_date(Date gonggu_buy_date) {
		this.gonggu_buy_date = gonggu_buy_date;
	}
}
