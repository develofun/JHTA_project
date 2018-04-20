package net.stylesolo.www.vo;

import java.sql.Date;

public class TbCouponMyCouponVo {
	private int coupon_mycoupon_num;
	private int coupon_mycoupon_qty;
	private int coupon_num;
	private String member_privacy_id;
	private Date coupon_startDate;
	private Date coupon_endDate;
	private String coupon_subject;
	private int coupon_discount;
	private int coupon_value;
	private int coupon_validity;
	
	
	public TbCouponMyCouponVo(){}

	public TbCouponMyCouponVo(int coupon_mycoupon_num, int coupon_mycoupon_qty, int coupon_num,
			String member_privacy_id) {
		super();
		this.coupon_mycoupon_num = coupon_mycoupon_num;
		this.coupon_mycoupon_qty = coupon_mycoupon_qty;
		this.coupon_num = coupon_num;
		this.member_privacy_id = member_privacy_id;
	}

	
	
	public int getCoupon_discount() {
		return coupon_discount;
	}

	public void setCoupon_discount(int coupon_discount) {
		this.coupon_discount = coupon_discount;
	}

	public TbCouponMyCouponVo(int coupon_mycoupon_num, int coupon_mycoupon_qty, int coupon_num,
			String member_privacy_id, Date coupon_startDate, Date coupon_endDate, String coupon_subject,
			int coupon_discount,int coupon_value, int coupon_validity) {
		super();
		this.coupon_mycoupon_num = coupon_mycoupon_num;
		this.coupon_mycoupon_qty = coupon_mycoupon_qty;
		this.coupon_num = coupon_num;
		this.member_privacy_id = member_privacy_id;
		this.coupon_startDate = coupon_startDate;
		this.coupon_endDate = coupon_endDate;
		this.coupon_subject = coupon_subject;
		this.coupon_discount= coupon_discount;
		this.coupon_value = coupon_value;
		this.coupon_validity = coupon_validity;
	}
	
	public Date getCoupon_startDate() {
		return coupon_startDate;
	}

	public void setCoupon_startDate(Date coupon_startDate) {
		this.coupon_startDate = coupon_startDate;
	}

	public Date getCoupon_endDate() {
		return coupon_endDate;
	}

	public void setCoupon_endDate(Date coupon_endDate) {
		this.coupon_endDate = coupon_endDate;
	}

	public String getCoupon_subject() {
		return coupon_subject;
	}

	public void setCoupon_subject(String coupon_subject) {
		this.coupon_subject = coupon_subject;
	}

	public int getCoupon_value() {
		return coupon_value;
	}

	public void setCoupon_value(int coupon_value) {
		this.coupon_value = coupon_value;
	}

	public int getCoupon_validity() {
		return coupon_validity;
	}

	public void setCoupon_validity(int coupon_validity) {
		this.coupon_validity = coupon_validity;
	}

	public int getCoupon_mycoupon_num() {
		return coupon_mycoupon_num;
	}

	public void setCoupon_mycoupon_num(int coupon_mycoupon_num) {
		this.coupon_mycoupon_num = coupon_mycoupon_num;
	}

	public int getCoupon_mycoupon_qty() {
		return coupon_mycoupon_qty;
	}

	public void setCoupon_mycoupon_qty(int coupon_mycoupon_qty) {
		this.coupon_mycoupon_qty = coupon_mycoupon_qty;
	}

	public int getCoupon_num() {
		return coupon_num;
	}

	public void setCoupon_num(int coupon_num) {
		this.coupon_num = coupon_num;
	}

	public String getMember_privacy_id() {
		return member_privacy_id;
	}

	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}

	@Override
	public String toString() {
		return "TbCouponMyCouponVo [coupon_mycoupon_num=" + coupon_mycoupon_num + ", coupon_mycoupon_qty="
				+ coupon_mycoupon_qty + ", coupon_num=" + coupon_num + ", member_privacy_id=" + member_privacy_id
				+ ", coupon_startDate=" + coupon_startDate + ", coupon_endDate=" + coupon_endDate + ", coupon_subject="
				+ coupon_subject + ", coupon_value=" + coupon_value + ", coupon_validity=" + coupon_validity + "]";
	}

	
	
}
