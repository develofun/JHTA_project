package net.stylesolo.www.vo;

public class ItemsetCartJoinVo {
	private String item_code_setname;
	private String itemset_code_mainimg;
	private String member_privacy_id;
	private int item_code_num;
	private int itemset_cart_price;
	private int itemset_cart_order_qty;
	private int itemset_cart_num;
	public ItemsetCartJoinVo(){}
	public ItemsetCartJoinVo(String item_code_setname, String itemset_code_mainimg, String member_privacy_id,
			int item_code_num, int itemset_cart_price, int itemset_cart_order_qty, int itemset_cart_num) {
		super();
		this.item_code_setname = item_code_setname;
		this.itemset_code_mainimg = itemset_code_mainimg;
		this.member_privacy_id = member_privacy_id;
		this.item_code_num = item_code_num;
		this.itemset_cart_price = itemset_cart_price;
		this.itemset_cart_order_qty = itemset_cart_order_qty;
		this.itemset_cart_num = itemset_cart_num;
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
	public String getMember_privacy_id() {
		return member_privacy_id;
	}
	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
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
	public int getItemset_cart_num() {
		return itemset_cart_num;
	}
	public void setItemset_cart_num(int itemset_cart_num) {
		this.itemset_cart_num = itemset_cart_num;
	}
}
	