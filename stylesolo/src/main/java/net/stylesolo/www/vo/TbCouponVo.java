package net.stylesolo.www.vo;

import java.util.Date;

public class TbCouponVo {
	private int coupon_num;
	private String coupon_subject;
	private int coupon_discount;
	private Date coupon_startDate;
	private Date coupon_endDate;
	private int coupon_value;
	public TbCouponVo(){}
	public TbCouponVo(int coupon_num, String coupon_subject, int coupon_discount, Date coupon_startDate,
			Date coupon_endDate, int coupon_value) {
		super();
		this.coupon_num = coupon_num;
		this.coupon_subject = coupon_subject;
		this.coupon_discount = coupon_discount;
		this.coupon_startDate = coupon_startDate;
		this.coupon_endDate = coupon_endDate;
		this.coupon_value = coupon_value;
	}
	public int getCoupon_num() {
		return coupon_num;
	}
	public void setCoupon_num(int coupon_num) {
		this.coupon_num = coupon_num;
	}
	public String getCoupon_subject() {
		return coupon_subject;
	}
	public void setCoupon_subject(String coupon_subject) {
		this.coupon_subject = coupon_subject;
	}
	public int getCoupon_discount() {
		return coupon_discount;
	}
	public void setCoupon_discount(int coupon_discount) {
		this.coupon_discount = coupon_discount;
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
	public int getCoupon_value() {
		return coupon_value;
	}
	public void setCoupon_value(int coupon_value) {
		this.coupon_value = coupon_value;
	}
	@Override
	public String toString() {
		return "TbCouponVo [coupon_num=" + coupon_num + ", coupon_subject=" + coupon_subject + ", coupon_discount="
				+ coupon_discount + ", coupon_startDate=" + coupon_startDate + ", coupon_endDate=" + coupon_endDate
				+ ", coupon_value=" + coupon_value + "]";
	}

	
}
