package net.stylesolo.www.vo;

import java.sql.Date;

public class TbGongguBuyVo {
	private int gonggu_buy_num;
	private int gonggu_buy_price;
	private int gonggu_buy_getnum;
	private Date gonggu_buy_date;
	private int gonggu_insert_num;
	private String member_privacy_id;
	
	public TbGongguBuyVo() {}

	public TbGongguBuyVo(int gonggu_buy_num, int gonggu_buy_price, int gonggu_buy_getnum, Date gonggu_buy_date,
			int gonggu_insert_num, String member_privacy_id) {
		super();
		this.gonggu_buy_num = gonggu_buy_num;
		this.gonggu_buy_price = gonggu_buy_price;
		this.gonggu_buy_getnum = gonggu_buy_getnum;
		this.gonggu_buy_date = gonggu_buy_date;
		this.gonggu_insert_num = gonggu_insert_num;
		this.member_privacy_id = member_privacy_id;
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

	public int getGonggu_insert_num() {
		return gonggu_insert_num;
	}

	public void setGonggu_insert_num(int gonggu_insert_num) {
		this.gonggu_insert_num = gonggu_insert_num;
	}

	public String getMember_privacy_id() {
		return member_privacy_id;
	}

	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}
}
