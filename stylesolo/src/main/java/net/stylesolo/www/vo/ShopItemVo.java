package net.stylesolo.www.vo;

public class ShopItemVo {
	private int shop_item_code;
	private String shop_item_name;
	private int shop_itemprice;
	private double shop_item_pointrate;
	private double shop_item_discountrate;
	private int shop_item_saleprice;
	private int shop_item_stock;
	private int item_section; //
	private String shop_item_desc; //상세설명
	private String shop_item_mainimg_imgname;
	private String shop_item_subimg_imgname;
	
	public ShopItemVo(){}
	public ShopItemVo(int shop_item_code, String shop_item_name, int shop_itemprice, double shop_item_pointrate,
			double shop_item_discountrate, int shop_item_saleprice, int shop_item_stock, int item_section,
			String shop_item_desc, String shop_item_subimg_imgname, String shop_item_mainimg_imgname) {
		this.shop_item_code = shop_item_code;
		this.shop_item_name = shop_item_name;
		this.shop_itemprice = shop_itemprice;
		this.shop_item_pointrate = shop_item_pointrate;
		this.shop_item_discountrate = shop_item_discountrate;
		this.shop_item_saleprice = shop_item_saleprice;
		this.shop_item_stock = shop_item_stock;
		this.item_section = item_section;
		this.shop_item_desc = shop_item_desc;
		this.shop_item_subimg_imgname = shop_item_subimg_imgname;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
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
	public int getShop_itemprice() {
		return shop_itemprice;
	}
	public void setShop_itemprice(int shop_itemprice) {
		this.shop_itemprice = shop_itemprice;
	}
	public double getShop_item_pointrate() {
		return shop_item_pointrate;
	}
	public void setShop_item_pointrate(double shop_item_pointrate) {
		this.shop_item_pointrate = shop_item_pointrate;
	}
	public double getShop_item_discountrate() {
		return shop_item_discountrate;
	}
	public void setShop_item_discountrate(double shop_item_discountrate) {
		this.shop_item_discountrate = shop_item_discountrate;
	}
	public int getShop_item_saleprice() {
		return shop_item_saleprice;
	}
	public void setShop_item_saleprice(int shop_item_saleprice) {
		this.shop_item_saleprice = shop_item_saleprice;
	}
	public int getShop_item_stock() {
		return shop_item_stock;
	}
	public void setShop_item_stock(int shop_item_stock) {
		this.shop_item_stock = shop_item_stock;
	}
	public int getItem_section() {
		return item_section;
	}
	public void setItem_section(int item_section) {
		this.item_section = item_section;
	}
	public String getShop_item_desc() {
		return shop_item_desc;
	}
	public void setShop_item_desc(String shop_item_desc) {
		this.shop_item_desc = shop_item_desc;
	}
	public String getShop_item_subimg_imgname() {
		return shop_item_subimg_imgname;
	}
	public void setShop_item_subimg_imgname(String shop_item_subimg_imgname) {
		this.shop_item_subimg_imgname = shop_item_subimg_imgname;
	}
	public String getShop_item_mainimg_imgname() {
		return shop_item_mainimg_imgname;
	}
	public void setShop_item_mainimg_imgname(String shop_item_mainimg_imgname) {
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
	}
	
}
