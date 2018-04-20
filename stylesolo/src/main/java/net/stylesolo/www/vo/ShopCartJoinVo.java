package net.stylesolo.www.vo;

public class ShopCartJoinVo {
	private String shop_item_name;
	private String shop_item_mainimg_imgname;
	private String member_privacy_id;
	private int shop_item_code;
	private int shop_cart_price;
	private int shop_cart_order_qty;
	private int shop_cart_num;
	private String item_options_name;
	public ShopCartJoinVo(){}
	public ShopCartJoinVo(String shop_item_name, String shop_item_mainimg_imgname, String member_privacy_id,
			int shop_item_code, int shop_cart_price, int shop_cart_order_qty, int shop_cart_num,
			String item_options_name) {
		super();
		this.shop_item_name = shop_item_name;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
		this.member_privacy_id = member_privacy_id;
		this.shop_item_code = shop_item_code;
		this.shop_cart_price = shop_cart_price;
		this.shop_cart_order_qty = shop_cart_order_qty;
		this.shop_cart_num = shop_cart_num;
		this.item_options_name = item_options_name;
	}
	public String getShop_item_name() {
		return shop_item_name;
	}
	public void setShop_item_name(String shop_item_name) {
		this.shop_item_name = shop_item_name;
	}
	public String getShop_item_mainimg_imgname() {
		return shop_item_mainimg_imgname;
	}
	public void setShop_item_mainimg_imgname(String shop_item_mainimg_imgname) {
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
	}
	public String getMember_privacy_id() {
		return member_privacy_id;
	}
	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}
	public int getShop_item_code() {
		return shop_item_code;
	}
	public void setShop_item_code(int shop_item_code) {
		this.shop_item_code = shop_item_code;
	}
	public int getShop_cart_price() {
		return shop_cart_price;
	}
	public void setShop_cart_price(int shop_cart_price) {
		this.shop_cart_price = shop_cart_price;
	}
	public int getShop_cart_order_qty() {
		return shop_cart_order_qty;
	}
	public void setShop_cart_order_qty(int shop_cart_order_qty) {
		this.shop_cart_order_qty = shop_cart_order_qty;
	}
	public String getItem_options_name() {
		return item_options_name;
	}
	public void setItem_options_name(String item_options_name) {
		this.item_options_name = item_options_name;
	}
	public int getShop_cart_num() {
		return shop_cart_num;
	}
	public void setShop_cart_num(int shop_cart_num) {
		this.shop_cart_num = shop_cart_num;
	}
}
