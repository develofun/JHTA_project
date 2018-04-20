package net.stylesolo.www.vo;

import java.sql.Date;

public class TbMyCouponInfoVo {
	private int coupon_mycoupon_num;
	private int coupon_mycoupon_qty;
	private int coupon_num;
	private String member_privacy_id;
	private Date coupon_startdate;
	private Date coupon_enddate;
	public TbMyCouponInfoVo(){}
	public TbMyCouponInfoVo(int coupon_mycoupon_num, int coupon_mycoupon_qty, int coupon_num, String member_privacy_id,
			Date coupon_startdate, Date coupon_enddate) {
		super();
		this.coupon_mycoupon_num = coupon_mycoupon_num;
		this.coupon_mycoupon_qty = coupon_mycoupon_qty;
		this.coupon_num = coupon_num;
		this.member_privacy_id = member_privacy_id;
		this.coupon_startdate = coupon_startdate;
		this.coupon_enddate = coupon_enddate;
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
	public Date getCoupon_startdate() {
		return coupon_startdate;
	}
	public void setCoupon_startdate(Date coupon_startdate) {
		this.coupon_startdate = coupon_startdate;
	}
	public Date getCoupon_enddate() {
		return coupon_enddate;
	}
	public void setCoupon_enddate(Date coupon_enddate) {
		this.coupon_enddate = coupon_enddate;
	}
}
