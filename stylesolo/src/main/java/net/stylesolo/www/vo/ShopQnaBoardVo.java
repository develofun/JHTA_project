package net.stylesolo.www.vo;

import java.sql.Date;

/*
 *   CREATE TABLE "DK"."TB_SHOP_QNA" 
   (	"SHOP_QNA_NUM" NUMBER(10,0) NOT NULL ENABLE, 
	"SHOP_QNA_TITLE" VARCHAR2(30 BYTE), 
	"SHOP_QNA_CONTENT" CLOB, 
	"SHOP_QNA_W_DATE" DATE, 
	"SHOP_QNA_HIT" NUMBER(10,0) DEFAULT 0, 
	"SHOP_ITEM_CODE" NUMBER(10,0) NOT NULL ENABLE, 
	"MEMBER_PRIVACY_ID" VARCHAR2(50 BYTE) NOT NULL ENABLE,
 */
public class ShopQnaBoardVo {
	private int SHOP_QNA_NUM;
	private String SHOP_QNA_TITLE;
	private String SHOP_QNA_CONTENT;
	private Date SHOP_QNA_W_DATE;
	private int SHOP_QNA_HIT;
	private int SHOP_ITEM_CODE;
	private String MEMBER_PRIVACY_ID;
	private String shop_qna_comm_content;
	private Date shop_qna_comm_w_date;
	
	
	
	public ShopQnaBoardVo(){}
	
	public ShopQnaBoardVo(int sHOP_QNA_NUM, String sHOP_QNA_TITLE, String sHOP_QNA_CONTENT, Date sHOP_QNA_W_DATE,
			int sHOP_QNA_HIT, int sHOP_ITEM_CODE, String mEMBER_PRIVACY_ID) {
		super();
		SHOP_QNA_NUM = sHOP_QNA_NUM;
		SHOP_QNA_TITLE = sHOP_QNA_TITLE;
		SHOP_QNA_CONTENT = sHOP_QNA_CONTENT;
		SHOP_QNA_W_DATE = sHOP_QNA_W_DATE;
		SHOP_QNA_HIT = sHOP_QNA_HIT;
		SHOP_ITEM_CODE = sHOP_ITEM_CODE;
		MEMBER_PRIVACY_ID = mEMBER_PRIVACY_ID;
	}

	
	
	public ShopQnaBoardVo(int sHOP_QNA_NUM, String sHOP_QNA_TITLE, String sHOP_QNA_CONTENT, Date sHOP_QNA_W_DATE,
			int sHOP_QNA_HIT, int sHOP_ITEM_CODE, String mEMBER_PRIVACY_ID, String shop_qna_comm_content,
			Date shop_qna_comm_w_date) {
		super();
		SHOP_QNA_NUM = sHOP_QNA_NUM;
		SHOP_QNA_TITLE = sHOP_QNA_TITLE;
		SHOP_QNA_CONTENT = sHOP_QNA_CONTENT;
		SHOP_QNA_W_DATE = sHOP_QNA_W_DATE;
		SHOP_QNA_HIT = sHOP_QNA_HIT;
		SHOP_ITEM_CODE = sHOP_ITEM_CODE;
		MEMBER_PRIVACY_ID = mEMBER_PRIVACY_ID;
		this.shop_qna_comm_content = shop_qna_comm_content;
		this.shop_qna_comm_w_date = shop_qna_comm_w_date;
	}

	public int getSHOP_QNA_NUM() {
		return SHOP_QNA_NUM;
	}

	public void setSHOP_QNA_NUM(int sHOP_QNA_NUM) {
		SHOP_QNA_NUM = sHOP_QNA_NUM;
	}

	public String getSHOP_QNA_TITLE() {
		return SHOP_QNA_TITLE;
	}

	public void setSHOP_QNA_TITLE(String sHOP_QNA_TITLE) {
		SHOP_QNA_TITLE = sHOP_QNA_TITLE;
	}

	public String getSHOP_QNA_CONTENT() {
		return SHOP_QNA_CONTENT;
	}

	public void setSHOP_QNA_CONTENT(String sHOP_QNA_CONTENT) {
		SHOP_QNA_CONTENT = sHOP_QNA_CONTENT;
	}

	public Date getSHOP_QNA_W_DATE() {
		return SHOP_QNA_W_DATE;
	}

	public void setSHOP_QNA_W_DATE(Date sHOP_QNA_W_DATE) {
		SHOP_QNA_W_DATE = sHOP_QNA_W_DATE;
	}

	public int getSHOP_QNA_HIT() {
		return SHOP_QNA_HIT;
	}

	public void setSHOP_QNA_HIT(int sHOP_QNA_HIT) {
		SHOP_QNA_HIT = sHOP_QNA_HIT;
	}

	public int getSHOP_ITEM_CODE() {
		return SHOP_ITEM_CODE;
	}

	public void setSHOP_ITEM_CODE(int sHOP_ITEM_CODE) {
		SHOP_ITEM_CODE = sHOP_ITEM_CODE;
	}

	public String getMEMBER_PRIVACY_ID() {
		return MEMBER_PRIVACY_ID;
	}

	public void setMEMBER_PRIVACY_ID(String mEMBER_PRIVACY_ID) {
		MEMBER_PRIVACY_ID = mEMBER_PRIVACY_ID;
	}

	public String getShop_qna_comm_content() {
		return shop_qna_comm_content;
	}

	public void setShop_qna_comm_content(String shop_qna_comm_content) {
		this.shop_qna_comm_content = shop_qna_comm_content;
	}

	public Date getShop_qna_comm_w_date() {
		return shop_qna_comm_w_date;
	}

	public void setShop_qna_comm_w_date(Date shop_qna_comm_w_date) {
		this.shop_qna_comm_w_date = shop_qna_comm_w_date;
	}
	
	
}
