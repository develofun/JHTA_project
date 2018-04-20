package net.stylesolo.www.vo;
/*
/*
create table tb_shop_cart(
	shop_cart_num number(10,0) primary key,
	item_options_num number(10,0) default 0 references TB_item_options
(item_options_num) on delete cascade,
	shop_cart_order_qty number(5,0),
	shop_cart_price number(10,0),
	shop_item_code number(10,0) references tb_shop_item(shop_item_code) on delete 
cascade,
	member_privacy_id VARCHAR2(50) 
);
*/


// 장바구니테이블에 추가하기 위한 VO
public class ShopCartVo {
	private int shop_cart_num; //글번호
	private String member_privacy_id; //아이디
	private int shop_item_code; //상품코드
	private int item_options_num; //옵션번호 (기본0)
	private int shop_cart_order_qty; //주문수량
	private int shop_cart_price; // 판매가
	public ShopCartVo(){}
	public ShopCartVo(int shop_cart_num, String member_privacy_id, int shop_item_code, int item_options_num,
			int shop_cart_order_qty, int shop_cart_price) {
		super();
		this.shop_cart_num = shop_cart_num;
		this.member_privacy_id = member_privacy_id;
		this.shop_item_code = shop_item_code;
		this.item_options_num = item_options_num;
		this.shop_cart_order_qty = shop_cart_order_qty;
		this.shop_cart_price = shop_cart_price;
	}
	public ShopCartVo(int shop_cart_num, String member_privacy_id, int shop_item_code,
			int shop_cart_order_qty, int shop_cart_price) {
		super();
		this.shop_cart_num = shop_cart_num;
		this.member_privacy_id = member_privacy_id;
		this.shop_item_code = shop_item_code;
		this.shop_cart_order_qty = shop_cart_order_qty;
		this.shop_cart_price = shop_cart_price;
	}
	public int getShop_cart_num() {
		return shop_cart_num;
	}
	public void setShop_cart_num(int shop_cart_num) {
		this.shop_cart_num = shop_cart_num;
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
	public int getItem_options_num() {
		return item_options_num;
	}
	public void setItem_options_num(int item_options_num) {
		this.item_options_num = item_options_num;
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
}