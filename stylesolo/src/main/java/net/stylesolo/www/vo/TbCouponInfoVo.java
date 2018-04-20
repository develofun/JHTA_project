package net.stylesolo.www.vo;

public class TbCouponInfoVo {
	private int coupon_num;
	private String coupon_subject;
	private int coupon_discount;
	private int coupon_value;
	private int coupon_validity;
	public TbCouponInfoVo() {}
	public TbCouponInfoVo(int coupon_num, String coupon_subject, int coupon_discount, int coupon_value,
			int coupon_validity) {
		super();
		this.coupon_num = coupon_num;
		this.coupon_subject = coupon_subject;
		this.coupon_discount = coupon_discount;
		this.coupon_value = coupon_value;
		this.coupon_validity = coupon_validity;
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
}
