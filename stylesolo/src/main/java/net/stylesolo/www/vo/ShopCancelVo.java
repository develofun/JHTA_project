package net.stylesolo.www.vo;

import java.sql.Date;

public class ShopCancelVo {
	private int cancel_num;
	private String reason;
	private String cancel_history;
	private Date cancel_applydate;
	private String member_privacy_id;
	private int shop_payment_item_num;
	
	public ShopCancelVo(){}

	public ShopCancelVo(int cancel_num, String reason, String cancel_history, Date cancel_applydate,
			String member_privacy_id, int shop_payment_item_num) {
		super();
		this.cancel_num = cancel_num;
		this.reason = reason;
		this.cancel_history = cancel_history;
		this.cancel_applydate = cancel_applydate;
		this.member_privacy_id = member_privacy_id;
		this.shop_payment_item_num = shop_payment_item_num;
	}

	public int getCancel_num() {
		return cancel_num;
	}

	public void setCancel_num(int cancel_num) {
		this.cancel_num = cancel_num;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCancel_history() {
		return cancel_history;
	}

	public void setCancel_history(String cancel_history) {
		this.cancel_history = cancel_history;
	}

	public Date getCancel_applydate() {
		return cancel_applydate;
	}

	public void setCancel_applydate(Date cancel_applydate) {
		this.cancel_applydate = cancel_applydate;
	}

	public String getMember_privacy_id() {
		return member_privacy_id;
	}

	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}

	public int getShop_payment_item_num() {
		return shop_payment_item_num;
	}

	public void setShop_payment_item_num(int shop_payment_item_num) {
		this.shop_payment_item_num = shop_payment_item_num;
	}
	
}
