package net.stylesolo.www.vo;

public class ShopItemsetCartVo {
	private int item_code_num;
	private String item_code_setname;
	private int itemset_cart_order_qty;
	private int itemset_cart_price;
	ShopItemsetCartVo(){}
	public ShopItemsetCartVo(int item_code_num, String item_code_setname, int itemset_cart_order_qty,
			int itemset_cart_price) {
		super();
		this.item_code_num = item_code_num;
		this.item_code_setname = item_code_setname;
		this.itemset_cart_order_qty = itemset_cart_order_qty;
		this.itemset_cart_price = itemset_cart_price;
	}
	public int getItem_code_num() {
		return item_code_num;
	}
	public void setItem_code_num(int item_code_num) {
		this.item_code_num = item_code_num;
	}
	public String getItem_code_setname() {
		return item_code_setname;
	}
	public void setItem_code_setname(String item_code_setname) {
		this.item_code_setname = item_code_setname;
	}
	public int getItemset_cart_order_qty() {
		return itemset_cart_order_qty;
	}
	public void setItemset_cart_order_qty(int itemset_cart_order_qty) {
		this.itemset_cart_order_qty = itemset_cart_order_qty;
	}
	public int getItemset_cart_price() {
		return itemset_cart_price;
	}
	public void setItemset_cart_price(int itemset_cart_price) {
		this.itemset_cart_price = itemset_cart_price;
	}
	
	
}
