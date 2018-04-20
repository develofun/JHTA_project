package net.stylesolo.www.vo;

public class ShopItemOptionVo {
	private int item_options_num;
	private String item_options_name;
	private int item_options_qty;
	private int shop_item_code;
	public ShopItemOptionVo(){}
	public ShopItemOptionVo(int item_options_num, String item_options_name, int item_options_qty, int shop_item_code) {
		super();
		this.item_options_num = item_options_num;
		this.item_options_name = item_options_name;
		this.item_options_qty = item_options_qty;
		this.shop_item_code = shop_item_code;
	}
	public int getItem_options_num() {
		return item_options_num;
	}
	public void setItem_options_num(int item_options_num) {
		this.item_options_num = item_options_num;
	}
	public String getItem_options_name() {
		return item_options_name;
	}
	public void setItem_options_name(String item_options_name) {
		this.item_options_name = item_options_name;
	}
	public int getItem_options_qty() {
		return item_options_qty;
	}
	public void setItem_options_qty(int item_options_qty) {
		this.item_options_qty = item_options_qty;
	}
	public int getShop_item_code() {
		return shop_item_code;
	}
	public void setShop_item_code(int shop_item_code) {
		this.shop_item_code = shop_item_code;
	}
	
	
}
