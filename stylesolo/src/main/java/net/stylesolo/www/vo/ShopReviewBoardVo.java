package net.stylesolo.www.vo;

import java.sql.Date;

/*
 * CREATE TABLE "DK"."TB_SHOP_REVIEW" 
   (	"SHOP_REVIEW_NUM" NUMBER(10,0) NOT NULL ENABLE, 
	"SHOP_REVIEW_CONTENT" CLOB, 
	"SHOP_REVIEW_W_DATE" DATE, 
	"SHOP_REVIEW_HIT" NUMBER(10,0), 
	"SHOP_REVIEW_STAR" CHAR(1 BYTE), 
	"SHOP_ITEM_CODE" NUMBER(10,0) NOT NULL ENABLE, 
	"MEMBER_PRIVACY_ID" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
 */

public class ShopReviewBoardVo {
	private int shop_review_num;
	private String shop_review_content;
	private Date shop_review_w_date;
	private String shop_review_star;
	private int shop_item_code;
	private String member_privacy_id;
	private String shop_review_file_filename; // Ã·ºÎÆÄÀÏ
	private int insertNum;
	
	public ShopReviewBoardVo(){}

	
	
	public int getInsertNum() {
		return insertNum;
	}



	public void setInsertNum(int insertNum) {
		this.insertNum = insertNum;
	}



	public ShopReviewBoardVo(int shop_review_num, String shop_review_content, Date shop_review_w_date,
		  String shop_review_star, int shop_item_code, String member_privacy_id,
			String shop_review_file_filename) {
		super();
		this.shop_review_num = shop_review_num;
		this.shop_review_content = shop_review_content;
		this.shop_review_w_date = shop_review_w_date;
		this.shop_review_star = shop_review_star;
		this.shop_item_code = shop_item_code;
		this.member_privacy_id = member_privacy_id;
		this.shop_review_file_filename = shop_review_file_filename;
	}



	public ShopReviewBoardVo(int shop_review_num, String shop_review_content, Date shop_review_w_date,
			String shop_review_star, int shop_item_code, String member_privacy_id) {
		super();
		this.shop_review_num = shop_review_num;
		this.shop_review_content = shop_review_content;
		this.shop_review_w_date = shop_review_w_date;
		this.shop_review_star = shop_review_star;
		this.shop_item_code = shop_item_code;
		this.member_privacy_id = member_privacy_id;
	}

	
	
	public String getShop_review_file_filename() {
		return shop_review_file_filename;
	}



	public void setShop_review_file_filename(String shop_review_file_filename) {
		this.shop_review_file_filename = shop_review_file_filename;
	}



	public int getShop_review_num() {
		return shop_review_num;
	}

	public void setShop_review_num(int shop_review_num) {
		this.shop_review_num = shop_review_num;
	}

	public String getShop_review_content() {
		return shop_review_content;
	}

	public void setShop_review_content(String shop_review_content) {
		this.shop_review_content = shop_review_content;
	}

	public Date getShop_review_w_date() {
		return shop_review_w_date;
	}

	public void setShop_review_w_date(Date shop_review_w_date) {
		this.shop_review_w_date = shop_review_w_date;
	}

	
	public String getShop_review_star() {
		return shop_review_star;
	}

	public void setShop_review_star(String shop_review_star) {
		this.shop_review_star = shop_review_star;
	}

	public int getShop_item_code() {
		return shop_item_code;
	}

	public void setShop_item_code(int shop_review_code) {
		this.shop_item_code = shop_review_code;
	}

	public String getMember_privacy_id() {
		return member_privacy_id;
	}

	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}

	@Override
	public String toString() {
		return "{shop_review_num:" + shop_review_num + ", shop_review_content:'" + shop_review_content
				+ "', shop_review_w_date:'" + shop_review_w_date.toString() 
				+ ", 'shop_review_star:'" + shop_review_star + "', shop_item_code:" + shop_item_code + ", member_privacy_id='"
				+ member_privacy_id+"'}";
	}

	
}
