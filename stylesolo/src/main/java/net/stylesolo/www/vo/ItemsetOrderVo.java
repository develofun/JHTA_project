package net.stylesolo.www.vo;

public class ItemsetOrderVo {
	private String item_code_setname;
	private String itemset_code_mainimg;
	private int item_code_num;
	private int itemset_cart_price;
	private int itemset_cart_order_qty;
	public ItemsetOrderVo(){}
	public ItemsetOrderVo(String item_code_setname, String itemset_code_mainimg,
			int item_code_num, int itemset_cart_price, int itemset_cart_order_qty) {
		super();
		this.item_code_setname = item_code_setname;
		this.itemset_code_mainimg = itemset_code_mainimg;
		this.item_code_num = item_code_num;
		this.itemset_cart_price = itemset_cart_price;
		this.itemset_cart_order_qty = itemset_cart_order_qty;
	}
	public String getItem_code_setname() {
		return item_code_setname;
	}
	public void setItem_code_setname(String item_code_setname) {
		this.item_code_setname = item_code_setname;
	}
	public String getItemset_code_mainimg() {
		return itemset_code_mainimg;
	}
	public void setItemset_code_mainimg(String itemset_code_mainimg) {
		this.itemset_code_mainimg = itemset_code_mainimg;
	}
	public int getItem_code_num() {
		return item_code_num;
	}
	public void setItem_code_num(int item_code_num) {
		this.item_code_num = item_code_num;
	}
	public int getItemset_cart_price() {
		return itemset_cart_price;
	}
	public void setItemset_cart_price(int itemset_cart_price) {
		this.itemset_cart_price = itemset_cart_price;
	}
	public int getItemset_cart_order_qty() {
		return itemset_cart_order_qty;
	}
	public void setItemset_cart_order_qty(int itemset_cart_order_qty) {
		this.itemset_cart_order_qty = itemset_cart_order_qty;
	}
	
}
