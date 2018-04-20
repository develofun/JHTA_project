package net.stylesolo.www.vo;

import java.sql.Date;

public class TbShopOrderListVo {
	private int shop_payment_ordernum;
	private Date shop_payment_w_date;
	private String shop_item_name;
	private int shop_payment_total_payment;
	private String shop_order_history;
	private String shop_delivery_history;
	
	public TbShopOrderListVo(){}

	public TbShopOrderListVo(int shop_payment_ordernum, Date shop_payment_w_date, String shop_item_name,
			int shop_payment_total_payment, String shop_order_history, String shop_delivery_history) {
		super();
		this.shop_payment_ordernum = shop_payment_ordernum;
		this.shop_payment_w_date = shop_payment_w_date;
		this.shop_item_name = shop_item_name;
		this.shop_payment_total_payment = shop_payment_total_payment;
		this.shop_order_history = shop_order_history;
		this.shop_delivery_history = shop_delivery_history;
	}

	public int getShop_payment_ordernum() {
		return shop_payment_ordernum;
	}

	public void setShop_payment_ordernum(int shop_payment_ordernum) {
		this.shop_payment_ordernum = shop_payment_ordernum;
	}

	public Date getShop_payment_w_date() {
		return shop_payment_w_date;
	}

	public void setShop_payment_w_date(Date shop_payment_w_date) {
		this.shop_payment_w_date = shop_payment_w_date;
	}

	public String getShop_item_name() {
		return shop_item_name;
	}

	public void setShop_item_name(String shop_item_name) {
		this.shop_item_name = shop_item_name;
	}

	public int getShop_payment_total_payment() {
		return shop_payment_total_payment;
	}

	public void setShop_payment_total_payment(int shop_payment_total_payment) {
		this.shop_payment_total_payment = shop_payment_total_payment;
	}

	public String getShop_order_history() {
		return shop_order_history;
	}

	public void setShop_order_history(String shop_order_history) {
		this.shop_order_history = shop_order_history;
	}

	public String getShop_delivery_history() {
		return shop_delivery_history;
	}

	public void setShop_delivery_history(String shop_delivery_history) {
		this.shop_delivery_history = shop_delivery_history;
	}
	
}
