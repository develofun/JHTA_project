package net.stylesolo.www.vo;

public class ItemsetShopJoinVo {
	private int item_code_num;
	private String item_code_setname;
	private int itemset_code_price;
	private String itemset_code_mainimg;
	private int shop_item_code;
	private String shop_item_name;
	private String shop_item_mainimg_imgname;
	public ItemsetShopJoinVo(){}
	public ItemsetShopJoinVo(int item_code_num, String item_code_setname, int itemset_code_price,
			String itemset_code_mainimg, int shop_item_code, String shop_item_name, String shop_item_mainimg_imgname) {
		super();
		this.item_code_num = item_code_num;
		this.item_code_setname = item_code_setname;
		this.itemset_code_price = itemset_code_price;
		this.itemset_code_mainimg = itemset_code_mainimg;
		this.shop_item_code = shop_item_code;
		this.shop_item_name = shop_item_name;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
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
	public int getItemset_code_price() {
		return itemset_code_price;
	}
	public void setItemset_code_price(int itemset_code_price) {
		this.itemset_code_price = itemset_code_price;
	}
	public String getItemset_code_mainimg() {
		return itemset_code_mainimg;
	}
	public void setItemset_code_mainimg(String itemset_code_mainimg) {
		this.itemset_code_mainimg = itemset_code_mainimg;
	}
	public int getShop_item_code() {
		return shop_item_code;
	}
	public void setShop_item_code(int shop_item_code) {
		this.shop_item_code = shop_item_code;
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
	
	
}
