package net.stylesolo.www.vo;
/*
 * 
 * 
create table tb_shop_cart(
	shop_cart_num number(10,0) primary key,
	shop_cart_order_qty number(5,0),
	shop_cart_price number(10,0),
	shop_item_code number(10,0) references tb_shop_item(shop_item_code) on delete 

cascade,
	member_privacy_id VARCHAR2(50) 
);
 */
public class ShopNormalCartVo {
	private int shop_cart_num;
	private int shop_cart_order_qty;
	private int shop_cart_price;
	private int shop_item_code;
	private String member_privacy_id;
	public ShopNormalCartVo(){}
	public ShopNormalCartVo(int shop_cart_num, int shop_cart_order_qty, int shop_cart_price, int shop_item_code,
			String member_privacy_id) {
		super();
		this.shop_cart_num = shop_cart_num;
		this.shop_cart_order_qty = shop_cart_order_qty;
		this.shop_cart_price = shop_cart_price;
		this.shop_item_code = shop_item_code;
		this.member_privacy_id = member_privacy_id;
	}
	public int getShop_cart_num() {
		return shop_cart_num;
	}
	public void setShop_cart_num(int shop_cart_num) {
		this.shop_cart_num = shop_cart_num;
	}
	public int getShop_cart_order_qty() {
		return shop_cart_order_qty;
	}
	public void setShop_cart_order_qty(int shop_cart_order_qty) {
		this.shop_cart_order_qty = shop_cart_order_qty;
	}
	public int getShop_cart_price() {
		return shop_cart_price;
	}
	public void setShop_cart_price(int shop_cart_price) {
		this.shop_cart_price = shop_cart_price;
	}
	public int getShop_item_code() {
		return shop_item_code;
	}
	public void setShop_item_code(int shop_item_code) {
		this.shop_item_code = shop_item_code;
	}
	public String getMember_privacy_id() {
		return member_privacy_id;
	}
	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}
	
	
	
}
