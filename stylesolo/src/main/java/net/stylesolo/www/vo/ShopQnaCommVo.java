package net.stylesolo.www.vo;

import java.util.Date;

public class ShopQnaCommVo {
	private int shop_qna_comm_num;
	private int shop_qna_comm_content;
	private Date shop_qna_comm_w_date;
	private int shop_qna_num;
	
	public ShopQnaCommVo(){}

	public ShopQnaCommVo(int shop_qna_comm_num, int shop_qna_comm_content, Date shop_qna_comm_w_date,
			int shop_qna_num) {
		super();
		this.shop_qna_comm_num = shop_qna_comm_num;
		this.shop_qna_comm_content = shop_qna_comm_content;
		this.shop_qna_comm_w_date = shop_qna_comm_w_date;
		this.shop_qna_num = shop_qna_num;
	}

	public int getShop_qna_comm_num() {
		return shop_qna_comm_num;
	}

	public void setShop_qna_comm_num(int shop_qna_comm_num) {
		this.shop_qna_comm_num = shop_qna_comm_num;
	}

	public int getShop_qna_comm_content() {
		return shop_qna_comm_content;
	}

	public void setShop_qna_comm_content(int shop_qna_comm_content) {
		this.shop_qna_comm_content = shop_qna_comm_content;
	}

	public Date getShop_qna_comm_w_date() {
		return shop_qna_comm_w_date;
	}

	public void setShop_qna_comm_w_date(Date shop_qna_comm_w_date) {
		this.shop_qna_comm_w_date = shop_qna_comm_w_date;
	}

	public int getShop_qna_num() {
		return shop_qna_num;
	}

	public void setShop_qna_num(int shop_qna_num) {
		this.shop_qna_num = shop_qna_num;
	}
	
	
}
